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

import com.example.quanlychothuenhatro.Adapter.DBHelper;
import com.example.quanlychothuenhatro.Adapter.DoanhThu.DoanhThuThang.DoanhThuThang;
import com.example.quanlychothuenhatro.Adapter.DoanhThu.DoanhThuThang.ListViewDoanhThuThangadapter;
import com.example.quanlychothuenhatro.Adapter.HoaDon.HoaDon;
import com.example.quanlychothuenhatro.Adapter.HoaDon.ListViewHoaDonadapter;
import com.example.quanlychothuenhatro.R;

import java.util.ArrayList;

public class DoanhThuTheoThang extends AppCompatActivity {
    ImageButton btnquaylai;
    Button btnDoanhthu;
    TextView Doanhthuthang;
    Spinner spinnerthang, spinnernam;
    ArrayAdapter<CharSequence> adapter,adapter1;
    DBHelper DB;
    int thang,nam;
    ArrayList<DoanhThuThang> dsDoanhthuthang;
    ListView lstDoanhThuthang;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doanhthutheothang);
        Intent intent1 = getIntent();
        DB = new DBHelper(this);

        Doanhthuthang = findViewById(R.id.tvDoanhthuthang);
        btnDoanhthu = findViewById(R.id.btnXemthangdoanhthu);
        btnDoanhthu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TongThang();
                try {
                    lstDoanhThuthang = findViewById(R.id.lstviewdoanhthuthang);
                    dsDoanhthuthang = DB.getdsdoanhthuthang(thang, nam);
                    ListViewDoanhThuThangadapter viewadapter=new ListViewDoanhThuThangadapter(DoanhThuTheoThang.this,dsDoanhthuthang,R.layout.list_quanlydoanhthuthang);
                    lstDoanhThuthang.setAdapter(viewadapter);
                }
                catch (Exception e)
                {
                    e.printStackTrace();

                }


            }
        });
        btnquaylai = findViewById(R.id.btnHomethang);
        btnquaylai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DoanhThuTheoThang.this, DoanhThuActivity.class);
                intent.putExtra("tendangnhap", intent1.getStringExtra("tendangnhap"));
                startActivity(intent);
            }
        });

        spinnerthang = findViewById(R.id.spinnerchonthang);
        adapter = ArrayAdapter.createFromResource(this, R.array.Month, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item);
        adapter.setDropDownViewResource(androidx.appcompat.R.layout.support_simple_spinner_dropdown_item);
        spinnerthang.setAdapter(adapter);
        spinnerthang.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String a= parent.getItemAtPosition(position).toString();
                String[] c=a.split("\\s");
                thang=Integer.parseInt(c[1]);

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        spinnernam = findViewById(R.id.spinnerchonnamthang);
        adapter1 = ArrayAdapter.createFromResource(this, R.array.Year, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item);
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



    private void TongThang(){
        try {
            Long TongTien=  DB.getTongTienTheoThang(thang,nam);
            Doanhthuthang.setText(String.valueOf(TongTien));
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

    }
}