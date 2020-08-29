package com.alis.geektech;

import android.app.Application;

import com.alis.geektech.data.AppPreferences;

public class App extends Application {

    //AppPreferences
    public static AppPreferences appPreferences;


    @Override
    public void onCreate() {
        super.onCreate();

        appPreferences = new AppPreferences(this);
    }
}
