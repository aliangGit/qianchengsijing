package com.example.administrator.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import com.example.administrator.myapplication.service.AidlService;

public class MainActivity extends Activity
{

    private static final String TAG="MainActivity";

    private Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn=findViewById(R.id.btn_intent);

        btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
             Intent intent=new Intent(MainActivity.this, AidlService.class);
             startService(intent);


            }
        });

    }
    @Override
    protected void onActivityResult(int arg0, int arg1, Intent arg2) {
        // TODO Auto-generated method stub
        super.onActivityResult(arg0, arg1, arg2);

        Log.i(TAG, "arg0="+arg0+",arg1="+arg1+",arg2="+arg2);
    }
}
