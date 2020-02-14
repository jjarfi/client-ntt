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
import com.github.jjarfi.sibntt.Adapter.TarianAdapter;
import com.github.jjarfi.sibntt.Api.API;
import com.github.jjarfi.sibntt.Model.Suku;
import com.github.jjarfi.sibntt.Model.Tarian;
import com.github.jjarfi.sibntt.Service.TarianService;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.disposables.CompositeDisposable;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import uk.co.chrisjenx.calligraphy.CalligraphyConfig;

import static com.github.jjarfi.sibntt.R.layout.activity_suku;
import static com.github.jjarfi.sibntt.R.layout.activity_tarian;

public class TarianActivity extends AppCompatActivity {
    TextView tvTitle, txttarian;
    Menu menu;
    TarianService tarianService;
    RecyclerView recyclerView;
    List<Tarian> listTarian;
    CompositeDisposable compositeDisposable = new CompositeDisposable();

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
        setContentView(R.layout.activity_tarian);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        tvTitle = findViewById(R.id.tvTitle);
        txttarian = findViewById(R.id.txt_menu_tarian);
        tvTitle.setText("Tarian Daerah");
        Typeface face = Typeface.createFromAsset(getAssets(), "font/NABILA.TTF");
        tvTitle.setTypeface(face);
        txttarian.setTypeface(face);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        tarianService = API.getTarian();

        recyclerView = (RecyclerView) findViewById(R.id.recyler_tarian);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        recyclerView.setHasFixedSize(true);

        //Tampilkan menu tarian di recycler View List
        tarianList();
    }

    public void tarianList() {
        Call<List<Tarian>> call = tarianService.getAllTarian();
        call.enqueue(new Callback<List<Tarian>>() {
            @Override
            public void onResponse(Call<List<Tarian>> call, Response<List<Tarian>> response) {
                if (response.isSuccessful()) {
                    listTarian = response.body();
                    recyclerView.setAdapter(new TarianAdapter(TarianActivity.this, activity_tarian, listTarian));
                }
            }


            @Override
            public void onFailure(Call<List<Tarian>> call, Throwable t) {
                Log.e("Error di", t.getMessage());
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        this.menu = menu;
        getMenuInflater().inflate(R.menu.tarian, menu);
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
