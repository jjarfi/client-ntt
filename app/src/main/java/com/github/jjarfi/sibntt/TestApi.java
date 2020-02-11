package com.github.jjarfi.sibntt;

import android.os.AsyncTask;
import android.util.Log;

import com.github.jjarfi.sibntt.Model.Suku;

import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

public class TestApi {

    public void cobapanggilapi(){
        new HttpReqTask().execute();
    }

    private class HttpReqTask extends AsyncTask<Void, Void, Suku>{

        @Override
        protected Suku doInBackground(Void... params) {
            try {
                final String url = "http://192.168.43.224:8083/api/suku"; // the  url from where to fetch data(json)
                RestTemplate restTemplate = new RestTemplate();
                restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
                Suku info = restTemplate.getForObject(url, Suku.class);
                return info;
            } catch (Exception e) {
                Log.e("MainActivity", e.getMessage(), e);
            }

            return null;

        }

        @Override
        protected void onPostExecute(Suku sukus) {

                Log.i("Suku: ", "######################");
                Log.i("ID: ", String.valueOf(sukus.getId()));
                Log.i("NAMA: ", String.valueOf(sukus.getNamasuku()));
                Log.i("DESKRIPSI: ", String.valueOf(sukus.getDeskripsi()));
                Log.i("LINK: ", String.valueOf(sukus.getLink()));
                Log.i("Suku: ", "######################");
            }
        }

}
