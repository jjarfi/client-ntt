package com.github.jjarfi.sibntt;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.andremion.counterfab.CounterFab;
import com.github.jjarfi.sibntt.Model.Suku;
import com.github.jjarfi.sibntt.Retrofit.apiSIBNTT;
import com.google.android.material.navigation.NavigationView;


import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import ss.com.bannerslider.Slider;
import uk.co.chrisjenx.calligraphy.CalligraphyConfig;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class HomeActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    ListView simpleList;
    String countryList[] = {"India", "China", "australia", "Portugle", "America", "NewZealand"};
    private static final String TAG = HomeActivity.class.getSimpleName();
    TextView tvFullName, tvTitle;
    CounterFab fab;
    private RecyclerView recycler_menu;
    private SwipeRefreshLayout swipeRefreshLayout;
    private boolean statusItemList = false;
    Menu menu;
    Slider sliderLayout;
    apiSIBNTT mService;
    TestApi test;

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
        setContentView(R.layout.activity_home);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        sliderLayout = (Slider) findViewById(R.id.slider);
        tvTitle = findViewById(R.id.tvTitle);
        tvTitle.setText("Dashboard");
        setSupportActionBar(toolbar);
        fab = findViewById(R.id.fab);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        View headerView = navigationView.getHeaderView(0);
        tvFullName = headerView.findViewById(R.id.tvFullName);
        swipeRefreshLayout = findViewById(R.id.swipe_layout);
        swipeRefreshLayout.setColorSchemeResources(R.color.colorPrimary,
                android.R.color.holo_green_dark,
                android.R.color.holo_orange_dark,
                android.R.color.holo_blue_dark
        );
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
            }
        });
        swipeRefreshLayout.post(new Runnable() {
            @Override
            public void run() {
                //checkLoadMenuSwipe();
            }
        });

       //  getBarnner();


    }

    private void getBarnner() {
        compositeDisposable.add(mService.getBarner()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<List<Suku>>() {
                    @Override
                    public void accept(List<Suku> sukus) throws Exception {
                        displayImage(sukus);

                    }
                }));

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        compositeDisposable.dispose();
    }

    private void displayImage(List<Suku> sukus) {
        HashMap<String, String> barnnerMap = new HashMap<>();
        for (Suku item : sukus)
            barnnerMap.put(item.getNamasuku(), item.getLink());

        for (String name:barnnerMap.keySet()){
          //TextSliderView n =
        }
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
//        fab.setCount(new Database(this).getCountCart(Common.currentUser.getPhone()));
//        if (adapter != null) adapter.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        //adapter.stopListening();
    }

    @Override
    protected void onStart() {
        super.onStart();
        new HttpRequestTask().execute();
    }

    private class HttpRequestTask extends AsyncTask<Void, Void, Suku[]> {

        @Override
        protected Suku[] doInBackground(Void... params) {
            try {
                final String url = "http://192.168.43.224:8083/api/suku"; // the  url from where to fetch data(json)
                RestTemplate restTemplate = new RestTemplate();
                restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
                Suku[] info = restTemplate.getForObject(url, Suku[].class);
                return info;
            } catch (Exception e) {
                Log.e("MainActivity", e.getMessage(), e);
            }

            return null;

        }

        @Override
        protected void onPostExecute(Suku[] sukus) {
            super.onPostExecute(sukus);
            HashMap<String, String> barnnerMap = new HashMap<>();
            for (Suku s : sukus){
                Log.i("Suku: ", "######################");
                Log.i("ID: ", String.valueOf(s.getId()));
                Log.i("NAMA: ", String.valueOf(s.getNamasuku()));
                Log.i("DESKRIPSI: ", String.valueOf(s.getDeskripsi()));
                Log.i("LINK: ", String.valueOf(s.getLink()));
                Log.i("LINK: ", String.valueOf(s.getCreatedate()));
                Log.i("LINK: ", String.valueOf(s.getCreatedby()));
                Log.i("Suku: ", "######################");
                barnnerMap.put(s.getNamasuku(), s.getLink());
            }

        }
    }


}
