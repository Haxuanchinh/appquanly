package com.example.appquanly;


import android.annotation.SuppressLint;
import android.content.ClipData;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.appquanly.QLDH.qldh;
import com.example.appquanly.QLHD.QLHD;
import com.example.appquanly.QLKH.qlkh;
import com.google.android.material.navigation.NavigationView;

public class TrangChu extends AppCompatActivity {

    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;
    FragmentManager fragmentManager;

    Button btnNhanvien, btnSanPham, btnkhachhang, btnhoadon, btndonhang;

    MenuItem trangchu,khachhang;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.trangchu);
        AnhXa();
        actionBar();
        trangchu = findViewById(R.id.trangchu);
        ActionBarDrawerToggle drawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.mo, R.string.dong){
            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
            }
        };
        drawerLayout.setDrawerListener(drawerToggle);
        drawerToggle.syncState();

        navigationView.setItemIconTintList(null);

        fragmentManager = getSupportFragmentManager();
        Intent intent = getIntent();

        btnNhanvien.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(TrangChu.this, NhanVien.class);
                startActivity(intent1);
            }
        });

        btnSanPham.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(TrangChu.this, SanPham.class);
                startActivity(intent1);
            }
        });

        btnkhachhang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(TrangChu.this, qlkh.class);
                startActivity(intent1);
            }
        });

        btnhoadon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(TrangChu.this, QLHD.class);
                startActivity(intent1);
            }
        });

        btndonhang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(TrangChu.this, qldh.class);
                startActivity(intent1);
            }
        });


    }

    private void AnhXa(){
        drawerLayout = findViewById(R.id.drawerlayout);
        navigationView = findViewById(R.id.ngvTrangchu);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        btnNhanvien = findViewById(R.id.btnNhanvien);
        btnSanPham = findViewById(R.id.btnSanPham);
        btnkhachhang = findViewById(R.id.btnkhachhang);
        btnhoadon = findViewById(R.id.btnhoadon);
        btndonhang = findViewById(R.id.btndonhang);
    }

    private void actionBar(){
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationIcon(R.mipmap.toolbar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.openDrawer(GravityCompat.START);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_trangchu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId()==R.id.trangchu){

            Intent intent = new Intent(this, TrangChu.class);
            startActivity(intent);
        } else if (item.getItemId()==R.id.khachhang) {
            Intent intent = new Intent(TrangChu.this, qlkh.class);
            startActivity(intent);
        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return super.onOptionsItemSelected(item);
    }

}
