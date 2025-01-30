package com.omelenko.todo.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.omelenko.todo.MainActivity;
import com.omelenko.todo.todo.ApiCallBack;
import com.omelenko.todo.todo.ApiCallBackImplForTodos;
import com.omelenko.todo.todo.Todo;
import com.omelenko.todo.todo.TodoAdapter;
import com.omelenko.todo.todo.TodoRepository;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

import javax.inject.Inject;

public class TodoAddViewModel extends ViewModel {
    @Inject
    TodoAdapter adapter;
    @Inject
    TodoRepository repository;
    Todo editTodo;
    private MutableLiveData<String> todoTitle = new MutableLiveData<>(editTodo == null ? "~" : editTodo.getTitle());
    private boolean todoCompleted = false;
    private final MutableLiveData<String> buttonText = new MutableLiveData<>(editTodo == null ? "Додати to-do" : "Редагувати to-do");
    private int position = 1999;

    public void setEditPost(int position) {
        ApiCallBackImplForTodos testCallBack = new ApiCallBackImplForTodos();
        repository.getTodoById(position, testCallBack);
        this.editTodo = testCallBack.passTodo;
        this.todoTitle.setValue(testCallBack.passTodo.getTitle());
        //this.postBody.setValue(emptyTodo[0].getTitle());
    }

    public void button_onClick() {
        if (!Objects.equals(todoTitle.getValue(), "")) {
            Todo newTodo = new Todo();
            //newTodo.setUserId(100);
            //newTodo.setId(1);
            newTodo.setTitle(todoTitle.getValue());
            newTodo.setCompleted(todoCompleted);
            ApiCallBack callBack = new ApiCallBackImplForTodos();
            if (position != 1999) {
                repository.updateTodo(newTodo, position, callBack);
            } else {
                repository.createTodo(newTodo, callBack);
            }
            MainActivity.popBackStack();
        }
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public MutableLiveData<String> getTodoTitle() {
        return todoTitle;
    }

    public void setTodoTitle(MutableLiveData<String> todoTitle) {
        this.todoTitle = todoTitle;
    }

    public boolean isTodoCompleted() {
        return todoCompleted;
    }

    public void setTodoCompleted(boolean todoCompleted) {
        this.todoCompleted = todoCompleted;
    }

    public MutableLiveData<String> getButtonText() {
        return buttonText;
    }
}
