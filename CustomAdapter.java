package com.framba.WatO;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by tommaso on 3/11/2015.
 */
public class CustomAdapter extends ArrayAdapter<String> {
    public CustomAdapter(Context context, int resource, List<String> objects) {
        super(context, resource, objects);
    }

    @Override
    public View getView(int pos, View convertView, ViewGroup parent){
        View v = super.getView(pos, convertView, parent);
        TextView tv = (TextView)v.findViewById(R.id.rowTextView);
        String text = tv.getText().toString();
        if (text.substring(text.indexOf(":") + 2).equals("false")) {
           tv.setBackgroundColor(Color.TRANSPARENT);
        } else {

            tv.setBackgroundColor(Color.GREEN);
        }
        return v;
    }
}
