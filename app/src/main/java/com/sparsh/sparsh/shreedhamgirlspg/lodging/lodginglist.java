package com.sparsh.sparsh.shreedhamgirlspg.lodging;

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
public class lodginglist extends Fragment {

    ExpandableListView expandablelodginglistview;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.lodging, container, false);
        expandablelodginglistview = (ExpandableListView) v.findViewById(R.id.expandableListView2);
        List<lodgingparent> lodgingparentitems = new ArrayList<lodgingparent>();
        List<lodgingchild> childlodgingitems = new ArrayList<lodgingchild>();
        HashMap<lodgingparent, lodgingchild> childlist = new HashMap<lodgingparent, lodgingchild>();

        lodgingparentitems.add(new lodgingparent(R.drawable.r1, "Category1"));
        lodgingparentitems.add(new lodgingparent(R.drawable.r5, "Category2"));
        lodgingparentitems.add(new lodgingparent(R.drawable.r6, "Category3"));
        lodgingparentitems.add(new lodgingparent(R.drawable.r2, "Category4"));
        lodgingparentitems.add(new lodgingparent(R.drawable.r3, "Category5"));
        lodgingparentitems.add(new lodgingparent(R.drawable.r4, "Category6"));

        childlodgingitems.add(new lodgingchild("Single room", "Air Conditioned", "Shared Washroom", "With Balcony"));
        childlodgingitems.add(new lodgingchild("Triple sharing room", "Air Conditioned", "Attached Washroom", "With Balcony"));
        childlodgingitems.add(new lodgingchild("Twin sharing room", "Air Conditioned", "Shared Washroom", "With Balcony"));
        childlodgingitems.add(new lodgingchild("Twin sharing room", "Non Air Conditioned", "Shared Washroom", "With Balcony"));
        childlodgingitems.add(new lodgingchild("Twin sharing room", "Air Conditioned", "Shared Washroom", "With Balcony"));
        childlodgingitems.add(new lodgingchild("Triple sharing room", "Non Air Conditioned", "Shared Washroom", "Without Balcony"));


        int i = 0;
        for (lodgingparent lodgingparentitem : lodgingparentitems) {
            childlist.put(lodgingparentitem, childlodgingitems.get(i));
            i++;
        }

        lodgingadapter lodginglistadapters = new lodgingadapter(getContext(), lodgingparentitems, childlist);
        expandablelodginglistview.setAdapter(lodginglistadapters);

        return v;
    }


}
