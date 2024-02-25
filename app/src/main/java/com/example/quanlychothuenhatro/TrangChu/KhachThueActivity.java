package com.example.quanlychothuenhatro.TrangChu;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

import com.example.quanlychothuenhatro.Adapter.DBHelper;
import com.example.quanlychothuenhatro.Adapter.KhachThue.KhachThue;
import com.example.quanlychothuenhatro.Adapter.KhachThue.ListViewKhachThueadapter;
import com.example.quanlychothuenhatro.QuanLyTaiKhoan.HomeActivity;
import com.example.quanlychothuenhatro.R;
import com.example.quanlychothuenhatro.CapNhat.SuaThongTinKhach;

import java.util.ArrayList;

public class KhachThueActivity extends AppCompatActivity {
    private ImageButton btnHome;
    ListView lvKhachThue;
    DBHelper DB;
    ArrayList<KhachThue> dsKhachThue;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_khachthue);
        Intent intent1 = getIntent();
        DB=new DBHelper(this);
        lvKhachThue=findViewById(R.id.lst_khachthue);
        dsKhachThue=DB.getdskhachthue();
        ListViewKhachThueadapter viewadapter=new ListViewKhachThueadapter(KhachThueActivity.this,dsKhachThue,R.layout.list_quanlykhachthue);
        lvKhachThue.setAdapter(viewadapter);
        lvKhachThue.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                int sophong = dsKhachThue.get(position).getSophong();
                String tenkhach = dsKhachThue.get(position).getTenkhachthue();
                String sdt = dsKhachThue.get(position).getSoDT();
                String cccd = dsKhachThue.get(position).getSoCCCD();
                AlertDialog.Builder builder = new AlertDialog.Builder(KhachThueActivity.this);
                builder.setTitle("Cập Nhật Thông Tin Khách Thuê")
                        .setMessage("Mời Bạn Chọn Chức Năng")
                        .setPositiveButton("Sửa Thông Tin Khách", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Intent intent = new Intent(KhachThueActivity.this, SuaThongTinKhach.class);
                                intent.putExtra("sophong", sophong);
                                intent.putExtra("tenkhach",tenkhach);
                                intent.putExtra("sdt", sdt);
                                intent.putExtra("cccd", cccd);
                                intent.putExtra("tendangnhap", intent1.getStringExtra("tendangnhap"));
                                startActivity(intent);
                            }
                        })
                        .setNegativeButton("Xóa Khách", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                builder.setTitle("Xóa Khách")
                                        .setMessage("Bạn Có Muốn Khách Thuê Không?")
                                        .setPositiveButton("Có", new DialogInterface.OnClickListener() {
                                            @Override
                                            public void onClick(DialogInterface dialog, int which) {
                                                int Sophong = dsKhachThue.get(position).getSophong();
                                                int i=DB.delete_KhachThue(Sophong);
                                                if(i!=0) {

                                                    dsKhachThue.remove(position);
                                                    viewadapter.notifyDataSetChanged();
                                                    lvKhachThue.setAdapter(viewadapter);
                                                    Toast.makeText(KhachThueActivity.this, "Xóa Khách Thuê Thành Công!", Toast.LENGTH_LONG).show();
                                                }
                                                else {
                                                    Toast.makeText(KhachThueActivity.this, "Xóa Khách Thuê Thất Bại!", Toast.LENGTH_LONG).show();

                                                }
                                            }
                                        })
                                        .setNegativeButton("Không", new DialogInterface.OnClickListener() {
                                            @Override
                                            public void onClick(DialogInterface dialog, int which) {
                                                Toast.makeText(KhachThueActivity.this, "Bạn Chọn Không! ", Toast.LENGTH_SHORT).show();
                                                dialog.cancel();
                                            }
                                        }).show();
                            }
                        }).show();
            }
        });


        btnHome = findViewById(R.id.btnhome);
        btnHome.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View v) {
                  Intent intent = new Intent(KhachThueActivity.this, HomeActivity.class);
                  intent.putExtra("tendangnhap", intent1.getStringExtra("tendangnhap"));
                  startActivity(intent);
              }
          });
    }
}