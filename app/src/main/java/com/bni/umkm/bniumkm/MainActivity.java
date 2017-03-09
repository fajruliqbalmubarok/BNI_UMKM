package com.bni.umkm.bniumkm;
import android.content.Intent;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v4.view.ViewPager; //import ViewPager, viewpager berfungsi untuk mengontrol posisi tab
import android.support.design.widget.TabLayout; //import TabLayout, TabLayout berfungsi untuk membuat menu tab layout
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    private TabLayout tabLayout; //Deklarasi Tab Layout

    private ViewPager viewPager; //Deklarasi view pager
    private DrawerLayout dr;
    private Toolbar tl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.finaly_layout);
        tl = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(tl);
        ProsesNavigasi();

        // tablayout
        tabLayout = (TabLayout) findViewById(R.id.tabLayout); //mengenalkan komponen tab layout yang berada di activity_main ke MainActivity.java
        tabLayout.addTab(tabLayout.newTab().setText("Berita")); //Nama menu tab yang pertama
        tabLayout.addTab(tabLayout.newTab().setText("Kalkulator")); //Nama menu tab yang kedua
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL); //membuat rata tengah posisi tab layout
        //viewpager
        viewPager = (ViewPager) findViewById(R.id.viewPager); //mengenalkan komponen view pager yang berada di activity_main ke MainActivity.java
        tabadapter adapter = new tabadapter(getSupportFragmentManager(), tabLayout.getTabCount()); //menerapkan page adapter PageAdapter.java


        //Menambahkan adapter ke pager
        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition()); //menampilkan fragment pada posisi tab menu yang sedang di klik

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }

        });

    }
    public void ProsesNavigasi() {
        NavigationView navigationView = (NavigationView) findViewById(R.id.navigation_view);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {

                int id = menuItem.getItemId();

                switch (id) {
                    case R.id.about:
                        Toast.makeText(getApplicationContext(), "About", Toast.LENGTH_SHORT).show();
                        dr.closeDrawers();
                        break;
                    case R.id.login:
                        Toast.makeText(getApplicationContext(), "Login", Toast.LENGTH_SHORT).show();
                        dr.closeDrawers();
                        Intent i=null;
                        i = new Intent(MainActivity.this, login.class);
                        startActivity(i);
                }
                return true;
            }
        });
        View header = navigationView.getHeaderView(0);
        TextView tv_email = (TextView) header.findViewById(R.id.tv_email);
        tv_email.setText("Fajrul Iqbal Mubarok");
        dr = (DrawerLayout) findViewById(R.id.drawer);

        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this, dr, tl, R.string.drawer_open, R.string.drawer_close) {

            @Override
            public void onDrawerClosed(View v) {
                super.onDrawerClosed(v);
            }

            @Override
            public void onDrawerOpened(View v) {
                super.onDrawerOpened(v);
            }
        };
        dr.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
    }
}

