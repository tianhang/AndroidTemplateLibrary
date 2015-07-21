package com.example.student.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import DAO.PersonDAO;
import beans.Person;


public class MainActivity extends Activity {

    private Button btn;
    private Button btn_list;
    private Button btn_photo;
    public final static String EXTRA_MESSAGE = "com.mycompany.myfirstapp.MESSAGE";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         btn = (Button)findViewById(R.id.id_sign);
         btn_list = (Button)findViewById(R.id.id_tolist);
         btn_photo = (Button)findViewById(R.id.id_photo);
         btn.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {

                 Intent intent = new Intent(MainActivity.this,LoginActivity.class);
                 startActivity(intent);
             }
         });
        btn_list.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ArrayList<Person> list= (ArrayList<Person>)PersonDAO.query(MainActivity.this);
                //Toast.makeText(MainActivity.this,""+list.size(),Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this,ListiewActivity.class);
                intent.putExtra("list",list);

                startActivity(intent);
            }
        });
        btn_photo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this,PhotoBrowserActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch(item.getItemId()){
            case R.id.add_item:
                Toast.makeText(this,"you click add",Toast.LENGTH_SHORT).show();
                break;
            case R.id.remove_item:
                Toast.makeText(this,"you click remove",Toast.LENGTH_LONG).show();
                break;
            default:
                Toast.makeText(this,"you click default",Toast.LENGTH_LONG).show();
                break;
        }
       // return super.onOptionsItemSelected(item);
        return true;
    }

    public void sendMessage(View view) {
        Intent intent = new Intent(this,DisplayMessageActivity.class);
        EditText editText =  (EditText)findViewById(R.id.edit_message);
        String msg = editText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, msg);
        startActivity(intent);
    }

    public void goSecActivity(View view){
        //Intent intent = new Intent("tianhang");
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("http://www.baidu.com"));
        startActivity(intent);
        Log.i("tianhang", "ahha");
    }

}



