package com.framba.WatO;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;


public class ResultActivity extends Activity {
    EditText xInY = null;
    EditText numOfTrials = null;
    TextView te = null;
    TextView te2 = null;
    private ArrayAdapter<String> listAdapter ;
    private ListView resultListView ;
    TextView backButton = null;
    TextView reButton = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        backButton = (TextView) findViewById(R.id.Home);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(view.getId() == R.id.Home){
                    //Intent intent = new Intent(view.getContext(), SelectingActivity.class);
                    Intent i = new Intent(view.getContext(), SplashActivity.class);
                    startActivity(i);
                    finish();
                    //startActivityForResult(intent, 0);
                }

            }
        });


        resultListView = (ListView) findViewById( R.id.result_list_view );
        resultListView.setClickable(false);
        Drawable myIcon = getResources().getDrawable( R.drawable.red_bg );
        resultListView.setDivider(myIcon);
        resultListView.setDividerHeight(30);

        this.overridePendingTransition(R.anim.animation_top,R.anim.animation_bottom);
        xInY = (EditText) findViewById(R.id.x_in_y);
        numOfTrials = (EditText) findViewById(R.id.num_of_trial);
        te = (TextView) findViewById(R.id.HelloWorld);
        te2 = (TextView) findViewById(R.id.HelloWorld2);
        Intent intent = getIntent();
        String[] texts = intent.getStringArrayExtra("values");
        final int numerator = Integer.valueOf(texts[0].substring(0,texts[0].indexOf("in") - 1));
        final int denomenator = Integer.valueOf(texts[0].substring(texts[0].indexOf("in") + 3));

        String text1 = "The Odds: \n" + numerator + " in " + denomenator + " = " + ((double)Math.round((((double)numerator/(double)denomenator)*100) * 10) / 10) + "%";
        te.setText(text1);
        String text2 = "# of Trials: \n" + texts[1];
        te2.setText(text2);
        
        int times = Integer.valueOf(texts[1]);
        String[] tfArray = new String[times];
        double chance = ((double)numerator/(double)denomenator)*100;
        for (int i = 0; i < times; i++){
            double r = (Math.random()*100);
            if(r <= chance){
                tfArray[i] = (i+1) + ": true";
            }else{
                tfArray[i] = (i+1) + ": false";
            }
        }
        ArrayList<String> tfList = new ArrayList<String>();
        tfList.addAll( Arrays.asList(tfArray) );
        listAdapter = new CustomAdapter(this, R.layout.simplerow, tfList);


        resultListView.setAdapter( listAdapter );

        reButton = (TextView) findViewById(R.id.New_Odds);
        reButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(view.getId() == R.id.New_Odds){
                    //Intent intent = new Intent(view.getContext(), SelectingActivity.class);

                    /*Integer[] numAndDem = {numerator, denomenator};
                    Intent i = new Intent(view.getContext(), ResultActivity.class);
                    i.putExtra("values",numAndDem);
                    startActivity(i);
                    finish();*/
                    recreate();
                    //startActivityForResult(intent, 0);
                }

            }
        });


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_result, menu);
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
