package com.area51.testflavors;

import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.fabShow)
                .setOnClickListener(v -> Snackbar.make(findViewById(R.id.mainActivityParent), "Flavour : " + BuildConfig.FLAVOR + " Type : " + BuildConfig.BUILD_TYPE, Snackbar.LENGTH_LONG)
                        .show());

    }

}