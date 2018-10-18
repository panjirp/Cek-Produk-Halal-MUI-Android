package com.example.panjirp.halalmui.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by panjirp on 11/09/2017.
 */

public class ProdukHalal {


    @SerializedName("data")
    @Expose
    private List<Data> results = new ArrayList<Data>();
    @SerializedName("next_page")
    @Expose
    private Integer nextPages;



    /**
     *
     * @return
     * The results
     */
    public List<Data> getResults() {
        return results;
    }

    /**
     *
     * @param results
     * The results
     */
    public void setResults(List<Data> results) {
        this.results = results;
    }


    /**
     *
     * @return
     * The totalPages
     */
    public Integer getNextPages() {
        return nextPages;
    }

    /**
     *
     * @param nextPages
     * The total_pages
     */
    public void setNextPages(Integer nextPages) {
        this.nextPages = nextPages;
    }

}
