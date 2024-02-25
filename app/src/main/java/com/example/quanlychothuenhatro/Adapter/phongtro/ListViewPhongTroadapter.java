package com.example.quanlychothuenhatro.Adapter.phongtro;

import android.content.Context;
import android.graphics.Color;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import androidx.cardview.widget.CardView;

import com.example.quanlychothuenhatro.Adapter.DBHelper;
import com.example.quanlychothuenhatro.Adapter.KhachThue.KhachThue;
import com.example.quanlychothuenhatro.R;

import java.util.ArrayList;
import java.util.List;

public class ListViewPhongTroadapter extends BaseAdapter {
    private Context context;

    private List<Integer> dsPhong;
    int layout;
    DBHelper DB;


    @Override
    public int getCount() {
        return dsPhong.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    public ListViewPhongTroadapter(Context context, ArrayList<Integer> dsPhong, int layout) {
        this.context = context;
        this.dsPhong = dsPhong;
        this.layout = layout;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = layoutInflater.inflate(layout, null);
        CardView cardView=(CardView)convertView.findViewById(R.id.homecard);
        DB=new DBHelper(context);
        if(DB.CheckKhach(dsPhong.get(position)))
        {
            cardView.setBackgroundColor(Color.rgb(255,140,0));
        }
        else {

        }
        TextView SoPhong = (TextView) convertView.findViewById(R.id.tvsophong);
        SoPhong.setText("Phòng: "+dsPhong.get(position));
        return convertView;
    }
}

