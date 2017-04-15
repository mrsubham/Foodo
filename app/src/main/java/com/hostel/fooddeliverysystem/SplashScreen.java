package com.hostel.fooddeliverysystem;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;

public class SplashScreen extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init();
        runTimer();
    }

    void init() {
        setContentView(R.layout.activity_splash_screen);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
    }

    void runTimer() {

        Thread timer = new Thread() {
            public void run() {
                try {
                    sleep(2000);
                }
                catch (InterruptedException e) {
                    e.printStackTrace();
                }
                finally {
                    finish();
                    //startActivity(new Intent(Splash.this, LoginSignup.class));
                    Intent i = new Intent(SplashScreen.this, Login.class);
                    startActivity(i);
                }
            }
        };
        timer.start();
    }
}
