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

public class SanPham extends AppCompatActivity {

    TextView textView;
    EditText edtmaSP, edttenSP, edtmotaSP, edtgiaSP;
    Button btnthemSP, btnsuaSP, btnxoaSP, btncapnhatSP;
    ListView lvDSSP;
    ArrayList<String> listSP;
    ArrayAdapter<String> adapterSP;
    SQLiteDatabase DBSanPham;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sanpham);
        AnhXa();
        Intent intent = getIntent();
        listSP = new ArrayList<>();
        adapterSP = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listSP);
        lvDSSP.setAdapter(adapterSP);

        DBSanPham = openOrCreateDatabase("DanhSachSP.db", MODE_PRIVATE, null);
        try{
            String sql = "CREATE TABLE tbSP (maSP TEXT primary key, tenSP TEXT, mota TEXT, giatien TEXT)";
            DBSanPham.execSQL(sql);
        }
        catch (Exception e)
        {
            Log.e("Lỗi", "Bảng đã tồn tại");
        }

        btnthemSP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String maSP = edtmaSP.getText().toString();
                String tenSP = edttenSP.getText().toString();
                String mota = edtmotaSP.getText().toString();
                String giatien = edtgiaSP.getText().toString();
                ContentValues values = new ContentValues();
                values.put("maSP", maSP);
                values.put("tenSP", tenSP);
                values.put("mota", mota);
                values.put("giatien", giatien);
                String  msg = "";
                if(DBSanPham.insert("tbSP", null, values) == -1){
                    msg = "Thêm thất bại";
                }
                else{
                    msg = "Thêm thành công";
                }
                Toast.makeText(SanPham.this, msg, Toast.LENGTH_SHORT).show();
            }
        });

        btnxoaSP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String maSP = edtmaSP.getText().toString();
                int n = DBSanPham.delete("tbSP", "maSP = ?", new String[]{maSP});
                String msg = "";
                if(n == 0){
                    msg = "No record to delete";
                }
                else{
                    msg = n + "record to delete";
                }
                Toast.makeText(SanPham.this, msg, Toast.LENGTH_SHORT).show();
            }
        });

        btnsuaSP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String maSP = edtmaSP.getText().toString();
                String tenSP = edttenSP.getText().toString();
                String mota = edtmotaSP.getText().toString();
                String giatien = edtgiaSP.getText().toString();
                ContentValues values = new ContentValues();
                values.put("tenSP", tenSP);
                values.put("mota", mota);
                values.put("giatien", giatien);
                int n = DBSanPham.update("tbSP", values, "maSP = ?", new String[]{maSP});
                String msg = "";
                if(n == 0){
                    msg = "No record to update";
                }
                else{
                    msg = n + "record to update";
                }
                Toast.makeText(SanPham.this, msg, Toast.LENGTH_SHORT).show();
            }
        });

        btncapnhatSP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listSP.clear();
                Cursor c = DBSanPham.query("tbSP", null,null,null,null,null,null);
                String data = "";
                while (c.isAfterLast() == false){
                    data = c.getString(0)+ "-"+c.getString(1)+ "-"+c.getString(2)+ "-"+c.getString(3);
                    c.moveToNext();
                    listSP.add(data);
                }
                c.close();
                adapterSP.notifyDataSetChanged();
            }
        });


    }

    private void AnhXa(){
        textView = findViewById(R.id.textView);
        edtmaSP = findViewById(R.id.edtmaSP);
        edttenSP = findViewById(R.id.edttenSP);
        edtmotaSP = findViewById(R.id.edtmotaSP);
        edtgiaSP = findViewById(R.id.edtgiaSP);
        btnthemSP = findViewById(R.id.btnthemSP);
        btnsuaSP = findViewById(R.id.btnsuaSP);
        btnxoaSP = findViewById(R.id.btnxoaSP);
        btncapnhatSP = findViewById(R.id.btncapnhatSP);
        lvDSSP = findViewById(R.id.lvDSSP);
        }
    }