package com.example.appquanly;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class DangNhap extends AppCompatActivity {

    private Button btnDangKy, btnDangNhap, btnThoat;
    private EditText edtTenDangNhap, edtMatKhau;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dangnhap);
        AnhXa();
        btnDangKy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DangNhap.this,DangKy.class);
                startActivity(intent);
            }
        });

        btnThoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(DangNhap.this, android.R.style.Theme_DeviceDefault_Light_Dialog);
                builder.setTitle("Bạn có chắc chắn không");
                builder.setMessage("Hãy chọn một trong hai lựa chọn sau");
                builder.setPositiveButton("Có", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        onBackPressed();
                    }
                });
                builder.setNegativeButton("Không", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                builder.show();
            }
        });

        btnDangNhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(edtTenDangNhap.getText().length() !=0 && edtMatKhau.getText().length() !=0){
                    if (edtTenDangNhap.getText().toString().equals("admin") && edtMatKhau.getText().toString().equals("admin")){
                        Toast.makeText(DangNhap.this, "Đăng nhập thành công", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(DangNhap.this,TrangChu.class);
                        startActivity(intent);
                    }
                    else{
                        Toast.makeText(DangNhap.this, "Đăng nhập thất bại", Toast.LENGTH_SHORT).show();
                    }
                }
                else{
                    Toast.makeText(DangNhap.this, "Hãy điền đầy đu thông tin", Toast.LENGTH_SHORT).show();
                }
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