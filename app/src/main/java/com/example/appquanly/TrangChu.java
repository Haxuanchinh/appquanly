package com.example.appquanly;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.example.appquanly.database.Databse_QuanLy;
import com.google.android.material.navigation.NavigationView;

public class TrangChu extends AppCompatActivity {

    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;
    TextView tenCH, bestseller;
    private Databse_QuanLy Database_QuanLy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.trangchu);
        Database_QuanLy = new Databse_QuanLy(this);
        AnhXa();
        actionBar();
        Intent intent = getIntent();

    }

    private void AnhXa(){
        drawerLayout = findViewById(R.id.drawerlayout);
        navigationView = findViewById(R.id.ngvTrangchu);
        toolbar = findViewById(R.id.toolbar);
        tenCH = findViewById(R.id.tenCH);
        bestseller = findViewById(R.id.bestseller);
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

}
