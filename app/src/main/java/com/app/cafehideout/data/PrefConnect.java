package com.app.cafehideout.data;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Apoorv Vardhman on 03-02-2020
 *
 * @Email :  apoorv.vardhman@gmail.com
 * @Author :  Apoorv Vardhman (developerapoorv.xyz)
 * @Linkedin :  https://in.linkedin.com/in/apoorv-vardhman
 * Contact :  +91 8434014444
 */
public class PrefConnect {
    public static final String FCM_TOKEN = "FCM_TOKEN";

    private static final String PREF_NAME = "MY_PREF";
    private static final int MODE = Context.MODE_PRIVATE;
    public static final String PERMISSION_ENABLED = "PERMISSION_ENABLED";

    public static void clearAllPrefs(Context context) {
        getEditor(context).clear().commit();
    }

    /**
     * @param context
     * @param key
     * @param value
     */
    public static void writeBoolean(Context context, String key, boolean value) {
        getEditor(context).putBoolean(key, value).commit();
    }

    /**
     * @param context
     * @param key
     * @param defValue
     * @return
     */
    public static boolean readBoolean(Context context, String key, boolean defValue) {
        return getPreferences(context).getBoolean(key, defValue);
    }

    /**
     * @param context
     * @param key
     * @param value
     */
    public static void writeInteger(Context context, String key, int value) {
        getEditor(context).putInt(key, value).commit();
    }

    /**
     * @param context
     * @param key
     * @param defValue
     * @return
     */
    public static int readInteger(Context context, String key, int defValue) {
        return getPreferences(context).getInt(key, defValue);
    }

    /**
     * @param context
     * @param key
     * @param value
     */
    public static void writeString(Context context, String key, String value) {
        getEditor(context).putString(key, value).commit();
    }

    /**
     * @param context
     * @param key
     * @param defValue
     * @return
     */
    public static String readString(Context context, String key, String defValue) {
        return getPreferences(context).getString(key, defValue);
    }

    /**
     * @param context
     * @param key
     * @param value
     */
    public static void writeFloat(Context context, String key, float value) {
        getEditor(context).putFloat(key, value).commit();
    }

    /**
     * @param context
     * @param key
     * @param defValue
     * @return
     */
    public static float readFloat(Context context, String key, float defValue) {
        return getPreferences(context).getFloat(key, defValue);
    }

    /**
     * @param context
     * @param key
     * @param value
     */
    public static void writeLong(Context context, String key, long value) {
        getEditor(context).putLong(key, value).commit();
    }

    /**
     * @param context
     * @param key
     * @param defValue
     * @return
     */
    public static long readLong(Context context, String key, long defValue) {
        return getPreferences(context).getLong(key, defValue);
    }

    /**
     * @param context
     * @return
     */
    public static SharedPreferences getPreferences(Context context) {
        return context.getSharedPreferences(PREF_NAME, MODE);
    }

    /**
     * @param context
     * @return
     */
    public static SharedPreferences.Editor getEditor(Context context) {
        return getPreferences(context).edit();
    }

}
