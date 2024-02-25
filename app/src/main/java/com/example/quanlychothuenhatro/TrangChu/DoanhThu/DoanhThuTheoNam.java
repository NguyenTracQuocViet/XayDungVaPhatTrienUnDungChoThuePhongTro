package com.example.quanlychothuenhatro.TrangChu.DoanhThu;

import androidx.appcompat.app.AppCompatActivity;

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
import com.example.quanlychothuenhatro.Adapter.DoanhThu.DoanhThuNam.DoanhThuNam;
import com.example.quanlychothuenhatro.Adapter.DoanhThu.DoanhThuNam.ListViewDoanhThuNamadapter;
import com.example.quanlychothuenhatro.Adapter.DoanhThu.DoanhThuThang.DoanhThuThang;
import com.example.quanlychothuenhatro.Adapter.DoanhThu.DoanhThuThang.ListViewDoanhThuThangadapter;
import com.example.quanlychothuenhatro.R;

import java.util.ArrayList;

public class DoanhThuTheoNam extends AppCompatActivity  {
    ImageButton btnquaylai;
    Spinner  spinnernam;
    Button btnxemnam;
    TextView tvdoanhthu;
    int nam;

    ArrayList<DoanhThuNam> dsDoanhthunam;
    ListView lstDoanhThuNam;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doanhthutheonam);
        Intent intent1 = getIntent();
        DBHelper DB=new DBHelper(this);
        lstDoanhThuNam = findViewById(R.id.lstviewdoanhthunam);
        btnquaylai = findViewById(R.id.btnquaylainam);
        btnxemnam = findViewById(R.id.btnXemnam);
        tvdoanhthu=findViewById(R.id.tvDoanhthunam);
        btnxemnam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Long TongTien =DB.getTongTienTheoNam(nam);
                tvdoanhthu.setText(String.valueOf(TongTien));
                try {
                    dsDoanhthunam = DB.getdsdoanhthunam(nam);
                    ListViewDoanhThuNamadapter viewadapter=new ListViewDoanhThuNamadapter(DoanhThuTheoNam.this,dsDoanhthunam,R.layout.list_quanlydoanhthunam);
                    lstDoanhThuNam.setAdapter(viewadapter);
                }
                catch (Exception e)
                {
                    e.printStackTrace();

                }

            }
        });
        btnquaylai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DoanhThuTheoNam.this, DoanhThuActivity.class);
                intent.putExtra("tendangnhap", intent1.getStringExtra("tendangnhap"));
                startActivity(intent);
            }
        });
        spinnernam = findViewById(R.id.chonnamnam);
        ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(this, R.array.Year, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item);
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
