package com.github.jjarfi.sibntt;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.github.jjarfi.sibntt.Adapter.SejarahAdapter;
import com.github.jjarfi.sibntt.Adapter.SukuAdapter;
import com.github.jjarfi.sibntt.Api.API;
import com.github.jjarfi.sibntt.Model.Sejarah;
import com.github.jjarfi.sibntt.Model.Suku;
import com.github.jjarfi.sibntt.Service.SejarahService;
import com.github.jjarfi.sibntt.Service.SukuService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import uk.co.chrisjenx.calligraphy.CalligraphyConfig;

import static com.github.jjarfi.sibntt.R.layout.activity_sejarah;
import static com.github.jjarfi.sibntt.R.layout.activity_suku;

public class SejarahActivity extends AppCompatActivity {
    TextView tvTitle;
    Menu menu;

    SejarahService sejarahService;
    List<Sejarah> listSejarah = new ArrayList<>();

    RecyclerView recyclerView;

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
        setContentView(R.layout.activity_sejarah);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        tvTitle = findViewById(R.id.tvTitle);
        tvTitle.setText("Sejarah NTT");
        Typeface face = Typeface.createFromAsset(getAssets(), "font/NABILA.TTF");
        tvTitle.setTypeface(face);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        recyclerView = (RecyclerView) findViewById(R.id.recyler_sejarah);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        recyclerView.setHasFixedSize(true);
        sejarahService = API.getSejarah();
        sejarahList();
    }


    public void sejarahList() {
        Call<List<Sejarah>> call = sejarahService.getAllSejarah();
        call.enqueue(new Callback<List<Sejarah>>() {
            @Override
            public void onResponse(Call<List<Sejarah>> call, Response<List<Sejarah>> response) {
                if (response.isSuccessful()) {
                    listSejarah = response.body();
                    recyclerView.setAdapter(new SejarahAdapter(SejarahActivity.this, activity_sejarah, listSejarah));
                }
            }


            @Override
            public void onFailure(Call<List<Sejarah>> call, Throwable t) {

            }
        });
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
