package com.example.lab61;

import android.graphics.Color;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.PopupMenu;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    PopupMenu popupMenu;
    int clicks = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
        TextView myTextView = findViewById(R.id.textView);
        registerForContextMenu(myTextView);

        View button = findViewById(R.id.buttonShowPopup);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showPopupMenu(v);
            }
        });
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.context_menu, menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        TextView myTextView = findViewById(R.id.textView);

        int itemId = item.getItemId();

        if (itemId == R.id.menu_red) {
            myTextView.setTextColor(Color.RED);
            return true;
        } else if (itemId == R.id.menu_green) {
            myTextView.setTextColor(Color.GREEN);
            return true;
        } else if (itemId == R.id.menu_blue) {
            myTextView.setTextColor(Color.BLUE);
            return true;
        } else {
            return super.onContextItemSelected(item);
        }
    }

    private void showPopupMenu(View view) {
        if(clicks == 0){
            popupMenu = new PopupMenu(this, view);
            popupMenu.inflate(R.menu.popup_menu);
        }


        // Set a listener for menu item clicks
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                int itemId = item.getItemId();

                if (itemId == R.id.menu_reverse_order) {
                    // Reverse the order of the menu items
                    reverseMenuOrder();
                    return true;
                } else if (itemId == R.id.menu_item1) {
                    showToast("Item 1 selected");
                    return true;
                } else if (itemId == R.id.menu_item2) {
                    showToast("Item 2 selected");
                    return true;
                } else if (itemId == R.id.menu_item3) {
                    showToast("Item 3 selected");
                    return true;
                } else {
                    return false;
                }
            }
        });

        clicks++;
        // Show the PopupMenu
        popupMenu.show();
    }

    private void reverseMenuOrder() {
        // Get the menu and reverse its items
        Menu menu = popupMenu.getMenu();
        int size = menu.size();

        List<MenuItem> menuItems = new ArrayList<>(size);

        // Create a list of menu items with reversed order
        for (int i = size - 1; i >= 0; i--) {
            menuItems.add(menu.getItem(i));
        }

        // Clear the existing menu
        menu.clear();

        // Add the menu items with reversed order back to the menu
        for (MenuItem menuItem : menuItems) {
            menu.add(menuItem.getGroupId(), menuItem.getItemId(), menuItem.getOrder(), menuItem.getTitle());
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