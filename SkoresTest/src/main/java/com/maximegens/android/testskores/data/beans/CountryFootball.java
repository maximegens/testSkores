package com.maximegens.android.testskores.data.beans;

/**
 * Bean who represent a footbal country.
 */
public class CountryFootball {

    /** id **/
    private long id;

    /** country name **/
    private String name;

    /** url image for country **/
    private String urlImage;

    /** number event of country **/
    private int nbEvents;

    /** number of live events for country **/
    private int nbEventsLive;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrlImage() {
        return urlImage;
    }

    public void setUrlImage(String urlImage) {
        this.urlImage = urlImage;
    }

    public int getNbEvents() {
        return nbEvents;
    }

    public void setNbEvents(int nbEvents) {
        this.nbEvents = nbEvents;
    }

    public int getNbEventsLive() {
        return nbEventsLive;
    }

    public void setNbEventsLive(int nbEventsLive) {
        this.nbEventsLive = nbEventsLive;
    }
}
