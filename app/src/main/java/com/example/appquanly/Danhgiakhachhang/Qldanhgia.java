package com.example.appquanly.Danhgiakhachhang;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import com.example.appquanly.R;

public class Qldanhgia  extends  AppCompatActivity{
    private EditText edtTen, edtGopY;
    private Button btnSend;
    private TextView txtReview;
    private CheckBox cb1, cb2, cb3, cb4, cb5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.danhgiasp);
        Intent intent = getIntent();

        // Ánh xạ các thành phần giao diện
        edtTen = findViewById(R.id.edtten);
        edtGopY = findViewById(R.id.edtgopy);
        btnSend = findViewById(R.id.btnsend);
        txtReview = findViewById(R.id.txtreview);
        cb1 = findViewById(R.id.cb1);
        cb2 = findViewById(R.id.cb2);
        cb3 = findViewById(R.id.cb3);
        cb4 = findViewById(R.id.cb4);
        cb5 = findViewById(R.id.cb5);

        // Xử lý sự kiện khi nhấn nút "Gửi đánh giá"
        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Lấy dữ liệu từ các trường nhập liệu
                String ten = edtTen.getText().toString().trim();
                String gopY = edtGopY.getText().toString().trim();

                // Hiển thị đánh giá lên màn hình
                String review = "Khách hàng: " + ten + "\nGóp ý: " + gopY;
                txtReview.setText(review);

                // Hiển thị thông báo thành công
                Toast.makeText(Qldanhgia.this, "Đánh giá đã được gửi", Toast.LENGTH_SHORT).show();

                // Xóa nội dung trường nhập liệu sau khi gửi thành công
                edtTen.setText("");
                edtGopY.setText("");
            }
        });

        // Thiết lập sự kiện cho từng Checkbox
        cb1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    txtReview.setText(cb1.getText());
                }
            }
        });

        cb2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    txtReview.setText(cb2.getText());
                }
            }
        });

        cb3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    txtReview.setText(cb3.getText());
                }
            }
        });

        cb4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    txtReview.setText(cb4.getText());
                }
            }
        });

        cb5.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    txtReview.setText(cb5.getText());
                }
            }
        });
    }
}
