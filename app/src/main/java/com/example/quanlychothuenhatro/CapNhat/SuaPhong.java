package com.example.quanlychothuenhatro.CapNhat;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.quanlychothuenhatro.Adapter.DBHelper;
import com.example.quanlychothuenhatro.CaiDatActivity.CaiDatPhongActivity;
import com.example.quanlychothuenhatro.R;

public class SuaPhong extends AppCompatActivity {
    EditText  dientich, giaphong;
    TextView sophong;
    Button btnCapnhat, btnHuy;
    DBHelper DB;
    float GiaPhong;
    int Sophong, Dientich;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_suaphong);
        Intent intent1 = getIntent();
        DB = new DBHelper(this);

        sophong = findViewById(R.id.sophongsp);
        Sophong = intent1.getIntExtra("sophong", 0);
        sophong.setText("Phòng: "+String.valueOf(Sophong));

        dientich = findViewById(R.id.dientichsp);
        Dientich = DB.getDientich(Sophong);
        dientich.setText(String.valueOf(Dientich));

        giaphong = findViewById(R.id.giaphongsp);
        GiaPhong = DB.getGiaThue(Sophong);
        giaphong.setText(String.valueOf(GiaPhong));

        btnHuy = findViewById(R.id.btnhuy);
        btnHuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SuaPhong.this, CaiDatPhongActivity.class);
                intent.putExtra("tendangnhap", intent1.getStringExtra("tendangnhap"));
                intent.putExtra("sophong", intent1.getIntExtra("sophong", 0));
                intent.putExtra("tenkhachthue", intent1.getStringExtra("tenkhachthue"));
                startActivity(intent);
            }
        });

        btnCapnhat = findViewById(R.id.btncapnhat);
        btnCapnhat.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(dientich.getText().toString().isEmpty()|| giaphong.getText().toString().isEmpty()){
                        Toast.makeText(SuaPhong.this,"Không Được Để Trống",Toast.LENGTH_LONG).show();
                        return;
                    }
                    Dientich = Integer.parseInt(dientich.getText().toString());
                    GiaPhong = Float.parseFloat(giaphong.getText().toString());
                    int SuaPhong= DB.updateSuaPhong(Sophong, Dientich, GiaPhong);
                    if(SuaPhong !=0 ){
                        Toast.makeText(SuaPhong.this,"Cập Nhật Thành Công",Toast.LENGTH_LONG).show();
                    }else {
                        Toast.makeText(SuaPhong.this,"Cập Nhật Thất Bại",Toast.LENGTH_LONG).show();

                    }
                    Intent intent = new Intent(SuaPhong.this, CaiDatPhongActivity.class);
                    intent.putExtra("tendangnhap", intent1.getStringExtra("tendangnhap"));
                    intent.putExtra("sophong", intent1.getIntExtra("sophong", 0));
                    intent.putExtra("tenkhachthue", intent1.getStringExtra("tenkhachthue"));
                    startActivity(intent);
                }
            });



    }


}