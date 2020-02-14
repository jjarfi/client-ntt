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

import com.github.jjarfi.sibntt.Adapter.MakananAdapter;
import com.github.jjarfi.sibntt.Adapter.SukuAdapter;
import com.github.jjarfi.sibntt.Api.API;
import com.github.jjarfi.sibntt.Model.Makanan;
import com.github.jjarfi.sibntt.Model.Suku;
import com.github.jjarfi.sibntt.Service.MakananService;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import uk.co.chrisjenx.calligraphy.CalligraphyConfig;

import static com.github.jjarfi.sibntt.R.layout.activity_makanan;
import static com.github.jjarfi.sibntt.R.layout.activity_suku;

public class MakananActivity extends AppCompatActivity {
    TextView tvTitle,selection,tvmenumakanan;
    MakananService makananService;
    List<Makanan> listMakanan = new ArrayList<>();

    RecyclerView recyclerView;
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
        setContentView(R.layout.activity_makanan);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        tvTitle = findViewById(R.id.tvTitle);
        tvmenumakanan = findViewById(R.id.txt_menu_makanan);
        tvTitle.setText("Makanan Khas");
        Typeface face = Typeface.createFromAsset(getAssets(), "font/NABILA.TTF");
        tvTitle.setTypeface(face);
        tvmenumakanan.setTypeface(face);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        recyclerView = (RecyclerView) findViewById(R.id.recyler_makanan);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        recyclerView.setHasFixedSize(true);

        makananService = API.getMakanan();
        makananList();

    }

    public void makananList() {
        Call<List<Makanan>> call = makananService.getAllMakanan();
        call.enqueue(new Callback<List<Makanan>>() {
            @Override
            public void onResponse(Call<List<Makanan>> call, Response<List<Makanan>> response) {
                if (response.isSuccessful()) {
                    listMakanan = response.body();
                    recyclerView.setAdapter(new MakananAdapter(MakananActivity.this, activity_makanan, listMakanan));
                }
            }


            @Override
            public void onFailure(Call<List<Makanan>> call, Throwable t) {

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
