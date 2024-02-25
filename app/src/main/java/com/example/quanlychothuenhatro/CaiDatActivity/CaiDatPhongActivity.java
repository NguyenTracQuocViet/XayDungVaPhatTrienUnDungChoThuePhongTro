package com.example.quanlychothuenhatro.CaiDatActivity;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.quanlychothuenhatro.Adapter.DBHelper;
import com.example.quanlychothuenhatro.R;
import com.example.quanlychothuenhatro.CapNhat.SuaPhong;
import com.example.quanlychothuenhatro.ThemDialog.TaoHoaDon;
import com.example.quanlychothuenhatro.ThemDialog.TaoHopDong;
import com.example.quanlychothuenhatro.ThemDialog.ThemKhachThue;
import com.example.quanlychothuenhatro.ThemDialog.ThongTinPhong;
import com.example.quanlychothuenhatro.TrangChu.PhongTroActivity;

import java.util.ArrayList;

public class CaiDatPhongActivity extends AppCompatActivity {
    ImageButton btnquaylai;
    private TextView tvphong, tvthemkhach, tvtaohopdong, tvthemhoadon, tvsuaphong, tvxemtt;
    DBHelper DB;

    ArrayList<Integer> dsPhong;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_caidatphong);
        tvphong=(TextView) findViewById(R.id.tvPhong);
        Intent intent1 = getIntent();
        int sophong=intent1.getIntExtra("sophong",0);
        tvphong.setText("Phòng: " +sophong);
        tvthemkhach = findViewById(R.id.tvThemkhach);
        tvthemkhach.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CaiDatPhongActivity.this, ThemKhachThue.class);
                intent.putExtra("sophong", intent1.getIntExtra("sophong", 0));
                intent.putExtra("tendangnhap", intent1.getStringExtra("tendangnhap"));
                startActivity(intent);
            }
        });

        tvtaohopdong = findViewById(R.id.tvToahopdong);
        tvtaohopdong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CaiDatPhongActivity.this, TaoHopDong.class);
                intent.putExtra("sophong", sophong);
                intent.putExtra("tendangnhap", intent1.getStringExtra("tendangnhap"));
                startActivity(intent);
            }
        });
        tvthemhoadon = findViewById(R.id.tvThemhoadon);
        tvthemhoadon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CaiDatPhongActivity.this, TaoHoaDon.class);
                intent.putExtra("tendangnhap", intent1.getStringExtra("tendangnhap"));
                intent.putExtra("sophong", sophong);
                startActivity(intent);
            }
        });
        tvsuaphong =findViewById(R.id.tvSuaphong);
        tvsuaphong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CaiDatPhongActivity.this, SuaPhong.class);
                intent.putExtra("tendangnhap", intent1.getStringExtra("tendangnhap"));
                intent.putExtra("sophong", sophong);

                startActivity(intent);
            }
        });
        tvxemtt =findViewById(R.id.tvXemtt);
        tvxemtt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CaiDatPhongActivity.this, ThongTinPhong.class);
                intent.putExtra("sophong", sophong);
                intent.putExtra("tendangnhap", intent1.getStringExtra("tendangnhap"));
                startActivity(intent);
            }
        });
        btnquaylai = findViewById(R.id.btnquaylai);
        btnquaylai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Intent intent = new Intent(CaiDatPhongActivity.this, PhongTroActivity.class);
                intent.putExtra("sophong", sophong);
                intent.putExtra("tendangnhap", intent1.getStringExtra("tendangnhap"));
                startActivity(intent);
            }
        });

    }
}