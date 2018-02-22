package com.utng.vgutierrez.nieves;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class ListActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private Snow[] snows = {
            new Snow(R.drawable.nieves3, "Nieves Garcia", "Desde 1987", "Nieves y Heledos"),
            new Snow(R.drawable.nieves1, "Nieves el volcan","Desde 1987", "Nieves y Helados"),
            new Snow(R.drawable.nieves2, "Helados Josue","Desde 1987", "Nieves y Helados"),
            new Snow(R.drawable.nieves4, "Nieves Maria","Desde 1987", "Nieves y Helados"),
            new Snow(R.drawable.nieves5, "Helados Miguel","Desde 1987", "Nieves y Helados"),


    };
    private ListView lsvSnows;



    @Override
    protected void
    onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        lsvSnows = (ListView) findViewById(R.id.lsv_snows);
        SnowAdapter adapter= new SnowAdapter(
                this,snows);
        lsvSnows.setAdapter(adapter);

        lsvSnows.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        String selectedOption = ((Snow)parent.getItemAtPosition(position)).getName();

        Toast.makeText(this, "You Selected: " + selectedOption, Toast.LENGTH_SHORT).show();
    }
    static class ViewHolder{
        TextView txvName;
        TextView txvStart;
        TextView txvType;
        ImageView imvPhoto;
    }

    class SnowAdapter extends ArrayAdapter<Snow> {
        public SnowAdapter(@NonNull Context context, Snow[]data){
            super(context, R.layout.activity_snow, data);
        }
        @NonNull
        @Override
        public View getView(int position, View convertView, @NonNull ViewGroup parent) {
            View cell = convertView;
            ViewHolder holder;
            if (cell == null) {
                LayoutInflater inflater =
                        LayoutInflater.from(getContext());
                cell = inflater.inflate(R.layout.activity_snow, null);

                holder = new ViewHolder();
                holder.imvPhoto = (ImageView) cell.findViewById(R.id.imv_photo);
                holder.txvName = (TextView) cell.findViewById(R.id.txv_name);
                holder.txvStart = (TextView) cell.findViewById(R.id.txv_start);
                holder.txvType = (TextView) cell.findViewById(R.id.txv_type);

                cell.setTag(holder);
            } else {
                holder = (ViewHolder) cell.getTag();
            }
            holder.imvPhoto.setImageResource(snows[position].getImageId());
            holder.txvName.setText(snows[position].getName());
            holder.txvStart.setText(snows[position].getStart());
            holder.txvType.setText(snows[position].getType());
            return cell;
        }
    }
}
