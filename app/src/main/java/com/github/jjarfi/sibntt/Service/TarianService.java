package com.github.jjarfi.sibntt.Service;
import com.github.jjarfi.sibntt.Model.Tarian;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface TarianService {
    @GET("tarian/")
    Call<List<Tarian>> getAllTarian();
}
