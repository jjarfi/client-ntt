package com.github.jjarfi.sibntt;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import uk.co.chrisjenx.calligraphy.CalligraphyConfig;

public class RumahActivity extends AppCompatActivity {
    TextView tvTitle,txtrumah;
    Menu menu;

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
        setContentView(R.layout.activity_rumah);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        tvTitle = findViewById(R.id.tvTitle);
        txtrumah = findViewById(R.id.txt_menu_rumah);
        tvTitle.setText("Rumah Adat");
        Typeface face = Typeface.createFromAsset(getAssets(), "font/NABILA.TTF");
        tvTitle.setTypeface(face);
        txtrumah.setTypeface(face);
        setSupportActionBar(toolbar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        this.menu = menu;
        getMenuInflater().inflate(R.menu.makanan, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.action_view:
                break;
            case R.id.action_search:
                break;
        }

        return super.onOptionsItemSelected(item);
    }
}
