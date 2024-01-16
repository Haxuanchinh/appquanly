package com.example.appquanly;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.appquanly.database.Databse_QuanLy;

public class DangNhap extends AppCompatActivity {

    private Button btnDangKy, btnDangNhap, btnThoat;
    private EditText edtTenDangNhap, edtMatKhau;
    private Databse_QuanLy Database_QuanLy;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dangnhap);
        AnhXa();
        Database_QuanLy = new Databse_QuanLy(this);
        btnDangKy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DangNhap.this,DangKy.class);
                startActivity(intent);
            }
        });

        btnDangNhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DangNhap.this,TrangChu.class);
                startActivity(intent);
            }
        });
    }

    private void AnhXa(){
        btnDangKy=(Button) findViewById(R.id.btnDangKy);
        btnDangNhap=(Button) findViewById(R.id.btnDangNhap);
        btnThoat=(Button) findViewById(R.id.btnThoat);
        edtTenDangNhap=(EditText) findViewById(R.id.edtTenDangNhap);
        edtMatKhau=(EditText) findViewById(R.id.edtMatKhau);
    }
}