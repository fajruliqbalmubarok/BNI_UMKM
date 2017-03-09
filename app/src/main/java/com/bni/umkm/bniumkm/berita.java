package com.bni.umkm.bniumkm;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class berita extends Fragment {
    private TextView textView;
    //deklarasi variabel reyclerview
    RecyclerView recyclerView;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    public berita() {
        // Required empty publ  ic constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.berita, container, false);


        RecyclerView rv = (RecyclerView) rootView.findViewById(R.id.recycler_view);

        BeritaAdapter adapter = new BeritaAdapter(new String[]{"Judul 1", "Judul 2", "Judul 3", "Judul 4", "Judul 5", "Judul 6", "Judul 7"});
        //membuat adapter baru untuk reyclerview
        rv.setAdapter(adapter);
        //menset nilai dari adapter
        rv.setHasFixedSize(true);
        //menset setukuran
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        rv.setLayoutManager(llm);
        //menset layoutmanager dan menampilkan daftar/list
        //dalam bentuk linearlayoutmanager pada class saat ini
        return rootView;

    }
}