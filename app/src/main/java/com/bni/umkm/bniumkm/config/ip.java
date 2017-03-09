package com.bni.umkm.bniumkm.config;

/**
 * Created by Fajrul on 08/03/2017.
 */

public class ip {
    private static final String ROOT_URL = "http://192.168.1.11/bniumkm";
    //    private static final String ROOT_URL = "https://gokostku.000webhostapp.com/gokost";
    private static final String ROOT_URL1 = "http://192.168.1.11/";
//    private static final String ROOT_URL1 = "https://gokostku.000webhostapp.com/";

    public static String ipstatic() {
        String ips = ROOT_URL;
        return ips;
    }
    public static String ipsget() {
        String ips = ROOT_URL1;
        return ips;
    }

}