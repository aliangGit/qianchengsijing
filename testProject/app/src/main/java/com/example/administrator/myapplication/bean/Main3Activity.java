package com.example.administrator.myapplication.bean;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.administrator.myapplication.R;

public class Main3Activity extends Activity
{
    private static final String TAG="MainActivity";
    private Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);


        btn=(Button) findViewById(R.id.btn_intent3);
        btn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                Log.i(TAG,"Main2Activity onClick");
                Intent intent=new Intent();
                intent.putExtra("tag", "tag");
                setResult(200, intent);
                finish();
            }
        });
    }
}
