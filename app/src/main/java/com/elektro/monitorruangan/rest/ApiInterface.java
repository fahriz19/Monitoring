package com.elektro.monitorruangan.rest;

import com.elektro.monitorruangan.model.Acara;
import com.elektro.monitorruangan.model.Dosen;
import com.elektro.monitorruangan.model.ResponsModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Fahriz on 12/23/2017.
 */

public interface ApiInterface {
    @GET("monitor.php")
    Call<ResponsModel> getDosen();
}
