package com.example.appquanly;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.appquanly.database.Databse_QuanLy;

public class DangKy extends AppCompatActivity {
     private Button btnQuayLai, btnTaiKhoan;
     private EditText edtTenDangNhapDK, edtMatKhauDK, edtXacNhan;
     private Databse_QuanLy Database_QuanLy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dangky);
        Database_QuanLy = new Databse_QuanLy(this);
        AnhXa();
        btnQuayLai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DangKy.this,DangNhap.class);
                startActivity(intent);
            }
        });
    }

    private void AnhXa(){
        btnQuayLai=(Button) findViewById(R.id.btnQuayLai);
        btnTaiKhoan=(Button) findViewById(R.id.btnTaiKhoan);
        edtTenDangNhapDK=(EditText) findViewById(R.id.edtTenDangNhapDK);
        edtMatKhauDK=(EditText) findViewById(R.id.edtMatKhauDK);
        edtXacNhan=(EditText) findViewById(R.id.edtXacNhan);
    }
}
