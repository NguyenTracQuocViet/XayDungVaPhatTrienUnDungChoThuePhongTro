package com.example.quanlychothuenhatro.ThemDialog;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.quanlychothuenhatro.Adapter.CaiDatGia.Gia;
import com.example.quanlychothuenhatro.Adapter.DBHelper;
import com.example.quanlychothuenhatro.CaiDatActivity.CaiDatPhongActivity;
import com.example.quanlychothuenhatro.R;

public class ThongTinPhong extends AppCompatActivity {
    ImageButton btnQuayLai;
    DBHelper DB;
    float GiaWifi,  GiaDien, GiaNuoc, GiaPhong;
    int Dientich;
    TextView sophong, tenkhach, giaphong, giadien, gianuoc, giawifi, dientich;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent1 = getIntent();
        setContentView(R.layout.activity_thongtinphong);

        DB = new DBHelper(this);
        Gia gia;
        gia=DB.getdsGia();

        sophong = findViewById(R.id.sophongtt);
        int Sophong=intent1.getIntExtra("sophong", 0);
        sophong.setText("Phòng: "+String.valueOf(Sophong));

        tenkhach = findViewById(R.id.Tenkhachtt);
        String TenKhach=DB.getKhachThue(Sophong);
        tenkhach.setText("Tên Khách: "+TenKhach);

        dientich = findViewById(R.id.dientichtt);
        Dientich = DB.getDientich(Sophong);
        dientich.setText("Diện Tích: " +Dientich +"m2");

        giaphong = findViewById(R.id.giaphongtt);
        GiaPhong = DB.getGiaThue(Sophong);
        giaphong.setText("Giá Phòng: "+GiaPhong);

        giadien=findViewById(R.id.giadientt);
        GiaDien=gia.getGiadien();
        giadien.setText("Giá Điện: "+GiaDien);

        gianuoc = findViewById(R.id.gianuoctt);
        GiaNuoc = gia.getGianuoc();
        gianuoc.setText("Giá Nước: "+GiaNuoc);

        giawifi = findViewById(R.id.giawifitt);
        GiaWifi = gia.getGiawifi();
        giawifi.setText("Giá Wifi: "+GiaWifi);

        btnQuayLai = findViewById(R.id.btnquaylaitt);
        btnQuayLai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ThongTinPhong.this, CaiDatPhongActivity.class);
                intent.putExtra("tendangnhap", intent1.getStringExtra("tendangnhap"));
                intent.putExtra("sophong", intent1.getIntExtra("sophong", 0));
                intent.putExtra("tenkhachthue", intent1.getStringExtra("tenkhachthue"));
                startActivity(intent);
            }
        });
    }
}