package com.framba.WatO;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

/**
 * Created by tommaso on 3/9/2015.
 */
    import android.app.Activity;
    import android.content.Intent;
    import android.os.Bundle;
    import android.view.Menu;
    import android.view.MenuItem;
    import android.view.View;
    import android.widget.EditText;
    import android.widget.ImageView;
import android.widget.Toast;


public class CoinSelectActivity extends Activity {
        EditText xInY = null;
        ImageView goButton = null;
        MediaPlayer coin1 = null;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_coin_select);
            coin1 = new MediaPlayer().create(this,R.raw.coin2);
            this.overridePendingTransition(R.anim.animation_enter,R.anim.animation_leave);
            xInY = (EditText) findViewById(R.id.x_in_y);

            goButton = (ImageView) findViewById(R.id.go_button);
            goButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(view.getId() == R.id.go_button){
                        coin1.start();
                        //Intent intent = new Intent(view.getContext(), SelectingActivity.class);
                        String[] texts = new String[2];
                        String xInY_text = String.valueOf(xInY.getText());

                        texts[0] = xInY_text;

                        Intent i = new Intent(view.getContext(), CoinFlip.class);
                        i.putExtra("values" , texts);

                        if(xInY_text.indexOf(" in ") >= 0){
                            startActivity(i);
                            finish();
                        }else{
                            Toast toast = Toast.makeText(getBaseContext(), " Incorrect Format Enter: # in #", Toast.LENGTH_LONG);
                            xInY.setText("");
                            toast.show();
                        }


                        //startActivityForResult(intent, 0);


                    }

                }
            });


        }

    }
