package cn.com.voyagegroup.ordersystem.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

public class SharedPreferencesUtils {
    
    public static String getStringSaveData(Context context, String name,
            String key) {
        SharedPreferences pref = context.getSharedPreferences(name,
                Context.MODE_PRIVATE);
        return pref.getString(key, null);
    }
    
    public static int getIntSaveData(Context context, String name, String key) {
        SharedPreferences pref = context.getSharedPreferences(name,
                Context.MODE_PRIVATE);
        return pref.getInt(key, -1);
    }

    public static boolean getBooleanSaveData(Context context, String name,
            String key) {
        SharedPreferences pref = context.getSharedPreferences(name,
                Context.MODE_PRIVATE);
        return pref.getBoolean(key, false);
    }

    
    public static void setStringSaveData(Context context, String name,
            String key, String value) {
        SharedPreferences pref = context.getSharedPreferences(name,
                Context.MODE_PRIVATE);
        Editor edit = pref.edit();
        edit.putString(key, value);
        edit.commit();
    }

    public static void setIntSaveData(Context context, String name, String key,
            int value) {
        SharedPreferences pref = context.getSharedPreferences(name,
                Context.MODE_PRIVATE);
        Editor edit = pref.edit();
        edit.putInt(key, value);
        edit.commit();
    }

    public static void setBooleanSaveData(Context context, String name,
            String key, boolean value) {
        SharedPreferences pref = context.getSharedPreferences(name,
                Context.MODE_PRIVATE);
        Editor edit = pref.edit();
        edit.putBoolean(key, value);
        edit.commit();
    }
}
