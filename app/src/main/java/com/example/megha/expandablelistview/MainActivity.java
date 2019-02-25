package com.example.megha.expandablelistview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    ExpandableListView expandableListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        expandableListView = findViewById(R.id.exp_listview);
        List<String> Headings = new ArrayList<String>();
        List<String> H1 = new ArrayList<String>();
        List<String> H2 = new ArrayList<String>();
        List<String> H3 = new ArrayList<String>();

        HashMap<String, List<String>> hashMap = new HashMap<String, List<String>>();

        String Heading_Items[] = getResources().getStringArray(R.array.heading_items);
        String Head1[] = getResources().getStringArray(R.array.h1);
        String Head2[] = getResources().getStringArray(R.array.h2);
        String Head3[] = getResources().getStringArray(R.array.h3);

        for (String title : Heading_Items) {
            Headings.add(title);
        }

        for (String title : Head1) {
            H1.add(title);
        }

        for (String title : Head2) {
            H2.add(title);
        }

        for (String title : Head3) {
            H3.add(title);
        }

        hashMap.put(Headings.get(0), H1);
        hashMap.put(Headings.get(1), H2);
        hashMap.put(Headings.get(2), H3);

        final MyAdapter myAdapter = new MyAdapter(this, Headings, hashMap);
        expandableListView.setAdapter(myAdapter);
        
        expandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
                String title = (String) myAdapter.getChild(groupPosition,childPosition);
                Toast.makeText(MainActivity.this, title, Toast.LENGTH_SHORT).show();
                return  false;
            }
        });


    }
   



}
