package com.bni.umkm.bniumkm;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Transaksi extends AppCompatActivity {
<<<<<<< HEAD
Button Kunam;
=======
    Button Transfer;

>>>>>>> e097de1d9c662a96f2c1dd52e2d06afecf8ae473
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transaksi);
       kunam();
        ActionBar menu=getSupportActionBar();
        menu.setDisplayShowHomeEnabled(true);
        menu.setDisplayHomeAsUpEnabled(true);
<<<<<<< HEAD

=======
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
>>>>>>> e097de1d9c662a96f2c1dd52e2d06afecf8ae473




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
