package com.maximegens.android.testskores.android.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.maximegens.android.testskores.android.activities.R;
import com.maximegens.android.testskores.data.beans.CountryFootball;

/**
 * View Holder for footbal country adapter.
 */
public class CountryViewHolder extends RecyclerView.ViewHolder{

    /** Country name **/
    private TextView nameCountry;

    /**
     * Conctructor
     * @param itemView a item view.
     */
    public CountryViewHolder(View itemView) {
        super(itemView);
        nameCountry = (TextView) itemView.findViewById(R.id.item_country_label);

    }

    /**
     * binding values
     * @param countryFootball a objet countryFootball for binding
     */
    public void bind(CountryFootball countryFootball){
        nameCountry.setText(countryFootball.getName());
    }
}
