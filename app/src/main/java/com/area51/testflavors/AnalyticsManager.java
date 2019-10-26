package com.area51.testflavors;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;

import com.google.firebase.analytics.FirebaseAnalytics;

class AnalyticsManager {

    static final String ACTION_CLICK = "CLICK";
    static final String ACTION_OPEN_ACTIVITY = "OPEN_ACTIVITY";

    private final Context context;
    private FirebaseAnalytics mFirebaseAnalytics;

    AnalyticsManager(Context context) {
        this.context = context;
        mFirebaseAnalytics = FirebaseAnalytics.getInstance(context);
    }

    void setScreen(String screen_name) {
        mFirebaseAnalytics.setCurrentScreen((Activity) context, "DISPLAY", screen_name);
    }

    void sendEvent(String action, String item_name, String item_id) {
        Bundle bundle = new Bundle();
        bundle.putString("ITEM_NAME", item_name);
        bundle.putString("ITEM_ID", item_id);
        mFirebaseAnalytics.logEvent(action, bundle);
    }

}