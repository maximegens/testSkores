package com.maximegens.android.testskores.data.beans;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Bean who represent a footbal country.
 */
public class CountryFootball implements Parcelable {

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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(id);
        parcel.writeString(name);
        parcel.writeString(urlImage);
        parcel.writeInt(nbEvents);
        parcel.writeInt(nbEventsLive);
    }

    public static final Parcelable.Creator<CountryFootball> CREATOR = new Parcelable.Creator<CountryFootball>() {
        @Override
        public CountryFootball createFromParcel(Parcel source) {
            return new CountryFootball(source);
        }
        @Override
        public CountryFootball[] newArray(int size) {
            return new CountryFootball[size];
        }
    };

    public CountryFootball(Parcel in) {
        this.id = in.readLong();
        this.name = in.readString();
        this.urlImage = in.readString();
        this.nbEvents = in.readInt();
        this.nbEventsLive = in.readInt();
    }
}
