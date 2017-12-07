package com.maximegens.android.testskores.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.maximegens.android.testskores.activities.R;
import com.maximegens.android.testskores.data.beans.CountryFootball;


/**
 * A detail view fragment for display name and image of country.
 */
public class DetailCountryFragments extends Fragment {

    /** Key for title **/
    private static final String TITLE = "TITLE";

    /** KEY for item **/
    public static final String ARG_ITEM_ID = "country_id";

    /** Name of football country **/
    private TextView nameCountry;

    /** number event **/
    private TextView nbEvents;

    /** number event lives **/
    private TextView nbEventsLive;

    /** message select country **/
    private TextView selectCountry;

    /** ImageView **/
    private ImageView imageViewCountry;

    /** FootBall Country **/
    private CountryFootball countryFootball;

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

        selectCountry = (TextView) view.findViewById(R.id.detail_select_country);
        imageViewCountry = (ImageView) view.findViewById(R.id.detail_image_pays);
        nameCountry = (TextView) view.findViewById(R.id.detail_name_country);
        nbEvents = (TextView) view.findViewById(R.id.detail_nb_event_country);
        nbEventsLive = (TextView) view.findViewById(R.id.detail_nb_event_live_country);

        if (getArguments() != null && getArguments().containsKey(ARG_ITEM_ID)) {
            countryFootball = getArguments().getParcelable(ARG_ITEM_ID);
        }
        // Display or hide select country message
        selectCountry.setVisibility(countryFootball == null ? View.VISIBLE : View.GONE);

        // Fill country data
        if(countryFootball != null){
            nameCountry.setText(countryFootball.getName());
            nbEvents.setText(String.valueOf(countryFootball.getNbEvents()));
            nbEventsLive.setText(String.valueOf(countryFootball.getNbEventsLive()));
        }
    }
}
