package com.area51.testflavors;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {

    private AnalyticsManager analyticsManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        analyticsManager = new AnalyticsManager(this);

    }

    @Override
    protected void onResume() {
        super.onResume();
        analyticsManager.setScreen("SecondScreen");
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        analyticsManager.sendEvent(AnalyticsManager.ACTION_CLICK, "BackButton", "BackButton pressed");
    }

}
