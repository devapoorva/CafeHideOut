package com.app.cafehideout.app;

import android.app.Application;
import android.content.Context;
import android.content.IntentFilter;
import android.util.Log;

import com.app.cafehideout.util.ConnectivityReceiver;

/**
 * Created by Apoorv Vardhman on 03-02-2020
 *
 * @Email :  apoorv.vardhman@gmail.com
 * @Author :  Apoorv Vardhman (developerapoorv.xyz)
 * @Linkedin :  https://in.linkedin.com/in/apoorv-vardhman
 * Contact :  +91 8434014444
 */
public class App extends Application {
    private static Context context;
    public static App mInstance;
    ConnectivityReceiver connectivityReceiver;

    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;
        context = getApplicationContext();
        connectivityReceiver = new ConnectivityReceiver();
        IntentFilter filters = new IntentFilter();
//        filters.addAction("android.net.wifi.WIFI_STATE_CHANGED");
        filters.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        registerReceiver(connectivityReceiver, filters);
    }

    public static synchronized App getInstance() {
        return mInstance;
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
    }

    public void setConnectivityListener(ConnectivityReceiver.ConnectivityReceiverListener listener) {
        Log.e("TAG", "setConnectivityListener:mYaPP ");
        ConnectivityReceiver.connectivityReceiverListener = listener;
    }

    public static Context getContext() {
        return context;
    }
}
