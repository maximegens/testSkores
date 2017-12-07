package com.maximegens.android.testskores.android.adapters;

import com.maximegens.android.testskores.data.beans.CountryFootball;

/**
 * Interface to communicate between adapter and fragments.
 */
public interface RecyclerViewListener {
    void onClickRecyclerView(CountryFootball countryFootball);
}
