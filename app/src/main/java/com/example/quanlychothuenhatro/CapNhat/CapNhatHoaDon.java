package com.example.quanlychothuenhatro.CapNhat;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.quanlychothuenhatro.Adapter.CaiDatGia.Gia;
import com.example.quanlychothuenhatro.Adapter.DBHelper;
import com.example.quanlychothuenhatro.Adapter.HoaDon.HoaDon;
import com.example.quanlychothuenhatro.QuanLyTaiKhoan.HomeActivity;
import com.example.quanlychothuenhatro.R;
import com.example.quanlychothuenhatro.TrangChu.HoaDonActivity;
import com.example.quanlychothuenhatro.TrangChu.HopDongActivity;

public class CapNhatHoaDon extends AppCompatActivity {
    TextView sophong, tenkhach, ngaytaohd, tienwifi, tienphong, tongtien;
    EditText sodien, sonuoc, chiphikhac;
    Button Tongtien, Capnhat, Huy;
    ImageButton Lich;
    DBHelper DB;

    int Sophong, Sodien, Sonuoc;
    String Tenkhach, NgaytaoHd;
    Float TienWifi, TienPhong, ChiPhiKhac, TongTien, GiaNuoc, GiaDien;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_capnhathoadon);
        DB = new DBHelper(this);
        Intent intent1 = getIntent();

        sophong = findViewById(R.id.cnsophonghoadon);
        Sophong= intent1.getIntExtra("sophong", 0);
        sophong.setText("Phòng: "+ intent1.getIntExtra("sophong", 0));

        tenkhach =findViewById(R.id.cnTenkhachhoadon);
        Tenkhach=DB.getKhachThue(Sophong);
        tenkhach.setText(String.valueOf(Tenkhach));

        ngaytaohd = findViewById(R.id.cnngaytaohoadon);
        NgaytaoHd = intent1.getStringExtra("ngaytaohd");
        ngaytaohd.setText("Ngày Tạo: "+NgaytaoHd);

        Gia gia;
        gia=DB.getdsGia();
        tienwifi = findViewById(R.id.cntienwifihoadon);
        TienWifi = gia.getGiawifi();
        tienwifi.setText("Tiền Wifi: "+TienWifi);

        tienphong = findViewById(R.id.cntienphonghoadon);
        TienPhong= DB.getGiaThue(Sophong);
        tienphong.setText("Tiền Phòng:" +TienPhong);

        tongtien = findViewById(R.id.cnTongtienhoadon);
        TongTien = intent1.getFloatExtra("tongtien", 0);
        tongtien.setText(String.valueOf(TongTien));
        sodien = findViewById(R.id.cnNhapsodienhoadon);
        sonuoc = findViewById(R.id.cnNhapsonuochoadon);
        chiphikhac = findViewById(R.id.cnChiphikhachoadon);

        Tongtien = findViewById(R.id.cnbtnTongtien);
        Tongtien.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TongTien();
            }
        });
        Capnhat = findViewById(R.id.cnbtncapnhathoadon);
        Capnhat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ngaytaohd.getText().toString().isEmpty() ||sodien.getText().toString().isEmpty()||sonuoc.getText().toString().isEmpty()||chiphikhac.getText().toString().isEmpty()||tongtien.getText().toString().isEmpty()){
                    Toast.makeText(CapNhatHoaDon.this,"Không Được Để Trống",Toast.LENGTH_LONG).show();
                    return;
                }
                NgaytaoHd = String.valueOf(ngaytaohd.getText().toString());
                Sodien = Integer.parseInt(sodien.getText().toString());
                Sonuoc = Integer.parseInt(sonuoc.getText().toString());
                ChiPhiKhac = Float.parseFloat(chiphikhac.getText().toString());
                TongTien = Float.parseFloat(tongtien.getText().toString());

                int Capnhathd= DB.updateHoaDon(Sophong, NgaytaoHd,Sodien,Sonuoc ,ChiPhiKhac, TongTien);
                if(Capnhathd != 0){
                    Toast.makeText(CapNhatHoaDon.this,"Gia Hạn Hợp Đồng Thành Công",Toast.LENGTH_LONG).show();
                }else {
                    Toast.makeText(CapNhatHoaDon.this,"Gia Hạn Hợp Đồng Thất Bại",Toast.LENGTH_LONG).show();
                }
                Intent intent = new Intent(CapNhatHoaDon.this, HoaDonActivity.class);
                intent.putExtra("tendangnhap", intent1.getStringExtra("tendangnhap"));
                intent.putExtra("sophong", intent1.getIntExtra("sophong", 0));
                intent.putExtra("tenkhachthue", intent1.getStringExtra("tenkhachthue"));
                startActivity(intent);
            }
        });
        Huy = findViewById(R.id.cnbtnhuyhoadon);
        Huy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Intent intent2 = new Intent(CapNhatHoaDon.this, HoaDonActivity.class);
                intent2.putExtra("tendangnhap", intent1.getStringExtra("tendangnhap"));
                startActivity(intent2);
            }
        });
        Lich = findViewById(R.id.cnbtnLichhoadon);
        Lich.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openLich();
            }
        });

    }

    private void TongTien(){
        Gia gia;
        gia=DB.getdsGia();
        GiaNuoc = gia.getGianuoc();
        GiaDien= gia.getGiadien();
        TienWifi= gia.getGiawifi();
        TienPhong= DB.getGiaThue(Sophong);
        Sodien = Integer.parseInt(sodien.getText().toString());
        Sonuoc = Integer.parseInt(sonuoc.getText().toString());
        ChiPhiKhac = Float.parseFloat(chiphikhac.getText().toString());
        float Tong = TienPhong+(Sodien*GiaDien)+(Sonuoc*GiaNuoc)+TienWifi+ChiPhiKhac;
        tongtien.setText(String.valueOf(Tong));
    }

    private  void openLich(){
        DatePickerDialog dialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int day) {
                ngaytaohd.setText(String.valueOf(day)+"/"+ String.valueOf(month+1)+"/"+String.valueOf(year));
            }
        },2023, 12,7);
        dialog.show();
    }
}