package com.omelenko.todo.todo;

import java.util.List;

public class ApiCallBackImplForTodos implements ApiCallBack{
    public Todo passTodo;
    @Override
    public void onSuccess(List<Todo> todos) {

    }

    @Override
    public void onSuccess(Todo todo) {
        passTodo = todo;
    }

    @Override
    public void onFailure() {

    }
}
