package com.example.quanlychothuenhatro.QuanLyTaiKhoan;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.quanlychothuenhatro.Adapter.DBHelper;

import com.example.quanlychothuenhatro.R;
import com.example.quanlychothuenhatro.TrangChu.PhongTroActivity;


public class LoginActivity extends AppCompatActivity {
    private Button btnDangNhap;
    private EditText edtUserLg, edtPassLg;
    private TextView tvDki;
    private DBHelper DB;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        DB = new DBHelper(this);
        Intent intent1 =getIntent();
        edtUserLg = findViewById(R.id.usernamelogin);
        edtPassLg = findViewById(R.id.passwordlogin);
        btnDangNhap = findViewById(R.id.btnLogin);
        btnDangNhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = edtUserLg.getText().toString();
                String pass = edtPassLg.getText().toString();
                int pass_hard= pass.hashCode();
                if(user.isEmpty()|| pass.isEmpty()){
                    Toast.makeText(LoginActivity.this, "Không Được Để Trống", Toast.LENGTH_SHORT).show();
                }else{
                    Boolean checkuserpass = DB.checkusernamepassword(user, pass_hard );

                    if(checkuserpass == true){
                        Toast.makeText(LoginActivity.this, "Đăng Nhập Thành Công", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(LoginActivity.this,HomeActivity.class);
                        intent.putExtra("tendangnhap", edtUserLg.getText().toString());
                        startActivity(intent);
                    }
                    else{
                        Toast.makeText(LoginActivity.this, "Thông Tin Không Hợp Lệ", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        tvDki = findViewById(R.id.tvDangKy);
        tvDki.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
            }
        });

    }
}