package com.example.lab61;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
    }

    // Inflate the menu; this adds items to the action bar if it is present.
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    // Handle menu item selection
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int itemId = item.getItemId();

        if (itemId == R.id.menu_item_option1) {
            showToast("Option 1 selected");
            return true;
        } else if (itemId == R.id.menu_item_option2) {
            showToast("Option 2 selected");
            return true;
        } else if (itemId == R.id.menu_item_option3) {
            showToast("Option 3 selected");
            return true;
        } else if (itemId == R.id.submenu_item1) {
            showToast("Submenu Item 1 selected");
            return true;
        } else if (itemId == R.id.submenu_item2) {
            showToast("Submenu Item 2 selected");
            return true;
        } else if (itemId == R.id.submenu_item3) {
            showToast("Submenu Item 3 selected");
            return true;
        } else {
            return super.onOptionsItemSelected(item);
        }
    }

    private void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}