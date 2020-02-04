package com.app.cafehideout.base;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.app.cafehideout.R;
import com.app.cafehideout.app.App;
import com.app.cafehideout.util.ConnectivityReceiver;
import com.google.android.material.snackbar.Snackbar;

/**
 * Created by Apoorv Vardhman on 03-02-2020
 *
 * @Email :  apoorv.vardhman@gmail.com
 * @Author :  Apoorv Vardhman (developerapoorv.xyz)
 * @Linkedin :  https://in.linkedin.com/in/apoorv-vardhman
 * Contact :  +91 8434014444
 */
public abstract class BaseActivity  extends AppCompatActivity implements ToastInterface, ConnectivityReceiver.ConnectivityReceiverListener {
    private ProgressDialog progressDialog;
    private int orientation;

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onStart() {
        super.onStart();
        //Thread.setDefaultUncaughtExceptionHandler(new ExceptionHandler(this));
        //noinspection WrongConstant
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void setContentView(int layoutResId) {
        super.setContentView(layoutResId);
    }


    @Override
    protected void onResume() {
        super.onResume();
        App.getInstance().setConnectivityListener(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
    }


    /**
     * /**
     * Sets orientation to portrait only.
     */
    protected void setOrientationPortrait() {
        orientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT;
    }

    /**
     * Sets orientation to landscape only.
     */
    protected void setOrientationLandscape() {
        orientation = ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE;
    }

    /**
     * Sets orientation to sensor mode.
     */
    protected void setOrientationSensor() {
        orientation = ActivityInfo.SCREEN_ORIENTATION_SENSOR;
    }

    /**
     * Set orientation to any supported one.
     *
     * @param orientation ActivityInfo.ORIENTATION_*
     */
    protected void setOrientation(int orientation) {
        this.orientation = orientation;
    }

  /*  public App getApp() {
        return App.getInstance();
    }*/

    public void pleaseWait(String... args) {
        try {
            okayThanks();
            progressDialog = new ProgressDialog(this);
            if (args.length > 0) {
                progressDialog.setMessage(args[0]);
            } else {
                progressDialog.setMessage("Please wait...");
            }
            progressDialog.setCancelable(false);
            progressDialog.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void okayThanks() {
        try {
            if (progressDialog != null) {
                progressDialog.dismiss();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void errorMessage(View coordinator, String message) {
        //        Snackbar.make(coordinator, "" + message, Snackbar.LENGTH_LONG)
        //                .setAction("Action", null).show();
        makeToast(message);
    }

    @Override
    public void makeToast(int message) {
        ToastMaker.makeToast(this, message);
    }

    @Override
    public void makeToast(String message) {
        ToastMaker.makeToast(this, message);
    }

    // Showing the status in Snackbar
    public void showSnack(boolean isConnected) {
        hideKeyBoard();
        okayThanks();
        String message;
        int color;
        if (isConnected) {
            message = "Good! Connected to Internet";
            color = Color.WHITE;
        } else {
            message = "Sorry! Not connected to internet";
            color = Color.RED;
        }

        Snackbar snackbar = Snackbar
                .make(findViewById(R.id.root), message, Snackbar.LENGTH_LONG);

        View sbView = snackbar.getView();
        TextView textView =  sbView.findViewById(com.google.android.material.R.id.snackbar_text);
        textView.setTextColor(color);
        if(!isConnected)
        {
            snackbar.show();
        }
    }

    public void hideKeyBoard()
    {
        InputMethodManager imm = (InputMethodManager) getSystemService(Activity.INPUT_METHOD_SERVICE);
        imm.toggleSoftInput(InputMethodManager.HIDE_IMPLICIT_ONLY, 0);
    }

    public void showValidationSnack(String message) {
        hideKeyBoard();
        Snackbar snackbar = Snackbar
                .make(findViewById(R.id.root), message, Snackbar.LENGTH_LONG);

        View sbView = snackbar.getView();
        int color = Color.RED;
        TextView textView =  sbView.findViewById(com.google.android.material.R.id.snackbar_text);
        textView.setTextColor(color);
        snackbar.show();
    }

}

