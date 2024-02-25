package com.example.quanlychothuenhatro.Adapter.HoaDon;


public class HoaDon  {
    private int Sophong;
    private String Tenkhach;
    private String NgayTaoHoaDon;
    private int SoDien;
    private int SoNuoc;
    private float TienWifi;
    private float TienPhong;

    private float ChiPhiKhac;
    private float TongTien;

    public void setNgayTaoHoaDon(String ngayTaoHoaDon) {
        NgayTaoHoaDon = ngayTaoHoaDon;
    }

    public float getTienWifi() {
        return TienWifi;
    }

    public void setTienWifi(float tienWifi) {
        TienWifi = tienWifi;
    }

    public float getTienPhong() {
        return TienPhong;
    }

    public void setTienPhong(float tienPhong) {
        TienPhong = tienPhong;
    }

    public HoaDon(int soPhong, String tenKhachThue, String NgaytaoHoaDon , int sonuoc, int sodien, float tienwifi, float tienphong , float chiphikhac, float tongtien) {
        Sophong = soPhong;
        Tenkhach = tenKhachThue;
        NgayTaoHoaDon = NgaytaoHoaDon;
        SoDien = sodien;
        SoNuoc = sonuoc;
        TienWifi = tienwifi;
        TienPhong = tienphong;
        ChiPhiKhac = chiphikhac;
        TongTien = tongtien;
    }

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

    public String getNgayTaoHoaDon() {
        return NgayTaoHoaDon;
    }



    public int getSoDien() {
        return SoDien;
    }

    public void setSoDien(int soDien) {
        SoDien = soDien;
    }

    public int getSoNuoc() {
        return SoNuoc;
    }

    public void setSoNuoc(int soNuoc) {
        SoNuoc = soNuoc;
    }

    public float getChiPhiKhac() {
        return ChiPhiKhac;
    }

    public void setChiPhiKhac(float chiPhiKhac) {
        ChiPhiKhac = chiPhiKhac;
    }

    public float getTongTien() {
        return TongTien;
    }

    public void setTongTien(float tongTien) {
        TongTien = tongTien;
    }
}
