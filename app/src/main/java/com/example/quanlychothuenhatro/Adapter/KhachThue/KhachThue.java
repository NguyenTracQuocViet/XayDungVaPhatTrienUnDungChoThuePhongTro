package com.example.quanlychothuenhatro.Adapter.KhachThue;

public class KhachThue implements Comparable<KhachThue>{

    private int Sophong;
    private String Tenkhachthue;
    private String SoCCCD;
    private String SoDT;
    private String GioiTinh;


    public void setSoCCCD(String soCCCD) {
        SoCCCD = soCCCD;
    }

    public void setSoDT(String soDT) {
        SoDT = soDT;
    }

    public String getGioiTinh() {
        return GioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        GioiTinh = gioiTinh;
    }

    public KhachThue(int sophong,String tenkhachthue, String gioitinh,String soDT,  String soCCCD) {
        Sophong = sophong;
        Tenkhachthue = tenkhachthue;
        SoCCCD = soCCCD;
        SoDT = soDT;
        GioiTinh = gioitinh;
    }


    public int getSophong() {
        return this.Sophong;
    }

    public void setSophong(int sophong) {
        Sophong = sophong;
    }

    public String getTenkhachthue() {
        return this.Tenkhachthue;
    }

    public void setTenkhachthue(String tenkhachthue) {
        Tenkhachthue = tenkhachthue;
    }



    public String getSoCCCD() {
        return SoCCCD;
    }

    public String getSoDT() {
        return SoDT;
    }





    @Override
    public int compareTo(KhachThue o) {
        return 0;
    }
}
