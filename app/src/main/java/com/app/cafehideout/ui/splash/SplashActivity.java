package com.app.cafehideout.ui.splash;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;

import com.app.cafehideout.R;
import com.app.cafehideout.base.BaseActivity;
import com.app.cafehideout.data.Global;
import com.app.cafehideout.data.PrefConnect;
import com.app.cafehideout.ui.login.LoginActivity;
import com.app.cafehideout.ui.table.TableActivity;
import com.google.android.material.snackbar.Snackbar;

/**
 * Created by Apoorv Vardhman on 03-02-2020
 *
 * @Email :  apoorv.vardhman@gmail.com
 * @Author :  Apoorv Vardhman (developerapoorv.xyz)
 * @Linkedin :  https://in.linkedin.com/in/apoorv-vardhman
 * Contact :  +91 8434014444
 */
public class SplashActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (PrefConnect.readString(SplashActivity.this, Global.LOGIN, "").isEmpty()) {
                    Intent intent = new Intent(SplashActivity.this, LoginActivity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(intent);
                } else {
                    Intent intent = new Intent(SplashActivity.this, TableActivity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(intent);
                }
            }
        }, 2000);
    }

    @Override
    public void onNetworkConnectionChanged(boolean isConnected) {
        showSnack(isConnected);
    }
}
