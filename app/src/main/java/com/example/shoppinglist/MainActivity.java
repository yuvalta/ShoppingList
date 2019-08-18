package com.example.shoppinglist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {

    FloatingActionButton createListBtn;
    MenuItem logoutBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initVariables();

        initCreateListBtn();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.top_appbar_menu, menu);
        return true;
    }

    private void initVariables() {
        createListBtn = findViewById(R.id.create_list_btn);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.recent_lists:
                return true;

            case R.id.share_list:
                // Some other methods
                return true;

            case R.id.info:
                // Some other methods
                return true;

            case R.id.logout:
                logout();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void initCreateListBtn() {
        createListBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Pressed!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void logout() {
        Intent i = new Intent(MainActivity.this, LoginActivity.class);
        startActivity(i);
    }
}
