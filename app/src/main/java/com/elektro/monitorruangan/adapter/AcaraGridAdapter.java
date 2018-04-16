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
import com.elektro.monitorruangan.fragment.MonitorFragment;
import com.elektro.monitorruangan.model.Acara;
import com.elektro.monitorruangan.model.Dosen;

import java.util.List;

/**
 * Created by Fahriz on 12/23/2017.
 */
public class AcaraGridAdapter extends RecyclerView.Adapter<AcaraGridAdapter.HolderData>{
    List<Dosen> list;
    MonitorFragment context;

//    public AcaraGridAdapter(List<Dosen> list){
//
//    }

    public AcaraGridAdapter(MonitorFragment context, List<Dosen> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public HolderData onCreateViewHolder(ViewGroup parent, int viewType) {

        View layout = LayoutInflater.from(parent.getContext()).inflate(R.layout.grid_acara,parent,false);
        HolderData holderData = new HolderData(layout);

        return holderData;
    }

    @Override
    public void onBindViewHolder(AcaraGridAdapter.HolderData holder, int position) {
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
//public class AcaraGridAdapter extends BaseAdapter {
//    List<Dosen> ListItem;
//    Activity activity;
//    public AcaraGridAdapter(List<Dosen> listItem, Activity activity) {
//        ListItem = listItem;
//        this.activity = activity;
//    }
//    @Override
//    public int getCount() {
//        return ListItem.size();
//    }
//    @Override
//    public Object getItem(int position) {
//        return ListItem.get(position);
//    }
//    @Override
//    public long getItemId(int position) {
//        return 0;
//    }
//    @Override
//    public View getView(int position, View convertView, ViewGroup parent) {
//        View view = convertView;
//        AcaraGridAdapter.ViewHolder holder = null;
//        if (view == null) {
//            holder = new AcaraGridAdapter.ViewHolder();
//            LayoutInflater inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//            view = inflater.inflate(R.layout.grid_acara, null);
//            holder.id = (TextView) view.findViewById(R.id.nomor);
//            holder.nama = (TextView) view.findViewById(R.id.nama);
//            holder.status = (TextView) view.findViewById(R.id.status);
//            holder.waktu = (TextView) view.findViewById(R.id.waktu);
//            view.setTag(holder);
//        }else{
//            holder = (AcaraGridAdapter.ViewHolder)view.getTag();
//        }
//        Dosen acara = (Dosen) getItem(position);
//        holder.id.setText(acara.getId());
//        holder.nama.setText(acara.getNama());
//        holder.status.setText(acara.getStatus());
//        holder.waktu.setText (acara.getWaktu());
//
//        return view;
//
//    }
//
//    static class ViewHolder{
//
//        TextView id,nama,status,waktu;
//    }
//
//
//}
