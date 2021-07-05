package com.example.practical_mobileappdevelopment;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.ArcShape;
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
         * Q4: Pacman Drawing - Arc shape, angle clockwise, startAngle & sweepAngle
         */
        ShapeDrawable pacMan = new ShapeDrawable(new ArcShape(40, 290));
        pacMan.setIntrinsicWidth(1);
        pacMan.setIntrinsicHeight(1);
        pacMan.getPaint().setColor(Color.parseColor("#FFEE87"));

        ImageView imageView = new ImageView(this);
        imageView.setImageDrawable(pacMan);

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