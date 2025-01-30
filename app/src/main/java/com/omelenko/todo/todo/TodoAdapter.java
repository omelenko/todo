package com.omelenko.todo.todo;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.omelenko.todo.App;
import com.omelenko.todo.R;
import com.omelenko.todo.databinding.ItemTodoBinding;
import com.omelenko.todo.viewmodel.ItemPostViewModel;

import java.util.List;

public class TodoAdapter extends RecyclerView.Adapter<TodoAdapter.PostViewHolder> {

    private final ItemPostViewModel viewModel;

    public TodoAdapter(ItemPostViewModel viewModel) {
        this.viewModel = viewModel;
    }

    @NonNull
    @Override
    public PostViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemTodoBinding binding = DataBindingUtil.inflate(
                LayoutInflater.from(parent.getContext()),
                R.layout.item_todo, parent, false);
        return new PostViewHolder(binding);
    }

    @Override
    public void onAttachedToRecyclerView(@NonNull RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        App.getComponent().injectsItemPostViewModel(viewModel);
    }

    @Override
    public void onBindViewHolder(PostViewHolder holder, int position) {
        Todo todo = viewModel.getTodoById(position);
        holder.bind(todo);
    }

    @Override
    public int getItemCount() {
        List<Todo> test = viewModel.getTodos();
        //Log.d(TodoAdapter.class.getSimpleName(), "test.get(0).getTitle() = " + test.get(0).getTitle());
        return 0;// test.size();
    }

    public class PostViewHolder extends RecyclerView.ViewHolder {

        private final ItemTodoBinding binding;

        public PostViewHolder(ItemTodoBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(Todo todo) {
            binding.setTodo(todo);
            binding.setViewModel(viewModel);
            binding.executePendingBindings();
        }
    }
}
