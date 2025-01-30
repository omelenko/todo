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

import com.omelenko.todo.App;
import com.omelenko.todo.R;
import com.omelenko.todo.databinding.TodoAddFragmentBinding;
import com.omelenko.todo.viewmodel.TodoAddViewModel;

public class TodoAddFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        TodoAddFragmentBinding binding = DataBindingUtil.inflate(inflater, R.layout.todo_add_fragment, container, false);
        TodoAddViewModel viewModel = new ViewModelProvider(this).get(TodoAddViewModel.class);

        App.getComponent().injectsPostAddViewModel(viewModel);

        View view = binding.getRoot();

        if(getArguments() != null)
        {
            int position = getArguments().getInt("position");
            viewModel.setEditPost(position);
            viewModel.setPosition(position);
        }

        binding.setViewModel(viewModel);

        return view;
    }
}
