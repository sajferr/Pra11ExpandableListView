package com.example.m.pra11expandablelistview;

import android.content.Context;
import android.graphics.Typeface;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import java.util.HashMap;
import java.util.List;

/**
 * Created by m on 2016-07-06.
 */
public class Adapter extends BaseExpandableListAdapter {
    private List<String> mainTitles;
    private HashMap<String,List<String>> childTitles;
    private Context context;
    Adapter(Context context,List<String> mainTitles,HashMap<String,List<String>>childTitles){
     this.mainTitles=mainTitles;
        this.context=context;
        Log.d("Uwaga","22");
        this.childTitles=childTitles;

    }
    @Override
    public int getGroupCount() {
        Log.d("Uwaga","getGroupCount(");
        return mainTitles.size();

    }

    @Override
    public int getChildrenCount(int groupPosition) {
        Log.d("Uwaga","getChildrenCount");
        return childTitles.get(mainTitles.get(groupPosition)).size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        Log.d("Uwaga"," getGroup");
        return mainTitles.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        Log.d("Uwaga","getChild");
        return childTitles.get(mainTitles.get(groupPosition)).get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        Log.d("Uwaga","getGroupId");
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        Log.d("Uwaga","getChildId");
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        Log.d("Uwaga","hasStableIds");
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        String title = (String) this.getGroup(groupPosition);
        Log.d("Uwaga","11131");
        if(convertView==null){
            Log.d("Uwaga","1222");
            LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView=inflater.inflate(R.layout.row,null);
        }
        Log.d("Uwaga","12222222222");
            TextView tekst = (TextView)convertView.findViewById(R.id.textView);
            tekst.setTypeface(null,Typeface.BOLD);
            tekst.setText(title);



        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        String title = (String) this.getChild(groupPosition,childPosition);
        if(convertView==null){
            Log.d("Uwaga","131313131");
            LayoutInflater inflater = (LayoutInflater)this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView=inflater.inflate(R.layout.row_child,null);
        }
        Log.d("Uwaga","11313131313131313131313");
        TextView tekst = (TextView)convertView.findViewById(R.id.textView2);
        tekst.setTypeface(null,Typeface.BOLD);
        tekst.setText(title);



        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return false;
    }
}
