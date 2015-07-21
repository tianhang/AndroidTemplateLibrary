package com.example.student.myapplication;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import service.LoginService;


public class LoginActivity extends Activity {
    private EditText ed_username;
    private EditText ed_password;
    private Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ed_username = (EditText)findViewById(R.id.id_username);
        ed_password = (EditText)findViewById(R.id.id_password);
        btn = (Button)findViewById(R.id.id_submit_btn);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e("dir", getFilesDir() + "");
                login();

                SharedPreferences sp = getSharedPreferences("config", MODE_PRIVATE);
                //SharedPreferences.Editor editor = sp.edit();
                String username = sp.getString("username", "no la");
                String password = sp.getString("password", "null");
                Toast.makeText(LoginActivity.this, username + "-->" + password, Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void login(){
        String username = ed_username.getText().toString().trim();
        String password = ed_password.getText().toString().trim();
        if(TextUtils.isEmpty(username)||TextUtils.isEmpty(password)){
            Toast.makeText(LoginActivity.this,"username or password can not be empty !",Toast.LENGTH_SHORT).show();
        }else {
            LoginService.saveUserInfo(this,username, password);
            Toast.makeText(LoginActivity.this, "save success !", Toast.LENGTH_SHORT).show();
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_login, menu);
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
