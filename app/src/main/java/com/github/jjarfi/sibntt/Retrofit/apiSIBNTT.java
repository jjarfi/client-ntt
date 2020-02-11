package com.github.jjarfi.sibntt.Retrofit;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.jjarfi.sibntt.Model.Suku;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface apiSIBNTT {

    @GET("suku")
    @JsonProperty("wrapper")
    Observable<List<Suku>> getBarner();


}
