package com.omelenko.todo.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.omelenko.todo.App;
import com.omelenko.todo.R;
import com.omelenko.todo.databinding.TodoFragmentBinding;
import com.omelenko.todo.viewmodel.TodoViewModel;

public class TodoFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        TodoFragmentBinding binding = DataBindingUtil.inflate(inflater, R.layout.todo_fragment, container, false);
        TodoViewModel viewModel = new ViewModelProvider(this).get(TodoViewModel.class);

        viewModel.setLinearLayoutManager(new LinearLayoutManager(this.getContext()));

        App.getComponent().injectsPostViewModel(viewModel);

        View view = binding.getRoot();

        binding.setViewModel(viewModel);

        return view;
    }
}
