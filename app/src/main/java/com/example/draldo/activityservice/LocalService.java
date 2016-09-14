package com.example.draldo.activityservice;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

import java.util.Random;

/**
 * Created by Draldo on 14/09/2016.
 */
public class LocalService extends Service {

    private static final String TAG = LocalService.class.getSimpleName() + "TAG_";
    private final IBinder mBinder = new LocalBinder();
    private final Random mGenertor = new Random();

    public class LocalBinder extends Binder{
        LocalService getService(){
            Log.d(TAG, "getService: ");
            return LocalService.this;
        }
    }

    @Override
    public IBinder onBind(Intent intent) {
        Log.d(TAG, "onBind: ");
        return mBinder;
    }

    public int getRandomNumber(){
        return mGenertor.nextInt(100);
    }
}
