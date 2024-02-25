package com.example.quanlychothuenhatro.Adapter.DoanhThu.DoanhThuThang;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.quanlychothuenhatro.Adapter.HoaDon.HoaDon;
import com.example.quanlychothuenhatro.R;

import java.util.ArrayList;
import java.util.List;

public class ListViewDoanhThuThangadapter extends BaseAdapter {
    private Context context;
    int layout;
    private List<DoanhThuThang> dsDoanhthuthang;

    @Override
    public int getCount() {
        return dsDoanhthuthang.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    public ListViewDoanhThuThangadapter(Context context, ArrayList<DoanhThuThang> dsDoanhthuthang, int layout ){
        this.context = context;
        this.dsDoanhthuthang = dsDoanhthuthang;
        this.layout = layout;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = layoutInflater.inflate(layout, null);
        TextView KhachThue = (TextView) convertView.findViewById(R.id.lnguoithuedoanhthuthang);
        KhachThue.setText(dsDoanhthuthang.get(position).getTenkhach());
        TextView SoPhong = (TextView) convertView.findViewById(R.id.lphongdoanhthuthang);
        SoPhong.setText("Phòng "+String.valueOf(dsDoanhthuthang.get(position).getSophong()));
        TextView NgayTaoHoaDon = (TextView) convertView.findViewById(R.id.lngaytaohoadondoanhthuthang);
        NgayTaoHoaDon.setText("Ngày Tạo HĐ: " +String.valueOf(dsDoanhthuthang.get(position).getNgayTaoHoaDon()));
        TextView TongTien = (TextView) convertView.findViewById(R.id.ltongtienhoadondoanhthuthang);
        TongTien.setText(String.valueOf("Tổng Tiền: "+dsDoanhthuthang.get(position).getTongTien()));
        return convertView;
    }
}
