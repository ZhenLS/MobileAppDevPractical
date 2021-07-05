package com.example.practical_mobileappdevelopment;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RectShape;
import android.graphics.drawable.shapes.Shape;
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

        private ShapeDrawable drawable;

        public CustomView(Context context) {
            super(context);

            // Method 1: Define Rectangle
            int x = 100;
            int y = 100;
            int width = 600;
            int height = 100;

            drawable = new ShapeDrawable(new RectShape());
            drawable.getPaint().setColor(Color.parseColor("#DAB1AD"));
            drawable.setBounds(x, y, x + width, y + height);
        }

        @Override
        protected void onDraw(Canvas canvas) {      // Canvas == drawing pad
            /**
             * Exercise 3: Draw Rectangle
             * Define Rectangle in constructor. draw in onDraw
             */
            drawable.draw(canvas);
        }
    }
}