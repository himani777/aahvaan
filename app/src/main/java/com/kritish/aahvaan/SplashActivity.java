package com.kritish.aahvaan;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Bundle;
import android.widget.ImageView;

public class SplashActivity extends Activity {

    private  static int SPLASH_TIME_OUT = 2000;
    SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        ImageView logo = (ImageView) findViewById(R.id.logo_aahvaan);
        logo.animate().alpha(1).setDuration(1000);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                preferences = getSharedPreferences("loginstate", MODE_PRIVATE);
                Boolean isLoggedIn = preferences.getBoolean("isLoggedIn", false);
                if(isLoggedIn) {
                    startActivity(new Intent(SplashActivity.this, MainActivity.class));
                } else {
                    startActivity(new Intent(SplashActivity.this, LoginActivity.class));
                }
                finish();
            }
        }, SPLASH_TIME_OUT);
    }
}
