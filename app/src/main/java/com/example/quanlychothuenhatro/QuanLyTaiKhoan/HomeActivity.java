package com.example.quanlychothuenhatro.QuanLyTaiKhoan;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewFlipper;

import com.example.quanlychothuenhatro.CaiDatActivity.CaiDatGiaActivity;
import com.example.quanlychothuenhatro.R;
import com.example.quanlychothuenhatro.TrangChu.DoanhThu.DoanhThuActivity;
import com.example.quanlychothuenhatro.TrangChu.HoaDonActivity;
import com.example.quanlychothuenhatro.TrangChu.HopDongActivity;
import com.example.quanlychothuenhatro.TrangChu.KhachThueActivity;
import com.example.quanlychothuenhatro.TrangChu.PhongTroActivity;

public class HomeActivity extends AppCompatActivity {
    CardView btnPhongTro, btnKhachThue, btnHopDong,btnHoaDon, btnDoanhThu, btnThoat, btnCaidatgia, btnDoimk;
    private TextView tvXinchao;

    ViewFlipper viewFlipper;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        //chay animation
        viewFlipper = findViewById(R.id.viewflipper);
        int images[] = {R.drawable.tro1, R.drawable.tro2,  R.drawable.tro3, R.drawable.tro4, R.drawable.tro5, R.drawable.tro6, R.drawable.tro7, R.drawable.tro8, R.drawable.tro9, R.drawable.tro10 };
        for(int i = 0; i<images.length; i++){
            ActionViewFlipper(images[i]);
        }

        Intent intent = getIntent();
        tvXinchao = findViewById(R.id.tvxinchao);
        tvXinchao.setText("Xin Chào: "+intent.getStringExtra("tendangnhap"));
        btnCaidatgia = findViewById(R.id.btnCaidatgia);
        btnCaidatgia.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                Intent intent6 = new Intent(HomeActivity.this, CaiDatGiaActivity.class);
                intent6.putExtra("tendangnhap", intent.getStringExtra("tendangnhap"));
                startActivity(intent6);
                return true;
            }
        });

        btnPhongTro = findViewById(R.id.btnPhongTro);
        btnPhongTro.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                Intent intent1 = new Intent(HomeActivity.this, PhongTroActivity.class);
                intent1.putExtra("tendangnhap", intent.getStringExtra("tendangnhap"));
                startActivity(intent1);
                return true;
            }
        });

        btnKhachThue = findViewById(R.id.btnKhachthue);
        btnKhachThue.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                Intent intent2 = new Intent(HomeActivity.this, KhachThueActivity.class);
                intent2.putExtra("tendangnhap", intent.getStringExtra("tendangnhap"));
                startActivity(intent2);
                return true;
            }
        });

        btnHopDong = findViewById(R.id.btnHopDong);
        btnHopDong.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                Intent intent3 = new Intent(HomeActivity.this, HopDongActivity.class);
                intent3.putExtra("tendangnhap", intent.getStringExtra("tendangnhap"));
                startActivity(intent3);
                return true;
            }
        });

        btnHoaDon =findViewById(R.id.btnHoaDon);
        btnHoaDon.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                Intent intent4 = new Intent(HomeActivity.this, HoaDonActivity.class);
                intent4.putExtra("tendangnhap", intent.getStringExtra("tendangnhap"));
                startActivity(intent4);
                return true;
            }
        });

        btnDoanhThu = findViewById(R.id.btnDoanhThu);
        btnDoanhThu.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                Intent intent5 = new Intent(HomeActivity.this, DoanhThuActivity.class);
                intent5.putExtra("tendangnhap", intent.getStringExtra("tendangnhap"));
                startActivity(intent5);
                return true;
            }
        });

        btnDoimk = findViewById(R.id.btndoimkhome);
        btnDoimk.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
             Intent intent1= new Intent(HomeActivity.this, DoiMatKhau.class);
                intent1.putExtra("tendangnhap", intent.getStringExtra("tendangnhap"));
                startActivity(intent1);
                return true;
            }
        });

        AlertDialog.Builder builder = new AlertDialog.Builder(HomeActivity.this);
        btnThoat = findViewById(R.id.btnLogout);
        btnThoat.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                builder.setTitle("Đăng Xuất")
                        .setMessage("Bạn muốn đóng ứng dụng?")
                        .setCancelable(true)
                        .setPositiveButton("Vâng", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                startActivity(new Intent(HomeActivity.this, LoginActivity.class));
                                Toast.makeText(HomeActivity.this, "Đăng xuất thành công ", Toast.LENGTH_SHORT).show();
                            }
                        })
                        .setNegativeButton("Không", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(HomeActivity.this, "Bạn chọn Không! ", Toast.LENGTH_SHORT).show();
                                dialog.cancel();
                            }
                        });
                builder.show();
                return false;
            }
        });
    }

    public void ActionViewFlipper(int image){
        ImageView imgView = new ImageView(this);
        imgView.setBackgroundResource(image);
        viewFlipper.addView(imgView);
        viewFlipper.setFlipInterval(3000); //thoi gian 3 giay
        viewFlipper.setAutoStart(true);
        //animation
        viewFlipper.setInAnimation(this, android.R.anim.slide_in_left);
        viewFlipper.setOutAnimation(this, android.R.anim.slide_out_right);
    }
}