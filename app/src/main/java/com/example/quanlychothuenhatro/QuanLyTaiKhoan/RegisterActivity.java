package com.example.quanlychothuenhatro.QuanLyTaiKhoan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.quanlychothuenhatro.Adapter.DBHelper;
import com.example.quanlychothuenhatro.R;

public class RegisterActivity extends AppCompatActivity {

    private Button btnDangKy;
    private EditText edtUserRe, edtPassRe, edtrePassRe;
    private DBHelper DB;
    private ImageButton imgBtnreturn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        imgBtnreturn = findViewById(R.id.imageBtnreturn);
        imgBtnreturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        DB = new DBHelper(this);
        edtUserRe = findViewById(R.id.usernameRegister);
        edtPassRe = findViewById(R.id.passwordRegister);

        edtrePassRe = findViewById(R.id.repassword);

        btnDangKy = findViewById(R.id.btnRegister);
        btnDangKy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = edtUserRe.getText().toString();
                String pass = edtPassRe.getText().toString();
                String repass = edtrePassRe.getText().toString();
                int pass_hard=pass.hashCode();
                if(user.isEmpty() || pass.isEmpty()|| repass.isEmpty())
                    Toast.makeText(RegisterActivity.this, "Không Được Để Trống", Toast.LENGTH_SHORT).show();
                else{
                    if(pass.equals(repass)){
                        Boolean checkuser =DB.checkusername(user);
                        if(checkuser == false){
                            Boolean insert =DB.insertData_User(user, pass_hard);
                            if(insert == true){
                                Toast.makeText(RegisterActivity.this, "Đăng Ký Thành Công", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
                            }else{
                                Toast.makeText(RegisterActivity.this, "Đăng Ký Thất Bại", Toast.LENGTH_SHORT).show();
                            }
                        }
                        else{
                            Toast.makeText(RegisterActivity.this, "Tên Đăng Nhập Đã Tồn Tại! Hãy Đổi Tên Đăng Nhập!!", Toast.LENGTH_SHORT).show();
                        }
                    }else{
                        Toast.makeText(RegisterActivity.this, "Mật Khẩu Không Khớp", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

    }
}