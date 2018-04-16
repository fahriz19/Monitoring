package com.elektro.monitorruangan.fragment;


import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.Toast;

import com.elektro.monitorruangan.R;
import com.elektro.monitorruangan.adapter.DosenAdapter;
import com.elektro.monitorruangan.model.Dosen;
import com.elektro.monitorruangan.model.ResponsModel;
import com.elektro.monitorruangan.rest.ApiClient;
import com.elektro.monitorruangan.rest.ApiInterface;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class MonitorFragment extends Fragment {

    ProgressDialog dialog;
    GridView gridDosen;

    public MonitorFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        dialog = new ProgressDialog(getActivity());
        View view = inflater.inflate(R.layout.fragment_monitor, container, false);
        gridDosen = (GridView) view.findViewById(R.id.list_dosen);
        getData();
        return view;
    }

    private void getData() {
        ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class); //Inheritance
        Call<ResponsModel> modelCall = apiInterface.getDosen();
        modelCall.enqueue(new Callback<ResponsModel>() {
            @Override
            public void onResponse(Call<ResponsModel> call, Response<ResponsModel> response) {
                List<Dosen> dosenList = response.body().getResult();
                Toast.makeText(getContext(), "Success", Toast.LENGTH_SHORT).show();
                DosenAdapter dosenAdapter = new DosenAdapter(dosenList, getContext());
                gridDosen.setAdapter(dosenAdapter);
            }

            @Override
            public void onFailure(Call<ResponsModel> call, Throwable t) {
                Log.e("Error get nama", "onFailure: ", t);
            }
        });
    }
}
