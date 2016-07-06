package com.example.m.pra11expandablelistview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ExpandableListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ExpandableListView expande;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        expande=(ExpandableListView)findViewById(R.id.expandableListView);
        List<String> titles = new ArrayList<String>();
        List<String> l1 = new ArrayList<String>();
        List<String> l2= new ArrayList<String>();
        Log.d("Uwaga","1");
        List<String> l3 = new ArrayList<String>();
        HashMap<String,List<String>> childList = new HashMap<String,List<String>>();
        String [] titless = getResources().getStringArray(R.array.MainTitle);
        String []l11 = getResources().getStringArray(R.array.childAngielska);
        String []l22 = getResources().getStringArray(R.array.childHiszpańska);
        Log.d("Uwaga","2");
        String []l33 = getResources().getStringArray(R.array.childWłoska);
        for (String item:titless){
            titles.add(item);
            Log.d("Uwaga","3");
        }
        for (String item:l11){
            l1.add(item);
            Log.d("Uwaga","41");
        }
        for (String item:l22){
           l2.add(item);
            Log.d("Uwaga","5");
        }
        for (String item:l33){
            l3.add(item);
        }
        childList.put(titles.get(0),l1);
        Log.d("Uwaga","6");
        childList.put(titles.get(1),l2);
        Log.d("Uwaga","7");
        childList.put(titles.get(2),l3);
        Adapter adapter = new Adapter(this,titles,childList);
        expande.setAdapter(adapter);


    }
}
