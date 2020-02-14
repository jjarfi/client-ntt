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

import com.github.jjarfi.sibntt.Adapter.MusikAdapter;
import com.github.jjarfi.sibntt.Adapter.PakaianAdapter;
import com.github.jjarfi.sibntt.Api.API;
import com.github.jjarfi.sibntt.Model.Musik;
import com.github.jjarfi.sibntt.Model.Pakaian;
import com.github.jjarfi.sibntt.Service.PakaianService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import uk.co.chrisjenx.calligraphy.CalligraphyConfig;

import static com.github.jjarfi.sibntt.R.layout.activity_musik;
import static com.github.jjarfi.sibntt.R.layout.activity_pakaian;

public class PakaianActivity extends AppCompatActivity {
    TextView tvTitle, txtpakaian;
    Menu menu;
    PakaianService pakaianService;
    List<Pakaian> listPakaian = new ArrayList<>();

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
        setContentView(R.layout.activity_pakaian);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        tvTitle = findViewById(R.id.tvTitle);
        txtpakaian = findViewById(R.id.txt_menu_pakaian);
        tvTitle.setText("Pakaian Adat");
        Typeface face = Typeface.createFromAsset(getAssets(), "font/NABILA.TTF");
        tvTitle.setTypeface(face);
        txtpakaian.setTypeface(face);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        recyclerView = (RecyclerView) findViewById(R.id.recyler_pakaian);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        recyclerView.setHasFixedSize(true);

        pakaianService = API.getPakaian();
        pakaianList();

    }

    public void pakaianList() {
        Call<List<Pakaian>> call = pakaianService.getAllPakaian();
        call.enqueue(new Callback<List<Pakaian>>() {
            @Override
            public void onResponse(Call<List<Pakaian>> call, Response<List<Pakaian>> response) {
                if (response.isSuccessful()) {
                    listPakaian = response.body();
                    recyclerView.setAdapter(new PakaianAdapter(PakaianActivity.this, activity_pakaian, listPakaian));
                }
            }
            @Override
            public void onFailure(Call<List<Pakaian>> call, Throwable t) {

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
