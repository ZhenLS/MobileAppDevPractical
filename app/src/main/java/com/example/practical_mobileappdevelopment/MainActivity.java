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
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);

        /**
         * Exercise 3: Draw Rectangle in ImageView
         */
        ShapeDrawable rect = new ShapeDrawable(new RectShape());
        rect.getPaint().setColor(Color.parseColor("#FAE0CC"));
        rect.getPaint().setStyle(Paint.Style.FILL_AND_STROKE);

        // Aspect Ratio of Whole Rect (Ratio of Width vs Height)
        rect.setIntrinsicHeight(1);
        rect.setIntrinsicWidth(2);

        // Create ImageView to show Rectangle
        ImageView imageView = new ImageView(this);
        imageView.setImageDrawable(rect);

        // Set content View to ImageView
        setContentView(imageView);

//        setContentView(new CustomView(this));
    }

    private static class CustomView extends View {

        private ShapeDrawable drawable;

        public CustomView(Context context) {
            super(context);
        }

        @Override
        protected void onDraw(Canvas canvas) {      // Canvas == drawing pad
        }
    }
}