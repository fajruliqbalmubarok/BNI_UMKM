package com.bni.umkm.bniumkm;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Transaksi extends AppCompatActivity {
Button Kunam;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transaksi);
       kunam();
        ActionBar menu=getSupportActionBar();
        menu.setDisplayShowHomeEnabled(true);
        menu.setDisplayHomeAsUpEnabled(true);





    }

    private void kunam() {
        Kunam = (Button) findViewById(R.id.Transfer);
        Kunam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent q = new Intent(Transaksi.this, TransaksiBank.class);
                startActivity(q);
            }
        });
    }
}
