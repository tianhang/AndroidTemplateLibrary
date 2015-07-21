package com.example.student.myapplication;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

/**
 * Created by student on 15/7/15.
 */
public class TitleLayout extends LinearLayout {
    public TitleLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.title_layout, this);

        Button btn1 =  (Button)findViewById(R.id.back);
        Button btn2 =  (Button)findViewById(R.id.edit);

        btn1.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(getContext(),"click back",Toast.LENGTH_SHORT).show();
                //Toast.makeText(TitleLayout.this,"",Toast.LENGTH_SHORT).show();
            }
        });

        btn2.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(),"click back",Toast.LENGTH_SHORT).show();
            }
        });

    }

    public void test(View v) {

        switch (v.getId()) {
            case R.id.back:
                Toast.makeText(getContext(),"click back",Toast.LENGTH_SHORT).show();
                Log.i("tianhang",getContext()+"");
                break;
            case R.id.edit:
                Toast.makeText(getContext(),"you click add",Toast.LENGTH_SHORT).show();
                Log.i("tianhang", getContext() + "");
                break;
        }
    }
}