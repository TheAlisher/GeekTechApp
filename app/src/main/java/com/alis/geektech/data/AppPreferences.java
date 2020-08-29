package com.alis.geektech.data;

import android.content.Context;
import android.content.SharedPreferences;

public class AppPreferences {

    public static final String PREF_IS_FIRST_LAUNCH = "is_first_launch";

    private SharedPreferences preferences;

    public AppPreferences(Context context) {
        preferences = context.getSharedPreferences(
                "geek_tech_app_preferences",
                Context.MODE_PRIVATE
        );
    }

    public void setLaunched() {
        preferences.edit().putBoolean(PREF_IS_FIRST_LAUNCH, false).apply();
    }

    public boolean isFirstLaunch() {
        return preferences.getBoolean(PREF_IS_FIRST_LAUNCH, true);
    }
}
