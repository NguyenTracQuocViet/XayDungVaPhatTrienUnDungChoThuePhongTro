package com.example.quanlychothuenhatro.Adapter.HoaDon;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.quanlychothuenhatro.R;

import java.util.ArrayList;
import java.util.List;

public class ListViewHoaDonadapter extends BaseAdapter {

    private Context context;
    int layout;
    private List<HoaDon> dsHoaDon;

    @Override
    public int getCount() {
        return dsHoaDon.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    public ListViewHoaDonadapter(Context context, ArrayList<HoaDon> dsHoaDon, int layout ){
        this.context = context;
        this.dsHoaDon = dsHoaDon;
        this.layout = layout;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = layoutInflater.inflate(layout, null);
        TextView KhachThue = (TextView) convertView.findViewById(R.id.lnguoithuehoadon);
        KhachThue.setText(dsHoaDon.get(position).getTenkhach());
        TextView SoPhong = (TextView) convertView.findViewById(R.id.lphonghoadon);
        SoPhong.setText("Phòng "+String.valueOf(dsHoaDon.get(position).getSophong()));
        TextView NgayTaoHoaDon = (TextView) convertView.findViewById(R.id.lngaytaohoadon);
        NgayTaoHoaDon.setText("Ngày Tạo HĐ: " +String.valueOf(dsHoaDon.get(position).getNgayTaoHoaDon()));
        TextView SoDien = (TextView) convertView.findViewById(R.id.lsodienhoadon);
        SoDien.setText(String.valueOf("Số Điện: "+dsHoaDon.get(position).getSoDien()));
        TextView SoNuoc = (TextView) convertView.findViewById(R.id.lsonuochoadon);
        SoNuoc.setText(String.valueOf("Số Nước: "+String.valueOf(dsHoaDon.get(position).getSoNuoc())));
        TextView TongTien = (TextView) convertView.findViewById(R.id.ltongtienhoadon);
        TongTien.setText(String.valueOf("Tổng Tiền: "+dsHoaDon.get(position).getTongTien()));
        return convertView;
    }
}
