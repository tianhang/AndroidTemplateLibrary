package com.example.student.pullrefresh;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.student.pullrefresh.view.RefreshListView;

import java.util.ArrayList;


public class MainActivity extends Activity {
    private RefreshListView refreshListView;
    private ArrayList<String> list = new ArrayList<String>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
        initData();
    }
    private void initView(){
        setContentView(R.layout.activity_main);
        refreshListView = (RefreshListView)findViewById(R.id.refreshListView);
    }
    private void initData(){
        for(int i =0;i<150;i++){
            list.add("listview data ->"+i);
        }
        MyAdapter myAdapter = new MyAdapter();
        refreshListView.setAdapter(myAdapter);
    }

    class MyAdapter extends BaseAdapter{

        @Override
        public int getCount() {
            return list.size();
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            TextView textview = new TextView(MainActivity.this);
            textview.setPadding(20,20,20,20);
            textview.setTextSize(18);
            textview.setText(list.get(position));
            return textview;
        }
    }
}
