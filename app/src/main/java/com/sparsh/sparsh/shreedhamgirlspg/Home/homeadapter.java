package com.sparsh.sparsh.shreedhamgirlspg.Home;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

import com.sparsh.sparsh.shreedhamgirlspg.R;

/**
 * Created by spars on 19-01-2016.
 */
public class homeadapter extends ArrayAdapter<Integer>

{
    private Context context;

    public homeadapter(Context context, Integer[] imglist) {
        super(context,R.layout.homeadapter , imglist);
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater homeinflater=LayoutInflater.from(getContext());
        View custom=homeinflater.inflate(R.layout.homeadapter, parent, false);

        Integer singleimg=getItem(position);
        ImageView homeimg=(ImageView)custom.findViewById(R.id.imageView);

        homeimg.setImageResource(singleimg);
        return  custom;
    }
}
