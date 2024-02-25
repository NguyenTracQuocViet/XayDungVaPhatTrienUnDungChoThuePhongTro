package com.example.quanlychothuenhatro.Adapter.DoanhThu.DoanhThuQuy;

public class DoanhThuQuy {
    private int Sophong;
    private String Tenkhach;
    private String NgayTaoHoaDon;
    private float TongTien;

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

    public void setNgayTaoHoaDon(String ngayTaoHoaDon) {
        NgayTaoHoaDon = ngayTaoHoaDon;
    }

    public float getTongTien() {
        return TongTien;
    }

    public void setTongTien(float tongTien) {
        TongTien = tongTien;
    }

    public DoanhThuQuy(int soPhong, String tenKhachThue, String NgaytaoHoaDon, float tongtien) {
        Sophong = soPhong;
        Tenkhach = tenKhachThue;
        NgayTaoHoaDon = NgaytaoHoaDon;
        TongTien = tongtien;
    }

}
