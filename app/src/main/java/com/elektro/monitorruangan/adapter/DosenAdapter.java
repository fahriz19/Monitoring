package com.elektro.monitorruangan.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.elektro.monitorruangan.R;
import com.elektro.monitorruangan.fragment.MonitorFragment;
import com.elektro.monitorruangan.model.Dosen;

import java.util.List;
import java.util.zip.Inflater;

/**
 * Created by Fahriz on 4/16/2018.
 */

public class DosenAdapter extends BaseAdapter {
    private static LayoutInflater inflater = null;
    private List<Dosen> list;
    private Context context;


        public DosenAdapter(List<Dosen> list, Context context) {
        this.list = list;
        this.context = context;

        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    public class Holder{
        TextView tvNomor, tvNama, tvStatus, tvWaktu;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Holder holder = new Holder();
        View rowView;
        rowView = inflater.inflate(R.layout.grid_acara,null);
        holder.tvNomor = (TextView) rowView.findViewById(R.id.nomor);
        holder.tvNama = (TextView) rowView.findViewById(R.id.nama);
        holder.tvStatus = (TextView) rowView.findViewById(R.id.status);
        holder.tvWaktu = (TextView) rowView.findViewById(R.id.waktu);

        holder.tvNama.setText(list.get(position).getNama());
        holder.tvNomor.setText(list.get(position).getId());
        holder.tvStatus.setText(list.get(position).getStatus());
        holder.tvWaktu.setText(list.get(position).getWaktu());
        return rowView;
    }

}







