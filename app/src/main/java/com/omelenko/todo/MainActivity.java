package com.omelenko.todo;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import com.omelenko.todo.fragment.TodoAddFragment;
import com.omelenko.todo.fragment.TodoFragment;

public class MainActivity extends AppCompatActivity {

    private static FragmentManager fragmentManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        fragmentManager = getSupportFragmentManager();
        if(savedInstanceState == null)
        {
            fragmentManager.beginTransaction()
                    .setReorderingAllowed(true)
                    .add(R.id.main, new TodoFragment(), null)
                    .commit();
        }
    }

    public static void addCall()
    {
        fragmentManager.beginTransaction()
                .replace(R.id.main, new TodoAddFragment())
                .setReorderingAllowed(true)
                .addToBackStack("add")
                .commit();
    }

    public static void popBackStack()
    {
        fragmentManager.popBackStack();
    }
}