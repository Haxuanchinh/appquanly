package com.example.appquanly.QLDH;

import android.content.ContentValues;
import android.content.Context;
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
import androidx.core.content.pm.PermissionInfoCompat;
import com.example.appquanly.R;

import java.util.ArrayList;

public class qldh extends AppCompatActivity {
    EditText edtmasp,edttensp , edtgiasp;
    Button btninsert, btndelete,btnupdate , btnquery;
    ListView lv;
    ArrayList<String> mylist;
    ArrayAdapter<String> myadapter;
    SQLiteDatabase mydatabase;

    @Override

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.qldonhang);
        edttensp = findViewById(R.id.edttensp);
        edtgiasp = findViewById(R.id.edtgiasp);
        edtmasp = findViewById(R.id.edtmasp);
        btninsert = findViewById(R.id.btninsert);
        btndelete = findViewById(R.id.btndelete);
        btnupdate = findViewById(R.id.btnupdate);
        btnquery = findViewById(R.id.btnquery);

        lv = findViewById(R.id.lv);
        mylist = new ArrayList<>();
        myadapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, mylist);
        lv.setAdapter(myadapter);
        mydatabase = openOrCreateDatabase("qldonhang.db",MODE_PRIVATE,null);
        try {
            String sql = "CREATE TABLE tbldonhang(masp TEXT primary key, tensp TEXT, giasp INTERGER)";
            mydatabase.execSQL(sql);

        }
        catch (Exception e){
            Log.e("error","table đã tồn tại");
        }
        btninsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String masp = edtmasp.getText().toString();
                String tensp = edttensp.getText().toString();
                int giasp = Integer.parseInt(edtgiasp.getText().toString());
                ContentValues myvalue = new ContentValues();
                myvalue.put("masp",masp);
                myvalue.put("tensp",tensp);
                myvalue.put("giasp",giasp);
                String msg = "";
                if (mydatabase.insert("tbldonhang",null,myvalue)==-1)
                {
                    msg = "fail";
                }
                else  {
                    msg = "Insert";
                }

                Toast.makeText(qldh.this, "msg", Toast.LENGTH_SHORT).show();
            }
        });
        btndelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String masp = edtmasp.getText().toString();
                int n = mydatabase.delete("tbldonhang","masp = ?",new String[]{masp});
                String msg = "";
                if (n==0){
                    msg = "no";
                }
                else {
                    msg = n + " record";
                }
                Toast.makeText(qldh.this, "msg", Toast.LENGTH_SHORT).show();

            }
        });


    }
}
