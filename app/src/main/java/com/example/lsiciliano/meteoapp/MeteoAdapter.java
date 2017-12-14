package com.example.lsiciliano.meteoapp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by l.siciliano on 14/12/2017.
 */

public class MeteoAdapter  extends RecyclerView.Adapter<MeteoAdapter.CityViewHolder>{
    private final Context context;
    private final ArrayList items;

    public MeteoAdapter(Activity activity, ArrayList items) {
        this.context = activity;
        this.items = items;
    }

    @Override
    public CityViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.rowlayout, parent, false);
        return new CityViewHolder(v);
    }

    @Override
    public void onBindViewHolder(CityViewHolder holder, final int position) {
        holder.textView.setText((String) items.get(position));
        holder.imageView.setImageDrawable(context.getResources().getDrawable(R.drawable.thumb));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(context, CityActivity.class);
                i.putExtra("cityTitle", (String) items.get(position));
                context.startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class CityViewHolder extends RecyclerView.ViewHolder {
        TextView textView;// init the item view's
        ImageView imageView;

        public CityViewHolder(View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.title);
            imageView = (ImageView) itemView.findViewById(R.id.thumb);
        }
    }
}
