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
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.widget.TextView;

import com.andremion.counterfab.CounterFab;
import com.google.android.material.navigation.NavigationView;

import uk.co.chrisjenx.calligraphy.CalligraphyConfig;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class HomeActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private static final String TAG = HomeActivity.class.getSimpleName();
    TextView tvFullName, tvTitle;
    CounterFab fab;
    private RecyclerView recycler_menu;
    private RecyclerView.LayoutManager mLayoutManger;
    private SwipeRefreshLayout swipeRefreshLayout;
    private boolean statusItemList = false;
    Menu menu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
                .setDefaultFontPath("fonts/food_font.ttf")
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

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        View headerView = navigationView.getHeaderView(0);
        tvFullName = headerView.findViewById(R.id.tvFullName);
        recycler_menu = findViewById(R.id.recycler_menu);
        mLayoutManger = new LinearLayoutManager(this);
        if (statusItemList) {
            recycler_menu.setHasFixedSize(true);
            recycler_menu.setLayoutManager(mLayoutManger);
        } else {
            recycler_menu.setLayoutManager(new GridLayoutManager(this, 2));
        }
        LayoutAnimationController controller = AnimationUtils.loadLayoutAnimation(recycler_menu.getContext(),
                R.anim.layout_fall_down);
        recycler_menu.setLayoutAnimation(controller);
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

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.action_view:
                statusItemList = !statusItemList;
                if (statusItemList) {
                    menu.getItem(0).setIcon(getResources().getDrawable(R.drawable.icon_view_list));
                    recycler_menu.setHasFixedSize(true);
                    recycler_menu.setLayoutManager(mLayoutManger);
                } else {
                    menu.getItem(0).setIcon(getResources().getDrawable(R.drawable.icon_view_grid));
                    recycler_menu.setLayoutManager(new GridLayoutManager(this, 2));
                }
                //  checkLoadMenuSwipe();
                break;
            case R.id.action_search:
                //  startActivity(new Intent(HomeActivity.this, SearchFoodActivity.class));
                break;
        }

        return super.onOptionsItemSelected(item);
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
}
