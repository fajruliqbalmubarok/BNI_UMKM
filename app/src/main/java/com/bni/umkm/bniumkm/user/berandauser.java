package com.bni.umkm.bniumkm.user;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v4.view.ViewPager; //import ViewPager, viewpager berfungsi untuk mengontrol posisi tab
import android.support.design.widget.TabLayout; //import TabLayout, TabLayout berfungsi untuk membuat menu tab layout
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.bni.umkm.bniumkm.DataSQLite.DataHelper;
import com.bni.umkm.bniumkm.MainActivity;
import com.bni.umkm.bniumkm.R;
import com.bni.umkm.bniumkm.login;
import com.bni.umkm.bniumkm.config.koneksi;
import com.bni.umkm.bniumkm.tabadapter;

public class berandauser extends AppCompatActivity {
    private TabLayout tabLayout; //Deklarasi Tab Layout

    private ViewPager viewPager; //Deklarasi view pager
    private DrawerLayout dr;
    private Toolbar tl;

    DataHelper dbcenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.finaly_layout);
        tl = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(tl);
        ProsesNavigasi();
        dbcenter = new DataHelper(this);
        // tablayout
        tabLayout = (TabLayout) findViewById(R.id.tabLayout); //mengenalkan komponen tab layout yang berada di activity_main ke MainActivity.java
        tabLayout.addTab(tabLayout.newTab().setText("Berita")); //Nama menu tab yang pertama
        tabLayout.addTab(tabLayout.newTab().setText("Calculator")); //Nama menu tab yang kedua
        tabLayout.setTabGravity(TabLayout.GRAVITY_CENTER); //membuat rata tengah posisi tab layout
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
                    case R.id.profile:
                        Toast.makeText(getApplicationContext(), "Profile", Toast.LENGTH_SHORT).show();
                        dr.closeDrawers();
                        break;
                    case R.id.record:
                        Toast.makeText(getApplicationContext(), "Record", Toast.LENGTH_SHORT).show();
                        dr.closeDrawers();
                        break;
                    case R.id.transaksi:
                        Toast.makeText(getApplicationContext(), "Transaksi", Toast.LENGTH_SHORT).show();
                        dr.closeDrawers();
                        break;
                    case R.id.logout:
                        Toast.makeText(getApplicationContext(), "Logout", Toast.LENGTH_SHORT).show();
                        dr.closeDrawers();
                       logout();
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
    private void logout() {
        // Munculkan alert dialog apabila user ingin keluar aplikasi
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setMessage("Metu Temenana?");
        alertDialogBuilder.setPositiveButton("Yes",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface arg0, int arg1) {

                        // Getting out
                        SharedPreferences preferences = getSharedPreferences(koneksi.SHARED_PREF_NAME, Context.MODE_PRIVATE);
                        //Getting editor
                        SharedPreferences.Editor editor = preferences.edit();

                        // put nilai false untuk login
                        editor.putBoolean(koneksi.LOGGEDIN_SHARED_PREF, false);

                        // put nilai untuk username
                        editor.putString(koneksi.EMAIL_SHARED_PREF, "");

                        //Simpan ke haredpreferences
                        editor.commit();
                        SQLiteDatabase db = dbcenter.getWritableDatabase();
                        db.execSQL("delete from member where 1");
                        Intent launchNextActivity;
                        launchNextActivity = new Intent(berandauser.this, MainActivity.class);
                        launchNextActivity.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        launchNextActivity.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                        launchNextActivity.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                        startActivity(launchNextActivity);
                    }
                });
        // Pilihan jika NO
        alertDialogBuilder.setNegativeButton("No",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface arg0, int arg1) {

                    }
                });

        // Tampilkan alert dialog
        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }
}