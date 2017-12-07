package com.maximegens.android.testskores.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.maximegens.android.testskores.R;

/**
 * A detail view fragment for display name and image of country.
 */
public class DetailCountryFragments extends Fragment {

    /** Key for title **/
    private static final String TITLE = "TITLE";

    /** Instance of fragment **/
    public static DetailCountryFragments newInstance(String title) {
        DetailCountryFragments fragment = new DetailCountryFragments();
        Bundle args = new Bundle();
        args.putString(TITLE, title);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_detail_country, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
}
