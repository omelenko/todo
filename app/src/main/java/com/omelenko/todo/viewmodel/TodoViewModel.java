package com.omelenko.todo.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.omelenko.todo.MainActivity;
import com.omelenko.todo.todo.TodoAdapter;

import javax.inject.Inject;

public class TodoViewModel extends ViewModel {

    @Inject
    TodoAdapter adapter;
    private LinearLayoutManager linearLayoutManager;
    public void button_onClick()
    {
        MainActivity.addCall();
    }

    public LinearLayoutManager getLinearLayoutManager() {
        return linearLayoutManager;
    }

    public void setLinearLayoutManager(LinearLayoutManager linearLayoutManager) {
        this.linearLayoutManager = linearLayoutManager;
    }

    public TodoAdapter getAdapter() {
        return adapter;
    }

    public void setAdapter(TodoAdapter adapter) {
        this.adapter = adapter;
    }
}
