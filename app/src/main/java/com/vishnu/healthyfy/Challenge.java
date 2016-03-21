package com.vishnu.healthyfy;

import android.os.Parcel;
import android.os.Parcelable;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by VISHNUPRASAD on 20/03/16.
 */
public class Challenge implements Parcelable {

    public Challenge()
    {

    }

    @JsonProperty("challenge_type")
    public String challengeType;

    @JsonProperty("college")
    public boolean isCollege;

    @JsonProperty("date")
    public String date;

    @JsonProperty("description")
    public String description;

    @JsonProperty("end_date")
    public String endDate;

    @JsonProperty("end_time")
    public String endTime;


    @JsonProperty("is_hackerearth")
    public boolean isHackerEarth;

    @JsonProperty("start_timestamp")
    public String startTimeStamp;

    @JsonProperty("status")
    public String status;

    @JsonProperty("subscribe")
    public String subscribeUrl;

    @JsonProperty("title")
    public String title;

    @JsonProperty("url")
    public  String url;

    protected Challenge(Parcel in) {
        challengeType = in.readString();
        isCollege = in.readByte() != 0;
        date = in.readString();
        description = in.readString();
        endDate = in.readString();
        endTime = in.readString();
        isHackerEarth = in.readByte() != 0;
        startTimeStamp = in.readString();
        status = in.readString();
        subscribeUrl = in.readString();
        title = in.readString();
        url = in.readString();
    }

    public static final Creator<Challenge> CREATOR = new Creator<Challenge>() {
        @Override
        public Challenge createFromParcel(Parcel in) {
            return new Challenge(in);
        }

        @Override
        public Challenge[] newArray(int size) {
            return new Challenge[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(challengeType);
        dest.writeByte((byte) (isCollege ? 1 : 0));
        dest.writeString(date);
        dest.writeString(description);
        dest.writeString(endDate);
        dest.writeString(endTime);
        dest.writeByte((byte) (isHackerEarth ? 1 : 0));
        dest.writeString(startTimeStamp);
        dest.writeString(status);
        dest.writeString(subscribeUrl);
        dest.writeString(title);
        dest.writeString(url);
    }
}
