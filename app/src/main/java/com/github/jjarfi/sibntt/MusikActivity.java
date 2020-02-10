package com.github.jjarfi.sibntt;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class MusikActivity extends AppCompatActivity {
    Menu menu;
 TextView tvTitle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_musik);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        tvTitle = findViewById(R.id.tvTitle);
        tvTitle.setText("Musik Daerah");
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
