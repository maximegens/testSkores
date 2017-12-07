package com.maximegens.android.testskores.android.asynctask;

import com.maximegens.android.testskores.data.beans.CountryFootball;

import java.util.List;

/**
 * Interface for asynctask response
 */
public interface AsyncResponse {
    void downloadFinish(List<CountryFootball> listCountry);
}
