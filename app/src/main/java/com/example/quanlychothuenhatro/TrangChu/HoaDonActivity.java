package com.example.quanlychothuenhatro.TrangChu;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

import com.example.quanlychothuenhatro.Adapter.DBHelper;
import com.example.quanlychothuenhatro.Adapter.HoaDon.HoaDon;
import com.example.quanlychothuenhatro.Adapter.HoaDon.ListViewHoaDonadapter;
import com.example.quanlychothuenhatro.Adapter.HopDong.HopDong;
import com.example.quanlychothuenhatro.Adapter.HopDong.ListViewHopDongadapter;
import com.example.quanlychothuenhatro.CapNhat.CapNhatHoaDon;
import com.example.quanlychothuenhatro.CapNhat.GiaHanHopDong;
import com.example.quanlychothuenhatro.QuanLyTaiKhoan.HomeActivity;
import com.example.quanlychothuenhatro.R;

import java.util.ArrayList;

public class HoaDonActivity extends AppCompatActivity {

    private ImageButton btnHome;
    DBHelper DB;
    ListView lvHoaDon;
    ArrayList<HoaDon> dsHoaDon;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hoa_don);
        Intent intent4 = getIntent();
        DB=new DBHelper(this);
        lvHoaDon = findViewById(R.id.listhoadon);
        dsHoaDon = DB.getdshoadon();
        ListViewHoaDonadapter viewadapter=new ListViewHoaDonadapter(HoaDonActivity.this,dsHoaDon,R.layout.list_quanlyhoadon);
        lvHoaDon.setAdapter(viewadapter);
        lvHoaDon.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                int sophong= dsHoaDon.get(position).getSophong();
                String TenKhach = dsHoaDon.get(position).getTenkhach();
                String NgayTaoHD = dsHoaDon.get(position).getNgayTaoHoaDon();
                int Sodien = dsHoaDon.get(position).getSoDien();
                int Sonuoc = dsHoaDon.get(position).getSoNuoc();
                Float Tienwifi = dsHoaDon.get(position).getTienWifi();
                Float Tienphong = dsHoaDon.get(position).getTienPhong();
                Float Chiphikhac = dsHoaDon.get(position).getChiPhiKhac();
                Float Tongtien = dsHoaDon.get(position).getTongTien();
                AlertDialog.Builder builder = new AlertDialog.Builder(HoaDonActivity.this);
                builder.setTitle("Cập Nhật Hóa Đơn")
                        .setMessage("Mời Bạn Chọn Chức Năng")
                        .setPositiveButton("Cập Nhật Hóa Đơn", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Intent intent = new Intent(HoaDonActivity.this, CapNhatHoaDon.class);
                                intent.putExtra("sophong", sophong);
                                intent.putExtra("tenkhach", TenKhach);
                                intent.putExtra("ngaytaohd", NgayTaoHD);
                                intent.putExtra("sodien", Sodien);
                                intent.putExtra("sonuoc", Sonuoc);
                                intent.putExtra("tienwifi", Tienwifi);
                                intent.putExtra("tienphong",Tienphong);
                                intent.putExtra("chiphikhac", Chiphikhac);
                                intent.putExtra("tongtien", Tongtien);
                                intent.putExtra("tendangnhap", intent4.getStringExtra("tendangnhap"));
                                startActivity(intent);
                            }
                        })
                        .setNegativeButton("Xóa Hóa Đơn", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                builder.setTitle("Xóa Hóa Đơn")
                                        .setMessage("Bạn Có Muốn Xóa Hóa Đơn Không? ")
                                        .setPositiveButton("Có", new DialogInterface.OnClickListener() {
                                            @Override
                                            public void onClick(DialogInterface dialog, int which) {
                                                int sophong = dsHoaDon.get(position).getSophong();
                                                int i = DB.delete_HoaDon(sophong);
                                                if(i!=0) {
                                                    dsHoaDon.remove(position);
                                                    viewadapter.notifyDataSetChanged();
                                                    lvHoaDon.setAdapter(viewadapter);
                                                    Toast.makeText(HoaDonActivity.this, "Xóa Hóa Đơn Thành Công!", Toast.LENGTH_LONG).show();
                                                }
                                                else {
                                                    Toast.makeText(HoaDonActivity.this, "Xóa Hóa Đơn Thất Bại!", Toast.LENGTH_LONG).show();
                                                }
                                            }
                                        })
                                        .setNegativeButton("Không", new DialogInterface.OnClickListener() {
                                            @Override
                                            public void onClick(DialogInterface dialog, int which) {
                                                Toast.makeText(HoaDonActivity.this, "Bạn Chọn Không! ", Toast.LENGTH_SHORT).show();
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
                Intent intent = new Intent(HoaDonActivity.this, HomeActivity.class);
                intent.putExtra("tendangnhap", intent4.getStringExtra("tendangnhap"));
                startActivity(intent);
            }
        });
    }
}