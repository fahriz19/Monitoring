package com.elektro.monitorruangan.fragment;


import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.elektro.monitorruangan.R;
import com.elektro.monitorruangan.adapter.AcaraAdapter;
import com.elektro.monitorruangan.model.Acara;
import com.elektro.monitorruangan.model.Dosen;
import com.elektro.monitorruangan.model.ResponsModel;
import com.elektro.monitorruangan.rest.ApiClient;
import com.elektro.monitorruangan.rest.ApiInterface;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class ListDosenFragment extends Fragment {
    RecyclerView gridView;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager manager;
    List<Dosen> list = new ArrayList<>();
    ProgressDialog dialog;

    public ListDosenFragment() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        dialog = new ProgressDialog(getActivity());
        View view  = inflater.inflate(R.layout.fragment_list_dosen, container, false);
        gridView = (RecyclerView) view.findViewById(R.id.list_dosen);
        gridView.setHasFixedSize(true);
//        gridView.setLayoutManager(new LinearLayoutManager(getContext()));

        manager = new LinearLayoutManager(getContext());
        gridView.setLayoutManager(manager);
        dialog.setMessage("Loading...");
        dialog.setCancelable(false);
//        dialog.show();

        ApiInterface api = ApiClient.getClient().create(ApiInterface.class);
        Call<ResponsModel> getData = api.getDosen();
        getData.enqueue(new Callback<ResponsModel>() {
            @Override
            public void onResponse(Call<ResponsModel> call, Response<ResponsModel> response) {
                dialog.hide();
                Log.d("RETRO","Response : "+response.body().getKode());

//                staggeredGridLayoutManager = new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL);
//                staggeredGridLayoutManager.setGapStrategy(StaggeredGridLayoutManager.GAP_HANDLING_NONE);

                list = response.body().getResult();
                //adapter.notifyDataSetChanged();

                adapter = new AcaraAdapter(ListDosenFragment.this,list);
                adapter.notifyDataSetChanged();
                gridView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<ResponsModel> call, Throwable t) {
                dialog.hide();
                Log.d("RETRO","Failed : respon gagal,data tidak tertampil" + t.getMessage());
            }
        });

        return view;

    }

}
