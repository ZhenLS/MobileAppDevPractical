package com.example.practical_mobileappdevelopment;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
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

        setContentView(new CustomView(this));
    }

    private static class CustomView extends View {

        private ShapeDrawable drawable;

        public CustomView(Context context) {
            super(context);
        }

        @Override
        protected void onDraw(Canvas canvas) {      // Canvas == drawing pad
            /**
             * Drawing Pacman
             * Method 1: using onDraw in CustomView
             */

            Paint pManPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
            canvas.drawColor(Color.DKGRAY);

            // Body of Pacman
            pManPaint.setColor(Color.parseColor("#FFEE87"));
            canvas.drawArc(new RectF(getWidth() / 2 - 200,
                            200,
                            getWidth() / 2 + 200, 600),
                    40, 290,
                    true, pManPaint);

            // Eye of Pacman
            pManPaint.setColor(Color.BLACK);
            canvas.drawCircle(getWidth() / 2 + 50,
                    getHeight() / 2 - 750,
                    20, pManPaint);
        }
    }
}