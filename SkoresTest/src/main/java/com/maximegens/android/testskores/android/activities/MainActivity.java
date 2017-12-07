package com.maximegens.android.testskores.android.activities;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import com.maximegens.android.testskores.data.beans.CountryFootball;
import com.maximegens.android.testskores.android.fragments.DetailCountryFragments;
import com.maximegens.android.testskores.android.fragments.ListCountryFragments;

/**
 * Main Activity.
 * Class with two fragments and FAB
 */
public class MainActivity extends AppCompatActivity implements ListCountryFragments.ListCountryFragmentsCallback {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        if(savedInstanceState == null){
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragmentLayout_list_country, ListCountryFragments.newInstance("Liste des pays"))
                    .commit();

            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragmentLayout_detail_country, DetailCountryFragments.newInstance("Détail"))
                    .commit();
        }

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, getString(R.string.send_mail), Snackbar.LENGTH_LONG)
                        .setAction(getString(R.string.action_mail), null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onCountrySelected(CountryFootball countryFootball) {
        createDetailFragment(countryFootball);
    }

    /**
     * Create a detail fragment with a football country selected or saved.
     * @param countryFootball a football country
     */
    private void createDetailFragment(CountryFootball countryFootball) {
        Bundle arguments = new Bundle();
        arguments.putParcelable(DetailCountryFragments.ARG_ITEM_ID, countryFootball);
        DetailCountryFragments fragment = DetailCountryFragments.newInstance("Détail");
        fragment.setArguments(arguments);
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragmentLayout_detail_country, fragment)
                .commit();
    }
}
