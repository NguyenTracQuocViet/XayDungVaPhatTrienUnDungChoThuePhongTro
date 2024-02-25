package com.example.quanlychothuenhatro.Adapter.HopDong;


import android.widget.DatePicker;

import java.sql.Date;

public class HopDong {
    private int Sophong;
    private String Tenkhach;
    private String NgayDBthue;
    private String Ngayhethanthue;
    private int Songuoithue;
    private int Soluongxe;
    private float TienCoc;

    public int getSophong() {
        return Sophong;
    }

    public void setSophong(int sophong) {
        Sophong = sophong;
    }

    public String getTenkhach() {
        return Tenkhach;
    }

    public void setTenkhach(String tenkhach) {
        Tenkhach = tenkhach;
    }

    public String getNgayDBthue() {
        return NgayDBthue;
    }



    public String getNgayhethanthue() {
        return Ngayhethanthue;
    }


    public int getSonguoithue() {
        return Songuoithue;
    }

    public void setSonguoithue(int songuoithue) {
        Songuoithue = songuoithue;
    }

    public int getSoluongxe() {
        return Soluongxe;
    }

    public void setSoluongxe(int soluongxe) {
        Soluongxe = soluongxe;
    }

    public float getTienCoc() {
        return TienCoc;
    }

    public void setTienCoc(float tienCoc) {
        TienCoc = tienCoc;
    }

    public HopDong(int sophong, String tenkhachthue, String Ngaybdthue , String Ngayhhthue, int songuoithue, int soluongxe, float tienCoc ){
        Sophong = sophong;
        Tenkhach= tenkhachthue;
        NgayDBthue= Ngaybdthue ;
        Ngayhethanthue= Ngayhhthue;
        Songuoithue= songuoithue;
        Soluongxe= soluongxe;
        TienCoc= tienCoc ;
    }
}
