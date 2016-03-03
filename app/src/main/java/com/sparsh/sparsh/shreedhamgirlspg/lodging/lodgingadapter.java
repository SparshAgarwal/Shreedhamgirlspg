package com.sparsh.sparsh.shreedhamgirlspg.lodging;

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
public class lodgingadapter extends BaseExpandableListAdapter{

    private List<lodgingparent> lodgingparentlist;
    private HashMap<lodgingparent,lodgingchild> lodgingchildlist;
    private Context context;


    public lodgingadapter(Context context,List<lodgingparent> lodgingparentlist,HashMap<lodgingparent,lodgingchild> lodgingchildlist) {

        this.context=context;
        this.lodgingparentlist=lodgingparentlist;
        this.lodgingchildlist=lodgingchildlist;


    }

    @Override
    public int getGroupCount() {
        return lodgingparentlist.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return 1;
    }

    @Override
    public Object getGroup(int groupPosition) {
        return lodgingparentlist.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return lodgingchildlist.get(lodgingparentlist.get(groupPosition));
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

        lodgingparent lodgingparentlistitem =(lodgingparent)this.getGroup(groupPosition);
        if(convertView == null)
        {
            LayoutInflater inflater=(LayoutInflater)this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.lodginglistparentitem,null);
        }

        ImageView imageView =(ImageView)convertView.findViewById(R.id.imageView1);
        imageView.setImageResource(lodgingparentlistitem.getImage_id());

        TextView textView =(TextView)convertView.findViewById(R.id.textView6);
        textView.setText(lodgingparentlistitem.getTextview());

        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {

        lodgingchild lodgingchildlistitem = (lodgingchild)this.getChild(groupPosition,childPosition);
        if(convertView==null)
        {
            LayoutInflater inflater=(LayoutInflater)this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.lodginglistchilditem,null);
        }
        TextView textView1=(TextView)convertView.findViewById(R.id.t10);
        textView1.setText(lodgingchildlistitem.getText1());

        TextView textView2=(TextView)convertView.findViewById(R.id.t11);
        textView2.setText(lodgingchildlistitem.getText2());

        TextView textView3=(TextView)convertView.findViewById(R.id.t12);
        textView3.setText(lodgingchildlistitem.getText3());

        TextView textView4=(TextView)convertView.findViewById(R.id.t13);
        textView4.setText(lodgingchildlistitem.getText4());

        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }


}
