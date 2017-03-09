package com.bni.umkm.bniumkm;

/**
 * Created by Fajrul on 07/03/2017.
 */

/**
 * Created by Fajrul on 06/03/2017.
 */
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Created by Fajrul on 06/03/2017.
 */

public class tabadapter extends FragmentStatePagerAdapter {

    //deklarasi variabel untuk menampung jumlah tab menu yang ada
    int tabCount;

    //konstruktor
    public tabadapter(FragmentManager fm, int tabCount) {
        super(fm);
        //menginisialisasi tabcount
        this.tabCount = tabCount;
    }

    //Overriding method getItem
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                Fragment tab1 = new berita(); //menginstansiasi objek baru yaitu Fragment1.java
                return tab1;
            case 1:
                Fragment tab2 = new calculator(); //menginstansiasi objek baru yaitu Fragment2.java
                return tab2;
            default:
                return null;
        }
    }

    //Overriden method getCount untuk mengambil jumlah dari tab menu
    @Override
    public int getCount() {
        return tabCount;
    }

}