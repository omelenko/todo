package com.omelenko.todo.dagger.component;

import com.omelenko.todo.todo.TodoAdapter;
import com.omelenko.todo.todo.TodoRepository;
import com.omelenko.todo.viewmodel.ItemPostViewModel;
import com.omelenko.todo.viewmodel.TodoAddViewModel;
import com.omelenko.todo.viewmodel.TodoViewModel;

import dagger.Component;

@Component(dependencies = {TodoRepository.class, TodoAdapter.class})
public interface AppComponent {
    //void injectsContactAdapter(ContactAdapter contactAdapter);
    //void injectsMainFragment(MainFragment mainFragment);
    //void injectsSecondaryFragment(SecondaryFragment secondaryFragment);
    void injectsPostViewModel(TodoViewModel todoViewModel);
    void injectsPostAddViewModel(TodoAddViewModel todoAddViewModel);
    void injectsItemPostViewModel(ItemPostViewModel itemPostViewModel);
}
