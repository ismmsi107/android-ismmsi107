package com.example.telephonymanager;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.PopupMenu;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.telephonymanager.databinding.ActivityMenuBinding;

public class MenuActivity extends AppCompatActivity {

    private ActivityMenuBinding menuBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        menuBinding = ActivityMenuBinding.inflate(getLayoutInflater());
        setContentView(menuBinding.getRoot());

        registerForContextMenu(menuBinding.button);

        menuBinding.button.setOnClickListener(view -> {
            PopupMenu popupMenu = new PopupMenu(MenuActivity.this, menuBinding.button);
            popupMenu.getMenuInflater().inflate(
                    R.menu.main_menu, popupMenu.getMenu());
            popupMenu.setOnMenuItemClickListener(item -> {
                switch (item.getItemId()) {
                    case R.id.action_contact:
                        // Implement code for Forward button.
                        return true;
                    default:
                        return false;
                }

            });
            popupMenu.show();

        });

    }

    public void displayToast(String message) {
        Toast.makeText(getApplicationContext(), message,
                Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_favorite:
                displayToast("favorite");
                return true;
            case R.id.action_settings:
                displayToast("settings");
                return true;
            case R.id.action_help:
                displayToast("help");
                return true;
            case R.id.action_contact:
                displayToast("contact");
                return true;
            default:
                // Do nothing
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        getMenuInflater().inflate(R.menu.main_menu, menu);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_favorite:
                displayToast("favorite");
                return true;
            case R.id.action_settings:
                displayToast("settings");
                return true;
            case R.id.action_help:
                displayToast("help");
                return true;
            case R.id.action_contact:
                displayToast("contact");
                return true;
            default:
                // Do nothing
        }

        return super.onContextItemSelected(item);
    }
}