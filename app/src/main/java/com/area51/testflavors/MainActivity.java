package com.area51.testflavors;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.snackbar.Snackbar;

import java.util.Random;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity
        implements View.OnClickListener {

    private AnalyticsManager analyicsManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.fabShow)
                .setOnClickListener(this);

        analyicsManager = new AnalyticsManager(this);

        findViewById(R.id.imageView)
                .setOnClickListener(this);

        findViewById(R.id.textViewMain)
                .setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.fabShow:
                Snackbar.make(findViewById(R.id.mainActivityParent), "Flavour : " + BuildConfig.FLAVOR + " Type : " + BuildConfig.BUILD_TYPE, Snackbar.LENGTH_LONG)
                        .show();
                analyicsManager.sendEvent(AnalyticsManager.ACTION_CLICK, "FAB", "Show Snackbar");
                break;
            case R.id.imageView:
                Random random = new Random();
                analyicsManager.sendEvent(AnalyticsManager.ACTION_CLICK, "Image", "OpenImage : " + random.nextInt());
                break;
            case R.id.textViewMain:
                analyicsManager.sendEvent(AnalyticsManager.ACTION_OPEN_ACTIVITY, "TextView", "Open Second Activity");
                startActivity(new Intent(MainActivity.this, SecondActivity.class));
                break;
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        analyicsManager.setScreen("MainActivity");
    }

}