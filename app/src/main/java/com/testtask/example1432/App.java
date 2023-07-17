package com.testtask.example1432;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;

import com.appsflyer.AppsFlyerConversionListener;
import com.appsflyer.AppsFlyerLib;
import com.appsflyer.attribution.AppsFlyerRequestListener;

import org.jetbrains.annotations.NotNull;

import java.util.Map;

public class App extends Application {
    private static final String FLYER_DEV_KEY = "kpMnLsf9CnAPshfoKnQutP";

    @Override
    public void onCreate() {
        super.onCreate();

        AppsFlyerLib.getInstance().init(FLYER_DEV_KEY, new AppsFlyerConversionListener() {
            @Override
            public void onConversionDataSuccess(Map<String, Object> conversionData) {
                for (String attrName : conversionData.keySet()) {
                    Log.d("RD_",  attrName + " == " + conversionData.get(attrName));
                }
            }

            @Override
            public void onConversionDataFail(String errorMessage) {
                Log.d("RD_", "error onAttributionFailure : " + errorMessage);
            }

            @Override
            public void onAppOpenAttribution(Map<String, String> attributionData) {
                for (String attrName : attributionData.keySet()) {
                    Log.d("RD_", "onAppOpen_attribute : " + attrName + " = " + attributionData.get(attrName));
                }
            }

            @Override
            public void onAttributionFailure(String errorMessage) {
                Log.d("RD_", "error onAttributionFailure : " + errorMessage);
            }
        }, this).start(this, FLYER_DEV_KEY, new AppsFlyerRequestListener() {
            @Override
            public void onSuccess() {
                Log.d("RD_", "Launch sent successfully");
            }

            @Override
            public void onError(int errorCode, @NonNull @NotNull String errorDesc) {
                Log.d("RD_", "Launch failed to be sent:\nError code: " + errorCode + "\nError description: " + errorDesc);
            }
        });
    }
}
