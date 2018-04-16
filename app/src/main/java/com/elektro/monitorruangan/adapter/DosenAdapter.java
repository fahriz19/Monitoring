package com.elektro.monitorruangan.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.elektro.monitorruangan.R;
import com.elektro.monitorruangan.fragment.MonitorFragment;
import com.elektro.monitorruangan.model.Dosen;

import java.util.ArrayList;
import java.util.List;
import java.util.zip.Inflater;

/**
 * Created by Fahriz on 4/16/2018.
 */

public class DosenAdapter extends BaseAdapter {
    private static LayoutInflater inflater = null;
    private List<Dosen> list = new ArrayList<>();
    private Context context;

    public DosenAdapter(List<Dosen> list, Context context) {
        this.list = list;
        this.context = context;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public class Holder {
        TextView tvNomor, tvNama, tvStatus, tvWaktu;
        ImageView imgStatus;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Holder holder = new Holder();
        View rowView;
        rowView = inflater.inflate(R.layout.grid_acara, null);
        holder.tvNomor = (TextView) rowView.findViewById(R.id.nomor);
        holder.tvNama = (TextView) rowView.findViewById(R.id.nama);
        holder.tvStatus = (TextView) rowView.findViewById(R.id.status);
        holder.tvWaktu = (TextView) rowView.findViewById(R.id.waktu);
        holder.imgStatus = (ImageView) rowView.findViewById(R.id.img_status);

        holder.tvNama.setText(list.get(position).getNama());
        holder.tvNomor.setText(list.get(position).getId());
        holder.tvStatus.setText(list.get(position).getStatus());
        holder.tvWaktu.setText(list.get(position).getWaktu());
        String stat = list.get(position).getStatus();
        if (stat.equals("0")) {
            holder.imgStatus.setBackgroundColor(rowView.getResources().getColor(android.R.color.holo_red_light));
        } else {
            holder.imgStatus.setBackgroundColor(rowView.getResources().getColor(android.R.color.holo_green_light));
        }

        return rowView;
    }

}







