package com.framba.WatO;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

public class GunStickView extends View {
    int x;
    int y;
    Paint paint = new Paint();
    Paint text = new Paint();
    boolean isTouchUpOccurred = true;
    boolean isTouchingJoystick = false;
    boolean isStart = false;
    FlagView flagView = null;
    int laserX;



    int laserY;



    public void setFlagView(FlagView flagView) {
        this.flagView = flagView;
    }

    public GunStickView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);

    }

    public GunStickView(Context context, AttributeSet attrs) {
        super(context, attrs);

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        isStart = true;

        if (event.getAction() == MotionEvent.ACTION_UP) {
            isTouchUpOccurred = true;
            flagView.setTouchUpOccured(false);
            isTouchingJoystick = false;
        } else {
            //Give values to x:Width and y:Height
            // of user location
            x = (int) event.getX();
            y = (int) event.getY();
            isTouchUpOccurred = false;
        }
        //restart overridden onDraw method
        this.invalidate();
        //Using

        return true;
    }


    @Override
    public void onDraw(Canvas canvas) {
        /*if(flagView.getSplashInt() < 90){

        }else{
*/
        setBackgroundColor(Color.TRANSPARENT);

        RectF handle = new RectF();
        RectF pivot = new RectF();


        if (x >= canvas.getWidth() / 2 - 85 && x <= canvas.getWidth() / 2 + 85 && y >= canvas.getHeight() / 2 - 85 && y <= canvas.getHeight() / 2 + 55 && isStart == true || isTouchingJoystick == true) {
            isTouchingJoystick = true;
            flagView.setTouchUpOccured(true);
            paint.setTextSize(30);
            paint.setColor(Color.WHITE);

            paint.setTextSize(50);
        } else {
            paint.setTextSize(30);
            paint.setColor(Color.WHITE);

            paint.setTextSize(50);


            handle.set(canvas.getWidth() / 2 - 85, canvas.getHeight() / 2 - 85, canvas.getWidth() / 2 + 85, canvas.getHeight() / 2 + 85);
            paint.setColor(Color.WHITE);
            paint.setStrokeWidth(5);
            paint.setTextSize(50);

            canvas.drawText("x: 0" + "y: 0", 210, 1000, paint);
            paint.setColor(Color.DKGRAY);
            canvas.drawOval(handle, paint);
        }

        if (!isStart) {
            x = canvas.getWidth() / 2;
            y = canvas.getHeight() / 2;
        }

        if (!isTouchUpOccurred) {
            paint.setTextSize(30);
            paint.setColor(Color.WHITE);

            paint.setTextSize(50);
            //Joystick arm
            if (isTouchingJoystick == true) {
                flagView.setTouchUpOccured(true);
                if (x > canvas.getWidth() / 2 + 140) {
                    x = canvas.getWidth() / 2 + 140;
                }
                if (x < canvas.getWidth() / 2 - 140) {
                    x = canvas.getWidth() / 2 - 140;
                }
                if (y < canvas.getHeight() / 2 - 140) {
                    y = canvas.getHeight() / 2 - 140;
                }
                if (y > canvas.getHeight() / 2 + 140) {
                    y = canvas.getHeight() / 2 + 140;
                }


                paint.setTextSize(30);
                paint.setColor(Color.BLACK);

                paint.setTextSize(20);
                paint.setColor(Color.GRAY);
                pivot.set(canvas.getWidth() / 2 - 15, canvas.getHeight() / 2 - 15, canvas.getWidth() / 2 + 15, canvas.getHeight() / 2 + 15);
                canvas.drawOval(pivot, paint);
                canvas.drawLine(canvas.getWidth() / 2, canvas.getHeight() / 2, x, y, paint);
                paint.setStyle(Paint.Style.FILL);
                handle.set(x - 85, y - 85, x + 85, y + 85);

                canvas.drawOval(handle, paint);

                paint.setStyle(Paint.Style.FILL);
                //canvas.drawText("N:", paint);
                paint.setColor(Color.BLACK);
                canvas.drawText("x: " + x + "y: "+ y, 50, 50, paint);
                canvas.drawText("x: "+canvas.getWidth() + "y: "+canvas.getHeight(), 50, 100, paint);
                paint.setColor(Color.DKGRAY);

                flagView.setGunLaserX(x);
                flagView.setGunLaserY(y);
            }
        }
        paint.setTextSize(30);
        paint.setColor(Color.WHITE);
        paint.setTextSize(30);
        paint.setColor(Color.BLUE);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(5);
        canvas.drawRect(canvas.getWidth() / 2 - 140, canvas.getHeight() / 2 - 140, canvas.getWidth() / 2 + 140, canvas.getHeight() / 2 + 140, paint);
        paint.setStrokeWidth(5);
        paint.setTextSize(50);
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.DKGRAY);

        if (x >= canvas.getWidth() / 2 - 85 && x <= canvas.getWidth() / 2 + 85 && y >= canvas.getHeight() / 2 - 85 && y <= canvas.getHeight() / 2 + 85 && isTouchUpOccurred == true && isTouchingJoystick == true) {
            isTouchingJoystick = false;
            flagView.setTouchUpOccured(false);
            handle.set(canvas.getWidth() / 2 - 85, canvas.getHeight() / 2 - 85, canvas.getWidth() / 2 + 85, canvas.getHeight() / 2 + 85);
            paint.setColor(Color.WHITE);
            paint.setStrokeWidth(10);
            paint.setTextSize(50);

            canvas.drawText("x: 0" + "y: 0", 210, 1000, paint);
            paint.setColor(Color.DKGRAY);
            canvas.drawOval(handle, paint);
        }


        /*paint.setColor(Color.RED);
        canvas.drawRect(x-10, y-10, x+140, y+80, paint);
        paint.setColor(Color.WHITE);
        canvas.drawRect(x-10, y-10, x+93, y+80, paint);
        paint.setColor(Color.GREEN);
        canvas.drawRect(x-10, y-10, x+46, y+80, paint);
        */





    }


}