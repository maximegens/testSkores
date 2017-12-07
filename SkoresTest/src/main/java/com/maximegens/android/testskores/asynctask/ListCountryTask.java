package com.maximegens.android.testskores.asynctask;

import android.os.AsyncTask;
import android.util.Log;

import com.maximegens.android.testskores.asynctask.AsyncResponse;
import com.maximegens.android.testskores.data.beans.CountryFootball;
import com.maximegens.android.testskores.services.SkoresService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Asynctask for execute download in background
 */
public class ListCountryTask extends AsyncTask<String, Void, List<CountryFootball>> {

    /** Delegate for finish download **/
    public AsyncResponse delegate = null;

    @Override
    protected List<CountryFootball> doInBackground(String... strings) {

        SkoresService skoresService = new Retrofit.Builder()
                .baseUrl(SkoresService.ENDPOINT)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(SkoresService.class);

        List<CountryFootball> listCountry = new ArrayList<>();
        try {
            listCountry = skoresService.listCountry().execute().body();
        } catch (IOException e) {
            Log.e("Error WebService", e.getMessage());
        }
        return listCountry;
    }

    @Override
    protected void onPostExecute(List<CountryFootball> result) {
        delegate.downloadFinish(result);
    }

}
