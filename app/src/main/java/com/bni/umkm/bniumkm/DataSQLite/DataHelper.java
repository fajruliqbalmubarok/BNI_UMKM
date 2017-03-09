package com.bni.umkm.bniumkm.DataSQLite;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DataHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "bniumkm.db";
    private static final int DATABASE_VERSION = 1;

    public DataHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        // TODO Auto-generated constructor stub
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // TODO Auto-generated method stub
        String sql1 = "create table pelanggan(nama_pelanggan text null, pass_pelanggan text null);";
        Log.d("Data", "onCreate: " + sql1);
        db.execSQL(sql1);


//        sql1 = "INSERT INTO daftarkost (no) VALUES ('10');";
//        db.execSQL(sql1);
//        sql2 = "INSERT INTO member (emailmember) VALUES ('iqbal@gmail.com');";
//        db.execSQL(sql2);
//        sql3 = "INSERT INTO owner (emailowner, passowner) VALUES ('iq','223');";
//        db.execSQL(sql3);
    }

    @Override
    public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {
        // TODO Auto-generated method stub

    }

}