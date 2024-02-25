package com.example.quanlychothuenhatro.Adapter.DoanhThu.DoanhThuNam;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.quanlychothuenhatro.R;

import java.util.ArrayList;
import java.util.List;

public class ListViewDoanhThuNamadapter extends BaseAdapter {
    private Context context;
    int layout;
    private List<DoanhThuNam> dsDoanhthunam;

    @Override
    public int getCount() {
        return dsDoanhthunam.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    public ListViewDoanhThuNamadapter(Context context, ArrayList<DoanhThuNam> dsDoanhthunam, int layout ){
        this.context = context;
        this.dsDoanhthunam = dsDoanhthunam;
        this.layout = layout;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = layoutInflater.inflate(layout, null);
        TextView KhachThue = (TextView) convertView.findViewById(R.id.lnguoithuedoanhthunam);
        KhachThue.setText(dsDoanhthunam.get(position).getTenkhach());
        TextView SoPhong = (TextView) convertView.findViewById(R.id.lphongdoanhthunam);
        SoPhong.setText("Phòng "+String.valueOf(dsDoanhthunam.get(position).getSophong()));
        TextView NgayTaoHoaDon = (TextView) convertView.findViewById(R.id.lngaytaohoadondoanhthunam);
        NgayTaoHoaDon.setText("Ngày Tạo HĐ: " +String.valueOf(dsDoanhthunam.get(position).getNgayTaoHoaDon()));
        TextView TongTien = (TextView) convertView.findViewById(R.id.ltongtienhoadondoanhthunam);
        TongTien.setText(String.valueOf("Tổng Tiền: "+dsDoanhthunam.get(position).getTongTien()));
        return convertView;
    }
}
