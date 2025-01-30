package com.omelenko.todo.todo;

import android.util.Log;

import com.omelenko.todo.App;

import java.util.ArrayList;
import java.util.List;

public class ApiCallBackImplForLists implements ApiCallBack{
    public List<Todo> passTodos;
    @Override
    public void onSuccess(List<Todo> todos) {
        /*synchronized (App.lock)
        {
            passTodos = todos;
            App.lock.notify();
        }*/
        passTodos = todos;
        Log.d(ApiCallBackImplForLists.class.getSimpleName(), "passTodo title: " + passTodos.get(0).getTitle());
    }

    @Override
    public void onSuccess(Todo todo) {

    }

    @Override
    public void onFailure() {

    }
    public List<Todo> getPassTodos() {
        //Log.d(ApiCallBackImplForLists.class.getSimpleName(), "passTodo title: " + passTodos.get(0).getTitle());
        return passTodos;
    }
}
