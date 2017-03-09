package com.bni.umkm.bniumkm;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by ahmadroihan on 3/8/17.
 */

public class BeritaAdapter extends  RecyclerView.Adapter<BeritaViewHolder>{
    private String[] nama;
    // menampilkan list item dalam bentuk text dengan tipe data string dengan variable name

    LayoutInflater inflater;
    public BeritaAdapter (String[] name) {

        nama = name;

    }
    @Override
    public BeritaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.activity_berita_list, parent, false);
        // set the view's size, margins, paddings and layout parameters
        BeritaViewHolder vh = new BeritaViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(BeritaViewHolder holder, int position) {

        holder.tv1.setText(nama[position]);
        holder.tv1.setTag(holder);
        holder.imageView.setTag(holder);

    }




    @Override
    public int getItemCount() {
        return nama.length;
    }
}


