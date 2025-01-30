package com.omelenko.todo;

import android.app.Application;

import com.omelenko.todo.dagger.component.AppComponent;
import com.omelenko.todo.dagger.component.DaggerAppComponent;
import com.omelenko.todo.todo.TodoAdapter;
import com.omelenko.todo.todo.TodoRepository;
import com.omelenko.todo.viewmodel.ItemPostViewModel;

public class App extends Application {

    private static AppComponent component;
    public static final Object lock = new Object();

    @Override
    public void onCreate() {
        super.onCreate();
        ItemPostViewModel viewModel = new ItemPostViewModel(this);
        TodoAdapter adapter = new TodoAdapter(viewModel);
        TodoRepository repository = new TodoRepository();
        component = DaggerAppComponent.builder()
                .todoAdapter(adapter)
                .todoRepository(repository)
                .build();
    }

    public static AppComponent getComponent()
    {
        return component;
    }

}
