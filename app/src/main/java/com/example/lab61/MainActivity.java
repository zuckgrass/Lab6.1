package com.example.lab61;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        // Check if the selected item is a color or a shade
        if (item.getGroupId() == R.id.menu_colors) {
            // Display the selected item in a Toast
            showToast(item.getTitle().toString());
            return true;
        } else {
           /* switch (item.getItemId()) {
                case R.id.color_red:
                case R.id.color_blue:
                case R.id.color_green:
                    // Display the selected item in a Toast
                    showToast(item.getTitle().toString());
                    return true;

                default:
                    return super.onOptionsItemSelected(item);
            }*/
        }
        return true;
    }

    private void showToast(String message) {
        Toast.makeText(this, "Selected: " + message, Toast.LENGTH_SHORT).show();
    }
}
