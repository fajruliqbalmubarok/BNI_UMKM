package com.bni.umkm.bniumkm;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Transaksi extends AppCompatActivity {
    Button Transfer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transaksi);
        ActionBar menu=getSupportActionBar();
        menu.setDisplayShowHomeEnabled(true);
        menu.setDisplayHomeAsUpEnabled(true);
        transferbank();
//        Button Transaksi = (Button) findViewById(R.id.transaksi);
//
//       Transaksi.setOnClickListener(new View.OnClickListener() {
//           @Override
//           public void onClick(View v) {
//               Intent transaksi=new Intent(Transaksi.this, TransaksiBank.class);
//               startActivity(transaksi);
//
//           }
//       });

    }
    public void transferbank(){
        Transfer = (Button) findViewById(R.id.Transfer);
        Transfer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View args0) {
                // TODO Auto-generated method stub
                Intent intent;
                intent = new Intent(Transaksi.this, TransaksiBank.class);
                startActivity(intent);
            }
        });
    }
}
