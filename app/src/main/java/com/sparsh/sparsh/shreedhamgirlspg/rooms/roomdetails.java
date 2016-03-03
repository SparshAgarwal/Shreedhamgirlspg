package com.sparsh.sparsh.shreedhamgirlspg.rooms;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.sparsh.sparsh.shreedhamgirlspg.R;

/**
 * Created by spars on 3/1/2016.
 */
public class roomdetails extends Fragment {

    int mainimg1;
    String heading1,sh1,ac1,wr1,b1;

    public roomdetails(int mainimg,String heading,String sh,String ac,String wr, String b ) {
        mainimg1=mainimg;
        heading1=heading;
        sh1=sh;
        ac1=ac;
        wr1=wr;
        b1=b;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View v= inflater.inflate(R.layout.roomdetails,container,false);

        ImageView mainimg=(ImageView)v.findViewById(R.id.rdheadimg);
        mainimg.setImageResource(mainimg1);

        TextView heading=(TextView)v.findViewById(R.id.rdheading);
        heading.setText(heading1);

        TextView sharing=(TextView)v.findViewById(R.id.rdsharing);
        sharing.setText(sh1);

        TextView ac=(TextView)v.findViewById(R.id.rdac);
        ac.setText(ac1);

        TextView washroom=(TextView)v.findViewById(R.id.rdwashroom);
        washroom.setText(wr1);

        TextView balcony=(TextView)v.findViewById(R.id.rdbalcony);
        balcony.setText(b1);


        return v;
    }
}
