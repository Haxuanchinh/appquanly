package com.example.appquanly.QLKH;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.appquanly.R;

import java.util.ArrayList;

public class qlkh extends AppCompatActivity {
    //khai báo biến giao diện
    EditText edtMakh, edtTen, edtSDT, edtGioitinh;
    Button btnThem, btnSua, btnXoa, btnCapnhat;
    //khai báo listview
    ListView lv;
    ArrayList<String> mylist;
    ArrayAdapter<String> myadapter;
    SQLiteDatabase mydatabase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.qlkh);
        Intent intent = getIntent();

        edtMakh = findViewById(R.id.edtMakh);
        edtTen = findViewById(R.id.edtTen);
        edtGioitinh = findViewById(R.id.edtGioitinh);
        edtSDT = findViewById(R.id.edtPhone);
        btnThem = findViewById(R.id.btnThem);
        btnXoa = findViewById(R.id.btnXoa);
        btnSua = findViewById(R.id.btnSua);
        btnCapnhat = findViewById(R.id.btnCapnhat);
        //Tạo listview
        lv = findViewById(R.id.lvQLKH);
        mylist = new ArrayList<>();
        myadapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, mylist);
        lv.setAdapter(myadapter);
        //Tạo và mở csdl
        mydatabase = openOrCreateDatabase("qlkh", MODE_PRIVATE, null);
        //Tạo table
        try{
            String sql = "CREATE TABLE Khachhang(makh TEXT primary key, tenkh TEXT, gioitinh text, sdt INTEGER)";
            mydatabase.execSQL(sql);
        }
        catch(Exception e)
        {
            Log.e("Error","Table tồn tại");
        }

        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String makh = edtMakh.getText().toString();
                String tenkh = edtTen.getText().toString();
                String gioitinh = edtGioitinh.getText().toString();
                int sdt = Integer.parseInt(edtSDT.getText().toString());
                ContentValues myvalue = new ContentValues();
                myvalue.put("makh", makh);
                myvalue.put("tenkh", tenkh);
                myvalue.put("gioitinh", gioitinh);
                myvalue.put("sdt", sdt);
                String msg = " ";
                if(mydatabase.insert("Khachhang", null, myvalue) == -1)
                {
                    msg = "Lỗi!";
                }
                else {
                    msg = "Thành công";
                }
                Toast.makeText(qlkh.this, msg, Toast.LENGTH_SHORT).show();
            }
        });

        btnXoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String makh = edtMakh.getText().toString();
                int n = mydatabase.delete("qlkh", "makh = ?", new String[]{makh});
                String msg = "";
                if(n==0){
                    msg = "Không có gì xóa";
                }
                else {
                    msg = "Có "+ n+ " bản ghi bị xóa";
                }
                Toast.makeText(qlkh.this, msg, Toast.LENGTH_SHORT).show();
            }
        });

        btnSua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String makh = edtMakh.getText().toString();
                String tenkh = edtTen.getText().toString();
                String gender = edtGioitinh.getText().toString();
                int sdt = Integer.parseInt(edtSDT.getText().toString());
                ContentValues myvalue = new ContentValues();
                //myvalue.put("sdt", sdt);
                int n = mydatabase.update("Khachhang", myvalue, "makh = ?", new String[]{makh});
                String msg = "";
                if (n == 0) {
                    msg = "không cập nhật";
                } else {
                    msg = "Có " + n + " hàng cập nhật";
                }
                Toast.makeText(qlkh.this, msg, Toast.LENGTH_SHORT).show();
            }
        });

        btnCapnhat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mylist.clear();
                Cursor c = mydatabase.query("Khachhang", null, null, null, null, null, null);
                c.moveToNext();
                String data = "";
                while (c.isAfterLast() == false){
                    data = c.getString(0)+" - "+c.getString(1)+" - "+c.getString(2)+" - "+c.getString(3);
                    c.moveToNext();
                    mylist.add(data);
                }
                c.close();
                myadapter.notifyDataSetChanged();
            }
        });
    }
}