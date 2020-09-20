package com.framba.WatO;

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


public class SelectingActivity extends Activity {
    /** Duration of wait **/
    ImageView startView = null;
    EditText xInY = null;
    EditText numOfTrials = null;
    ImageView goButton = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layout);

            this.overridePendingTransition(R.anim.animation_enter,R.anim.animation_leave);

        xInY = (EditText) findViewById(R.id.x_in_y);
        numOfTrials = (EditText) findViewById(R.id.num_of_trial);
        goButton = (ImageView) findViewById(R.id.go_button);
        goButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(view.getId() == R.id.go_button){
                    //Intent intent = new Intent(view.getContext(), SelectingActivity.class);
                    String[] texts = new String[2];
                    String xInY_text = String.valueOf(xInY.getText());
                    String numOfTrials_text = String.valueOf(numOfTrials.getText());
                    texts[0] = xInY_text;
                    texts[1] = numOfTrials_text;
                    Intent i = new Intent(view.getContext(), ResultActivity.class);
                    i.putExtra("values", texts);


                    if(xInY_text.indexOf(" in ") >= 0 && Integer.getInteger(numOfTrials_text) > 0){
                        startActivity(i);
                        finish();
                    }else{
                        if(xInY_text.indexOf(" in ") >= 0){
                            Toast toast = Toast.makeText(getBaseContext(), " Minimum # of Trials > 0", Toast.LENGTH_LONG);
                            xInY.setText("");
                            toast.show();
                        }else{
                            Toast toast = Toast.makeText(getBaseContext(), " Incorrect Format Enter: # in #", Toast.LENGTH_LONG);
                            xInY.setText("");
                            toast.show();
                        }

                    }


                    //startActivityForResult(intent, 0);


                }

            }
        });

    }





}
