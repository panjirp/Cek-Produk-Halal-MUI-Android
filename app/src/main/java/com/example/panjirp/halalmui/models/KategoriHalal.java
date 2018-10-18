package com.example.panjirp.halalmui.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by panjirp on 20/09/2017.
 */

public class KategoriHalal {
    @SerializedName("semua_kategori")
    @Expose
    private List<Data> results = new ArrayList<Data>();


    /**
     * @return The results
     */
    public List<Data> getResults() {
        return results;
    }

    /**
     * @param results The results
     */
    public void setResults(List<Data> results) {
        this.results = results;
    }

}