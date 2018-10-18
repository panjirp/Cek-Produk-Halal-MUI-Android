package com.example.panjirp.halalmui;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ProgressBar;

import com.example.panjirp.halalmui.api.ApiHalal;
import com.example.panjirp.halalmui.api.HalalService;
import com.example.panjirp.halalmui.api.KategoriService;
import com.example.panjirp.halalmui.models.Data;
import com.example.panjirp.halalmui.models.KategoriHalal;
import com.example.panjirp.halalmui.models.ProdukHalal;
import com.example.panjirp.halalmui.utils.PaginationScrollListener;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.content.ContentValues.TAG;

/**
 * Created by panjirp on 20/09/2017.
 */

public class Kategori extends AppCompatActivity {
    private static final String TAG = "HasilCari";
    KategoriAdapter adapter;
    LinearLayoutManager linearLayoutManager;
    RecyclerView rv;
    ProgressBar progressBar;
    private KategoriService movieService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.semua_kategori);
        rv = (RecyclerView) findViewById(R.id.main_recycler);
        progressBar = (ProgressBar) findViewById(R.id.main_progress);
        adapter = new KategoriAdapter(this);
        linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        rv.setLayoutManager(linearLayoutManager);
        rv.setItemAnimator(new DefaultItemAnimator());
        rv.setAdapter(adapter);
        //init service and load data
        movieService = ApiHalal.getClient().create(KategoriService.class);
        loadFirstPage();
        ItemClickSupport.addTo(rv)
                .setOnItemClickListener(new ItemClickSupport.OnItemClickListener() {
                    @Override
                    public void onItemClicked(RecyclerView recyclerView, int position, View v) {
                        // do it
                        Data data = adapter.getItem(position);
                        String halalUri = String.valueOf(data.getKategori_id());
                        Intent halalIntent = new Intent(Kategori.this, SelectedKategori.class);
                        halalIntent.putExtra("halalUri", halalUri);
                        startActivity(halalIntent);
                        Log.v(TAG, String.valueOf(data.getKategori_id()));
                    }
                });
    }


    private void loadFirstPage() {
        Log.d(TAG, "loadFirstPage: ");

        callTopRatedMoviesApi().enqueue(new Callback<KategoriHalal>() {
            @Override
            public void onResponse(Call<KategoriHalal> call, Response<KategoriHalal> response) {
                // Got data. Send it to adapter

                List<Data> results = fetchResults(response);
                progressBar.setVisibility(View.GONE);
                adapter.addAll(results);

            }

            @Override
            public void onFailure(Call<KategoriHalal> call, Throwable t) {
                t.printStackTrace();
                // TODO: 08/11/16 handle failure
            }
        });

    }

    /**
     * @param response extracts List<{@link Data>} from response
     * @return
     */
    private List<Data> fetchResults(Response<KategoriHalal> response) {
        KategoriHalal topRatedMovies = response.body();
        return topRatedMovies.getResults();
    }


    /**
     * Performs a Retrofit call to the top rated movies API.
     * Same API call for Pagination.
     * As {@link #} will be incremented automatically
     * by @{@link PaginationScrollListener} to load next page.
     */
    private Call<KategoriHalal> callTopRatedMoviesApi() {
        return movieService.getKategori(
                "semua_kategori"
        );
    }


}
