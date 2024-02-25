package com.example.quanlychothuenhatro.TrangChu.DoanhThu;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageButton;

import com.example.quanlychothuenhatro.QuanLyTaiKhoan.HomeActivity;
import com.example.quanlychothuenhatro.R;

public class DoanhThuActivity extends AppCompatActivity {
    private ImageButton btnHome;
    CardView btntheoquy, btntheonam, btntheothang;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doanh_thu);
        Intent intent5 = getIntent();
        btnHome = findViewById(R.id.btnHome);
        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(DoanhThuActivity.this, HomeActivity.class);
                intent2.putExtra("tendangnhap", intent5.getStringExtra("tendangnhap"));
                startActivity(intent2);;
            }
        });

        btntheothang = findViewById(R.id.doanhthuthangdt);
        btntheothang.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                Intent intent1 = new Intent(DoanhThuActivity.this, DoanhThuTheoThang.class);
                intent1.putExtra("tendangnhap", intent5.getStringExtra("tendangnhap"));
                startActivity(intent1);
                return true;
            }
        });

        btntheoquy = findViewById(R.id.doanhthuquydt);
       btntheoquy.setOnTouchListener(new View.OnTouchListener() {
           @Override
           public boolean onTouch(View v, MotionEvent event) {
               Intent intent1 = new Intent(DoanhThuActivity.this, DoanhThuTheoQuy.class);
               intent1.putExtra("tendangnhap", intent5.getStringExtra("tendangnhap"));
               startActivity(intent1);
               return true;
           }
       });
        btntheonam = findViewById(R.id.doanhthunam);
        btntheonam.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                Intent intent4 = new Intent(DoanhThuActivity.this, DoanhThuTheoNam.class);
                intent4.putExtra("tendangnhap", intent5.getStringExtra("tendangnhap"));
                startActivity(intent4);
                return true;
            }
        });
    }
}