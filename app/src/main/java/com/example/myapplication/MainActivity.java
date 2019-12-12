package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import android.view.Window;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(new MyDraw(this));
        //setContentView(R.layout.activity_main);
        Paint paint = new Paint();
        paint.setColor(Color.RED);
        paint.setSubpixelText(true);
        paint.setAntiAlias(true);

    }

    public class MyDraw extends View {
        public MyDraw (Context context){
            super(context);
        }
        @Override
        protected void onDraw(Canvas canvas){
            super.onDraw(canvas);
            Paint paint = new Paint();
            paint.setStyle(Paint.Style.FILL);
            paint.setColor(Color.YELLOW);
            canvas.drawPaint(paint);
            paint.setColor(Color.RED);
            canvas.drawCircle(getWidth()/2, getWidth()/2, 100, paint);
            paint.setColor(Color.BLUE);
            canvas.drawRect(0, 0, getWidth(), 200, paint);
            paint.setColor(Color.YELLOW);
            paint.setStyle(Paint.Style.FILL);
            paint.setTextSize(30);
            canvas.drawText("VANISH PSINA", 50, 100, paint);
            float rotate_center_x = 200;
            float rotate_center_y = 200;
            float rotate_angle = 45;
            canvas.rotate(-rotate_angle, rotate_center_x, rotate_center_y);
            paint.setColor((Color.BLUE));
            paint.setTextSize(40);
            canvas.drawText("VANISH GachiBUS", 0, 450, paint);
            canvas.rotate(rotate_angle, rotate_center_x, rotate_center_y);
            Bitmap image = BitmapFactory.decodeResource(getResources(), R.drawable.gachi);
            int xx = canvas.getWidth(), yy = canvas. getHeight();
            canvas.drawBitmap(image, xx - image.getWidth(), yy - image.getHeight(), paint);
        }

    }
}