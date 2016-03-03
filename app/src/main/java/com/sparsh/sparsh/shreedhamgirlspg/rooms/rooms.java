package com.sparsh.sparsh.shreedhamgirlspg.rooms;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.sparsh.sparsh.shreedhamgirlspg.R;

/**
 * Created by spars on 3/1/2016.
 */
public class rooms extends Fragment {

    ImageView r1,r2,r3,r4,r5,r6;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View v=inflater.inflate(R.layout.rooms,container,false);

        ImageView r1=(ImageView)v.findViewById(R.id.room1);
        ImageView r2=(ImageView)v.findViewById(R.id.room2);
        ImageView r3=(ImageView)v.findViewById(R.id.room3);
        ImageView r4=(ImageView)v.findViewById(R.id.room4);
        ImageView r5=(ImageView)v.findViewById(R.id.room5);
        ImageView r6=(ImageView)v.findViewById(R.id.room6);


        r1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager().beginTransaction().setCustomAnimations(R.animator.card_flip_right_in,R.animator.card_flip_right_out,R.animator.card_flip_left_in,R.animator.card_flip_left_out).replace(R.id.rooms,new roomdetails(R.drawable.r1,"Category 1","Single room","Yes","attached","Yes")).addToBackStack(null).commit();
            }
        });







        return v;
    }
}
