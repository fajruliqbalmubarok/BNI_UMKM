package com.bni.umkm.bniumkm;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by ahmadroihan on 3/8/17.
 */

public class BeritaViewHolder extends RecyclerView.ViewHolder{

    // ViewHolder akan mendeskripisikan item view yang ditempatkan di dalam RecyclerView.
    TextView tv1,tv2; //deklarasi textview
    ImageView imageView;  //deklarasi imageview

    public BeritaViewHolder(View itemView) {
        super(itemView);

        tv1= (TextView) itemView.findViewById(R.id.judul);
        //menampilkan text dari widget CardView pada id daftar_judul
        tv2= (TextView) itemView.findViewById(R.id.deskripsi);
        //menampilkan text deskripsi dari widget CardView pada id daftar_deskripsi
        imageView= (ImageView) itemView.findViewById(R.id.gambar);
        //menampilkan gambar atau icon pada widget Cardview pada id daftar_icon
    }
}