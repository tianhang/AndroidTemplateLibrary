package com.example.student.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import beans.Person;


public class ListiewActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listiew);

        ListView listView = (ListView)findViewById(R.id.id_lv);
        List<Person> list = (List<Person>)getIntent().getSerializableExtra("list");
        List<Map<String,String>> mapList = new ArrayList<Map<String,String>>();
        for(Person p :list){
            Map<String,String> map = new HashMap<String,String>();
            map.put("name",p.getName());
            map.put("phone",p.getPhone());
            mapList.add(map);
            //Log.i("list-test",p.getName()+"-"+p.getPhone());
        }
        SimpleAdapter adapter = new SimpleAdapter(this,mapList,R.layout.list_item,new String[]{"name","phone"},
                new int[]{R.id.id_name,R.id.id_phone});
        listView.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_listiew, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
