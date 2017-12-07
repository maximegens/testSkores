package com.maximegens.android.testskores.android.fragments;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.maximegens.android.testskores.android.activities.MainActivity;
import com.maximegens.android.testskores.android.activities.R;
import com.maximegens.android.testskores.android.adapters.AdapterCountry;
import com.maximegens.android.testskores.android.adapters.RecyclerViewListener;
import com.maximegens.android.testskores.android.asynctask.AsyncResponse;
import com.maximegens.android.testskores.android.asynctask.ListCountryTask;
import com.maximegens.android.testskores.data.beans.CountryFootball;

import java.util.ArrayList;
import java.util.List;

/**
 * A fragment for display football country list.
 */
public class ListCountryFragments extends Fragment implements AsyncResponse, RecyclerViewListener {

    /** KEY to save data with savedInstance **/
    private static final String KEY_SAVED_LIST = "savedInstanceList";
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
    /** Progress for loading data **/
    private ProgressBar progressBar;
    /** indication text for loading **/
    private TextView labelProgressBar;

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
        recyclerViewCountry = (RecyclerView) view.findViewById(R.id.recyclerViewPays);
        progressBar = (ProgressBar) view.findViewById(R.id.progressbar_list_country);
        labelProgressBar = (TextView) view.findViewById(R.id.label_progress_bar_list_country);

        if (savedInstanceState != null && savedInstanceState.getParcelableArrayList(KEY_SAVED_LIST) != null){
            this.listCountry = savedInstanceState.getParcelableArrayList(KEY_SAVED_LIST);
            displayLoading(false);
        }else{
            // Get list football Country
            displayLoading(true);
            ListCountryTask listCountryTask = new ListCountryTask();
            listCountryTask.delegate = this;
            listCountryTask.execute();
        }

        adapterCountry = new AdapterCountry(listCountry, this);
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

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        savedInstanceState.putParcelableArrayList(KEY_SAVED_LIST, (ArrayList<? extends Parcelable>) this.listCountry);
        super.onSaveInstanceState(savedInstanceState);
    }

    @Override
    public void downloadFinish(List<CountryFootball> listCountry) {
        this.listCountry = listCountry;
        adapterCountry.setListCountry(listCountry);
        adapterCountry.notifyDataSetChanged();
        displayLoading(false);
    }

    @Override
    public void onClickRecyclerView(CountryFootball countryFootball) {
        listCountryFragmentsCallback.onCountrySelected(countryFootball);
    }

    /**
     * Display or hide a loading information
     * @param isDisplay a boolean
     */
    private void displayLoading(boolean isDisplay){
        progressBar.setVisibility(isDisplay ? View.VISIBLE : View.GONE);
        labelProgressBar.setVisibility(isDisplay ? View.VISIBLE : View.GONE);
        recyclerViewCountry.setVisibility(isDisplay ? View.GONE : View.VISIBLE);
    }

}
