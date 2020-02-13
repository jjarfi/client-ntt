package com.github.jjarfi.sibntt.Service;

import com.github.jjarfi.sibntt.Model.Pakaian;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface PakaianService {
    @GET("pakaian/")
    Call<List<Pakaian>> getAllPakaian();
}
