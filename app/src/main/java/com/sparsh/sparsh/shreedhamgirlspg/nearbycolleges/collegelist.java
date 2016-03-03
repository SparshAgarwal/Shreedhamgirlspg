package com.sparsh.sparsh.shreedhamgirlspg.nearbycolleges;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;

import com.sparsh.sparsh.shreedhamgirlspg.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by spars on 21-12-2015.
 */
public class collegelist extends Fragment{

    ExpandableListView expandablecollegelistview;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.colleges,container,false);
        expandablecollegelistview =(ExpandableListView)v.findViewById(R.id.expandableListView1);
        List<parentcollege> collegeparentitems=new ArrayList<parentcollege>();
        List<childcollege> childcollegeitems=new ArrayList<childcollege>();
        HashMap<parentcollege,childcollege> childlist = new HashMap<parentcollege,childcollege>();

        collegeparentitems.add(new parentcollege(R.drawable.miranda,"Miranda"));
        collegeparentitems.add(new parentcollege(R.drawable.srcc,"srcc"));
        collegeparentitems.add(new parentcollege(R.drawable.laxmibai,"Laxmi Bai College"));
        collegeparentitems.add(new parentcollege(R.drawable.satyawati,"Satyawati"));

        childcollegeitems.add(new childcollege("Miranda ",""));
        childcollegeitems.add(new childcollege("SRCC",""));
        childcollegeitems.add(new childcollege("Laxmi Bai college",""));
        childcollegeitems.add(new childcollege("Satyawati",""));

        int i=0;
        for (parentcollege parentcollegeitem:collegeparentitems) {
            childlist.put(parentcollegeitem,childcollegeitems.get(i));
            i++;
        }

        collegelistadapter Collegelistadapter = new collegelistadapter(getContext(),collegeparentitems,childlist);
        expandablecollegelistview.setAdapter(Collegelistadapter);

        return v;
    }


}
