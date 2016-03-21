package com.vishnu.healthyfy;

import android.os.Parcel;
import android.os.Parcelable;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

/**
 * Created by VISHNUPRASAD on 20/03/16.
 */
public class ChallengeList implements Parcelable {

    public ChallengeList()
    {

    }
    @JsonProperty("response")
    public ArrayList<Challenge> challenges;

    protected ChallengeList(Parcel in) {
    }

    public static final Creator<ChallengeList> CREATOR = new Creator<ChallengeList>() {
        @Override
        public ChallengeList createFromParcel(Parcel in) {
            return new ChallengeList(in);
        }

        @Override
        public ChallengeList[] newArray(int size) {
            return new ChallengeList[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
    }
}
