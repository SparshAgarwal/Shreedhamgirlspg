package com.sparsh.sparsh.shreedhamgirlspg.Home;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.sparsh.sparsh.shreedhamgirlspg.R;

/**
 * Created by spars on 19-12-2015.
 */

public class Home extends Fragment{

    ListView homelist;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View v= inflater.inflate(R.layout.home,container,false);
        homelist=(ListView)v.findViewById(R.id.homelist);



        Integer[] hmeinglist={R.drawable.comfortable,
                R.drawable.peaceful,
                R.drawable.secure,
                R.drawable.meals};

        homeadapter homeadap= new homeadapter(getContext(),hmeinglist);
        homelist.setAdapter(homeadap);

        return v;



    }


}
