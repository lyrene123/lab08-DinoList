package com.example.laborlyrene.lab08_dinolist;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

/**
 * Created by laborlyrene on 2017-10-20.
 */

public class DogActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dino);
        String name;
        int id;

        TextView tvName = (TextView) findViewById(R.id.tv_dino);
        TextView tvInfo = (TextView) findViewById(R.id.tv_info);
        ImageView iv = (ImageView) findViewById(R.id.iv_dino);

        if ( getIntent().hasExtra("dino_name") ) {
            tvName.setText(getIntent().getExtras().getString("dino_name"));
        } else {
            tvName.setText("no name");
        }

        if(getIntent().hasExtra("dino_info") ){
            tvInfo.setText(getIntent().getExtras().getString("dino_info"));
        } else {
            tvInfo.setText("info unavailable");
        }

        if ( getIntent().hasExtra("dino_image") ) {
            iv.setImageResource(getIntent().getExtras().getInt("dino_image"));
        }


    }
}
