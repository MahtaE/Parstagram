package com.example.myapplication;

import android.app.Application;

import com.parse.Parse;

public class ParseApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        // set applicationId, and server server based on the values in the back4app settings.
        // any network interceptors must be added with the Configuration Builder given this syntax
        Parse.initialize(new Parse.Configuration.Builder(this)
                .applicationId("mahtaparsagaram") // should correspond to Application Id env variable
                .clientKey("codepathMoveFastParse")  // should correspond to Client key env variable
                .server("https://mahtaparsagaram.herokuapp.com/parse").build());
    }
}
