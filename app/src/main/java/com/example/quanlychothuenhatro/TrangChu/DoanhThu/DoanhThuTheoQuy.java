package com.example.quanlychothuenhatro.TrangChu.DoanhThu;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.quanlychothuenhatro.Adapter.DBHelper;
import com.example.quanlychothuenhatro.Adapter.DoanhThu.DoanhThuQuy.DoanhThuQuy;
import com.example.quanlychothuenhatro.Adapter.DoanhThu.DoanhThuQuy.ListViewDoanhThuQuyadapter;
import com.example.quanlychothuenhatro.Adapter.DoanhThu.DoanhThuThang.DoanhThuThang;
import com.example.quanlychothuenhatro.Adapter.DoanhThu.DoanhThuThang.ListViewDoanhThuThangadapter;
import com.example.quanlychothuenhatro.R;

import java.util.ArrayList;

public class DoanhThuTheoQuy extends AppCompatActivity  {

    ImageButton btnquaylai;
    Button btnDoanhthu;
    TextView Doanhthuquy;
    int nam,quy;
    ArrayList<DoanhThuQuy> dsDoanhthuquy;
    ListView lstDoanhThuQuy;


    Spinner spinnerquy, spinnernam;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DBHelper DB=new DBHelper(this);
        setContentView(R.layout.activity_doanhthutheoquy);
        Intent intent1 = getIntent();
        lstDoanhThuQuy = findViewById(R.id.lstviewdoanhthuquy);

        Doanhthuquy = findViewById(R.id.tvDoanhthuquy);
        btnDoanhthu = findViewById(R.id.btnXemquy);
        btnDoanhthu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                try {
                    float TongTien=Float.parseFloat("0");
                    int t1,t2,t3,t4;
                    if(quy==1)
                    {
                        t1=1;
                        t2=2;
                        t3=3;
                        t4=4;
                        String sql="SELECT sum(TongTien) from HoaDon where NgayTaoHD like '%/1/"+nam+"' or NgayTaoHD like '%/2/"+nam+"'or NgayTaoHD like '%/3/"+nam+"'or NgayTaoHD like '%/4/"+nam+"'";
                        TongTien=DB.getTongTienTheoQuy(sql);
                        Doanhthuquy.setText(String.valueOf(TongTien));
                        dsDoanhthuquy = DB.getdsdoanhthuquy(t1,t2,t3,t4, nam);
                        ListViewDoanhThuQuyadapter viewadapter=new ListViewDoanhThuQuyadapter(DoanhThuTheoQuy.this,dsDoanhthuquy,R.layout.list_quanlydoanhthuquy);
                        lstDoanhThuQuy.setAdapter(viewadapter);
                    }
                    else {
                        if(quy==2)
                        {
                            t1=5;
                            t2=6;
                            t3=7;
                            t4=8;
                            String sql="SELECT sum(TongTien) from HoaDon where NgayTaoHD like '%/5/"+nam+"' or NgayTaoHD like '%/6/"+nam+"'or NgayTaoHD like '%/7"+nam+"'or NgayTaoHD like '%/8/"+nam+"'";
                            TongTien=DB.getTongTienTheoQuy(sql);
                            Doanhthuquy.setText(String.valueOf(TongTien));
                            dsDoanhthuquy = DB.getdsdoanhthuquy(t1,t2,t3,t4, nam);
                            ListViewDoanhThuQuyadapter viewadapter=new ListViewDoanhThuQuyadapter(DoanhThuTheoQuy.this,dsDoanhthuquy,R.layout.list_quanlydoanhthuquy);
                            lstDoanhThuQuy.setAdapter(viewadapter);
                        }
                        else {
                            if(quy==3) {
                                t1=9;
                                t2=10;
                                t3=11;
                                t4=12;
                                String sql = "SELECT sum(TongTien) from HoaDon where NgayTaoHD like '%/9/" + nam + "' or NgayTaoHD like '%/10/" + nam + "'or NgayTaoHD like '%/11/" + nam + "'or NgayTaoHD like '%/12/" + nam + "'";
                                TongTien = DB.getTongTienTheoQuy( sql);
                                Doanhthuquy.setText(String.valueOf(TongTien));
                                dsDoanhthuquy = DB.getdsdoanhthuquy(t1,t2,t3,t4, nam);
                                ListViewDoanhThuQuyadapter viewadapter=new ListViewDoanhThuQuyadapter(DoanhThuTheoQuy.this,dsDoanhthuquy,R.layout.list_quanlydoanhthuquy);
                                lstDoanhThuQuy.setAdapter(viewadapter);
                            }

                        }
                    }
                }
                catch (Exception e)
                {
                    e.printStackTrace();

                }
            }
        });
        btnquaylai = findViewById(R.id.btnquaylaiquy);
        btnquaylai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DoanhThuTheoQuy.this, DoanhThuActivity.class);
                intent.putExtra("tendangnhap", intent1.getStringExtra("tendangnhap"));
                startActivity(intent);
            }
        });
        spinnerquy = findViewById(R.id.spinnerchonquy);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.Quarter, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item);
        adapter.setDropDownViewResource(androidx.appcompat.R.layout.support_simple_spinner_dropdown_item);
        spinnerquy.setAdapter(adapter);
        spinnerquy.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(parent.getSelectedItemPosition()==0)
                {
                     quy=1;
                }
                else {
                    if(parent.getSelectedItemPosition()==1)
                    {
                         quy=2;
                    }
                    else {
                        quy=3;
                    }
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        spinnernam = findViewById(R.id.spinnerchonnamquy);
        ArrayAdapter<CharSequence>adapter1 = ArrayAdapter.createFromResource(this, R.array.Year, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item);
        spinnernam.setAdapter(adapter1);
        spinnernam.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String a= parent.getItemAtPosition(position).toString();
                String[] c=a.split("\\s");
                nam=Integer.parseInt(c[1]);

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }






}