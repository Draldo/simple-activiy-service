package com.example.draldo.activityservice;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

import java.util.Random;

/**
 * Created by Draldo on 14/09/2016.
 */
public class BoundService extends Service {

    private static final String TAG = BoundService.class.getSimpleName() + "TAG_";
    private final IBinder mBinder = new LocalBinder();
    private final Random mGenertor = new Random();

    public class LocalBinder extends Binder{
        BoundService getService(){
            Log.d(TAG, "getService: ");
            return BoundService.this;
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
