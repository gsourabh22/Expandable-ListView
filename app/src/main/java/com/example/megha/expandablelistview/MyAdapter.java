package com.example.megha.expandablelistview;


import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;

import android.widget.TextView;


import java.util.HashMap;
import java.util.List;


public class MyAdapter extends BaseExpandableListAdapter {

    private Context ctx;
    private List<String> Header_titles;
    private HashMap<String, List<String>> Child_titles;

    MyAdapter(Context ctx, List<String> Header_titles, HashMap<String, List<String>> Child_titles) {
        this.ctx = ctx;
        this.Header_titles = Header_titles;
        this.Child_titles = Child_titles;
    }

    @Override
    public int getGroupCount() {
        return Header_titles.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return Child_titles.get(Header_titles.get(groupPosition)).size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return Header_titles.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return Child_titles.get(Header_titles.get(groupPosition)).get(childPosition);
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
        String title = (String) this.getGroup(groupPosition);
        if (convertView == null) {
            LayoutInflater layoutInflater = (LayoutInflater) this.ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.parent_layout, null);

        }
        TextView textView = convertView.findViewById(R.id.text_parent);
        textView.setText(title);
        textView.setTypeface(null,Typeface.BOLD);
        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {

        String title = (String) this.getChild(groupPosition, childPosition);
        if (convertView == null) {
            LayoutInflater layoutInflater = (LayoutInflater) this.ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.child_layout, null);
        }

        TextView textView = convertView.findViewById(R.id.text_child);
        textView.setText(title);
        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }


}
