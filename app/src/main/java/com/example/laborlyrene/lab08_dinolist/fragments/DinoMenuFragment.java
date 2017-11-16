package com.example.laborlyrene.lab08_dinolist.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.laborlyrene.lab08_dinolist.DinoAdapter;
import com.example.laborlyrene.lab08_dinolist.MainActivity;
import com.example.laborlyrene.lab08_dinolist.R;

/**
 * Created by laborlyrene on 2017-11-16.
 */

public class DinoMenuFragment extends Fragment {

    DinoAdapter adapter;
    private String[] dinoNames;
    private int[] dinoImgs;
    private String[] dinoInfos;
    private OnItemSelectedListener listener;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        dinoNames = getResources().getStringArray(R.array.dinoList);
        dinoImgs = new int[]{ R.drawable.ankylosaurus, R.drawable.edmontonia,
                R.drawable.euoplocephalus, R.drawable.hylaeosaurus,
                R.drawable.minmi };
        dinoInfos = getResources().getStringArray(R.array.dinoInfoList);
        adapter = new DinoAdapter(getContext(), dinoNames, dinoImgs, dinoInfos, listener);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup parent,
                             @Nullable Bundle savedInstanceState) {
        // Inflate the xml file for the fragment
        return inflater.inflate(R.layout.fragment_dino_menu, parent, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {

        ListView lvItems = (ListView) view.findViewById(R.id.listView);
        lvItems.setAdapter(adapter);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if(context instanceof OnItemSelectedListener){      // context instanceof YourActivity
            this.listener = (OnItemSelectedListener) context; // = (YourActivity) context
        } else {
            throw new ClassCastException(context.toString()
                    + " must implement DinoMenuFragment.OnItemSelectedListener");
        }
    }

    // Define the events that the fragment will use to communicate
    public interface OnItemSelectedListener {
        // This can be any number of events to be sent to the activity
        void onDinoItemSelected(int position);
    }
}
