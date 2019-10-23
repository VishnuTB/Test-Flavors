package com.area51.testflavors;

import android.os.Bundle;
import android.view.View;

import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.analytics.FirebaseAnalytics;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity
        implements View.OnClickListener {

    private FirebaseAnalytics mFirebaseAnalytics;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.fabShow)
                .setOnClickListener(this);

        mFirebaseAnalytics = FirebaseAnalytics.getInstance(this);
        Bundle bundle = new Bundle();
        bundle.putString("SCREEN_NAME", MainActivity.class.getName());
        bundle.putString("APP_NAME", BuildConfig.FLAVOR);
        mFirebaseAnalytics.logEvent(FirebaseAnalytics.Event.APP_OPEN, bundle);
        mFirebaseAnalytics.setUserProperty("user_name", "John Doe");

    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.fabShow) {
            Snackbar.make(findViewById(R.id.mainActivityParent), "Flavour : " + BuildConfig.FLAVOR + " Type : " + BuildConfig.BUILD_TYPE, Snackbar.LENGTH_LONG)
                    .show();
            Bundle bundle = new Bundle();
            bundle.putString(FirebaseAnalytics.Param.ITEM_CATEGORY, "FAB");
            bundle.putString(FirebaseAnalytics.Event.VIEW_ITEM, "SnackBar");
            mFirebaseAnalytics.logEvent(FirebaseAnalytics.Event.SELECT_CONTENT, bundle);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        mFirebaseAnalytics.setCurrentScreen(this, BuildConfig.FLAVOR, null);
    }

}