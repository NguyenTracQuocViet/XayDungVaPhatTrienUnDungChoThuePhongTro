package com.example.quanlychothuenhatro.CapNhat;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.quanlychothuenhatro.Adapter.DBHelper;
import com.example.quanlychothuenhatro.R;
import com.example.quanlychothuenhatro.TrangChu.HopDongActivity;

import java.util.Calendar;

public class GiaHanHopDong extends AppCompatActivity {
    ImageButton lich, quaylai;
    Button Giahan;
    TextView ngaygh, phong;
    DBHelper DB;
    int Sophong;
    String NgayHHthue;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_giahanhopdong);
        Intent intent1 = getIntent();
        DB = new DBHelper(this);
        ngaygh = findViewById(R.id.giahan);

        phong = findViewById(R.id.sophonggh);
        Sophong = intent1.getIntExtra("sophong", 0);
        phong.setText("Phòng: "+String.valueOf(Sophong));

        lich = findViewById(R.id.btnlichgh);
        lich.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lichgiahan();
            }
        });
        quaylai = findViewById(R.id.btnquaylaigh);
        quaylai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(GiaHanHopDong.this, HopDongActivity.class);
                intent.putExtra("tendangnhap", intent1.getStringExtra("tendangnhap"));
                intent.putExtra("sophong", intent1.getIntExtra("sophong", 0));
                intent.putExtra("tenkhachthue", intent1.getStringExtra("tenkhachthue"));
                startActivity(intent);
            }
        });

        Giahan = findViewById(R.id.btnGiahan);
        Giahan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ngaygh.getText().toString().isEmpty()){
                    Toast.makeText(GiaHanHopDong.this,"Không Được Để Trống",Toast.LENGTH_LONG).show();
                    return;
                }
              NgayHHthue = String.valueOf(ngaygh.getText().toString());
                int Giahanhd= DB.Giahanhopdong(Sophong, NgayHHthue);
                if(Giahanhd != 0){
                    Toast.makeText(GiaHanHopDong.this,"Gia Hạn Hợp Đồng Thành Công",Toast.LENGTH_LONG).show();
                }else {
                    Toast.makeText(GiaHanHopDong.this,"Gia Hạn Hợp Đồng Thất Bại",Toast.LENGTH_LONG).show();
                }
                Intent intent = new Intent(GiaHanHopDong.this, HopDongActivity.class);
                intent.putExtra("tendangnhap", intent1.getStringExtra("tendangnhap"));
                intent.putExtra("sophong", intent1.getIntExtra("sophong", 0));
                intent.putExtra("tenkhachthue", intent1.getStringExtra("tenkhachthue"));
                startActivity(intent);
            }
        });
    }
    private void lichgiahan(){
        Calendar calendar = Calendar.getInstance();
        int Year = calendar.get(Calendar.YEAR);
        int Month = calendar.get(Calendar.MONTH);
        int Date = calendar.get(Calendar.DAY_OF_MONTH);
        DatePickerDialog dialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                ngaygh.setText(String.valueOf(day)+"/"+ String.valueOf(month+1)+"/"+String.valueOf(year));
            }
        } ,Year, Month, Date);
        dialog.show();
    }
}