package com.example.laborlyrene.lab08_dinolist;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private String[] dinoNames;
    private int[] dinoImgs;
    private String[] dinoInfos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dinoNames = getResources().getStringArray(R.array.dinoList);
        dinoImgs = new int[]{ R.drawable.ankylosaurus, R.drawable.edmontonia,
                        R.drawable.euoplocephalus, R.drawable.hylaeosaurus,
                        R.drawable.minmi };
        dinoInfos = getResources().getStringArray(R.array.dinoInfoList);
        ListView list = (ListView) findViewById(R.id.listView);
        list.setAdapter(new DinoAdapter(this, dinoNames, dinoImgs, dinoInfos));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.activity_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch(item.getItemId()){
            case R.id.website :
                openWebsite();
                return true;
            case R.id.about :
                displayAboutPage();
                return true;
            default :
                openWebsite();
                return true;
        }
    }

    private void openWebsite(){
        String url = "http://www.kidsdinos.com/armored-dinosaur/";
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse(url));
        startActivity(i);
    }

    public class DinoAdapter extends BaseAdapter {
        private Context context;
        String [] listDino;
        String[] listDinoInfos;
        int [] listIdDino;
        LayoutInflater inflater;

        public DinoAdapter(Context c, String[] list, int[] imageId, String[] listInfos){
            context = c;
            listDino = list;
            listIdDino = imageId;
            listDinoInfos = listInfos;
            inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
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
                    Intent i = new Intent(context, DogActivity.class);
                    i.putExtra("dino_name", listDino[position]);
                    i.putExtra("dino_info", listDinoInfos[position]);
                    i.putExtra("dino_image", listIdDino[position]);
                    context.startActivity(i);
                }
            });

            return row;
        }
    }
}
