package com.example.appquanly.QLHD;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;

public class HoadonDAO {
    private DbHelper dbHelper;
    private SQLiteDatabase database;
    public HoadonDAO(Context Context){
        dbHelper = new DbHelper(Context);
        database=dbHelper.getWritableDatabase();
    }

    public long addHoadon(Hoadon hoadon){
        ContentValues values = new ContentValues();
        values.put("mahd", hoadon.getMahd());
        values.put("tensp", hoadon.getTensp());
        values.put("soluong", hoadon.getSoluong());
        values.put("giatien", hoadon.getGiatien());
        values.put("date", hoadon.getDate());

        long check=database.insert("Hoadon", null, values);
        return check;
    }
    //hàm xóa
    public long deleteHoadon(int mahd){
        long check=database.delete("Hoadon", "mahd=?", new String[]{String.valueOf(mahd)});
        return check;
    }
    //hàm sửa
    public long updateHoadon(Hoadon hoadon){
        ContentValues values = new ContentValues();
        values.put("mahd", hoadon.getMahd());
        values.put("tensp", hoadon.getTensp());
        values.put("soluong", hoadon.getSoluong());
        values.put("giatien", hoadon.getGiatien());
        values.put("date", hoadon.getDate());
        //values.put("tien", hoadon.getTien());

        long check=database.update("Hoadon", values, "mahd=?", new String[]{String.valueOf(hoadon.getMahd())});
        return check;
    }

    public ArrayList<Hoadon> getlistHoadon(){
        ArrayList<Hoadon> list = new ArrayList<>();
        database=dbHelper.getReadableDatabase();
        try{
            Cursor cursor = database.rawQuery("select * from Hoadon", null);
            if(cursor.getCount()>0){
                cursor.moveToFirst();
                do{
                    list.add(new Hoadon(cursor.getInt(0),
                            cursor.getString(1),
                            cursor.getInt(2),
                            cursor.getInt(3),
                            cursor.getString(4)));
                }while(cursor.moveToNext());
            }
        }catch (Exception e){
            Log.e("TAG", e.getMessage());
        }
        return list;
    }
}