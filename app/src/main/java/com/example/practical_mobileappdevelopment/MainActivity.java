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

        View decorView = getWindow().getDecorView();


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