package com.mandala.surveyor;

import android.app.Application;
import android.content.Context;

import com.mandala.surveyor.utils.TypefaceUtil;

import androidx.multidex.MultiDex;


public class MyApp extends Application {

    public static final String TAG = MyApp.class.getSimpleName();

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        TypefaceUtil.overrideFont(getApplicationContext(), "SERIF", "fonts/Montserrat-Light.otf");

//        final FirebaseRemoteConfig firebaseRemoteConfig = FirebaseRemoteConfig.getInstance();
//
//        // set in-app defaults
//        Map<String, Object> remoteConfigDefaults = new HashMap();
//        remoteConfigDefaults.put(ForceUpdateChecker.KEY_UPDATE_REQUIRED, false);
//        remoteConfigDefaults.put(ForceUpdateChecker.KEY_CURRENT_VERSION, "0.9.9");
//        remoteConfigDefaults.put(ForceUpdateChecker.KEY_UPDATE_URL,
//                "https://play.google.com/store/apps/details?id=com.gandengtangan.trust");
//
//        firebaseRemoteConfig.setDefaults(remoteConfigDefaults);
//        firebaseRemoteConfig.fetch(60) // fetch every minutes
//                .addOnCompleteListener(new OnCompleteListener<Void>() {
//                    @Override
//                    public void onComplete(@NonNull Task<Void> task) {
//                        if (task.isSuccessful()) {
//                            Log.d(TAG, "remote config is fetched.");
//                            firebaseRemoteConfig.activateFetched();
//                        }
//                    }
//                });
    }
}
