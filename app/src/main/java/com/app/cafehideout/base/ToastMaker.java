package com.app.cafehideout.base;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by Apoorv Vardhman on 03-02-2020
 *
 * @Email :  apoorv.vardhman@gmail.com
 * @Author :  Apoorv Vardhman (developerapoorv.xyz)
 * @Linkedin :  https://in.linkedin.com/in/apoorv-vardhman
 * Contact :  +91 8434014444
 */
public class ToastMaker {
    public static void makeToast(Context context, int message) {
        Toast.makeText(context, ""+message, Toast.LENGTH_SHORT).show();
    }

    public static void makeToast(Context context, String message) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
    }
}

