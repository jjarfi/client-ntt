package com.github.jjarfi.sibntt.Service;

import com.github.jjarfi.sibntt.Model.Rumah;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RumahService {
    @GET("rumah/")
    Call<List<Rumah>> getAllRumah();
}
