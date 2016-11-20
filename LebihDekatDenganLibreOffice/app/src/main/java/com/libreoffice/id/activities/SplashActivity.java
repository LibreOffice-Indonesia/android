package com.libreoffice.id.activities;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

import com.libreoffice.id.R;

public class SplashActivity extends AppCompatActivity {

    public static final int SPLASH_MOCK_TIME_OUT = 3500;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        delay(SPLASH_MOCK_TIME_OUT);
    }

    private void delay(int timeOut){
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(SplashActivity.this, HomeActivity.class));
                finish();
            }
        }, timeOut);
    }
}
