package com.elektro.monitorruangan.fragment;


import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.elektro.monitorruangan.R;
import com.elektro.monitorruangan.adapter.AcaraAdapter;
import com.elektro.monitorruangan.adapter.AcaraGridAdapter;
import com.elektro.monitorruangan.adapter.SpaceItemDecorationGridView;
import com.elektro.monitorruangan.model.Acara;
import com.elektro.monitorruangan.model.Dosen;
import com.elektro.monitorruangan.model.ResponsModel;
import com.elektro.monitorruangan.rest.ApiClient;
import com.elektro.monitorruangan.rest.ApiInterface;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class MonitorFragment extends Fragment {
    RecyclerView gridView;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager manager;
    List<Dosen> mItems = new ArrayList<>();
    StaggeredGridLayoutManager staggeredGridLayoutManager;
    GridLayoutManager gridLayoutManager;
    Context context;
    ProgressDialog dialog;
    public MonitorFragment() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        dialog = new ProgressDialog(getActivity());
        View view = inflater.inflate(R.layout.fragment_monitor, container, false);
        gridView = (RecyclerView) view.findViewById(R.id.recycler_view);

//        getData();
        dialog.setMessage("Loading...");
        dialog.setCancelable(false);
        dialog.show();

        ApiInterface api = ApiClient.getClient().create(ApiInterface.class);
        Call<ResponsModel> getData = api.getDosen();
        getData.enqueue(new Callback<ResponsModel>() {
            @Override
            public void onResponse(Call<ResponsModel> call, Response<ResponsModel> response) {
                dialog.hide();
                Log.d("RETRO","Response : "+response.body().getKode());

                staggeredGridLayoutManager = new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL);
                staggeredGridLayoutManager.setGapStrategy(StaggeredGridLayoutManager.GAP_HANDLING_NONE);
                gridView.setLayoutManager(staggeredGridLayoutManager);
                gridLayoutManager = new GridLayoutManager(context,2);
                gridView.addItemDecoration(new SpaceItemDecorationGridView(context,2,2,2,2));
                mItems = response.body().getResult();
//                adapter.notifyDataSetChanged();

                adapter = new AcaraGridAdapter(MonitorFragment.this,mItems);
                gridView.setHasFixedSize(true);
                gridView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<ResponsModel> call, Throwable t) {
                dialog.hide();
                Log.d("RETRO","Failed : respon gagal,data tidak tertampil");
            }
        });

        return view;
    }
//    private void getData(){
//         final ProgressDialog dialog = new ProgressDialog(getActivity());
//        dialog.setMessage("Loading");
//        dialog.show();
//        ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);
//        Call<ResponsModel> listCall = apiInterface.getDosen();
//        listCall.enqueue(new Callback<ResponsModel>() {
//            @Override
//            public void onResponse(Call<ResponsModel> call, Response<ResponsModel> response) {
//                try {
//                    dialog.dismiss();
//                    mItems = response.body().getResult();
//                    AcaraAdapter acaraAdapter = new AcaraAdapter(dosenList,getActivity());
//                    gridView.setAdapter(acaraAdapter);
//
//                    Log.d("kesalahan",response.body().toString());
//                }catch (NullPointerException e){
//                    e.printStackTrace();
//                    Log.e("onResponse: ", e.getMessage());
//                }
//            }
//            @Override
//            public void onFailure(Call<ResponsModel> call, Throwable t) {
//                Log.e( "onFailure: ", t.getMessage());
//                dialog.dismiss();
//            }
//        });
//    }

}
