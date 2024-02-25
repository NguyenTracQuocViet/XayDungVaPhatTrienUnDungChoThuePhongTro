package com.example.quanlychothuenhatro.Adapter.DoanhThu.DoanhThuQuy;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.quanlychothuenhatro.R;

import java.util.ArrayList;
import java.util.List;

public class ListViewDoanhThuQuyadapter extends BaseAdapter {
    private Context context;
    int layout;
    private List<DoanhThuQuy> dsDoanhthuquy;

    @Override
    public int getCount() {
        return dsDoanhthuquy.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    public ListViewDoanhThuQuyadapter(Context context, ArrayList<DoanhThuQuy> dsDoanhthuquy, int layout ){
        this.context = context;
        this.dsDoanhthuquy = dsDoanhthuquy;
        this.layout = layout;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = layoutInflater.inflate(layout, null);
        TextView KhachThue = (TextView) convertView.findViewById(R.id.lnguoithuedoanhthuquy);
        KhachThue.setText(dsDoanhthuquy.get(position).getTenkhach());
        TextView SoPhong = (TextView) convertView.findViewById(R.id.lphongdoanhthuquy);
        SoPhong.setText("Phòng "+String.valueOf(dsDoanhthuquy.get(position).getSophong()));
        TextView NgayTaoHoaDon = (TextView) convertView.findViewById(R.id.lngaytaohoadondoanhthuquy);
        NgayTaoHoaDon.setText("Ngày Tạo HĐ: " +String.valueOf(dsDoanhthuquy.get(position).getNgayTaoHoaDon()));
        TextView TongTien = (TextView) convertView.findViewById(R.id.ltongtienhoadondoanhthuquy);
        TongTien.setText(String.valueOf("Tổng Tiền: "+dsDoanhthuquy.get(position).getTongTien()));
        return convertView;
    }
}
