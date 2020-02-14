package com.github.jjarfi.sibntt;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import com.andremion.counterfab.CounterFab;
import com.github.jjarfi.sibntt.Adapter.HomeAdapter;
import com.github.jjarfi.sibntt.Adapter.HomeSejarahAdapter;
import com.github.jjarfi.sibntt.Api.API;
import com.github.jjarfi.sibntt.Model.Sejarah;
import com.github.jjarfi.sibntt.Model.Suku;
import com.github.jjarfi.sibntt.Service.SejarahService;
import com.github.jjarfi.sibntt.Service.SukuService;
import com.google.android.material.navigation.NavigationView;
import java.util.ArrayList;
import java.util.List;
import io.reactivex.disposables.CompositeDisposable;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import ss.com.bannerslider.Slider;
import uk.co.chrisjenx.calligraphy.CalligraphyConfig;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;
import static com.github.jjarfi.sibntt.R.layout.content_home;

public class HomeActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {


    private static final String TAG = HomeActivity.class.getSimpleName();
    TextView txttitleappname, tvTitle;
    CounterFab fab;
    Menu menu;
    CompositeDisposable compositeDisposable = new CompositeDisposable();
    SukuService sukuService;
    SejarahService sejarahService;
    List<Suku> listSuku = new ArrayList<>();
    List<Sejarah> listSejarah = new ArrayList<>();

    RecyclerView recyclerView;
    RecyclerView recyclerView1;

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
        setContentView(R.layout.activity_home);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        tvTitle = findViewById(R.id.tvTitle);
        tvTitle.setText("Dashboard");
        setSupportActionBar(toolbar);
        fab = findViewById(R.id.fab);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        recyclerView = (RecyclerView) findViewById(R.id.list_menu_home);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        recyclerView.setHasFixedSize(true);

        recyclerView1 = (RecyclerView) findViewById(R.id.list_menu_sejarah_home);
        recyclerView1.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        recyclerView1.setHasFixedSize(true);


        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        View headerView = navigationView.getHeaderView(0);
        txttitleappname = headerView.findViewById(R.id.tvTitleAppName);

        sukuService = API.getSuku();
        sukuList();

        sejarahService = API.getSejarah();
        sejarahList();

    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        compositeDisposable.dispose();
    }


    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        this.menu = menu;
        getMenuInflater().inflate(R.menu.home, menu);
        return true;
    }


    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.nav_dashboard:
                //  checkLoadMenuSwipe();
                break;
            case R.id.nav_provinsi:
                startActivity(new Intent(HomeActivity.this, ProvinsiActivity.class));
                break;
            case R.id.nav_suku:
                startActivity(new Intent(HomeActivity.this, SukuActivity.class));
                break;
            case R.id.nav_sejarah:
                startActivity(new Intent(HomeActivity.this, SejarahActivity.class));
                break;
            case R.id.nav_pakaian:
                startActivity(new Intent(HomeActivity.this, PakaianActivity.class));
                break;
            case R.id.nav_rumah:
                startActivity(new Intent(HomeActivity.this, RumahActivity.class));
                break;
            case R.id.nav_makanan:
                startActivity(new Intent(HomeActivity.this, MakananActivity.class));
                break;
            case R.id.nav_musik:
                startActivity(new Intent(HomeActivity.this, MusikActivity.class));
                break;
            case R.id.nav_tarian:
                startActivity(new Intent(HomeActivity.this, TarianActivity.class));
                break;
        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onStart() {
        super.onStart();

    }

    public void sukuList() {
        Call<List<Suku>> call = sukuService.getAllSuku();
        call.enqueue(new Callback<List<Suku>>() {
            @Override
            public void onResponse(Call<List<Suku>> call, Response<List<Suku>> response) {
                if (response.isSuccessful()) {
                    listSuku = response.body();
                    recyclerView.setAdapter(new HomeAdapter(HomeActivity.this, content_home, listSuku));
                }
            }


            @Override
            public void onFailure(Call<List<Suku>> call, Throwable t) {
                Log.e("Error di", t.getMessage());
            }
        });
    }

    public void sejarahList() {
        Call<List<Sejarah>> call = sejarahService.getAllSejarah();
        call.enqueue(new Callback<List<Sejarah>>() {
            @Override
            public void onResponse(Call<List<Sejarah>> call, Response<List<Sejarah>> response) {
                if (response.isSuccessful()) {
                    listSejarah = response.body();
                    recyclerView1.setAdapter(new HomeSejarahAdapter(HomeActivity.this, content_home, listSejarah));
                }
            }


            @Override
            public void onFailure(Call<List<Sejarah>> call, Throwable t) {
                Log.e("Error di", t.getMessage());
            }
        });
    }

}
