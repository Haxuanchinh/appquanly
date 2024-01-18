package com.example.appquanly;

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
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class NhanVien extends AppCompatActivity {

    TextView textView;
    EditText edtMaNV, edtHoTen, edtMatKhauNV, edtXacNhanNV;
    Button btnThemNV, btnSuaNV, btnXoaNV, btnCapNhatNV;
    ListView lvDSNV;
    ArrayList <String> listNV;
    ArrayAdapter <String> adapterNV;
    SQLiteDatabase DBNhanVien;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nhanvien);
        AnhXa();
        Intent intent = getIntent();
        listNV = new ArrayList<>();
        adapterNV = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listNV);
        lvDSNV.setAdapter(adapterNV);

        DBNhanVien = openOrCreateDatabase("DanhSachNV.db", MODE_PRIVATE, null);
        try{
            String sql = "CREATE TABLE tbNV (maNV TEXT primary key, hoten TEXT, matkhauNV TEXT, xacnhanNV TEXT)";
            DBNhanVien.execSQL(sql);
        }
        catch (Exception e)
        {
            Log.e("Lỗi", "Bảng đã tồn tại");
        }

        btnThemNV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String maNV = edtMaNV.getText().toString();
                String hoten = edtHoTen.getText().toString();
                String matkhauNV = edtMatKhauNV.getText().toString();
                String xacnhanNV = edtXacNhanNV.getText().toString();
                ContentValues values = new ContentValues();
                values.put("maNV", maNV);
                values.put("hoten", hoten);
                values.put("matkhau", matkhauNV);
                values.put("xacnhanMK", xacnhanNV);
                String  msg = "";
                if(DBNhanVien.insert("DanhSachNV", null, values) == -1){
                    msg = "Thêm thất bại";
                }
                else{
                    msg = "Thêm thành công";
                }
                Toast.makeText(NhanVien.this, msg, Toast.LENGTH_SHORT).show();
            }
        });

        btnXoaNV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String maNV = edtMaNV.getText().toString();
                int n = DBNhanVien.delete("DanhSachNV", "maNV = ?", new String[]{maNV});
                String msg = "";
                if(n == 0){
                    msg = "No record to delete";
                }
                else{
                    msg = n + "record to delete";
                }
                Toast.makeText(NhanVien.this, msg, Toast.LENGTH_SHORT).show();
            }
        });

        btnSuaNV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String maNV = edtMaNV.getText().toString();
                String hoten = edtHoTen.getText().toString();
                String matkhauNV = edtMatKhauNV.getText().toString();
                String xacnhanNV = edtXacNhanNV.getText().toString();
                ContentValues values = new ContentValues();
                values.put("hoten", hoten);
                values.put("matkhau", matkhauNV);
                values.put("xacnhanMK", xacnhanNV);
                int n = DBNhanVien.update("DanhSachNV", values, "maNV = ?", new String[]{maNV});
                String msg = "";
                if(n == 0){
                    msg = "No record to update";
                }
                else{
                    msg = n + "record to update";
                }
                Toast.makeText(NhanVien.this, msg, Toast.LENGTH_SHORT).show();
            }
        });

        btnCapNhatNV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listNV.clear();
                Cursor c = DBNhanVien.query("DanhSachNV", null,null,null,null,null,null);
                String data = "";
                while (c.isAfterLast() == false){
                    data = c.getString(0)+ "-"+c.getString(1)+ "-"+c.getString(2)+ "-"+c.getString(3);
                    c.moveToNext();
                    listNV.add(data);
                }
                c.close();
                adapterNV.notifyDataSetChanged();
            }
        });


    }

    private void AnhXa(){
        textView = findViewById(R.id.textView);
        edtMaNV = findViewById(R.id.edtMaNV);
        edtHoTen = findViewById(R.id.edtHoTen);
        edtMatKhauNV = findViewById(R.id.edtMatKhauNV);
        edtXacNhanNV = findViewById(R.id.edtXacNhanNV);
        btnThemNV = findViewById(R.id.btnThemNV);
        btnSuaNV = findViewById(R.id.btnSuaNV);
        btnXoaNV = findViewById(R.id.btnXoaNV);
        btnCapNhatNV = findViewById(R.id.btnCapNhatNV);
        lvDSNV = findViewById(R.id.lvDSNV);
    }

}