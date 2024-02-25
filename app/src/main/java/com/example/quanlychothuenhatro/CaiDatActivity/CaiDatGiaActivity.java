package com.example.quanlychothuenhatro.CaiDatActivity;

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

import com.example.quanlychothuenhatro.Adapter.CaiDatGia.Gia;
import com.example.quanlychothuenhatro.Adapter.DBHelper;
import com.example.quanlychothuenhatro.QuanLyTaiKhoan.HomeActivity;
import com.example.quanlychothuenhatro.R;

import java.util.ArrayList;

public class CaiDatGiaActivity extends AppCompatActivity {
    Button  them, xoa, capnhat;
    ImageButton quaylai;
    EditText edtgiadien, edtgianuoc, edtgiawifi;
    float GiaDien,GiaNuoc, GiaWifi;
    TextView tvgiadiencd, tvgianuoccd, tvgiawifi;

    DBHelper DB;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cai_dat_gia);
        Intent intent2 = getIntent();
        DB = new DBHelper(this);
        edtgiadien = findViewById(R.id.giadiencd);
        edtgianuoc = findViewById(R.id.gianuoccd);
        edtgiawifi = findViewById(R.id.giawificd);

        tvgiadiencd = findViewById(R.id.tvgiadiencd);
        tvgiadiencd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edtgiadien.setText(tvgiadiencd.getText().toString());
            }
        });
        tvgianuoccd = findViewById(R.id.tvgianuoccd);
        tvgianuoccd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edtgianuoc.setText(tvgianuoccd.getText().toString());
            }
        });
        tvgiawifi = findViewById(R.id.tvgiawificd);
        tvgiawifi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edtgiawifi.setText(tvgiawifi.getText().toString());
            }
        });

        Capnhat();

        quaylai = findViewById(R.id.quaylaicd);
        quaylai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CaiDatGiaActivity.this, HomeActivity.class);
                intent.putExtra("tendangnhap", intent2.getStringExtra("tendangnhap"));
                startActivity(intent);

            }
        });

        them = findViewById(R.id.btnthemcd);
        them.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(edtgiadien.getText().toString().isEmpty()|| edtgianuoc.getText().toString().isEmpty() || edtgiawifi.getText().toString().isEmpty()){
                    Toast.makeText(CaiDatGiaActivity.this,"Không Được Để Trống",Toast.LENGTH_LONG).show();
                        return;
                }

                    GiaDien = Float.parseFloat(edtgiadien.getText().toString());
                    GiaNuoc = Float.parseFloat(edtgianuoc.getText().toString());
                    GiaWifi = Float.parseFloat(edtgiawifi.getText().toString());

                    Boolean insert= DB.Check_Gia(GiaDien,GiaNuoc, GiaWifi);
                    if(insert==true)
                    {
                        Toast.makeText(CaiDatGiaActivity.this,"Thêm Thành Công",Toast.LENGTH_LONG).show();
                    }
                    else {

                        Toast.makeText(CaiDatGiaActivity.this,"Thêm Thất Bại",Toast.LENGTH_LONG).show();
                    }
                    Intent intent3 = new Intent(CaiDatGiaActivity.this, CaiDatGiaActivity.class);
                    intent3.putExtra("tendangnhap", intent2.getStringExtra("tendangnhap"));
                    intent3.putExtra("giadien", edtgiadien.getText().toString());
                    intent3.putExtra("gianuoc", edtgianuoc.getText().toString());
                    intent3.putExtra("giawifi", edtgiawifi.getText().toString());
                    startActivity(intent3);
            }
        });

        xoa = findViewById(R.id.btnxoacd);
        xoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int Xoa=DB.delete_Gia();
                if(Xoa!=0)
                {
                    Toast.makeText(CaiDatGiaActivity.this,"Xóa Thành Công",Toast.LENGTH_LONG).show();
                    xoa();
                }
                else {
                    Toast.makeText(CaiDatGiaActivity.this,"Xóa Thất Bại",Toast.LENGTH_LONG).show();

                }
            }
        });

        capnhat = findViewById(R.id.btncapnhatcd);
        capnhat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GiaDien = Float.parseFloat(edtgiadien.getText().toString());
                GiaNuoc = Float.parseFloat(edtgianuoc.getText().toString());
                GiaWifi = Float.parseFloat(edtgiawifi.getText().toString());

                Boolean updatedCaiDatGia= DB.Check_Gia(GiaDien,GiaNuoc,GiaWifi);
                if(updatedCaiDatGia == true){
                    Toast.makeText(CaiDatGiaActivity.this,"Cập Nhật Thành Công",Toast.LENGTH_LONG).show();
                    Capnhat();
                }else {
                    Toast.makeText(CaiDatGiaActivity.this,"Cập Nhật Thất Bại",Toast.LENGTH_LONG).show();
                }


            }
        });
    }
    public void Capnhat()
    {
        GiaDien=DB.getdsGia().getGiadien();
        GiaNuoc=DB.getdsGia().getGianuoc();
        GiaWifi = DB.getdsGia().getGiawifi();
        tvgiadiencd.setText(String.valueOf(GiaDien));
        tvgianuoccd.setText(String.valueOf(GiaNuoc));
        tvgiawifi.setText(String.valueOf(GiaWifi));
    }

    public void xoa()
    {
        GiaDien=DB.getdsGia().getGiadien();
        GiaNuoc=DB.getdsGia().getGianuoc();
        GiaWifi = DB.getdsGia().getGiawifi();
        tvgiadiencd.setText(String.valueOf(GiaDien));
        tvgianuoccd.setText(String.valueOf(GiaNuoc));
        tvgiawifi.setText(String.valueOf(GiaWifi));
    }

}