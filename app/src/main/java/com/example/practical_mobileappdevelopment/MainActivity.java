package com.example.practical_mobileappdevelopment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;

import java.lang.reflect.Type;

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
            // set bg color
            canvas.drawColor(Color.DKGRAY);

            // set paint color
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
        }
    }
}