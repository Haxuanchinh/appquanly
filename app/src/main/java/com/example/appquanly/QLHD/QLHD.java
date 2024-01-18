package com.example.appquanly.QLHD;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.appquanly.R;

import java.util.ArrayList;

public class QLHD extends AppCompatActivity {
    EditText edtMahd, edtTensp, edtSL, edtGia, edtNgay;
    TextView tvTien;
    Button btnAdd, btnUpdate, btnDelete;
    ListView listView;
    ArrayList<String> list= new ArrayList<>();
    ArrayList<Hoadon> listHD=new ArrayList<>();
    HoadonDAO hoadonDAO;
    Context context=this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.qlhd);
        edtMahd=findViewById(R.id.edtMahd);
        edtTensp=findViewById(R.id.edtTensp);
        edtSL=findViewById(R.id.edtSL);
        edtGia=findViewById(R.id.edtGia);
        edtNgay=findViewById(R.id.edtNgay);

        btnAdd=findViewById(R.id.btnAdd);
        btnDelete=findViewById(R.id.btnDelete);
        btnUpdate=findViewById(R.id.btnUpdate);
        listView = findViewById(R.id.lvQLHD);

        hoadonDAO = new HoadonDAO(context);
        listHD.clear();
        list.clear();

        listHD=hoadonDAO.getlistHoadon();
        for(Hoadon hd: listHD){
            list.add(hd.getMahd()+" - "+hd.getTensp()+" - "+hd.getSoluong()+" - "+hd.getGiatien()+" - "+hd.getDate());
        }
        ArrayAdapter<String> adapter=new ArrayAdapter<>(context, android.R.layout.simple_list_item_1, list);
        listView.setAdapter(adapter);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Hoadon hoadon = new Hoadon();
                hoadon.setMahd(Integer.parseInt(edtMahd.getText().toString()));
                hoadon.setTensp(edtTensp.getText().toString());
                hoadon.setSoluong(Integer.parseInt(edtSL.getText().toString()));
                hoadon.setGiatien(Integer.parseInt(edtGia.getText().toString()));
                hoadon.setDate(edtNgay.getText().toString());
                //goi ham insert
                hoadonDAO.addHoadon(hoadon);
                listHD.clear();
                list.clear();
                listHD=hoadonDAO.getlistHoadon();
                for(Hoadon hd :listHD){
                    list.add(hd.getMahd()+" - "+hd.getTensp()+" - "+hd.getSoluong()+" - "+hd.getGiatien()+" - "+hd.getDate());
                }
                adapter.notifyDataSetChanged();
            }
        });

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Hoadon hoadon=new Hoadon();
                hoadon.setMahd(Integer.parseInt(edtMahd.getText().toString()));
                hoadon.setTensp(edtTensp.getText().toString());
                hoadon.setSoluong(Integer.parseInt(edtSL.getText().toString()));
                hoadon.setGiatien(Integer.parseInt(edtGia.getText().toString()));
                hoadon.setDate(edtNgay.getText().toString());
                hoadonDAO.updateHoadon(hoadon);
                listHD.clear();
                list.clear();
                listHD=hoadonDAO.getlistHoadon();
                for(Hoadon hd :listHD){
                    list.add(hd.getMahd()+" - "+hd.getTensp()+" - "+hd.getSoluong()+" - "+hd.getGiatien()+" - "+hd.getDate());
                }
                adapter.notifyDataSetChanged();
            }
        });

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int mahd = Integer.parseInt((edtMahd.getText().toString()));
                hoadonDAO.deleteHoadon(mahd);
                listHD.clear();
                list.clear();
                listHD=hoadonDAO.getlistHoadon();
                for(Hoadon hd :listHD){
                    list.add(hd.getMahd()+" - "+hd.getTensp()+" - "+hd.getSoluong()+" - "+hd.getGiatien()+" - "+hd.getDate());
                }
                adapter.notifyDataSetChanged();
            }
        });
    }
}