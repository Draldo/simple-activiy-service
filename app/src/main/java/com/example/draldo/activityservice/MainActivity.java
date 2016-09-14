package com.example.draldo.activityservice;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.draldo.activityservice.LocalService.LocalBinder;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "TAG_";
    LocalService mService;
    boolean mBound = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d(TAG, "We're in the onCreate of the MainActivity");

//        Intent service = new Intent(this, MyService.class);
//        stopService(service);

    }

    @Override
    protected void onStart() {
        super.onStart();
        Intent intent = new Intent(this, LocalService.class);
        bindService(intent, mConnection, Context.BIND_AUTO_CREATE);
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (mBound) {
            unbindService(mConnection);
            mBound = false;
        }
    }

    public void doMagic(View view) {
        Intent intent = new Intent(this, SecondActivity.class);
        startActivity(intent);

        Intent service = new Intent(this, MyService.class);
        startService(service);
    }

    public void doMagic2(View view) {
        Intent service = new Intent(this, CounterService.class);
        this.startService(service);
    }

    public void doMagic3(View view) {
        if (mBound) {
            int num = mService.getRandomNumber();
            Toast.makeText(this, "number: " + num, Toast.LENGTH_SHORT).show();
        }
    }

    private ServiceConnection mConnection = new ServiceConnection() {

        @Override
        public void onServiceConnected(ComponentName className, IBinder service) {
            LocalBinder binder = (LocalBinder) service;
            mService = binder.getService();
            mBound = true;
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            mBound = false;
        }
    };
}
