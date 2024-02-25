package com.example.quanlychothuenhatro.Adapter;

import static java.lang.Float.valueOf;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.quanlychothuenhatro.Adapter.CaiDatGia.Gia;
import com.example.quanlychothuenhatro.Adapter.DoanhThu.DoanhThuNam.DoanhThuNam;
import com.example.quanlychothuenhatro.Adapter.DoanhThu.DoanhThuQuy.DoanhThuQuy;
import com.example.quanlychothuenhatro.Adapter.DoanhThu.DoanhThuThang.DoanhThuThang;
import com.example.quanlychothuenhatro.Adapter.HoaDon.HoaDon;
import com.example.quanlychothuenhatro.Adapter.HopDong.HopDong;
import com.example.quanlychothuenhatro.Adapter.KhachThue.KhachThue;

import java.util.ArrayList;

public class DBHelper extends SQLiteOpenHelper {
    public static final String DBNAME = "QuanLyNhaTro.db";

    public DBHelper(Context context) {
        super(context, "QuanLyNhaTro.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase MyDB) {
        MyDB.execSQL("create Table IF NOT EXISTS users(username Text primary key, password Interger)");
        MyDB.execSQL("create Table IF NOT EXISTS CaiDatGia(GiaDien Float primary key, GiaNuoc Float, GiaWifi Float)");
        MyDB.execSQL("create Table IF NOT EXISTS PhongTro(SoPhong INTEGER primary key, GiaPhong Float, DienTich Interger, GiaDien Float, GiaNuoc Float, GiaWifi Float) ");
        MyDB.execSQL("create Table IF NOT EXISTS KhachThue(SoPhong INTEGER UNIQUE , TenKhach Text primary key, GioiTinh String , SoDT Text, SoCCCD Text) ");
        MyDB.execSQL("create Table IF NOT EXISTS HopDong(SoPhong INTEGER , TenKhach Text primary key  , NgayBDThue Datetime, NgayHethanThue Datetime, Songuoithue Integer, Soluongxe Integer, TienCoc Float)");
        MyDB.execSQL("create Table IF NOT EXISTS HoaDon(SoPhong INTEGER , TenKhach Text  , NgayTaoHD Datetime, SoDien int, SoNuoc int,TienWifi Float, TienPhong Float ,ChiPhiKhac Float, TongTien Float ) ");
    }

    @Override
    public void onUpgrade(SQLiteDatabase MyDB, int oldVersion, int newVersion) {
        MyDB.execSQL("drop Table if exists users");
        MyDB.execSQL("drop Table if exists CaiDatGia");
        MyDB.execSQL("drop Table if exists PhongTro");
        MyDB.execSQL("drop Table if exists KhachThue");
        MyDB.execSQL("drop Table if exists HopDong");
        MyDB.execSQL("drop Table if exists HoaDon");
        onCreate(MyDB);
    }

    public Boolean insertData_User(String username, int password) {
        SQLiteDatabase MyDB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("username", username);
        contentValues.put("password", password);
        long result = MyDB.insert("users", null, contentValues);
        if (result == -1) return false;
        else return true;
    }

    public Boolean insertData_CaiDatGia(Float Giadien, Float Gianuoc, Float Giawifi) {
        SQLiteDatabase MyDB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("GiaDien", Giadien);
        contentValues.put("GiaNuoc", Gianuoc);
        contentValues.put("GiaWifi", Giawifi);
        long result = MyDB.insert("CaiDatGia", null, contentValues);
        if (result == -1) return false;
        else return true;
    }

    public Boolean insertData_PhongTro(int SoPhong, Float GiaPhong, int DienTich, Float GiaDien, Float GiaNuoc, Float GiaWifi) {
        SQLiteDatabase MyDB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("SoPhong", SoPhong);
        contentValues.put("GiaPhong", GiaPhong);
        contentValues.put("DienTich", DienTich);
        contentValues.put("GiaDien", GiaDien);
        contentValues.put("GiaNuoc", GiaNuoc);
        contentValues.put("GiaWifi", GiaWifi);
        long result = MyDB.insert("PhongTro", null, contentValues);
        if (result == -1) return false;
        else return true;
    }


    public Boolean insertData_KhachThue(int SoPhong, String TenKhach, String GioiTinh, String SoDT, String SoCCCD) {
        SQLiteDatabase MyDB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("SoPhong", SoPhong);
        contentValues.put("TenKhach", TenKhach);
        contentValues.put("GioiTinh", GioiTinh);
        contentValues.put("SoDT", SoDT);
        contentValues.put("SoCCCD", SoCCCD);
        long result = MyDB.insert("KhachThue", null, contentValues);
        if (result == -1) return false;
        else return true;
    }

    public Boolean insertData_HopDong(int SoPhong, String TenKhach, String NgayBDThue, String NgayHetHanThue, int SoNguoiThue, int SoLuongXe, Float TienCoc) {
        SQLiteDatabase MyDB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("SoPhong", SoPhong);
        contentValues.put("TenKhach", TenKhach);
        contentValues.put("NgayBDThue", NgayBDThue);
        contentValues.put("NgayHetHanThue", NgayHetHanThue);
        contentValues.put("SoNguoiThue", SoNguoiThue);
        contentValues.put("SoLuongXe", SoLuongXe);
        contentValues.put("TienCoc", TienCoc);
        long result = MyDB.insert("HopDong", null, contentValues);
        if (result == -1) return false;
        else return true;
    }

    public Boolean insertData_HoaDon(int SoPhong, String TenKhach, String NgayTaoHD, int SoDien, int SoNuoc, Float TienPhong, Float TienWifi, Float ChiPhiKhac, Float TongTien) {
        SQLiteDatabase MyDB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("SoPhong", SoPhong);
        contentValues.put("TenKhach", TenKhach);
        contentValues.put("NgayTaoHD", NgayTaoHD);
        contentValues.put("SoDien", SoDien);
        contentValues.put("SoNuoc", SoNuoc);
        contentValues.put("TienWifi", TienWifi);
        contentValues.put("TienPhong", TienPhong);
        contentValues.put("ChiPhiKhac", ChiPhiKhac);
        contentValues.put("TongTien", TongTien);
        long result = MyDB.insert("HoaDon", null, contentValues);
        if (result == -1) return false;
        else return true;
    }



    public Boolean checkusername(String username) {
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("Select * from users where username = ? ", new String[]{username});
        if (cursor.getCount() > 0)
            return true;
        else return false;
    }


    public Boolean checkusernamepassword(String username, int password) {
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("Select * from users where username = ? and password =?", new String[]{username, String.valueOf(password)});
        if (cursor.getCount() > 0)
            return true;
        else return false;
    }

    public ArrayList<Integer> getdssophong() {
        ArrayList<Integer> dssophong = new ArrayList<>();
        SQLiteDatabase MyDB = getReadableDatabase();
        Cursor cursor = MyDB.rawQuery(" SELECT * FROM PhongTro", new String[]{});
        while (cursor.moveToNext()) {
            int sophong = cursor.getInt(0);
            dssophong.add(sophong);
        }
        return dssophong;

    }

    public ArrayList<KhachThue> getdskhachthue() {
        ArrayList<KhachThue> dskhachthue = new ArrayList<>();
        SQLiteDatabase MyDB = getReadableDatabase();
        Cursor cursor = MyDB.rawQuery(" SELECT * FROM KhachThue", new String[]{});
        while (cursor.moveToNext()) {
            int SoPhong = cursor.getInt(0);
            String TenKhach = cursor.getString(1);
            String GioiTinh = cursor.getString(2);
            String SoDT = cursor.getString(3);
           String SoCCCD = cursor.getString(4);

            dskhachthue.add(new KhachThue(SoPhong, TenKhach,GioiTinh, SoDT, SoCCCD));
        }
        return dskhachthue;

    }

    public ArrayList<HopDong> getdshopdong() {
        ArrayList<HopDong> dshopdong = new ArrayList<>();
        SQLiteDatabase MyDB = getReadableDatabase();
        Cursor cursor = MyDB.rawQuery(" SELECT * FROM HopDong", new String[]{});
        while (cursor.moveToNext()) {
            int SoPhong = cursor.getInt(0);
            String TenKhach = cursor.getString(1);
            String NgayDBthue = cursor.getString(2);
            String Ngayhethanthue = cursor.getString(3);
            int Songuoithue = cursor.getInt(4);
            int Soluongxe = cursor.getInt(5);
            float TienCoc = cursor.getFloat(6);
            dshopdong.add(new HopDong(SoPhong, TenKhach, NgayDBthue, Ngayhethanthue, Songuoithue, Soluongxe, TienCoc));
        }
        return dshopdong;

    }

    public ArrayList<HoaDon> getdshoadon() {
        ArrayList<HoaDon> dshoadon = new ArrayList<>();
        SQLiteDatabase MyDB = getReadableDatabase();
        Cursor cursor = MyDB.rawQuery(" SELECT * FROM HoaDon", new String[]{});
        while (cursor.moveToNext()) {
            int SoPhong = cursor.getInt(0);
            String TenKhachThue = cursor.getString(1);
            String NgayTaohoadon = cursor.getString(2);
            int SoDien = cursor.getInt(3);
            int Sonuoc = cursor.getInt(4);
            float TienWifi = cursor.getFloat(5);
            float TienPhong = cursor.getFloat(6);
            float Chiphikhac = cursor.getFloat(7);
            float Tongtien = cursor.getFloat(8);
            dshoadon.add(new HoaDon(SoPhong, TenKhachThue, NgayTaohoadon, SoDien, Sonuoc, TienWifi, TienPhong, Chiphikhac, Tongtien));
        }

        return dshoadon;

    }

    public Gia getdsGia() {
        Gia gia = new Gia(0, 0);
        SQLiteDatabase MyDB = getReadableDatabase();
        Cursor cursor = MyDB.rawQuery(" SELECT * FROM CaiDatGia", new String[]{});
        while (cursor.moveToNext()) {
            float GiaDien = cursor.getFloat(0);
            float GiaNuoc = cursor.getFloat(1);
            float GiaWifi = cursor.getFloat(2);
            gia.setGiadien(GiaDien);
            gia.setGianuoc(GiaNuoc);
            gia.setGiawifi(GiaWifi);
        }

        return gia;

    }



    public String getKhachThue(int SoPhong) {
        String TenKhach = null;
        SQLiteDatabase MyDB = getReadableDatabase();

        Cursor cursor = MyDB.rawQuery(" SELECT * FROM KhachThue where Sophong=?", new String[]{String.valueOf(SoPhong)});
        while (cursor.moveToNext()) {
            TenKhach = cursor.getString(1);
        }

        return TenKhach;

    }


    public Float getGiaThue(int SoPhong) {
        Float GiaPhong = null;
        SQLiteDatabase MyDB = getReadableDatabase();

        Cursor cursor = MyDB.rawQuery(" SELECT * FROM PhongTro where Sophong=?", new String[]{String.valueOf(SoPhong)});
        while (cursor.moveToNext()) {
            GiaPhong = cursor.getFloat(1);
        }

        return GiaPhong;

    }

    public int getDientich(int SoPhong) {
        int DienTich = 0;
        SQLiteDatabase MyDB = getReadableDatabase();

        Cursor cursor = MyDB.rawQuery(" SELECT * FROM PhongTro where Sophong=?", new String[]{String.valueOf(SoPhong)});
        while (cursor.moveToNext()) {
            DienTich = cursor.getInt(2);
        }

        return DienTich;
    }



    public int delete_PhongTro(int SoPhong) {
        SQLiteDatabase MyDB = this.getWritableDatabase();
        return MyDB.delete("PhongTro", "SoPhong=?", new String[]{String.valueOf(SoPhong)});

    }
    public int delete_KhachThue(int SoPhong) {
        SQLiteDatabase MyDB = this.getWritableDatabase();
        return MyDB.delete("KhachThue", "SoPhong=?", new String[]{String.valueOf(SoPhong)});

    }
    public int delete_HopDong(int SoPhong) {
        SQLiteDatabase MyDB = this.getWritableDatabase();
        return MyDB.delete("HopDong", "SoPhong=?", new String[]{String.valueOf(SoPhong)});

    }
    public int delete_HoaDon(int SoPhong) {
        SQLiteDatabase MyDB = this.getWritableDatabase();
        return MyDB.delete("HoaDon", "SoPhong=?", new String[]{String.valueOf(SoPhong)});

    }

    public int delete_Gia()
    {
        SQLiteDatabase MyDB = this.getWritableDatabase();
        return  MyDB.delete("CaiDatGia",null,new String[]{});
    }

    public Boolean updateCaiDatGia(Float GiaDien, Float GiaNuoc, Float GiaWifi) {
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("GiaDien", GiaDien);
        contentValues.put("GiaNuoc", GiaNuoc);
        contentValues.put("GiaWifi", GiaWifi);
         if( DB.update("CaiDatGia", contentValues, null, new String[]{})!=0)
        {
            return true;
        }
         else {
             return  false;
         }

    }
    public  boolean Check_Gia(Float GiaDien,Float GiaNuoc,Float GiaWifi)
    {
        SQLiteDatabase DB = this.getReadableDatabase();
        Cursor cursor = DB.rawQuery(" SELECT * FROM CaiDatGia ", new String[]{});
       if(cursor.getCount()==0) {
         return   this.insertData_CaiDatGia(GiaDien, GiaNuoc, GiaWifi);
       }
       else {
          return  this.updateCaiDatGia(GiaDien,GiaNuoc,GiaWifi);

       }
    }
    public  boolean CheckKhach(int SoPhong)
    {
        SQLiteDatabase DB = this.getReadableDatabase();
        Cursor cursor = DB.rawQuery(" SELECT * FROM KhachThue where SoPhong=?", new String[]{String.valueOf(SoPhong)});
        if(cursor.getCount()!=0)
        {
            return true;
        }
        return  false;
    }

    public  boolean CheckKhachHD(String TenKhach)
    {
        SQLiteDatabase DB = this.getReadableDatabase();
        Cursor cursor = DB.rawQuery(" SELECT * FROM KhachThue,HopDong where KhachThue.TenKhach=?", new String[]{TenKhach});
        if(cursor.getCount()!=0)
        {
            return true;
        }
        return  false;
    }

    public int updateTaiKhoan(String username, String password) {
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues cv=new ContentValues();
        cv.put("username",username);
        cv.put("password",password.hashCode());
        return DB.update("users",cv,"username=?",new String[]{String.valueOf(username)});
    }

    public int updateSuaPhong(int SoPhong, int DienTich, Float GiaPhong) {
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues cv=new ContentValues();
        cv.put("DienTich",DienTich);
        cv.put("GiaPhong",GiaPhong);
       return DB.update("PhongTro",cv,"SoPhong="+SoPhong+"",new String[]{});
    }

    public int updateTTkhach(int SoPhong, String Sodt, String Socccd) {
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues cv=new ContentValues();
        cv.put("SoDT",Sodt);
        cv.put("SoCCCD",Socccd);
        return DB.update("KhachThue",cv,"SoPhong=?",new String[]{String.valueOf(SoPhong)});
    }

    public int updateHoaDon(int SoPhong, String NgayTaoHoaDon,int Sonuoc, int Sodien, Float ChiPhiKhac, Float TongTien ) {
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues cv=new ContentValues();
        cv.put("NgayTaoHD",NgayTaoHoaDon);
        cv.put("SoDien",Sodien);
        cv.put("SoNuoc",Sonuoc);
        cv.put("ChiPhiKhac",ChiPhiKhac);
        cv.put("TongTien",TongTien);
        return DB.update("HoaDon",cv,"SoPhong=?",new String[]{String.valueOf(SoPhong)});
    }


    public int Giahanhopdong(int sophong, String Ngayhh) {
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues cv=new ContentValues();
        cv.put("NgayHetHanThue",Ngayhh);
        return DB.update("HopDong",cv,"SoPhong=?",new String[]{String.valueOf(sophong)});
    }


    public Long getTongTienTheoThang(int thang,int nam) {
        Long TongTien= Long.getLong("0");
        SQLiteDatabase MyDB = getReadableDatabase();

        Cursor cursor = MyDB.rawQuery(" SELECT SUM(TongTien) as TongTien  from HoaDon where NgayTaoHD like '%/"+thang+"/"+nam+"'",new String[]{});
       while (cursor.moveToNext())
        {

            TongTien=cursor.getLong(0);

        }
        return TongTien;

    }

    public ArrayList<DoanhThuThang> getdsdoanhthuthang(int thang, int nam) {
        ArrayList<DoanhThuThang> dsDoanhthuthang = new ArrayList<>();
        SQLiteDatabase MyDB = getReadableDatabase();
        Cursor cursor = MyDB.rawQuery(" SELECT * from HoaDon where NgayTaoHD like '%/"+thang+"/"+nam+"'",new String[]{});
        while (cursor.moveToNext()) {
            int SoPhong = cursor.getInt(0);
            String TenKhachThue = cursor.getString(1);
            String NgayTaohoadon = cursor.getString(2);
            float Tongtien = cursor.getFloat(8);
            dsDoanhthuthang.add(new DoanhThuThang(SoPhong, TenKhachThue, NgayTaohoadon, Tongtien));
        }

        return dsDoanhthuthang;

    }

    public ArrayList<DoanhThuQuy> getdsdoanhthuquy(int t1,int t2,int t3,int t4, int nam) {


        ArrayList<DoanhThuQuy> dsDoanhthuquy = new ArrayList<>();
        SQLiteDatabase MyDB = getReadableDatabase();
        Cursor cursor = MyDB.rawQuery(" SELECT * from HoaDon where NgayTaoHD like '%/"+t1+"/"+nam+"' or NgayTaoHD like '%/"+t2+"/"+nam+"' or NgayTaoHD like '%/"+t3+"/"+nam+"' or NgayTaoHD like '%/"+t4+"/"+nam+"'",new String[]{} );
        while (cursor.moveToNext()) {
            int SoPhong = cursor.getInt(0);
            String TenKhachThue = cursor.getString(1);
            String NgayTaohoadon = cursor.getString(2);
            float Tongtien = cursor.getFloat(8);
            dsDoanhthuquy.add(new DoanhThuQuy(SoPhong, TenKhachThue, NgayTaohoadon, Tongtien));
        }

        return  dsDoanhthuquy;

    }

    public ArrayList<DoanhThuNam> getdsdoanhthunam( int nam) {
        ArrayList<DoanhThuNam> dsDoanhthutnam = new ArrayList<>();
        SQLiteDatabase MyDB = getReadableDatabase();
        Cursor cursor = MyDB.rawQuery(" SELECT * from HoaDon where NgayTaoHD like '%/%/"+nam+"'",new String[]{});
        while (cursor.moveToNext()) {
            int SoPhong = cursor.getInt(0);
            String TenKhachThue = cursor.getString(1);
            String NgayTaohoadon = cursor.getString(2);
            float Tongtien = cursor.getFloat(8);
            dsDoanhthutnam.add(new DoanhThuNam(SoPhong, TenKhachThue, NgayTaohoadon, Tongtien));
        }

        return dsDoanhthutnam;

    }
    public Long getTongTienTheoQuy(String sql) {
        Long TongTien = Long.getLong("0");

        SQLiteDatabase MyDB = getReadableDatabase();
        Cursor cursor=MyDB.rawQuery(sql,new String[]{});
        while (cursor.moveToNext())
        {

            TongTien=cursor.getLong(0);

        }
        return TongTien;



    }
    public Long getTongTienTheoNam(int nam) {
        Long TongTien = Long.getLong("0");

        SQLiteDatabase MyDB = getReadableDatabase();
        Cursor cursor = MyDB.rawQuery("SELECT SUM(TongTien) as TongTien  from HoaDon where NgayTaoHD like '%/" + nam + "'", new String[]{});
        while (cursor.moveToNext()) {

            TongTien = cursor.getLong(0);

        }
        return TongTien;
    }


}


























