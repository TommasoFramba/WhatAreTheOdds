package com.framba.WatO;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;


public class CoinFlip extends Activity {
    ImageView coinPress = null;
    Drawable heads = null;
    Drawable tails = null;
    TextView reButton = null;
    TextView backButton = null;
    boolean pressed = false;
    MediaPlayer coinSound = null;
    MediaPlayer coin1 = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        this.overridePendingTransition(R.anim.animation_top,R.anim.animation_bottom);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coin_flip);

        //Initalize both heads and tails image drawables
        heads = getResources().getDrawable( R.drawable.heads);
        tails = getResources().getDrawable( R.drawable.tails);

        coinSound = new MediaPlayer().create(this,R.raw.coin_drop);
        coin1 = new MediaPlayer().create(this,R.raw.coin4);

        //Recieve Odds given
        Intent intent = getIntent();
        String[] texts = intent.getStringArrayExtra("values");
        int numerator = 0;
        try {
            numerator = Integer.valueOf(texts[0].substring(0,texts[0].indexOf("in") - 1));
            //go on as normal
        } catch (NumberFormatException e) {
            numerator = 1;
        }
        int denomenator = 1;
        try {
            denomenator = Integer.valueOf(texts[0].substring(texts[0].indexOf("in") + 3));
            //go on as normal
        } catch (NumberFormatException e) {
            denomenator = 2;
        }

        coinPress = (ImageView) findViewById(R.id.coin);
        final int finalNumerator = numerator;
        final int finalDenomenator = denomenator;
        coinPress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(view.getId() == R.id.coin && !pressed){
                    coinSound.start();
                    pressed = true;
                    double chance = ((double) finalNumerator /(double) finalDenomenator)*100;
                    double r = (Math.random()*100);
                    if(r <= chance){
                        coinPress.setImageDrawable(heads);
                    }else{
                        coinPress.setImageDrawable(tails);
                    }
                }


            }
        });
        reButton = (TextView) findViewById(R.id.New_Odds);
        reButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(view.getId() == R.id.New_Odds){
                    coin1.start();
                    recreate();

                }

            }
        });
        backButton = (TextView) findViewById(R.id.Home);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(view.getId() == R.id.Home){
                    //Intent intent = new Intent(view.getContext(), SelectingActivity.class);
                    Intent i = new Intent(view.getContext(), SplashActivity.class);
                    coin1.start();
                    startActivity(i);
                    finish();


                }

            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_coin_flip, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
