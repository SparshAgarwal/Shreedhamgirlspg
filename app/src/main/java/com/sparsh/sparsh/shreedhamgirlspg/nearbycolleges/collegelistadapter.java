package com.sparsh.sparsh.shreedhamgirlspg.nearbycolleges;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.sparsh.sparsh.shreedhamgirlspg.R;

import java.util.HashMap;
import java.util.List;

/**
 * Created by spars on 21-12-2015.
 */
public class collegelistadapter extends BaseExpandableListAdapter{

    private List<parentcollege> parentcollegelist;
    private HashMap<parentcollege,childcollege> childcollegelist;
    private Context context;


    public collegelistadapter(Context context,List<parentcollege> parentcollegelist,HashMap<parentcollege,childcollege> childcollegelist) {

        this.context=context;
        this.parentcollegelist=parentcollegelist;
        this.childcollegelist=childcollegelist;


    }

    @Override
    public int getGroupCount() {
        return parentcollegelist.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return 1;
    }

    @Override
    public Object getGroup(int groupPosition) {
        return parentcollegelist.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return childcollegelist.get(parentcollegelist.get(groupPosition));
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {

        parentcollege parentcollegelistitem =(parentcollege)this.getGroup(groupPosition);
        if(convertView == null)
        {
            LayoutInflater inflater=(LayoutInflater)this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.collegelistparentitem,null);
        }

        ImageView imageView =(ImageView)convertView.findViewById(R.id.imageView);
        imageView.setImageResource(parentcollegelistitem.getImage_id());

        TextView textView =(TextView)convertView.findViewById(R.id.textView5);
        textView.setText(parentcollegelistitem.getTextview());

        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {

        childcollege childcollegelistitem = (childcollege)this.getChild(groupPosition,childPosition);
        if(convertView==null)
        {
            LayoutInflater inflater=(LayoutInflater)this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.collegelistchilditem,null);
        }
        TextView textView1=(TextView)convertView.findViewById(R.id.t8);
        textView1.setText(childcollegelistitem.getText1());

        TextView textView2=(TextView)convertView.findViewById(R.id.t9);
        textView2.setText(childcollegelistitem.getText2());

        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }


}
