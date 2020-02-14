package com.github.jjarfi.sibntt;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.github.jjarfi.sibntt.Adapter.SukuAdapter;
import com.github.jjarfi.sibntt.Api.API;
import com.github.jjarfi.sibntt.Model.Suku;
import com.github.jjarfi.sibntt.Model.Tarian;
import com.github.jjarfi.sibntt.Service.SukuService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import uk.co.chrisjenx.calligraphy.CalligraphyConfig;
import static com.github.jjarfi.sibntt.R.layout.activity_suku;
public class SukuActivity extends AppCompatActivity {
    TextView tvTitle;
    SukuService sukuService;
    List<Suku> listSuku = new ArrayList<>();

    RecyclerView recyclerView;
    Menu menu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
                .setDefaultFontPath("font/NABILA.TTF")
                .setFontAttrId(R.attr.fontPath)
                .build());
        setContentView(R.layout.activity_suku);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        tvTitle = findViewById(R.id.tvTitle);
        tvTitle.setText("Suku Asli NTT");
        Typeface face = Typeface.createFromAsset(getAssets(), "font/NABILA.TTF");
        tvTitle.setTypeface(face);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        recyclerView = (RecyclerView) findViewById(R.id.recyler_suku);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        recyclerView.setHasFixedSize(true);

        sukuService = API.getSuku();
        sukuList();


    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        this.menu = menu;
        getMenuInflater().inflate(R.menu.suku, menu);
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

    public void sukuList() {
        Call<List<Suku>> call = sukuService.getAllSuku();
        call.enqueue(new Callback<List<Suku>>() {
            @Override
            public void onResponse(Call<List<Suku>> call, Response<List<Suku>> response) {
                if (response.isSuccessful()) {
                    listSuku = response.body();
                    recyclerView.setAdapter(new SukuAdapter(SukuActivity.this, activity_suku, listSuku));
                }
            }


            @Override
            public void onFailure(Call<List<Suku>> call, Throwable t) {
                Log.e("Error di", t.getMessage());
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();

    }

}
