package com.omelenko.todo.todo;

import java.util.List;

public interface ApiCallBack{
    void onSuccess(List<Todo> todos);
    void onSuccess(Todo todo);
    void onFailure();
}
