package com.example.panjirp.halalmui.api;

import com.example.panjirp.halalmui.models.ProdukHalal;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by panjirp on 11/09/2017.
 */

public interface HalalService {

    @GET("halal/")
    Call<ProdukHalal> getProdukHalal(
            @Query("menu") String menu,
            @Query("query") String query,
            @Query("page") int pageIndex
    );
}

