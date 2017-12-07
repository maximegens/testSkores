package com.maximegens.android.testskores.android.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.maximegens.android.testskores.android.activities.R;
import com.maximegens.android.testskores.data.beans.CountryFootball;

import java.util.List;

/**
 * Adapter for a Football country items.
 */
public class AdapterCountry extends RecyclerView.Adapter<CountryViewHolder>{

    /** Listener for click **/
    private RecyclerViewListener recyclerViewListener;
    /** List of country **/
    private List<CountryFootball> listCountry;

    /**
     * Constructeur
     * @param list Football country list
     */
    public AdapterCountry(List<CountryFootball> list, RecyclerViewListener recyclerViewListener) {
        this.listCountry = list;
        this.recyclerViewListener = recyclerViewListener;
    }

    /**
     * Setters for a football country list
     * @param listCountry a new list to replace.
     */
    public void setListCountry(List<CountryFootball> listCountry) {
        this.listCountry = listCountry;
    }

    @Override
    public CountryViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_country, parent, false);
        return new CountryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CountryViewHolder holder, int position) {
        final CountryFootball country = listCountry.get(position);
        holder.bind(country);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                recyclerViewListener.onClickRecyclerView(country);
            }
        });
    }

    @Override
    public int getItemCount() {
        return listCountry.size();
    }
}
