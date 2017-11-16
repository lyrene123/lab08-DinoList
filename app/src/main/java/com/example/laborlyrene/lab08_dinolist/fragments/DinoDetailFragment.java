package com.example.laborlyrene.lab08_dinolist.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.laborlyrene.lab08_dinolist.R;

/**
 * Created by laborlyrene on 2017-11-16.
 */

public class DinoDetailFragment extends Fragment {
    int position = 0;
    TextView tvTitle;
    TextView tvDetails;
    ImageView imgIV;
    private int[] dinoImgs;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if(savedInstanceState == null){
            // Get back arguments
            if(getArguments() != null) {
                position = getArguments().getInt("position", 0);
            }
        }

        dinoImgs = new int[]{ R.drawable.ankylosaurus, R.drawable.edmontonia,
                R.drawable.euoplocephalus, R.drawable.hylaeosaurus,
                R.drawable.minmi };
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup parent,
                             @Nullable Bundle savedInstanceState) {

        // Inflate the xml file for the fragment
        return inflater.inflate(R.layout.activity_dino, parent, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {

        // Set values for view here
        tvTitle = (TextView) view.findViewById(R.id.tv_dino);
        tvDetails = (TextView) view.findViewById(R.id.tv_info);
        imgIV = (ImageView) view.findViewById(R.id.iv_dino);

        // update view
        tvTitle.setText(getResources().getStringArray(R.array.dinoList)[position]);
        tvDetails.setText(getResources().getStringArray(R.array.dinoInfoList)[position]);
        imgIV.setImageResource(dinoImgs[position]);
    }

    // Activity is calling this to update view on Fragment
    public void updateView(int position){
        // update view
        tvTitle.setText(getResources().getStringArray(R.array.dinoList)[position]);
        tvDetails.setText(getResources().getStringArray(R.array.dinoInfoList)[position]);
        imgIV.setImageResource(dinoImgs[position]);
    }
}
