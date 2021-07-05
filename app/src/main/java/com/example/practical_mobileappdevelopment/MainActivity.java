package com.example.practical_mobileappdevelopment;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
        setContentView(new CustomView(this));
    }

    private static class CustomView extends View {
        public CustomView(Context context) {
            super(context);
        }

        @Override
        protected void onDraw(Canvas canvas) {      // Canvas == drawing pad
            /**
             * When using Canvas:
             * 1. Set Background Color
             * 2. Set Paint (Line/Shape) Color
             * 3. Setup Fonts
             * 4. Draw primitive operations / Shape
             */

            // Set BG Color
            canvas.drawColor(Color.DKGRAY);

            // Set Paint Color
            Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);     // Anti alias: replace the jagger line with smooth line

            // 2nd Component: Fonts
            Typeface typeface;
            typeface = Typeface.create(Typeface.MONOSPACE, Typeface.NORMAL);

            paint.setColor(Color.GREEN);
            paint.setTextSize(40);
            paint.setTypeface(typeface);

            // 3rd component: drawing primitive operations / shape
            canvas.drawText("This is my Low-Level_UI using View.",
                    10, 50, paint);

            // Second Format
            paint.setColor(Color.parseColor("aqua"));
            Typeface typeface1 = Typeface.create(Typeface.SERIF, Typeface.BOLD_ITALIC);
            paint.setTypeface(typeface1);
            canvas.drawText("2ND Low LEVEL UI",
                    10, 100, paint);


        }
    }
}