package com.example.practical_mobileappdevelopment;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.ArcShape;
import android.graphics.drawable.shapes.PathShape;
import android.graphics.drawable.shapes.RoundRectShape;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        /**
         * Exercise 5: Snake Drawing using Path
         */

        // Define Path
        Path p = new Path();
        p.moveTo(0, 40);    // STart position
        p.lineTo(25, 15);   // next position
        p.lineTo(30, 30);
        p.lineTo(32, 45);
        p.lineTo(30, 60);
        p.lineTo(28, 85);
        p.lineTo(40, 90);
        p.lineTo(50, 70);
        p.lineTo(53, 55);
        p.lineTo(56, 55);
        p.lineTo(65, 85);
        p.lineTo(80, 90);
        p.lineTo(85, 87);
        p.lineTo(90, 85);
        p.lineTo(87, 90);
        p.lineTo(80, 100);
        p.lineTo(63, 90);
        p.lineTo(55, 65);
        p.lineTo(50, 85);
        p.lineTo(42, 100);
        p.lineTo(25, 90);
        p.lineTo(27, 50);
        p.lineTo(25, 25);
        p.lineTo(7,50);
        p.lineTo(20,25);
        p.lineTo(0,40);

        // Draw Snake
        ShapeDrawable snake = new ShapeDrawable(new PathShape(p, 100, 100));
        snake.setIntrinsicHeight(1);
        snake.setIntrinsicWidth(1);
        snake.getPaint().setColor(Color.parseColor("#E6ECCC"));
        snake.getPaint().setStyle(Paint.Style.FILL_AND_STROKE);

        ImageView imageView = new ImageView(this);
        imageView.setImageDrawable(snake);
        setContentView(imageView);
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