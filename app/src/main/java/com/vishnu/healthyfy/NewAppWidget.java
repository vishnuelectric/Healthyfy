package com.vishnu.healthyfy;

import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.widget.RemoteViews;

/**
 * Implementation of App Widget functionality.
 * App Widget Configuration implemented in {@link NewAppWidgetConfigureActivity NewAppWidgetConfigureActivity}
 */
public class NewAppWidget extends AppWidgetProvider implements UpdateTask.OnDataLoaded {
NewAppWidget newAppWidget = new NewAppWidget();
    ChallengeList challengeList ;
     void updateAppWidget(Context context, AppWidgetManager appWidgetManager,
                                int appWidgetId) {

        // CharSequence widgetText = NewAppWidgetConfigureActivity.loadTitlePref(context, appWidgetId);
        // Construct the RemoteViews object
         RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.new_app_widget);

         final Intent intent = new Intent(context, WidgetService.class);
         intent.putExtra("challenges", challengeList);

         views.setRemoteAdapter(R.id.viewflipper, intent);


        // Instruct the widget manager to update the widget
        appWidgetManager.updateAppWidget(appWidgetId, views);
    }

    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        // There may be multiple widgets active, so update all of them
        System.out.println("update");
        for (int appWidgetId : appWidgetIds) {
            UpdateTask updateTask = new UpdateTask(newAppWidget);
            updateTask.execute();
            updateAppWidget(context, appWidgetManager, appWidgetId);
        }
    }

    @Override
    public void onDeleted(Context context, int[] appWidgetIds) {
        // When the user deletes the widget, delete the preference associated with it.
        for (int appWidgetId : appWidgetIds) {
            NewAppWidgetConfigureActivity.deleteTitlePref(context, appWidgetId);
        }
    }

    @Override
    public void onEnabled(Context context) {
        // Enter relevant functionality for when the first widget is created
    }

    @Override
    public void onDisabled(Context context) {
        // Enter relevant functionality for when the last widget is disabled
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        super.onReceive(context, intent);
    }

    @Override
    public void loadedData(ChallengeList challengeList) {
     this.challengeList = challengeList;
    }
}

