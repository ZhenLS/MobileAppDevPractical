package com.example.practical_mobileappdevelopment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /**
         * Target: change textView bg color according to btn selected
         */

        // Get elements textView and buttons
        View.OnClickListener colorChangeListener;
        TextView textView = findViewById(R.id.txt_pick);
        RadioButton radioBtnPrimrose = findViewById(R.id.radio_primrose);
        RadioButton radioBtnHoneydew = findViewById(R.id.radio_honeydew);
        RadioButton radioBtnApricot = findViewById(R.id.radio_apricot);
        RadioButton radioBtnPoppy = findViewById(R.id.radio_poppy);

        // Define colorChangeListener
        colorChangeListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RadioButton temp = (RadioButton) v;
                switch (v.getId()) {
                    case R.id.radio_primrose:
                        textView.setBackgroundColor(getResources().getColor(R.color.primrose));
                        break;
                    case R.id.radio_apricot:
                        textView.setBackgroundResource(R.color.apricot);
                        break;
                    case R.id.radio_honeydew:
                        textView.setBackgroundResource(R.color.honeydew);
                        break;
                    case R.id.radio_poppy:
                        textView.setBackgroundColor(getResources().getColor(R.color.poppy));
                        break;
                    default:
                        break;
                }
                textView.setTextColor(Color.BLACK);
            }
        };

        // Bind colorChangeListener to radioBtn
        radioBtnApricot.setOnClickListener(colorChangeListener);
        radioBtnPrimrose.setOnClickListener(colorChangeListener);
        radioBtnHoneydew.setOnClickListener(colorChangeListener);
        radioBtnPoppy.setOnClickListener(colorChangeListener);
    }

    /**
     * Create an option menu at Top Right Corner
     * @param menu
     * @return
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);

//        getMenuInflater().inflate(R.menu.example_menu, menu);
        menu.add("Next Page").setIntent(new Intent(this, NextActivity.class));
        menu.add("Exit")
                .setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        finish();
                        return false;
                    }
                });
        return true;
    }

    /**
     * Configure Actions on OptionsItem clicked
     */
}