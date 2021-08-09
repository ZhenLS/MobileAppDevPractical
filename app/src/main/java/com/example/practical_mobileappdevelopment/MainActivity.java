package com.example.practical_mobileappdevelopment;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Hide the status bar / system UI bar
        View decorView = getWindow().getDecorView();
        int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY;
        decorView.setSystemUiVisibility(uiOptions);

        // Hide the application bar
        getSupportActionBar().hide();


        Button clearViewBtn = findViewById(R.id.clearView);
        clearViewBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TouchEventView teView = findViewById(R.id.touchView);
                teView.clearScreen();
            }
        });
    }
}