package com.github.jjarfi.sibntt.Service;

import com.github.jjarfi.sibntt.Model.Makanan;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface MakananService {
    @GET("makanan/")
    Call<List<Makanan>> getAllMakanan();
}
