package com.omelenko.todo.todo;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface TodoApi {
    @GET("todos")
    Call<List<Todo>> getTodos();
    @GET("todos")
    Call<Todo> getTodoById(@Path("id") int id);
    @POST("todos")
    Call<Todo> createTodo(@Body Todo todo);
    @PUT("todos/{id}")
    Call<Todo> updateTodo(@Path("id") int id, @Body Todo todo);
    @DELETE("todos/{id}")
    Call<Void> deleteTodo(@Path("id") int id);

}
