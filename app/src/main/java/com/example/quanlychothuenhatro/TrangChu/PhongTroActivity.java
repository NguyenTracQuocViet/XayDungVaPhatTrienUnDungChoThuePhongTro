package com.example.quanlychothuenhatro.TrangChu;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;

import android.annotation.SuppressLint;
import android.app.SearchManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.quanlychothuenhatro.Adapter.DBHelper;
import com.example.quanlychothuenhatro.Adapter.phongtro.ListViewPhongTroadapter;
import com.example.quanlychothuenhatro.CaiDatActivity.CaiDatPhongActivity;
import com.example.quanlychothuenhatro.QuanLyTaiKhoan.HomeActivity;
import com.example.quanlychothuenhatro.R;
import com.example.quanlychothuenhatro.ThemDialog.ThemPhong;

import java.util.ArrayList;

public class PhongTroActivity extends AppCompatActivity {
    ImageButton btnThemPhong, btnHome;

    TextView tvsophong;
    ListView lvPhongTro;
    DBHelper DB;
    ArrayList<Integer> dsPhong;
    ListViewPhongTroadapter  viewadapter;



    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phongtro);
        Intent intent1 = getIntent();
        DB=new DBHelper(this);
        lvPhongTro = findViewById(R.id.lstPhongTro);
        dsPhong=DB.getdssophong();
        viewadapter=new ListViewPhongTroadapter(PhongTroActivity.this,dsPhong,R.layout.list_phongtro);
        lvPhongTro.setAdapter(viewadapter);

        tvsophong = findViewById(R.id.tvsophong);
        lvPhongTro = findViewById(R.id.lstPhongTro);
        lvPhongTro.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                int sophong= dsPhong.get(position);
               AlertDialog.Builder builder = new AlertDialog.Builder(PhongTroActivity.this);
                builder.setTitle("Cập Nhật Phòng Trọ");
                builder.setMessage("Mời Bạn Chọn Chức Năng");
                builder.setPositiveButton("Cập Nhật Phòng", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent(PhongTroActivity.this, CaiDatPhongActivity.class);
                        intent.putExtra("sophong", sophong);
                        intent.putExtra("tendangnhap", intent1.getStringExtra("tendangnhap"));
                        startActivity(intent);
                    }
                });

                builder.setNegativeButton("Xóa Phòng", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        builder.setTitle("Xóa Phòng")
                                .setMessage("Bạn Có Muốn Xóa Phòng Không?")
                                .setPositiveButton("Có", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        int sophong= dsPhong.get(position);
                                        int i=DB.delete_PhongTro(sophong);
                                       int x=DB.delete_KhachThue(sophong);
                                        if(i!=0 && x!=0 ) {
                                            dsPhong.remove(position);
                                            viewadapter.notifyDataSetChanged();
                                            lvPhongTro.setAdapter(viewadapter);
                                            Toast.makeText(PhongTroActivity.this, "Xóa phòng thành công!", Toast.LENGTH_LONG).show();
                                        }
                                        else {
                                            Toast.makeText(PhongTroActivity.this, "Xóa Phòng Thất Bại!", Toast.LENGTH_LONG).show();

                                        }
                                    }
                                })
                                .setNegativeButton("Không", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        Toast.makeText(PhongTroActivity.this, "Bạn Chọn Không! ", Toast.LENGTH_SHORT).show();
                                        dialog.cancel();
                                    }
                                });
                        builder.show();
                    }
                });
             builder.show();

            }
        });


        btnHome = findViewById(R.id.btnHome);
        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PhongTroActivity.this, HomeActivity.class);
                intent.putExtra("tendangnhap", intent1.getStringExtra("tendangnhap"));
                startActivity(intent);
            }
        });
        btnThemPhong = findViewById(R.id.btnAdd);
        btnThemPhong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PhongTroActivity.this, ThemPhong.class);
                intent.putExtra("tendangnhap", intent1.getStringExtra("tendangnhap"));
                startActivity(intent);
            }
        });
    }



}














