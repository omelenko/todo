package com.omelenko.todo.todo;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.databinding.ObservableArrayList;

import com.omelenko.todo.retrofit.RetrofitClient;
import com.omelenko.todo.viewmodel.ItemPostViewModel;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TodoRepository {
    static TodoApi todoApi = RetrofitClient.getClient().create(TodoApi.class);
    public void getAllTodos(final ApiCallBack callBack) {

        Call<List<Todo>> call = todoApi.getTodos();
        Log.d(TodoRepository.class.getSimpleName(), "enqueue is about to happen");
        call.enqueue(new Callback<>() {
            @Override
            public void onResponse(@NonNull Call<List<Todo>> call, @NonNull Response<List<Todo>> response) {
                if (response.isSuccessful()) {
                    Log.d(TodoRepository.class.getSimpleName(), "onreponse is happening");
                    List<Todo> todos = response.body();
                    callBack.onSuccess(todos);
                    Log.d(TodoRepository.class.getSimpleName(), "onreponse has happened");
                } else {
                    System.out.println("Запит не успішний!");
                }
            }

            @Override
            public void onFailure(@NonNull Call<List<Todo>> call, @NonNull Throwable t) {
                Log.d(TodoRepository.class.getSimpleName(), "onfailure has happened");
                Logger.getGlobal().log(Level.WARNING, t.getMessage(), t);
                callBack.onFailure();
            }
        });
    }
    public void getTodoById(int postId, final ApiCallBack callBack)
    {
        Call<Todo> call = todoApi.getTodoById(postId);
        call.enqueue(new Callback<>() {
            @Override
            public void onResponse(@NonNull Call<Todo> call, @NonNull Response<Todo> response) {
                if (response.isSuccessful()) {
                    Todo todo = response.body();
                    callBack.onSuccess(todo);
                } else {
                    System.out.println("Запит не успішний!");
                }
            }

            @Override
            public void onFailure(@NonNull Call<Todo> call, @NonNull Throwable t) {
                Logger.getGlobal().log(Level.WARNING, t.getMessage(), t);
                callBack.onFailure();
            }
        });
    }
    public void createTodo(Todo todo, final ApiCallBack callBack)
    {
        Call<Todo> call = todoApi.createTodo(todo);
        call.enqueue(new Callback<>() {
            @Override
            public void onResponse(@NonNull Call<Todo> call, @NonNull Response<Todo> response) {
                if (response.isSuccessful()) {
                    Todo createdTodo = response.body();
                    callBack.onSuccess(createdTodo);
                } else {
                    System.out.println("Запит не успішний!");
                }
            }

            @Override
            public void onFailure(@NonNull Call<Todo> call, @NonNull Throwable t) {
                Logger.getGlobal().log(Level.WARNING, t.getMessage(), t);
                callBack.onFailure();
            }
        });
    }
    public void updateTodo(Todo todo, int postId, final ApiCallBack callBack)
    {
        Call<Todo> call = todoApi.updateTodo(postId, todo);
        call.enqueue(new Callback<>() {
            @Override
            public void onResponse(@NonNull Call<Todo> call, @NonNull Response<Todo> response) {
                if (response.isSuccessful()) {
                    Todo updatedTodo = response.body();
                    callBack.onSuccess(updatedTodo);
                } else {
                    System.out.println("Запит не успішний!");
                }
            }

            @Override
            public void onFailure(@NonNull Call<Todo> call, @NonNull Throwable t) {
                Logger.getGlobal().log(Level.WARNING, t.getMessage(), t);
                callBack.onFailure();
            }
        });
    }
}

