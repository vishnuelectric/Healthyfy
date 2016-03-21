package com.vishnu.healthyfy;

import android.appwidget.AppWidgetManager;
import android.content.Intent;
import android.util.Log;
import android.widget.RemoteViews;
import android.widget.RemoteViewsService;

import java.util.Date;

/**
 * Created by VISHNUPRASAD on 20/03/16.
 */
public class WidgetService extends RemoteViewsService {
    private static final String TAG = WidgetService.class
            .getSimpleName();





    @Override
    public RemoteViewsFactory onGetViewFactory(Intent intent) {
        Log.d(TAG, "onGetViewFactory()");


        return new ViewFactory(intent);
    }


    private class ViewFactory implements RemoteViewsService.RemoteViewsFactory {

        private int mInstanceId = AppWidgetManager.INVALID_APPWIDGET_ID;
        private Date mUpdateDate = new Date();
ChallengeList challengeList;
        public ViewFactory(Intent intent) {
          challengeList = intent.getParcelableExtra("challenges");
        }


        @Override
        public void onCreate() {
            Log.i(TAG, "onCreate()");


        }


        @Override
        public void onDataSetChanged() {
            Log.i(TAG, "onDataSetChanged()");


            mUpdateDate = new Date();
        }


        @Override
        public void onDestroy() {
            Log.i(TAG, "onDestroy()");
        }


        @Override
        public int getCount() {
            Log.i(TAG, "getCount() " + challengeList.challenges.size());


            return challengeList.challenges.size();
        }


        @Override
        public RemoteViews getViewAt(int position) {
            Log.i(TAG, "getViewAt()" + position);


            RemoteViews page = new RemoteViews(getPackageName(), R.layout.widget_layout);
            page.setTextViewText(R.id.challenge_title,challengeList.challenges.get(position).title);


            return page;
        }


        @Override
        public RemoteViews getLoadingView() {
            Log.i(TAG, "getLoadingView()");

            return new RemoteViews(getPackageName(), R.layout.loading);
        }


        @Override
        public int getViewTypeCount() {
            Log.i(TAG, "getViewTypeCount()");


            return challengeList.challenges.size();
        }


        @Override
        public long getItemId(int position) {
            Log.i(TAG, "getItemId()");


            return position;
        }


        @Override
        public boolean hasStableIds() {
            Log.i(TAG, "hasStableIds()");


            return true;
        }


    }
}
