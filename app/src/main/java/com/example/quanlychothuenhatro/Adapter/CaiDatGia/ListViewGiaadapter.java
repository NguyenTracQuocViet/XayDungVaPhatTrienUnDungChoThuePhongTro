package com.example.quanlychothuenhatro.Adapter.CaiDatGia;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.quanlychothuenhatro.R;

import java.util.ArrayList;
import java.util.List;

public class ListViewGiaadapter extends BaseAdapter {
    private Context context;
    int layout;
    private List<Gia> dsGia;
    @Override
    public int getCount() {
        return dsGia.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    public ListViewGiaadapter(Context context, ArrayList<Gia> dsGia, int layout ){
        this.context = context;
        this.dsGia = dsGia;
        this.layout = layout;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = layoutInflater.inflate(layout, null);
        TextView GiaDien = (TextView) convertView.findViewById(R.id.tvgiadiencd);
        GiaDien.setText("Giá Điện: "+ dsGia.get(position).getGiadien());
        TextView GiaNuoc = (TextView) convertView.findViewById(R.id.tvgianuoccd);
        GiaNuoc.setText("Giá Nước: "+ dsGia.get(position).getGianuoc());

        return convertView;
    }
}
