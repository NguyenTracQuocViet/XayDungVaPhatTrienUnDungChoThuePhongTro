package com.example.quanlychothuenhatro.QuanLyTaiKhoan;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.quanlychothuenhatro.Adapter.DBHelper;
import com.example.quanlychothuenhatro.R;

import java.util.ArrayList;

public class DoiMatKhau extends AppCompatActivity {

    TextView taikhoan;
    EditText nlmatkhau, matkhaumoi;
    Button Doimk;
    ImageButton quaylai;
    DBHelper DB;
    String User;
    String MKmoi;
    String NhaplaiMk;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doimatkhau);
        DB = new DBHelper(this);
        Intent intent = getIntent();
        taikhoan = findViewById(R.id.taikhoan);
        taikhoan.setText(intent.getStringExtra("tendangnhap"));
        nlmatkhau = findViewById(R.id.remkmoi);
        matkhaumoi = findViewById(R.id.mkmoi);
        quaylai = findViewById(R.id.btnquaylaidmk);
        quaylai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent4 = new Intent(DoiMatKhau.this, HomeActivity.class);
                intent4.putExtra("tendangnhap", intent.getStringExtra("tendangnhap"));
                startActivity(intent4);
            }
        });
        Doimk = findViewById(R.id.btnDoimkmk);
        Doimk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if( matkhaumoi.getText().toString().isEmpty()|| nlmatkhau.getText().toString().isEmpty()){
                    Toast.makeText(DoiMatKhau.this,"Không Được Để Trống",Toast.LENGTH_LONG).show();
                    return;
                }
                MKmoi = matkhaumoi.getText().toString();
                NhaplaiMk = nlmatkhau.getText().toString();
                User = String.valueOf(taikhoan.getText().toString());

                if(MKmoi.equals(NhaplaiMk)){
                    int DoiMK= DB.updateTaiKhoan(User,MKmoi);
                    if(DoiMK !=0 ){
                        Toast.makeText(DoiMatKhau.this,"Đổi Mật Khẩu Thành Công",Toast.LENGTH_LONG).show();
                        Intent intent2 = new Intent(DoiMatKhau.this, HomeActivity.class);
                        intent2.putExtra("tendangnhap", intent.getStringExtra("tendangnhap"));
                        startActivity(intent2);
                    }else {
                        Toast.makeText(DoiMatKhau.this,"Đổi Mật Khẩu Thất Bại",Toast.LENGTH_LONG).show();
                    }
                }else {
                    Toast.makeText(DoiMatKhau.this, "Mật Khẩu Không Khớp", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }


}