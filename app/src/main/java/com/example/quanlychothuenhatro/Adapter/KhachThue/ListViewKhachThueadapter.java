package com.example.quanlychothuenhatro.Adapter.KhachThue;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.quanlychothuenhatro.R;

import java.util.ArrayList;
import java.util.List;

public class ListViewKhachThueadapter extends BaseAdapter {

    private  Context context;
    int layout;
    private List<KhachThue> dsKhachThue;


    @Override
    public int getCount() {
        return dsKhachThue.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    public ListViewKhachThueadapter(Context context, ArrayList<KhachThue> dsKhachThue, int layout ){
        this.context = context;
        this.dsKhachThue = dsKhachThue;
        this.layout = layout;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = layoutInflater.inflate(layout, null);
        TextView KhachThue = (TextView) convertView.findViewById(R.id.tvkhach);
        KhachThue.setText(dsKhachThue.get(position).getTenkhachthue());
        TextView GioiTinh = (TextView) convertView.findViewById(R.id.gioitinhkhach);
        GioiTinh.setText("Giới tính: "+dsKhachThue.get(position).getGioiTinh());
        TextView SoPhong = (TextView) convertView.findViewById(R.id.tvphong1);
        SoPhong.setText("Phòng "+String.valueOf(dsKhachThue.get(position).getSophong()));
        TextView SoDt = (TextView) convertView.findViewById(R.id.tvsdt);
        SoDt.setText( String.valueOf(dsKhachThue.get(position).getSoDT()));
        TextView Socccd = (TextView) convertView.findViewById(R.id.tvcccd);
        Socccd.setText(String.valueOf(dsKhachThue.get(position).getSoCCCD()));
        return convertView;

    }

}

