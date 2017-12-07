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
    private String imageURL;

    /** number event of country **/
    private int nbEvents;

    /** number of live events for country **/
    private int nbLiveEvents;

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

    public String getImageURL() {
        return imageURL;
    }

    public int getNbEvents() {
        return nbEvents;
    }

    public int getNbLiveEvents() {
        return nbLiveEvents;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(id);
        parcel.writeString(name);
        parcel.writeString(imageURL);
        parcel.writeInt(nbEvents);
        parcel.writeInt(nbLiveEvents);
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
        this.imageURL = in.readString();
        this.nbEvents = in.readInt();
        this.nbLiveEvents = in.readInt();
    }
}
