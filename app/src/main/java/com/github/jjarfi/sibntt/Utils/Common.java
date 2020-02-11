package com.github.jjarfi.sibntt.Utils;

import com.github.jjarfi.sibntt.Retrofit.RetrofitClient;
import com.github.jjarfi.sibntt.Retrofit.apiSIBNTT;

public class Common {
    private static final String BASE_URL = "http://192.168.43.224:8083/api/suku";

    public static apiSIBNTT getAPI() {
        return RetrofitClient.getClient(BASE_URL).create(apiSIBNTT.class);
    }
}
