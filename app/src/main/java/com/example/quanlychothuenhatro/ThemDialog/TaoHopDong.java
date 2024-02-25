package com.example.quanlychothuenhatro.ThemDialog;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.quanlychothuenhatro.Adapter.DBHelper;
import com.example.quanlychothuenhatro.CaiDatActivity.CaiDatPhongActivity;
import com.example.quanlychothuenhatro.R;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class TaoHopDong extends AppCompatActivity {
    Button btnthem, btnHuy;
    EditText edtSonguoithue, edtSoluongxe, edtTienCoc;
    TextView tvNgaybd, tvNgaykt, tvSophonghopdong, tvTenkhach;
    ImageButton btnLich1, btnLich2;
    DBHelper DB;
    int  soxe, sokhachthue ;

    float tiencoc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_taohopdong);
        Intent intent1= getIntent();
        DB = new DBHelper(this);
        tvNgaybd = findViewById(R.id.tvngaybdhopdong);
        tvNgaykt = findViewById(R.id.tvngaykthopdong);
        tvTenkhach = findViewById(R.id.tvTenkhachhopdong);
        int Sophong=intent1.getIntExtra("sophong", 0);
        String TenKhach=DB.getKhachThue(Sophong);
        tvTenkhach.setText("Tên Khách: "+TenKhach);
        tvSophonghopdong = findViewById(R.id.sophonghopdong);
        tvSophonghopdong.setText("Phòng: "+String.valueOf(Sophong));
        edtSoluongxe = findViewById(R.id.edtSoluongxe);
        edtSonguoithue = findViewById(R.id.edtSonguoithue);
        edtTienCoc = findViewById(R.id.Tiencochopdong);
        String TenDangnhap=intent1.getStringExtra("tendangnhap");
        btnHuy = findViewById(R.id.btnhuy);
        btnHuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(TaoHopDong.this, CaiDatPhongActivity.class);
                intent2.putExtra("sophong", Sophong);
                intent2.putExtra("tendangnhap",TenDangnhap);
                startActivity(intent2);
            }
        });

        btnLich1 = findViewById(R.id.btnLich1);
        btnLich1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                opendialogbd();
            }
        });
        btnLich2 = findViewById(R.id.btnLich2);
        btnLich2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                opendialogkt();
            }
        });

        btnthem = findViewById(R.id.btnthemhopdong);
        btnthem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(tvNgaybd.getText().toString().isEmpty()|| tvNgaykt.getText().toString().isEmpty()|| edtSoluongxe.getText().toString().isEmpty() || edtSonguoithue.getText().toString().isEmpty() || edtTienCoc.getText().toString().isEmpty()  ){
                    Toast.makeText(TaoHopDong.this,"Không Được Để Trống",Toast.LENGTH_LONG).show();
                    return;
                }

                SimpleDateFormat sd = new SimpleDateFormat("dd/MM/yyyy");
                try {
                    Date date1 = sd.parse(tvNgaybd.getText().toString());
                    Date date2 = sd.parse(tvNgaykt.getText().toString());
                    if(date2.before(date1))
                    {
                        Toast.makeText(TaoHopDong.this,"Ngày Hết Hạn Không Được Trước Ngày Bắt Đầu",Toast.LENGTH_LONG).show();
                        return;
                    }
                } catch (ParseException e) {
                    throw new RuntimeException(e);
                }

//                Date bd=new Date(tvNgaybd.getText().toString());
//                Date kt=new Date(tvNgaykt.getText().toString());


                String ngaybdhopdong =tvNgaybd.getText().toString();
                String  ngaykthopdong= tvNgaykt.getText().toString();
                soxe = Integer.parseInt(edtSoluongxe.getText().toString());
                sokhachthue =  Integer.parseInt(edtSonguoithue.getText().toString());
                tiencoc = Float.parseFloat(edtTienCoc.getText().toString());
                Boolean insert= DB.insertData_HopDong(Sophong,TenKhach, ngaybdhopdong, ngaykthopdong, soxe, sokhachthue,tiencoc );

                if(insert==true)
                {
                    Toast.makeText(TaoHopDong.this,"Thêm Thành Công",Toast.LENGTH_LONG).show();
                }
                else {

                    Toast.makeText(TaoHopDong.this,"Thêm Thất Bại",Toast.LENGTH_LONG).show();
                }

                Intent intent4 = new Intent(TaoHopDong.this, CaiDatPhongActivity.class);
                intent4.putExtra("tendangnhap", intent1.getStringExtra("tendangnhap"));
                intent4.putExtra("sophong",intent1.getIntExtra("sophong", 0));
                intent4.putExtra("tenkhachthue", intent1.getStringExtra("tenkhachthue"));
                intent4.putExtra("ngaybdhopdong", tvNgaybd.getText().toString());
                intent4.putExtra("ngaykthopdong", tvNgaykt.getText().toString());
                intent4.putExtra("soluongkhach", edtSonguoithue.getText().toString());
                intent4.putExtra("soxe", edtSoluongxe.getText().toString());
                intent4.putExtra("tiencoc", edtTienCoc.getText().toString());
                startActivity(intent4);
            }
        });
    }

    private void opendialogbd(){
        Calendar calendar = Calendar.getInstance();
        int Year = calendar.get(Calendar.YEAR);
        int Month = calendar.get(Calendar.MONTH);
        int Date = calendar.get(Calendar.DAY_OF_MONTH);
        DatePickerDialog dialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                tvNgaybd.setText(String.valueOf(day)+"/"+ String.valueOf(month+1)+"/"+String.valueOf(year));
            }
        } ,Year, Month, Date);
        dialog.show();
    }

    private void opendialogkt(){
        Calendar calendar = Calendar.getInstance();
        int Year = calendar.get(Calendar.YEAR);
        int Month = calendar.get(Calendar.MONTH);
        int date = calendar.get(Calendar.DAY_OF_MONTH);
        DatePickerDialog dialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                tvNgaykt.setText(String.valueOf(day)+"/"+ String.valueOf(month+1)+"/"+String.valueOf(year));
            }
        } ,Year, Month, date);
        dialog.show();
    }

}