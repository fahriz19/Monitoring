package com.elektro.monitorruangan.adapter;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.elektro.monitorruangan.R;
import com.elektro.monitorruangan.fragment.ListDosenFragment;
import com.elektro.monitorruangan.model.Acara;
import com.elektro.monitorruangan.model.Dosen;

import java.util.List;

/**
 * Created by Fahriz on 12/23/2017.
 */

public class AcaraAdapter extends RecyclerView.Adapter<AcaraAdapter.HolderData>{
    List<Dosen> list;
    ListDosenFragment context;

    public AcaraAdapter(ListDosenFragment context, List<Dosen> list) {
        this.context = context;
        this.list = list;
    }



    @Override
    public HolderData onCreateViewHolder(ViewGroup parent, int viewType) {

        View layout = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_acara,parent,false);
        HolderData holderData = new HolderData(layout);

        return holderData;
    }

    @Override

    public void onBindViewHolder(HolderData holder, int position) {
        Dosen dosen = (Dosen) getItem(position);
        holder.id.setText(dosen.getId());
        holder.nama.setText(dosen.getNama());
        holder.status.setText(dosen.getStatus());
        holder.waktu.setText (dosen.getWaktu());

        holder.dosen = dosen;
    }

    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    class HolderData extends RecyclerView.ViewHolder{
        TextView id,nama,status,waktu;
        Dosen dosen;

        public HolderData(View itemView) {
            super(itemView);

            id = (TextView)itemView.findViewById(R.id.nomor);
            nama = (TextView) itemView.findViewById(R.id.nama);
            status = (TextView) itemView.findViewById(R.id.status);
            waktu = (TextView) itemView.findViewById(R.id.waktu);



        }
    }

}
