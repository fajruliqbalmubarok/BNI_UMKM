package com.bni.umkm.bniumkm.config;

/**
 * Created by roihan on 05/12/2016.
 */

public class config {
    private static final ip is = new ip();
    private static final String ipku = is.ipstatic();

    public static final String LOGIN_URL = ipku + "/new_login.php";
    // Variabel untuk definisikan Username dan password methode POST sesuai dengan yang di : new_login.php
    public static final String KEY_LOGIN = "nama_pelanggan";
    public static final String KEY_PASSWORD = "pass_pelanggan";

    // Jika respon server adalah sukses login
    public static final String LOGIN_SUCCESS = "success";

    //Kunci untuk Sharedpreferences
    public static final String SHARED_PREF_NAME = "myloginapp";

    //Ini digunakan untuk store username jika User telah Login
    public static final String EMAIL_SHARED_PREF = "idLogin";

    // Ini digunakan untuk store sharedpreference untuk cek user melakukan login atau tidak
    public static final String LOGGEDIN_SHARED_PREF = "loggedin";


    public static final String URL_ADD = ipku + "/create.php";
    // Link Untuk Tampil Data
    //public static final String URL_GET_ALL = ipku + "/read.php";
    // Link untuk Update data Profil
    // public static final String URL_UPDATE_EMP = ipku + "/update_profil.php";


    // Field yang digunakan untuk dikirimkan ke Database, sesuaikan saja dengan Field di Tabel Mahasiswa
    public static final String key_namamember = "namamember";
    public static final String key_no_telpmemebr = "no_telpmemebr";
    public static final String key_alamatmember = "alamatmember";
    public static final String key_emailmember = "emailmember";
    public static final String key_pass = "pass";

    //employee id to pass with intent
    // Mahasiswa ID
    public static final String EMP_ID = "emp_id";
    public static final String PASS_ID = "pass_id";
    public static final String idkuki = "id";

}
