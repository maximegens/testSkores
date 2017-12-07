package com.maximegens.android.testskores.fragments;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.maximegens.android.testskores.R;
import com.maximegens.android.testskores.android.activities.MainActivity;
import com.maximegens.android.testskores.android.adapters.AdapterCountry;

import com.maximegens.android.testskores.data.beans.CountryFootball;

import java.util.ArrayList;
import java.util.List;

/**
 * A fragment for display football country list.
 */
public class ListCountryFragments extends Fragment{

    /** KEY for title**/
    private static final String TITLE = "TITLE";
    /** List of football country **/
    private List<CountryFootball> listCountry = new ArrayList<>();
    /** Callback for communicate to activity **/
    private ListCountryFragmentsCallback listCountryFragmentsCallback;
    /** recyclerView for display football country **/
    private RecyclerView recyclerViewCountry;
    /** Adapter for football country **/
    private AdapterCountry adapterCountry;

    /** Interface for communicate with activity **/
    public interface ListCountryFragmentsCallback {
        void onCountrySelected(CountryFootball countryFootball);
    }

    /** instance of fragment **/
    public static ListCountryFragments newInstance(String title) {
        ListCountryFragments fragment = new ListCountryFragments();
        Bundle args = new Bundle();
        args.putString(TITLE, title);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_list_country, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recyclerViewCountry = view.findViewById(R.id.recyclerViewPays);
        adapterCountry = new AdapterCountry(listCountry);
        recyclerViewCountry.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerViewCountry.setAdapter(adapterCountry);

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof MainActivity){
            listCountryFragmentsCallback = (ListCountryFragmentsCallback) context;
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        listCountryFragmentsCallback = null;
    }

}
