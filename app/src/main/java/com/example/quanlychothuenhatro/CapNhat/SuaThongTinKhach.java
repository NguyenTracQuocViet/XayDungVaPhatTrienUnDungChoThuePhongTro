package com.example.quanlychothuenhatro.CapNhat;

import androidx.appcompat.app.AppCompatActivity;

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
import com.example.quanlychothuenhatro.TrangChu.KhachThueActivity;

public class SuaThongTinKhach extends AppCompatActivity {
    TextView Khach, sophong;
    EditText Sdt, soCccd;
    ImageButton quaylai;
    Button capnhat;
    DBHelper DB;

    int Sophong;
    String tenkhach, Sodt, Socccd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_suathongtinkhach);
        Intent intent1 = getIntent();
        DB = new DBHelper(this);

        sophong = findViewById(R.id.phongttsua);
        Sophong = intent1.getIntExtra("sophong", 0);
        sophong.setText("Phòng: "+String.valueOf(Sophong));

        Khach = findViewById(R.id.khachttsua);
        tenkhach = DB.getKhachThue(Sophong);
        Khach.setText("Tên Khách: "+tenkhach);

        Sdt = findViewById(R.id.sdtttkhach);
        Sodt = intent1.getStringExtra("sdt");
        Sdt.setText(Sodt);

        soCccd = findViewById(R.id.cccdttkhach);
        Socccd = intent1.getStringExtra("cccd");
        soCccd.setText(Socccd);

        quaylai = findViewById(R.id.btnquaylaittkhach);
        quaylai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SuaThongTinKhach.this, KhachThueActivity.class);
                intent.putExtra("tendangnhap", intent1.getStringExtra("tendangnhap"));
                intent.putExtra("sophong", intent1.getIntExtra("sophong", 0));
                intent.putExtra("tenkhachthue", intent1.getStringExtra("tenkhachthue"));
                startActivity(intent);
            }
        });
        capnhat =findViewById(R.id.btnCapnhatttkhach);
        capnhat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Sdt.getText().toString().isEmpty() || soCccd.getText().toString().isEmpty()){
                    Toast.makeText(SuaThongTinKhach.this,"Không Được Để Trống",Toast.LENGTH_LONG).show();
                    return;
                }
                Sodt = String.valueOf(Sdt.getText().toString());
                Socccd = String.valueOf(soCccd.getText().toString());
                if(Sdt.getText().length()!=10)
                {
                    Toast.makeText(SuaThongTinKhach.this,"Số Điện Thoại Đủ 10 ký tự",Toast.LENGTH_LONG).show();
                    return ;
                }
                if(soCccd.getText().length()!=12)
                {
                    Toast.makeText(SuaThongTinKhach.this,"Số CCCD Đủ 12 ký tự",Toast.LENGTH_LONG).show();
                    return ;
                }
                int TTkhach= DB.updateTTkhach(Sophong, Sodt,  Socccd);
                if(TTkhach != 0){
                    Toast.makeText(SuaThongTinKhach.this,"Cập Nhật Thông Tin Khách Thành Công",Toast.LENGTH_LONG).show();
                }else {
                    Toast.makeText(SuaThongTinKhach.this,"Cập Nhật Thông Tin Khách Thất Bại",Toast.LENGTH_LONG).show();
                }
                Intent intent = new Intent(SuaThongTinKhach.this, KhachThueActivity.class);
                intent.putExtra("tendangnhap", intent1.getStringExtra("tendangnhap"));
                intent.putExtra("sdt", intent1.getStringExtra("sdt"));
                intent.putExtra("cccd", intent1.getStringExtra("cccd"));
                intent.putExtra("sophong", intent1.getIntExtra("sophong", 0));
                intent.putExtra("tenkhachthue", intent1.getStringExtra("tenkhachthue"));
                startActivity(intent);
            }

        });
    }
}