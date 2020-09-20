package com.framba.WatO;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class SplashActivity extends Activity {
    TextView textView = null;
    //MediaPlayer mp;
    //MediaPlayer mp2;
    ImageView startButton = null;
    ImageView coinButton = null;
    ImageView muteButton = null;
    boolean muted = false;
    MediaPlayer coinSound = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        this.overridePendingTransition(R.anim.animation_top,R.anim.animation_bottom);

        coinSound = new MediaPlayer().create(this,R.raw.coin3);
        startButton = (ImageView) findViewById(R.id.start_button);
        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(view.getId() == R.id.start_button){
                    Intent intent = new Intent(view.getContext(), SelectingActivity.class);
                    /*mp.pause();

                    if(!muted){
                        mp2.start();
                    }*/


                    startActivityForResult(intent, 0);


                }

            }
        });
        coinButton = (ImageView) findViewById(R.id.coin_button);
        coinButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(view.getId() == R.id.coin_button){
                    Intent intent = new Intent(view.getContext(), CoinSelectActivity.class);
                    coinSound.start();

                    startActivityForResult(intent, 0);


                }

            }
        });

    }



    @Override
    public void onPause(){
        super.onPause();
        //mp.pause();

    }
    @Override
    public void onResume(){
        super.onResume();

       // if(!muted){
          //  muteButton.setImageResource(R.drawable.mute);
           // mp.start();
      //  }

    }



}
