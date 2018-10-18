package com.example.panjirp.halalmui.api;

import com.example.panjirp.halalmui.models.KategoriHalal;
import com.example.panjirp.halalmui.models.ProdukHalal;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface KategoriService {

    @GET("halal/")
    Call<KategoriHalal> getKategori(
            @Query("menu") String menu

    );
}

