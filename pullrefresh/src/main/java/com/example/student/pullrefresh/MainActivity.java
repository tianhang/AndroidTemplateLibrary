package com.example.student.pullrefresh;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.student.pullrefresh.view.RefreshListView;

import java.util.ArrayList;


public class MainActivity extends Activity {
    private RefreshListView refreshListView;
    private ArrayList<String> list = new ArrayList<String>();
    private MyAdapter adapter;
    private Handler handler = new Handler(){
        @Override
        public void handleMessage(android.os.Message msg) {
            //更新UI
            adapter.notifyDataSetChanged();
            refreshListView.completeRefresh();
        };
    };

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
        for(int i =0;i<50;i++){
            list.add("listview data ->"+i);
        }
        // addHeadView must be operated before set adapter
//        View headView = View.inflate(this,R.layout.layout_header,null);
//        refreshListView.addHeaderView(headView);

        adapter = new MyAdapter();
        refreshListView.setAdapter(adapter);

        refreshListView.setOnRefreshListener(new RefreshListView.OnRefreshListener() {
            @Override
            public void onPullRefresh() {
                //需要联网请求服务器的数据，然后更新UI
                requestDataFromServer(false);
            }

            @Override
            public void onLoadingMore() {
                requestDataFromServer(true);
            }
        });

    }
    /**
     * 模拟向服务器请求数据
     */
    private void requestDataFromServer(final boolean isLoadingMore){
        new Thread(){
            public void run() {
                SystemClock.sleep(3000);//模拟请求服务器的一个时间长度

                if(isLoadingMore){
                    list.add("加载更多的数据-1");
                    list.add("加载更多的数据-2");
                    list.add("加载更多的数据-3");
                }else {
                    list.add(0, "下拉刷新的数据");
                }

                //在UI线程更新UI
                handler.sendEmptyMessage(0);
            };
        }.start();
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
