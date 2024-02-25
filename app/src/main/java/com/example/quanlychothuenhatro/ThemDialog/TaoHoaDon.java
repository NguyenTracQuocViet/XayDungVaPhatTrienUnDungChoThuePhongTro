package com.example.quanlychothuenhatro.ThemDialog;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.quanlychothuenhatro.Adapter.CaiDatGia.Gia;
import com.example.quanlychothuenhatro.Adapter.DBHelper;
import com.example.quanlychothuenhatro.CaiDatActivity.CaiDatPhongActivity;
import com.example.quanlychothuenhatro.R;

import java.util.ArrayList;

public class TaoHoaDon extends AppCompatActivity {
    Button btnThem, btnHuy,btnTongTien;
    ImageButton btnLichhd;
    TextView ngaytaohd, sophong, tongtien, tenkhach, tienwifi, tienphong;
    EditText sodien, sonuoc, chiphikhac;
    DBHelper DB;
    int Sophong, Sodien, Sonuoc ;
    String Ngaytaohoadon;
    String Tenkhach;
    float ChiPhiKhac, Tongtien,GiaDien,GiaNuoc,TienWifi, TienPhong;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_taohoadon);
        ngaytaohd = findViewById(R.id.ngaytaohoadon);
        sodien = findViewById(R.id.Nhapsodienhoadon);
        sonuoc = findViewById(R.id.Nhapsonuochoadon);
        btnTongTien=findViewById(R.id.btnTongtien);
        chiphikhac = findViewById(R.id.Chiphikhachoadon);
        tongtien = findViewById(R.id.Tongtienhoadon);
        DB = new DBHelper(this);
        Intent intent1 = getIntent();
        Sophong= intent1.getIntExtra("sophong", 0);
        sophong = findViewById(R.id.sophonghoadon);
        sophong.setText("Phòng: "+ intent1.getIntExtra("sophong", 0));
        tenkhach =  findViewById(R.id.Tenkhachhoadon);
        Tenkhach=DB.getKhachThue(Sophong);
        tenkhach.setText(String.valueOf(Tenkhach));

        Gia gia;
        gia=DB.getdsGia();
        tienwifi = findViewById(R.id.tienwifihoadon);
        TienWifi = gia.getGiawifi();
        tienwifi.setText("Tiền Wifi: "+TienWifi);

        tienphong = findViewById(R.id.tienphonghoadon);
        TienPhong= DB.getGiaThue(Sophong);
        tienphong.setText("Tiền Phòng:" +TienPhong);

        btnHuy = findViewById(R.id.btnhuyhoadon);
        btnHuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TaoHoaDon.this, CaiDatPhongActivity.class);
                intent.putExtra("sophong", intent1.getIntExtra("sophong", 0));
                intent.putExtra("tendangnhap", intent1.getStringExtra("tendangnhap"));
                startActivity(intent);
            }
        });
        btnTongTien.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TongTien();
            }
        });
       btnLichhd = findViewById(R.id.btnLich);
       btnLichhd.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               opendialoghd();
           }
       });

       btnThem = findViewById(R.id.btnthemhoadon);
       btnThem.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               if(ngaytaohd.getText().toString().isEmpty()|| sodien.getText().toString().isEmpty()|| sonuoc.getText().toString().isEmpty() || tongtien.getText().toString().isEmpty()){
                   Toast.makeText(TaoHoaDon.this,"Không Được Để Trống",Toast.LENGTH_LONG).show();
                   return;
               }
               Tenkhach =tenkhach.getText().toString();
               Ngaytaohoadon = ngaytaohd.getText().toString();
               Sodien= Integer.parseInt(sodien.getText().toString());
               Sonuoc= Integer.parseInt(sonuoc.getText().toString());
               ChiPhiKhac = Float.parseFloat(chiphikhac.getText().toString());
               Tongtien = Float.parseFloat(tongtien.getText().toString());
               Boolean insert= DB.insertData_HoaDon(Sophong,  Tenkhach, Ngaytaohoadon, Sodien, Sonuoc,TienWifi, TienPhong ,ChiPhiKhac,Tongtien );

               if(insert==true)
               {
                   Toast.makeText(TaoHoaDon.this,"Thêm Thành Công",Toast.LENGTH_LONG).show();
               }
               else {

                   Toast.makeText(TaoHoaDon.this,"Thêm Thất Bại",Toast.LENGTH_LONG).show();
               }

               Intent intent4 = new Intent(TaoHoaDon.this, CaiDatPhongActivity.class);
               intent4.putExtra("tendangnhap", intent1.getStringExtra("tendangnhap"));
               intent4.putExtra("sophong",intent1.getIntExtra("sophong", 0));
               intent4.putExtra("tenkhachthue", intent1.getStringExtra("tenkhachthue"));
               intent4.putExtra("ngaytaohoadon", ngaytaohd.getText().toString());
               intent4.putExtra("sodien", sodien.getText().toString());
               intent4.putExtra("sonuoc", sonuoc.getText().toString());
               intent4.putExtra("chiphikhac", chiphikhac.getText().toString());
               intent4.putExtra("tongtien", tongtien.getText().toString());
               startActivity(intent4);
           }
       });

    }
   private void opendialoghd(){
       DatePickerDialog dialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
           @Override
           public void onDateSet(DatePicker view, int year, int month, int day) {
               ngaytaohd.setText(String.valueOf(day)+"/"+ String.valueOf(month+1)+"/"+String.valueOf(year));
           }
       },2023, 12,7);
       dialog.show();
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

}