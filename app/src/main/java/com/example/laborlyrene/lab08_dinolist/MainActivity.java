package com.example.laborlyrene.lab08_dinolist;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private String[] dinoNames;
    private int[] dinoImgs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dinoNames = getResources().getStringArray(R.array.dinoList);
        dinoImgs = new int[]{ R.drawable.ankylosaurus, R.drawable.edmontonia,
                        R.drawable.euoplocephalus, R.drawable.hylaeosaurus,
                        R.drawable.minmi };
        ListView list = (ListView) findViewById(R.id.listView);
        Log.d("CHECK THISSSSSSSSS", list + " ");
        list.setAdapter(new DinoAdapter(this, dinoNames, dinoImgs));
    }

    public class DinoAdapter extends BaseAdapter {
        private Context context;
        String [] listDino;
        int [] listIdDino;
        LayoutInflater inflater;

        public DinoAdapter(Context c, String[] list, int[] imageId){
            context = c;
            listDino = list;
            listIdDino = imageId;
            inflater = ( LayoutInflater )context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }

        @Override
        public int getCount() {
            return listDino.length;
        }

        @Override
        public Object getItem(int i) {
            return i;
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        public class ViewHolder {
            TextView tv; ImageView iv;
        }

        @Override
        public View getView(int position, View view, ViewGroup viewGroup) {
            ViewHolder vh = new ViewHolder();
            View row = view;

            if (view == null) {
                row = inflater.inflate(R.layout.dino_list, null);

                vh.tv = (TextView) row.findViewById(R.id.dinoName);
                vh.iv = (ImageView) row.findViewById(R.id.dinoImg);
                vh.tv.setText(listDino[position]);
                vh.iv.setImageResource(listIdDino[position]);
                row.setTag(vh);
                // can set the listener here if I want to
            } else {
                vh = (ViewHolder) view.getTag();
                // spotted by Brian Doherty 2017-03-06
                // we are re using the view but changing the content
                vh.tv.setText(listDino[position]);
                vh.iv.setImageResource(listIdDino[position]);
            }

            return row;
        }
    }
}
