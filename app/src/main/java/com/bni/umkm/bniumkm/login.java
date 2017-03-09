package com.bni.umkm.bniumkm;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import java.util.HashMap;
import java.util.Map;
import com.bni.umkm.bniumkm.DataSQLite.DataHelper;
import com.bni.umkm.bniumkm.config.config;
import com.bni.umkm.bniumkm.config.koneksi;
import com.bni.umkm.bniumkm.user.berandauser;

public class login extends AppCompatActivity {
    EditText nama_pelanggan,pass_pelanggan;
    Button masuk_pelanggan;
    private boolean loggedIn = false;
    DataHelper dbHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        loginmember();
          }
    public void loginmember() {
        // TODO Auto-generated method stub

        setContentView(R.layout.login);


        nama_pelanggan = (EditText)findViewById(R.id.nama_pelanggan);
        pass_pelanggan = (EditText)findViewById(R.id.pass_pelanggan);
        masuk_pelanggan = (Button)findViewById(R.id.masuk_pelanggan);

        dbHelper = new DataHelper(this);
        masuk_pelanggan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View args0) {
                // TODO Auto-generated method stub
                login();
            }
        });
    }
    @Override
    protected void onResume() {
        super.onResume();
        SharedPreferences sharedPreferences = getSharedPreferences(koneksi.SHARED_PREF_NAME, Context.MODE_PRIVATE);
        loggedIn = sharedPreferences.getBoolean(koneksi.LOGGEDIN_SHARED_PREF, false);

        if (loggedIn) {
            Intent intent;
            intent = new Intent(login.this, berandauser.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
            intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
            startActivity(intent);
        }
    }
    private void login() {
        // Ubah ketipe String
        final String IdLogin = nama_pelanggan.getText().toString().trim();
        final String PassLogin = pass_pelanggan.getText().toString().trim();

//        Buatkan Request Dalam bentuk String
        StringRequest stringRequest = new StringRequest(Request.Method.POST, koneksi.LOGIN_URL,
                new Response.Listener<String>() {

                    @Override
                    public void onResponse(String response) {
                        //Jika Respon server sukses
                        if (response.equalsIgnoreCase(koneksi.LOGIN_SUCCESS)) {
                            //Buatkan sebuah shared preference
                            SharedPreferences sharedPreferences = login.this.getSharedPreferences(koneksi.SHARED_PREF_NAME, Context.MODE_PRIVATE);

                            //Buatkan Sebuah variabel Editor Untuk penyimpanan Nilai shared preferences
                            SharedPreferences.Editor editor = sharedPreferences.edit();

                            //Tambahkan Nilai ke Editor
                            editor.putBoolean(koneksi.LOGGEDIN_SHARED_PREF, true);
                            editor.putString(koneksi.EMAIL_SHARED_PREF, IdLogin);

                            //Simpan Nilai ke Variabel editor
                            editor.commit();

                            //Starting Class yang dipanggil
                            Intent intent = new Intent(login.this, berandauser.class);
                            String Id = String.valueOf(nama_pelanggan.getText());
                            intent.putExtra(config.EMP_ID,Id);
//                            intent.putExtra(MainActivity.terima,Id);

                            SQLiteDatabase db = dbHelper.getWritableDatabase();
                            db.execSQL("insert into member(nama_pelanggan, pass_pelanggan) values('" +
                                    String.valueOf(nama_pelanggan.getText()) + "','" +
                                    String.valueOf(pass_pelanggan.getText()) + "')");
                            Toast.makeText(getApplicationContext(), "data sukses", Toast.LENGTH_LONG).show();
                            startActivity(intent);
                        } else {
                            //Jika Respon Dari Server tidak Sukses
                            //Tampilkan Pesan Errorrr dengan Toast,,
                            Toast.makeText(login.this, "Salah Id dan Password", Toast.LENGTH_LONG).show();
                        }
                    }

                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(login.this, "Cek koneksi Internet", Toast.LENGTH_LONG).show();
                        //Tambahkan apa yang terjadi setelah Pesan Error muncul, alternatif
                    }
                }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                //Tambahkan Parameter username dan password untuk Request
                params.put(koneksi.KEY_LOGIN, IdLogin);
                params.put(koneksi.KEY_PASSWORD, PassLogin);

                //Kembalikan Nilai parameter
                return params;
            }
        };
        //Tambahkan Request String ke dalam Queue
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }

    private Boolean exit = false;

    @Override
    public void onBackPressed() {
        if (exit) {
            finish(); // finish activity
        } else {
            Toast.makeText(this, "Press Back again to Exit.",
                    Toast.LENGTH_SHORT).show();
            exit = true;
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    exit = false;
                }
            }, 3 * 1000);
        }
    }


}
