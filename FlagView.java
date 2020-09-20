package com.framba.WatO;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import java.io.IOException;

import static com.framba.WatO.R.*;

public class FlagView extends View {
    MainFragment mainFragment = new MainFragment();
    Paint paint = new Paint();
    int colorCount;
    int speedY = 0;
    int speedX = 0;
    int directionY = 0;
    int directionX = 0;
    boolean first = true;
    boolean red = true;
    int tempframe = 1;
    int screenHeight = 0;
    int gunLaserX;
    int gunLaserY;
    Bitmap[] anim = new Bitmap[8];
    int imageCounter = 1;
    int imageExpCounter = 1;
    int splashInt = 0;
    SplashActivity sp = new SplashActivity();



    public int getThreeTwoOne() {
        return threeTwoOne;
    }

    int threeTwoOne = 0;

    public void setBegan(boolean began) {
        this.began = began;
    }

    boolean began = false;
    int x = 0;
    int y = -1;
    boolean pressedStart = false;
    Bitmap[] redMageStand = new Bitmap[8];
    Bitmap[] blueMageStand = new Bitmap[8];
    Bitmap[] explosion = new Bitmap[8];
    Bitmap three;
    Bitmap two;
    Bitmap one;


    public void setTouchUpOccured(boolean isTouchUpOccured) {
        this.isTouchUpOccured = isTouchUpOccured;
    }

    boolean isTouchUpOccured = true;

    public void setGunLaserX(int gunLaserX) {
        this.gunLaserX = gunLaserX;
    }

    public void setGunLaserY(int gunLaserY) {
        this.gunLaserY = gunLaserY;
    }

    public void setDirectiony(int directiony) {
        this.directionY = directiony;
    }

    public void setDirectionx(int directionx) {
        this.directionX = directionx;
    }

    public void setSpeedy(int speedy) {
        this.speedY = speedy;
    }

    public int getSplashInt() {
        return this.splashInt;
    }

    public void setSpeedx(int speedx) {
        this.speedX = speedx;
    }

    public FlagView(Context context, AttributeSet attrs, int defStyle) throws IOException {
        super(context, attrs, defStyle);


        redMageStand[1] = BitmapFactory.decodeResource(context.getResources(), drawable.mage1);
        redMageStand[2] = BitmapFactory.decodeResource(context.getResources(), drawable.mage2);
        redMageStand[3] = BitmapFactory.decodeResource(context.getResources(), drawable.mage3);
        redMageStand[4] = BitmapFactory.decodeResource(context.getResources(), drawable.mage4);
        redMageStand[5] = BitmapFactory.decodeResource(context.getResources(), drawable.mage5);
        redMageStand[6] = BitmapFactory.decodeResource(context.getResources(), drawable.mage6);
        redMageStand[7] = BitmapFactory.decodeResource(context.getResources(), drawable.mage7);
        blueMageStand[1] = BitmapFactory.decodeResource(context.getResources(), drawable.bmage1);
        blueMageStand[2] = BitmapFactory.decodeResource(context.getResources(), drawable.bmage2);
        blueMageStand[3] = BitmapFactory.decodeResource(context.getResources(), drawable.bmage3);
        blueMageStand[4] = BitmapFactory.decodeResource(context.getResources(), drawable.bmage4);
        blueMageStand[5] = BitmapFactory.decodeResource(context.getResources(), drawable.bmage5);
        blueMageStand[6] = BitmapFactory.decodeResource(context.getResources(), drawable.bmage6);
        blueMageStand[7] = BitmapFactory.decodeResource(context.getResources(), drawable.bmage7);
        explosion[1] = BitmapFactory.decodeResource(context.getResources(), drawable.explosion1);
        explosion[2] = BitmapFactory.decodeResource(context.getResources(), drawable.explosion2);
        explosion[3] = BitmapFactory.decodeResource(context.getResources(), drawable.explosion3);
        explosion[4] = BitmapFactory.decodeResource(context.getResources(), drawable.explosion4);
        explosion[5] = BitmapFactory.decodeResource(context.getResources(), drawable.explosion5);
        explosion[6] = BitmapFactory.decodeResource(context.getResources(), drawable.explosion6);
        explosion[7] = BitmapFactory.decodeResource(context.getResources(), drawable.explosion7);
        three = BitmapFactory.decodeResource(context.getResources(), drawable.three);
        two = BitmapFactory.decodeResource(context.getResources(), drawable.two);
        one = BitmapFactory.decodeResource(context.getResources(), drawable.one);

    }

    public FlagView(Context context, AttributeSet attrs) throws IOException {
        super(context, attrs);


        redMageStand[1] = BitmapFactory.decodeResource(context.getResources(), drawable.mage1);
        redMageStand[2] = BitmapFactory.decodeResource(context.getResources(), drawable.mage2);
        redMageStand[3] = BitmapFactory.decodeResource(context.getResources(), drawable.mage3);
        redMageStand[4] = BitmapFactory.decodeResource(context.getResources(), drawable.mage4);
        redMageStand[5] = BitmapFactory.decodeResource(context.getResources(), drawable.mage5);
        redMageStand[6] = BitmapFactory.decodeResource(context.getResources(), drawable.mage6);
        redMageStand[7] = BitmapFactory.decodeResource(context.getResources(), drawable.mage7);
        blueMageStand[1] = BitmapFactory.decodeResource(context.getResources(), drawable.bmage1);
        blueMageStand[2] = BitmapFactory.decodeResource(context.getResources(), drawable.bmage2);
        blueMageStand[3] = BitmapFactory.decodeResource(context.getResources(), drawable.bmage3);
        blueMageStand[4] = BitmapFactory.decodeResource(context.getResources(), drawable.bmage4);
        blueMageStand[5] = BitmapFactory.decodeResource(context.getResources(), drawable.bmage5);
        blueMageStand[6] = BitmapFactory.decodeResource(context.getResources(), drawable.bmage6);
        blueMageStand[7] = BitmapFactory.decodeResource(context.getResources(), drawable.bmage7);
        explosion[1] = BitmapFactory.decodeResource(context.getResources(), drawable.explosion1);
        explosion[2] = BitmapFactory.decodeResource(context.getResources(), drawable.explosion2);
        explosion[3] = BitmapFactory.decodeResource(context.getResources(), drawable.explosion3);
        explosion[4] = BitmapFactory.decodeResource(context.getResources(), drawable.explosion4);
        explosion[5] = BitmapFactory.decodeResource(context.getResources(), drawable.explosion5);
        explosion[6] = BitmapFactory.decodeResource(context.getResources(), drawable.explosion6);
        explosion[7] = BitmapFactory.decodeResource(context.getResources(), drawable.explosion7);
        three = BitmapFactory.decodeResource(context.getResources(), drawable.three);
        two = BitmapFactory.decodeResource(context.getResources(), drawable.two);
        one = BitmapFactory.decodeResource(context.getResources(), drawable.one);

    }

    @Override
    public void onDraw(Canvas canvas) {


        screenHeight = canvas.getHeight();
        if(!began){

            paint.setColor(Color.BLACK);
            paint.setTextSize(45);
            paint.setStrokeWidth(5);

            canvas.drawText("Fireball V.05", 0, 45, paint);
            paint.setTextSize(25);
            canvas.drawText("Copyright © 2014 Orbit Softwares", 0, 70, paint);
        }



        paint.setStrokeWidth(15);
        if(x<=-40){
            paint.setStrokeWidth(15);
            paint.setColor(Color.GREEN);
            canvas.drawLine(canvas.getWidth()/2,0,canvas.getWidth()/2,canvas.getHeight(),paint);
            switch (imageExpCounter) {
                case 1:
                    canvas.drawBitmap(explosion[1], canvas.getWidth()/2- 50, canvas.getHeight()/2 - 50, paint);break;
                case 2:
                    canvas.drawBitmap(explosion[2], canvas.getWidth()/2- 50, canvas.getHeight()/2- 50, paint);break;
                case 3:
                    canvas.drawBitmap(explosion[3], canvas.getWidth()/2- 50, canvas.getHeight()/2- 50, paint);break;
                case 4:
                    canvas.drawBitmap(explosion[4], canvas.getWidth()/2- 50, canvas.getHeight()/2- 50, paint);break;
                case 5:
                    canvas.drawBitmap(explosion[5], canvas.getWidth()/2- 50, canvas.getHeight()/2- 50, paint);break;
                case 6:
                    canvas.drawBitmap(explosion[6], canvas.getWidth()/2- 50, canvas.getHeight()/2- 50, paint);break;
                case 7:
                    canvas.drawBitmap(explosion[7], canvas.getWidth()/2- 50, canvas.getHeight()/2- 50, paint);break;
                default:
                    break;

            }
        }else{
            paint.setColor(Color.BLACK);
            canvas.drawLine(canvas.getWidth()/2,0,canvas.getWidth()/2,y,paint);
        }

        if(y >= 0 && y <= canvas.getHeight()/3){
            canvas.drawBitmap(three,canvas.getWidth()/2- 100,y- 160,paint);

        }
        if(y >= canvas.getHeight()/3 && y <= canvas.getHeight()/1.333){
            canvas.drawBitmap(two,canvas.getWidth()/2- 100,y- 160,paint);
        }
        if(y >= canvas.getHeight()/1.333 && y <= canvas.getHeight()){
            canvas.drawBitmap(one,canvas.getWidth()/2 - 100,y - 175,paint);
        }

        paint.setColor(Color.RED);
        canvas.drawLine(canvas.getWidth()/2,0,canvas.getWidth()/2,x,paint);

        switch (imageCounter) {
            case 1:
                canvas.drawBitmap(redMageStand[1], (float) (canvas.getWidth()/5.9), (float) (canvas.getHeight()/1.86), paint);
                canvas.drawBitmap(blueMageStand[1], (float) (canvas.getWidth() * (.73)), (float) (canvas.getHeight()/1.86), paint);
                tempframe = 1;
                break;
            case 6:
                canvas.drawBitmap(redMageStand[2], (float) (canvas.getWidth()/5.9), (float) (canvas.getHeight()/1.86), paint);
                canvas.drawBitmap(blueMageStand[2], (float) (canvas.getWidth() * (.73)), (float) (canvas.getHeight()/1.86), paint);
                tempframe = 2;
                break;
            case 11:
                canvas.drawBitmap(redMageStand[3], (float) (canvas.getWidth()/5.9), (float) (canvas.getHeight()/1.86), paint);
                canvas.drawBitmap(blueMageStand[3], (float) (canvas.getWidth() * (.73)), (float) (canvas.getHeight()/1.86), paint);
                tempframe = 3;
                break;
            case 16:
                canvas.drawBitmap(redMageStand[4], (float) (canvas.getWidth()/5.9), (float) (canvas.getHeight()/1.86), paint);
                canvas.drawBitmap(blueMageStand[4], (float) (canvas.getWidth() * (.73)), (float) (canvas.getHeight()/1.86), paint);
                tempframe = 4;
                break;
            case 21:
                canvas.drawBitmap(redMageStand[5], (float) (canvas.getWidth()/5.9), (float) (canvas.getHeight()/1.86), paint);
                canvas.drawBitmap(blueMageStand[5], (float) (canvas.getWidth() * (.73)), (float) (canvas.getHeight()/1.86), paint);
                tempframe = 5;
                break;
            case 26:
                canvas.drawBitmap(redMageStand[6], (float) (canvas.getWidth()/5.9), (float) (canvas.getHeight()/1.86), paint);
                canvas.drawBitmap(blueMageStand[6], (float) (canvas.getWidth() * (.73)), (float) (canvas.getHeight()/1.86), paint);
                tempframe = 6;
                break;
            case 31:
                canvas.drawBitmap(redMageStand[7], (float) (canvas.getWidth()/5.9), (float) (canvas.getHeight()/1.86), paint);
                canvas.drawBitmap(blueMageStand[7], (float) (canvas.getWidth() * (.73)), (float) (canvas.getHeight()/1.86), paint);
                tempframe = 7;
                break;
            default:
                canvas.drawBitmap(redMageStand[tempframe], (float) (canvas.getWidth()/5.9), (float) (canvas.getHeight()/1.86), paint);
                canvas.drawBitmap(blueMageStand[tempframe], (float) (canvas.getWidth() * (.73)), (float) (canvas.getHeight()/1.86), paint);
                break;

        }
    }


    public void updatePosition() {
        //threeTwoOne += screenHeight/300;


        if(began){
            if(y >= screenHeight){
                y = screenHeight + 1;
                if(x >= screenHeight){
                    x = -440;
                }else{
                    x+=screenHeight/13.5;
                }
            }else{
                y+=screenHeight/40;
            }

            imageExpCounter++;
            if(imageExpCounter == 7){
                imageExpCounter = 1;
            }

            imageCounter++;
            if(imageCounter == 31){
                imageCounter = 1;
            }
        }

        this.invalidate();
        // update x,y based on speed/direction
        // invalidate
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        began = true;

        //x = (int)event.getX();
        //y = (int)event.getY();
        return true;
    }






    //Distance formula bruh
    public double distance(double x1, double y1, double x2, double y2) {
        return Math.sqrt((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2));
    }

}


