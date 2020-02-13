package com.github.jjarfi.sibntt.Service;

import com.github.jjarfi.sibntt.Model.Sejarah;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface SejarahService {
    @GET("sejarah/")
    Call<List<Sejarah>> getAllSejarah();
}
