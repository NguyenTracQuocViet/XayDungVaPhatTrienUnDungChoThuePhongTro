package com.example.quanlychothuenhatro.ThemDialog;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.telephony.PhoneNumberUtils;
import android.text.InputFilter;
import android.text.Spanned;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.quanlychothuenhatro.Adapter.DBHelper;
import com.example.quanlychothuenhatro.CaiDatActivity.CaiDatGiaActivity;
import com.example.quanlychothuenhatro.CaiDatActivity.CaiDatPhongActivity;
import com.example.quanlychothuenhatro.R;

public class ThemKhachThue extends AppCompatActivity {
    Button btnthem, btnHuy;
    TextView tvSophong;
    EditText edtTenkhach, edtCccd, edtSdt;
    int sophong;
    String tenkhach,SoDt, SoCCCD, gioitinh;
    RadioButton gtNam, gtNu;
    RadioGroup radioGroup;
    RadioButton radioButton;
    DBHelper DB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_themkhachthue);
        Intent intent1 = getIntent();
        DB = new DBHelper(this);
        tvSophong=findViewById(R.id.sophongkhachthue);
        tvSophong.setText("Phòng: "+ intent1.getIntExtra("sophong", 0));
        edtTenkhach = findViewById(R.id.edttenkhach);
        edtSdt = findViewById(R.id.edtsdt);
        edtCccd = findViewById(R.id.edtcccd);
        radioGroup = findViewById(R.id.radioGroup);
        gtNam = findViewById(R.id.GTnam);
        gtNu = findViewById(R.id.GTnu);
        btnHuy = findViewById(R.id.btnhuy);
        btnHuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(ThemKhachThue.this, CaiDatPhongActivity.class);
                intent2.putExtra("sophong", intent1.getIntExtra("sophong", 0));
                intent2.putExtra("tendangnhap", intent1.getStringExtra("tendangnhap"));
                startActivity(intent2);
            }
        });
        btnthem = findViewById(R.id.btnthem);
        btnthem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(edtSdt.getText().toString().isEmpty()|| edtCccd.getText().toString().isEmpty() ){
                    Toast.makeText(ThemKhachThue.this,"Không Được Để Trống",Toast.LENGTH_LONG).show();
                    return;
                }
                int radioID = radioGroup.getCheckedRadioButtonId();
                radioButton = findViewById(radioID);
                sophong= intent1.getIntExtra("sophong", 0);
                tenkhach =edtTenkhach.getText().toString();
                gioitinh = radioButton.getText().toString();
                SoDt=String.valueOf(edtSdt.getText().toString());
                SoCCCD=String.valueOf(edtCccd.getText().toString());
                if(edtSdt.getText().length()!=10)
                {
                    Toast.makeText(ThemKhachThue.this,"Số Điện Thoại Đủ 10 ký tự",Toast.LENGTH_LONG).show();
                    return ;
                }
                if(edtCccd.getText().length()!=12)
                {
                    Toast.makeText(ThemKhachThue.this,"Số CCCD Đủ 12 ký tự",Toast.LENGTH_LONG).show();
                    return ;
                }

                Boolean insert= DB.insertData_KhachThue(sophong,tenkhach,gioitinh, SoDt, SoCCCD);

                if(insert==true)
                {
                    Toast.makeText(ThemKhachThue.this,"Thêm Thành Công",Toast.LENGTH_LONG).show();
                }
                else {

                    Toast.makeText(ThemKhachThue.this,"Thêm Thất Bại",Toast.LENGTH_LONG).show();
                }

                Intent intent3 = new Intent(ThemKhachThue.this, CaiDatPhongActivity.class);
                intent3.putExtra("tendangnhap", intent1.getStringExtra("tendangnhap"));
                intent3.putExtra("sophong",intent1.getIntExtra("sophong", 0));
                intent3.putExtra("tenkhachthue", edtTenkhach.getText().toString());
                intent3.putExtra("gioitinh", radioButton.getText().toString());
                intent3.putExtra("sdt", edtSdt.getText().toString());
                intent3 .putExtra("socccd", edtCccd.getText().toString());
                startActivity(intent3);
            }
        });
    }

    public void checkButton(View view){
        int radioID = radioGroup.getCheckedRadioButtonId();
        radioButton = findViewById(radioID);
    }

}