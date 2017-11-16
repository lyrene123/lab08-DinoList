package com.example.laborlyrene.lab08_dinolist;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.laborlyrene.lab08_dinolist.fragments.DinoMenuFragment;

/**
 * Created by laborlyrene on 2017-11-16.
 */

public class DinoAdapter extends BaseAdapter {
    private Context context;
    String [] listDino;
    String[] listDinoInfos;
    int [] listIdDino;
    LayoutInflater inflater;
    private DinoMenuFragment.OnItemSelectedListener listener;

    public DinoAdapter(Context c, String[] list, int[] imageId, String[] listInfos, DinoMenuFragment.OnItemSelectedListener listener){
        context = c;
        listDino = list;
        listIdDino = imageId;
        listDinoInfos = listInfos;
        inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.listener = listener;
    }

    @Override
    public int getCount() {
        return listDino.length;
    }

    @Override
    public Object getItem(int i) {
        return listDino[i];
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    public class ViewHolder {
        TextView tv; ImageView iv;
    }

    @Override
    public View getView(final int position, View view, ViewGroup viewGroup) {
        ViewHolder vh = new ViewHolder();
        View row = view;

        if (view == null) {
            row = inflater.inflate(R.layout.dino_list, null);

            vh.tv = (TextView) row.findViewById(R.id.dinoName);
            vh.iv = (ImageView) row.findViewById(R.id.dinoImg);
            vh.tv.setText(listDino[position]);
            vh.iv.setImageResource(listIdDino[position]);
            row.setTag(vh);
        } else {
            vh = (ViewHolder) view.getTag();
            vh.tv.setText(listDino[position]);
            vh.iv.setImageResource(listIdDino[position]);
        }

        row.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
               /* Intent i = new Intent(context, DinoActivity.class);
                i.putExtra("dino_name", listDino[position]);
                i.putExtra("dino_info", listDinoInfos[position]);
                i.putExtra("dino_image", listIdDino[position]);
                context.startActivity(i);*/
                listener.onDinoItemSelected(position);
            }
        });

        return row;
    }



}
