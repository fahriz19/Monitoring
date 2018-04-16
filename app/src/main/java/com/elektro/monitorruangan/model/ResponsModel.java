package com.elektro.monitorruangan.model;

import java.util.List;

/**
 * Created by Fahriz on 4/5/2018.
 */

public class ResponsModel {

    String kode,pesan;
    List<Dosen> result;

    public List<Dosen> getResult(){
        return result;
    }

    public String getKode(){
        return kode;
    }

    public String getPesan(){
        return pesan;
    }

    public void setKode(String kode){
        this.kode = kode;
    }

    public void setPesan(String pesan){
        this.pesan = pesan;
    }
}
