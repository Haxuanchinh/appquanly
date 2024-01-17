package com.example.appquanly.QLHD;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DbHelper extends SQLiteOpenHelper {
    public DbHelper(Context context) {
        super(context, "Hoadon", null, 1);
    }

    @Override
    //tạo db
    public void onCreate(SQLiteDatabase db) {
        String sql ="create table Hoadon(mahd interger primary key, tensp text, soluong int, giatien int, date text)";
        db.execSQL(sql);

        String data= "INSERT INTO Hoadon(mahd, tensp, soluong, giatien, date) values ('01','cafe','1', '30000','01-01-2024')";
        db.execSQL(data);
    }

    @Override
    //cập nhật
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if(oldVersion != newVersion){
            db.execSQL("Drop table if exists Hoadon");
            onCreate(db);
        }
    }
}