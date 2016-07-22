package com.example.draldo.activityservice;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class SecondActivity extends AppCompatActivity {

    private static final String TAG = "TAG_" ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Log.d(TAG, "We're in the onCreate of the 2ndActivity");
    }

    public void doMagic2(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        Intent service = new Intent(this, MyService.class);
        startActivity(intent);
        stopService(service);
    }
}
