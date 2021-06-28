package com.example.practical_mobileappdevelopment;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

public class NextActivity extends AppCompatActivity {

    private LinearLayout linearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next);

        // Register TextView for Context Menu
        TextView longPressTextView = findViewById(R.id.longPressTxtView);
        registerForContextMenu(longPressTextView);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        // Show context menu on long press
        if (v.getId() == R.id.longPressTxtView) {
            menu.add(0, 1, 1, "Primrose");
            menu.add(0, 2, 2, "HoneyDew");
            menu.add(0, 3, 3, "Poppy");
            menu.add(0,4,4,"Apricot");
            menu.setHeaderIcon(android.R.drawable.ic_media_play)
                    .setHeaderTitle("Choose Color");
        }
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {

        linearLayout = findViewById(R.id.longPressLayout);

        switch (item.getItemId()) {
            case 1:
//                linearLayout.setBackgroundResource(R.color.primrose);
                linearLayout.setBackgroundColor(getResources().getColor(R.color.primrose));
                return true;
            case 2:
                linearLayout.setBackgroundResource(R.color.honeydew);
                return true;
            case 3:
                linearLayout.setBackgroundResource(R.color.poppy);
                return true;
            case 4:
                linearLayout.setBackgroundResource(R.color.apricot);
            default:
                return super.onContextItemSelected(item);

        }
    }
}