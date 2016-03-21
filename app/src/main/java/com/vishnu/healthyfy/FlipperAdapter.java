package com.vishnu.healthyfy;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

/**
 * Created by VISHNUPRASAD on 20/03/16.
 */
public class FlipperAdapter extends ArrayAdapter<Challenge> {
private ChallengeList challengeList ;
    public FlipperAdapter(Context context, int resource,ChallengeList challengeList) {
        super(context, resource);
        this.challengeList = challengeList;
    }



    @Override
    public int getCount() {
        return challengeList.challenges.size();
    }

    @Override
    public Challenge getItem(int position) {
        return super.getItem(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        return super.getView(position, convertView, parent);
    }
}
