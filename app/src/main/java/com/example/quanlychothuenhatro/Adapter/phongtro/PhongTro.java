package com.example.quanlychothuenhatro.Adapter.phongtro;

public class PhongTro implements Comparable<PhongTro>{

    private int Sophong;
    private String Tenkhachthue;
    private int Dientich;
    private float Giadien;
    private float Gianuoc;
    private float Giawifi;


    public PhongTro(int sophong, String tenkhachthue,int dientich, float giadien, float gianuoc, float giawifi) {
        Sophong = sophong;
        Tenkhachthue = tenkhachthue;
        Dientich = dientich;
        Giadien = giadien;
        Gianuoc = gianuoc;
        Giawifi = giawifi;

    }

    public int getSophong() {
        return Sophong;
    }

    public void setSophong(int sophong) {
        Sophong = sophong;
    }
    public int getDientich() {
        return Dientich;
    }

    public void setDientich(int dientich) {
        Dientich = dientich;
    }

    public String getTenkhachthue() {
        return Tenkhachthue;
    }

    public void setTenkhachthue(String tenkhachthue) {
        Tenkhachthue = tenkhachthue;
    }

    public float getGiadien() {
        return Giadien;
    }

    public void setGiadien(float giadien) {
        Giadien = giadien;
    }

    public float getGianuoc() {
        return Gianuoc;
    }

    public void setGianuoc(float gianuoc) {
        Gianuoc = gianuoc;
    }

    public float getGiawifi() {
        return Giawifi;
    }

    public void setGiawifi(float giawifi) {
        Giawifi = giawifi;
    }



    @Override
    public int compareTo(PhongTro o) {
        return 0;
    }
}
