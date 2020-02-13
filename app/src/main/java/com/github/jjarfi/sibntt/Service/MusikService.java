package com.github.jjarfi.sibntt.Service;


import com.github.jjarfi.sibntt.Model.Musik;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface MusikService {

    @GET("musik/")
    Call<List<Musik>> getAllMusik();
}
