package com.github.jjarfi.sibntt.Service;

import com.github.jjarfi.sibntt.Model.Suku;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface SukuService {

    @GET("suku/")
    Call<List<Suku>> getAllSuku();
}
