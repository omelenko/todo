package com.omelenko.todo.todo;

import com.squareup.moshi.Json;

public class Todo {
    @Json(name = "userId")
    private int userId;
    @Json(name = "id")
    private int id;
    @Json(name = "title")
    private String title;
    @Json(name = "completed")
    private boolean completed;

    // Геттери та сеттери
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public boolean isCompleted() {
        return completed;
    }
    public String getCompleted()
    {
        return isCompleted() ? "Так" : "Ні";
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
}
