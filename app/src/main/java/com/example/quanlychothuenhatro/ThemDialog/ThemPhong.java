package com.example.quanlychothuenhatro.ThemDialog;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.quanlychothuenhatro.Adapter.CaiDatGia.Gia;
import com.example.quanlychothuenhatro.Adapter.DBHelper;
import com.example.quanlychothuenhatro.R;
import com.example.quanlychothuenhatro.TrangChu.PhongTroActivity;

public class ThemPhong extends AppCompatActivity {
    private Button btnThem, btnHuy;
    EditText edtsophong, edtGiaphong, edtDientich;
    TextView  gianuoc, giadien, giawifi;
    int sophong, Dientich;
    float GiaWifi, Giaphong, GiaDien, GiaNuoc;

    DBHelper DB;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_themphong);
        DB = new DBHelper(this);
        Intent intent1 = getIntent();
        Gia gia;
        gia=DB.getdsGia();
        giadien = findViewById(R.id.giadientp);
        GiaDien=gia.getGiadien();
        giadien.setText("Giá Điện: "+GiaDien);
        GiaNuoc=gia.getGianuoc();
        gianuoc = findViewById(R.id.gianuoctp);
        gianuoc.setText("Giá Nước: "+GiaNuoc);
        edtsophong = findViewById(R.id.sophong);
        edtGiaphong = findViewById(R.id.giaphong);
        edtDientich = findViewById(R.id.dientich);
        giawifi = findViewById(R.id.tvgiawiftp);
        GiaWifi = gia.getGiawifi();
        giawifi.setText("Giá Wifi: "+GiaWifi);
        btnHuy = findViewById(R.id.btnhuy);

        btnHuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ThemPhong.this, PhongTroActivity.class);
                intent.putExtra("tendangnhap", intent1.getStringExtra("tendangnhap"));
                startActivity(intent);
            }
        });

        btnThem= findViewById(R.id.btnthem);
        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(edtsophong.getText().toString().isEmpty()|| edtDientich.getText().toString().isEmpty()|| edtGiaphong.getText().toString().isEmpty() ){
                    Toast.makeText(ThemPhong.this,"Không Được Để Trống",Toast.LENGTH_LONG).show();
                    return;
                }
                sophong=Integer.parseInt(edtsophong.getText().toString());
                Dientich=Integer.parseInt(edtDientich.getText().toString());
                Giaphong=Float.parseFloat(edtGiaphong.getText().toString());

                Boolean insert= DB.insertData_PhongTro(sophong,Giaphong,Dientich,GiaDien,GiaNuoc,GiaWifi);
                if(insert==true)
                {
                    Toast.makeText(ThemPhong.this,"Thêm Thành Công",Toast.LENGTH_LONG).show();
                }
                else {

                    Toast.makeText(ThemPhong.this,"Thêm Thất Bại",Toast.LENGTH_LONG).show();
                }

                Intent intent = new Intent(ThemPhong.this, PhongTroActivity.class);
                intent.putExtra("tendangnhap", intent1.getStringExtra("tendangnhap"));
                intent.putExtra("sophong", edtsophong.getText().toString());
                intent.putExtra("giaphong", edtGiaphong.getText().toString());
                startActivity(intent);
            }
        });
    }
}