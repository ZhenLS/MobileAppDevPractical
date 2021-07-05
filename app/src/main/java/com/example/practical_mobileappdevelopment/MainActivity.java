package com.example.practical_mobileappdevelopment;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.RectF;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
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

        // Attributes for Rounded Rectangle
        float[] outerRadii = new float[]{10, 10, 10, 10, 10, 10, 10, 10, 10, 10};    // Radius value of each corner
        float[] innerRadii = new float[]{10, 10, 10, 10, 10, 10, 10, 10, 10, 10};
        RectF insetRect = new RectF(15, 10, 15, 10);  // Inner padding of Rect


        ShapeDrawable roundedRect = new ShapeDrawable(new RoundRectShape(outerRadii, insetRect, innerRadii));
        roundedRect.getPaint().setColor(Color.parseColor("#FAE0CC"));
//        roundedRect.getPaint().setStyle(Paint.Style.FILL_AND_STROKE);

        // Aspect Ratio of Whole Rect (Ratio of Width vs Height)
        roundedRect.setIntrinsicHeight(50);
        roundedRect.setIntrinsicWidth(100);

        // Create ImageView to show Rectangle
        ImageView imageView = new ImageView(this);
        imageView.setImageDrawable(roundedRect);

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