package com.mandala.surveyor.ui.activity.splash;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MotionEvent;

import com.mandala.surveyor.R;
import com.mandala.surveyor.ui.activity.login.LoginActivity;
import com.mandala.surveyor.ui.activity.main.MainActivity;

public class SplashActivity extends Activity {

    protected boolean _active = true;
    protected int _splashTime = 1000;
    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        sharedPreferences = this.getSharedPreferences("Login", MODE_PRIVATE);

        Thread splashThread = new Thread() {
            // Timer Splash
            public void run() {
                try {
                    int waited = 0;
                    while (_active && (waited < _splashTime)) {
                        sleep(100);
                        if (_active) {
                            waited += 100;
                        }
                    }
                } catch (InterruptedException e) {
                    // do nothing
                } finally {
                    Boolean saveLogin = sharedPreferences.getBoolean("saveLogin", false);

                    if (saveLogin == false) {
                        Intent intent = new Intent(SplashActivity.this, LoginActivity.class);
                        startActivity(intent);
                        finish();

                    } else {
                        Intent intent = new Intent(SplashActivity.this, MainActivity.class);
                        startActivity(intent);
                        finish();
                    }
                }
            }
        };
        splashThread.start();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            _active = false;
        }
        return true;
    }
}

