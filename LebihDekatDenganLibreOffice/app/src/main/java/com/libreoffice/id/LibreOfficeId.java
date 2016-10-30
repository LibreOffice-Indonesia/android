package com.libreoffice.id;

import android.app.Application;

import com.crashlytics.android.Crashlytics;
import com.facebook.stetho.Stetho;
import com.google.firebase.analytics.FirebaseAnalytics;

import io.fabric.sdk.android.Fabric;

/**
 * Created by rhony on 10/30/16.
 */

public class LibreOfficeId extends Application{

    public static LibreOfficeId instance;
    private FirebaseAnalytics firebaseAnalytics;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;

//        Enable hanya dalam keadaan DEBUG
        if (BuildConfig.DEBUG){
            Stetho.initializeWithDefaults(this);
        }

//        Enable hanya untuk versi aplikasi RELEASE
        if (!BuildConfig.DEBUG || BuildConfig.FLAVOR.equalsIgnoreCase("beta")){
            Fabric.with(this, new Crashlytics());
        }
    }

    synchronized public FirebaseAnalytics getFirebaseAnalytics() {
        if (firebaseAnalytics == null) {
            firebaseAnalytics = FirebaseAnalytics.getInstance(this);
        }
        return firebaseAnalytics;
    }
}
