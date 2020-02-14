package com.github.jjarfi.sibntt;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;

import dmax.dialog.SpotsDialog;
import uk.co.chrisjenx.calligraphy.CalligraphyConfig;

public class MainActivity extends AppCompatActivity {
    private TextView tvSlogan, tvjudul;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
        //Notes : add this code before setContentView
        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
                .setDefaultFontPath("font/NABILA.TTF")
                .setFontAttrId(R.attr.fontPath)
                .build());
        setContentView(R.layout.activity_main);
        initViews();
        checkConnection();

    }

    private void initViews() {
        tvSlogan = findViewById(R.id.tvSlogan);
        tvjudul = findViewById(R.id.tvJudul);
        Typeface face = Typeface.createFromAsset(getAssets(), "font/NABILA.TTF");
        tvSlogan.setTypeface(face);
        tvjudul.setTypeface(face);
    }

    public boolean isConnect() {
        ConnectivityManager manager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = manager.getActiveNetworkInfo();

        boolean isAvailable = false;
        if (networkInfo != null && networkInfo.isConnected()) {
            isAvailable = true;
        }
        return isAvailable;
    }

    private void checkConnection() {
        if (!isConnect()) {
            final AlertDialog loding = new SpotsDialog.Builder().setContext(MainActivity.this).build();
            loding.show();
            loding.setMessage("Mohon menunggu");
            loding.setCancelable(false);
        } else {
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    startActivity(new Intent(MainActivity.this, HomeActivity.class));
                    finish();
                }
            }, 2000);
        }
    }
}
