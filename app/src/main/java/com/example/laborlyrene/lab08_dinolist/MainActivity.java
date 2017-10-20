package com.example.laborlyrene.lab08_dinolist;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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
        public View getView(int i, View view, ViewGroup viewGroup) {
            return null;
        }
    }
}
