package com.example.shoppinglist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    FloatingActionButton addFab;

    private static RecyclerView.Adapter mainAdapter;

    private RecyclerView.LayoutManager layoutManagerCardView;

    private static RecyclerView mainRecyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addFab = findViewById(R.id.add_fab);
        addFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Pressed!", Toast.LENGTH_SHORT).show();
            }
        });

        mainRecyclerView = findViewById(R.id.main_RV);

        layoutManagerCardView = new LinearLayoutManager(this);
        mainRecyclerView.setLayoutManager(layoutManagerCardView);

        mainAdapter = new CustomCardAdapter(MyData.headersList);
        mainRecyclerView.setAdapter(mainAdapter);




    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.top_appbar_menu, menu);
        return true;
    }
}
