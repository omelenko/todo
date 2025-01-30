package com.omelenko.todo.viewmodel;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.omelenko.todo.App;
import com.omelenko.todo.todo.ApiCallBack;
import com.omelenko.todo.todo.ApiCallBackImplForLists;
import com.omelenko.todo.todo.ApiCallBackImplForTodos;
import com.omelenko.todo.todo.Todo;
import com.omelenko.todo.todo.TodoRepository;

import java.util.Collections;
import java.util.List;

import javax.inject.Inject;

public class ItemPostViewModel extends AndroidViewModel {
    @Inject
    TodoRepository repository;

    public ItemPostViewModel(@NonNull Application application) {
        super(application);
    }

    /// З використанням нового потоку

    public List<Todo> getTodos()
    {
        ApiCallBackImplForLists testCallBack = new ApiCallBackImplForLists();
        Log.d(ItemPostViewModel.class.getSimpleName(), "repository.getAllTodos is about to happen");
        Thread T1 = new Thread(() -> repository.getAllTodos(testCallBack));
        T1.start();
        try {
            T1.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        Log.d(ItemPostViewModel.class.getSimpleName(), "repository.getAllTodos is happening");
        return testCallBack.getPassTodos();
    }

    /// З використанням кастомного ApiCallBack

//    public List<Todo> getTodos()
//    {
//        final List<Todo>[] passTodo = new List[1];
//        ApiCallBack testCallBack = new ApiCallBack() {
//            @Override
//            public void onSuccess(List<Todo> todos) {
//                synchronized (App.lock)
//                {
//                    passTodo[0] = todos;
//                    App.lock.notify();
//                }
//            }
//
//            @Override
//            public void onSuccess(Todo todo) {
//
//            }
//
//            @Override
//            public void onFailure() {
//
//            }
//        };
//        Log.d(ItemPostViewModel.class.getSimpleName(), "repository.getAllTodos is about to happen");
//        repository.getAllTodos(testCallBack);
//        Log.d(ItemPostViewModel.class.getSimpleName(), "repository.getAllTodos is happening");
//        try
//        {
//            synchronized (App.lock)
//            {
//                while(passTodo[0] == null)
//                {
//                    App.lock.wait();
//                }
//            }
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
//        return passTodo[0];
//    }

    /// З використанням ApiCallBackImplForLists ///

//    public List<Todo> getTodos()
//    {
//        ApiCallBackImplForLists testCallBack = new ApiCallBackImplForLists();
//        Log.d(ItemPostViewModel.class.getSimpleName(), "repository.getAllTodos is about to happen");
//        repository.getAllTodos(testCallBack);
//        Log.d(ItemPostViewModel.class.getSimpleName(), "repository.getAllTodos is happening");
//        try
//        {
//            synchronized (App.lock)
//            {
//                while(testCallBack.getPassTodos() == null)
//                {
//                    App.lock.wait();
//                }
//            }
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
//        return testCallBack.getPassTodos();
//    }

    public Todo getTodoById(int position)
    {

        ApiCallBackImplForTodos testCallBack = new ApiCallBackImplForTodos();
        repository.getTodoById(position, testCallBack);
        return testCallBack.passTodo;
    }
    public int getTodoId(Todo todo)
    {
        return getTodos().indexOf(todo);
    }

    public void editButton_onClick(int position)
    {

    }

    public void deleteButton_onClick(int position)
    {

    }
}
