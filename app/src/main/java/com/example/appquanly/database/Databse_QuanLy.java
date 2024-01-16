package com.example.appquanly.database;

import android.database.sqlite.SQLiteOpenHelper;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

public class Databse_QuanLy extends SQLiteOpenHelper {

    public static String TB_NHANVIEN = "NHANVIEN";
    public static String TB_SANPHAM = "SANPHAM";

    public static String TB_NHANVIEN_MANV = "MANV";
    public static String TB_NHANVIEN_TENDN = "TENDN";
    public static String TB_NHANVIEN_MATKHAU = "MATKHAU";
    public static String TB_NHANVIEN_XACNHANMK = "XACNHANMK";

    public static String TB_SANPHAM_MASP = "MASP" ;
    public static String TB_SANPHAM_TENSP = "TENSP" ;
    public static String TB_SANPHAM_MOTA = "MOTA" ;
    public static String TB_SANPHAM_GIATIEN = "GIATIEN" ;
    public static String TB_SAPNPHAM_ANH = "ANH";
    public Databse_QuanLy(Context context){
        super(context, "QuanLy", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db){
        String tbNHANVIEN = "CREATE TABLE " + TB_NHANVIEN + " ( " + TB_NHANVIEN_MANV + " INTERGER PRIMARY KEY AUTOINCREMENT, " +
                TB_NHANVIEN_TENDN + "TEXT," +
                TB_NHANVIEN_MATKHAU + "TEXT," +
                TB_NHANVIEN_XACNHANMK + "TEXT) ";

        String tbSANPHAM = "CREATE TABLE " + TB_SANPHAM + " ( " + TB_SANPHAM_MASP + " INTERGER PRIMARY KEY AUTOINCREMENT, " +
                TB_SANPHAM_TENSP + "TEXT, " +
                TB_SANPHAM_MOTA + "TEXT, " +
                TB_SANPHAM_GIATIEN + "TEXT, " +
                TB_SAPNPHAM_ANH + "TEXT)";

        db.execSQL(tbNHANVIEN);
        db.execSQL(tbSANPHAM);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){

    }

    public SQLiteDatabase open(){
        return this.getWritableDatabase();
    }
}
