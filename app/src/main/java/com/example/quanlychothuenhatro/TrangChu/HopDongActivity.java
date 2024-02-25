package com.example.quanlychothuenhatro.TrangChu;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

import com.example.quanlychothuenhatro.Adapter.DBHelper;
import com.example.quanlychothuenhatro.Adapter.HopDong.HopDong;
import com.example.quanlychothuenhatro.Adapter.HopDong.ListViewHopDongadapter;
import com.example.quanlychothuenhatro.QuanLyTaiKhoan.HomeActivity;
import com.example.quanlychothuenhatro.R;
import com.example.quanlychothuenhatro.CapNhat.GiaHanHopDong;

import java.util.ArrayList;

public class HopDongActivity extends AppCompatActivity {
    private ImageButton btnHome;
    DBHelper DB;
    ListView lvHopDong;
    ArrayList<HopDong> dsHopDong;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hopdong);
        DB=new DBHelper(this);
        Intent intent3 = getIntent();
        lvHopDong = findViewById(R.id.listHopDong);
        dsHopDong = DB.getdshopdong();
        ListViewHopDongadapter viewadapter=new ListViewHopDongadapter(HopDongActivity.this,dsHopDong,R.layout.list_quanlyhopdong);
        lvHopDong.setAdapter(viewadapter);
        lvHopDong.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                int sophong= dsHopDong.get(position).getSophong();
                AlertDialog.Builder builder = new AlertDialog.Builder(HopDongActivity.this);
                builder.setTitle("Cập Nhật Hợp Đồng")
                        .setMessage("Mời Bạn Chọn Chức Năng")
                        .setPositiveButton("Cập Nhật Hợp Đồng", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                builder.setPositiveButton("Gia Hạn Hợp Đồng", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        Intent intent = new Intent(HopDongActivity.this, GiaHanHopDong.class);
                                        intent.putExtra("sophong", sophong);
                                        intent.putExtra("tendangnhap", intent3.getStringExtra("tendangnhap"));
                                        startActivity(intent);
                                    }
                                })
                                        .setNegativeButton("Chấm Dứt Hợp Đồng", new DialogInterface.OnClickListener() {
                                            @Override
                                            public void onClick(DialogInterface dialog, int which) {
                                                int sophong = dsHopDong.get(position).getSophong();
                                                int i = DB.delete_KhachThue(sophong);

                                                if(i!=0) {
//                                                    dsHopDong.remove(position);
                                                    viewadapter.notifyDataSetChanged();
                                                    lvHopDong.setAdapter(viewadapter);
                                                    Toast.makeText(HopDongActivity.this, "Đã Kết Thúc Hợp Đồng!", Toast.LENGTH_LONG).show();
                                                }
                                                else {
                                                    Toast.makeText(HopDongActivity.this, "Chưa Kết Thúc Hợp Đồng!", Toast.LENGTH_LONG).show();
                                                }

                                            }
                                        }).show();
                            }
                        })
                        .setNegativeButton("Xóa Hợp Đồng", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                builder.setTitle("Xóa Hợp Đồng")
                                        .setMessage("Bạn Có Muốn Xóa Hợp Đồng Không? ")
                                        .setPositiveButton("Có", new DialogInterface.OnClickListener() {
                                            @Override
                                            public void onClick(DialogInterface dialog, int which) {
                                                int sophong = dsHopDong.get(position).getSophong();
                                                int i = DB.delete_HopDong(sophong);
                                                if(i!=0) {
                                                    dsHopDong.remove(position);
                                                    viewadapter.notifyDataSetChanged();
                                                    lvHopDong.setAdapter(viewadapter);
                                                    Toast.makeText(HopDongActivity.this, "Xóa Hợp Đồng Thành Công!", Toast.LENGTH_LONG).show();
                                                }
                                                else {
                                                    Toast.makeText(HopDongActivity.this, "Xóa Hợp Đồng Thất Bại!", Toast.LENGTH_LONG).show();
                                                }
                                            }
                                        })
                                        .setNegativeButton("Không", new DialogInterface.OnClickListener() {
                                            @Override
                                            public void onClick(DialogInterface dialog, int which) {
                                                Toast.makeText(HopDongActivity.this, "Bạn Chọn Không! ", Toast.LENGTH_SHORT).show();
                                                dialog.cancel();
                                            }
                                        }).show();
                            }
                        }).show();
            }
        });

        btnHome = findViewById(R.id.btnHome);
        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HopDongActivity.this, HomeActivity.class);
                intent.putExtra("tendangnhap", intent3.getStringExtra("tendangnhap"));
                startActivity(intent);
            }
        });

    }
}