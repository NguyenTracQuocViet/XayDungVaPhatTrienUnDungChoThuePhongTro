package com.example.quanlychothuenhatro.Adapter.HopDong;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import androidx.cardview.widget.CardView;

import com.example.quanlychothuenhatro.Adapter.DBHelper;
import com.example.quanlychothuenhatro.Adapter.KhachThue.KhachThue;
import com.example.quanlychothuenhatro.R;

import java.sql.Date;
import java.util.List;

public class ListViewHopDongadapter extends BaseAdapter {
    private Context context;
    int layout;
    private List<HopDong> dsHopDong;
    DBHelper DB;

    @Override
    public int getCount() {
        return dsHopDong.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    public ListViewHopDongadapter(Context context,List<HopDong> dsHopDong, int layout ){
        this.context = context;
        this.dsHopDong = dsHopDong ;
        this.layout = layout;
    }



    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = layoutInflater.inflate(layout, null);
        CardView cardView=(CardView)convertView.findViewById(R.id.hopdongcard);
        DB=new DBHelper(context);
        if(DB.CheckKhachHD(dsHopDong.get(position).getTenkhach()))
        {

        }
        else {
            cardView.setBackgroundColor(Color.rgb(230,0,0));

        }
        TextView KhachThue = (TextView) convertView.findViewById(R.id.nguoithuehopdong1);
        KhachThue.setText(dsHopDong.get(position).getTenkhach());
        TextView SoPhong = (TextView) convertView.findViewById(R.id.phonghopdong1);
        SoPhong.setText("Phòng: "+String.valueOf(dsHopDong.get(position).getSophong()));
        TextView NgayBDthue = (TextView) convertView.findViewById(R.id.ngaybdhopdong1);
        NgayBDthue.setText("Ngày bắt đầu: " +String.valueOf(dsHopDong.get(position).getNgayDBthue()));
        TextView NgayHH = (TextView) convertView.findViewById(R.id.tvngaykthopdong1);
        NgayHH.setText("Ngày hết hạn:" +String.valueOf(dsHopDong.get(position).getNgayhethanthue()));
        TextView Songuoithue = (TextView) convertView.findViewById(R.id.songuoihopdong1);
        Songuoithue.setText(String.valueOf(dsHopDong.get(position).getSonguoithue()));
        TextView Soxe = (TextView) convertView.findViewById(R.id.soxehopdong1);
        Soxe.setText(String.valueOf(dsHopDong.get(position).getSoluongxe()));
        TextView TienCoc = (TextView) convertView.findViewById(R.id.cochopdong1);
          TienCoc.setText("Tiền Cọc: " +String.valueOf(dsHopDong.get(position).getTienCoc()));

        return convertView;
    }
}
