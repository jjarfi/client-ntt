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

import com.github.jjarfi.sibntt.Adapter.MusikAdapter;
import com.github.jjarfi.sibntt.Adapter.SukuAdapter;
import com.github.jjarfi.sibntt.Api.API;
import com.github.jjarfi.sibntt.Model.Musik;
import com.github.jjarfi.sibntt.Model.Suku;
import com.github.jjarfi.sibntt.Service.MusikService;
import com.github.jjarfi.sibntt.Service.SukuService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import uk.co.chrisjenx.calligraphy.CalligraphyConfig;

import static com.github.jjarfi.sibntt.R.layout.activity_musik;
import static com.github.jjarfi.sibntt.R.layout.activity_suku;

public class MusikActivity extends AppCompatActivity {
    Menu menu;
    TextView tvTitle, txtalatmusik;

    MusikService musikService;
    List<Musik> listMusik = new ArrayList<>();

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
        setContentView(R.layout.activity_musik);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        tvTitle = findViewById(R.id.tvTitle);
        txtalatmusik = findViewById(R.id.txt_menu_musik);
        tvTitle.setText("Alat Musik");
        Typeface face = Typeface.createFromAsset(getAssets(), "font/NABILA.TTF");
        tvTitle.setTypeface(face);
        txtalatmusik.setTypeface(face);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        recyclerView = (RecyclerView) findViewById(R.id.recyler_musik);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        recyclerView.setHasFixedSize(true);

        musikService = API.getMusik();
        musikList();
    }

    public void musikList() {
        Call<List<Musik>> call = musikService.getAllMusik();
        call.enqueue(new Callback<List<Musik>>() {
            @Override
            public void onResponse(Call<List<Musik>> call, Response<List<Musik>> response) {
                if (response.isSuccessful()) {
                    listMusik = response.body();
                    recyclerView.setAdapter(new MusikAdapter(MusikActivity.this, activity_musik, listMusik));
                }
            }
            @Override
            public void onFailure(Call<List<Musik>> call, Throwable t) {
                Log.e("Error di", t.getMessage());
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
