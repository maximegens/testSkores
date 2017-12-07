package com.maximegens.android.testskores.services;


import com.maximegens.android.testskores.data.beans.CountryFootball;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Interface Retrofit 2
 */
public interface SkoresService {

    public static final String ENDPOINT = "http://www.footballistic.net";

    @GET("/ws_base/public/listePays.php?idSport=1&codePays=fr_FR&idLangue=1036&device=a&idApp=1&version=2.4")
    Call<List<CountryFootball>> listCountry();


}
