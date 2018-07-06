package com.kirsch.lennard.bakingapp;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.RemoteViews;

import com.kirsch.lennard.bakingapp.Activities.MainActivity;

/**
 * Implementation of App Widget functionality.
 */
public class IngredientsWidgetProvider extends AppWidgetProvider {

    static void updateAppWidget(Context context, AppWidgetManager appWidgetManager, String text,
                                int appWidgetId) {

        CharSequence widgetText = context.getString(R.string.appwidget_text);
        // Construct the RemoteViews object
        RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.ingredients_widget_provider);
        if(text != null && !text.equals("")) {
            views.setTextViewText(R.id.appwidget_text, text);
        } else {
            views.setTextViewText(R.id.appwidget_text, widgetText);
        }

        Intent intent = new Intent(context, MainActivity.class);
        intent.putExtra(MainActivity.TEXT_ID, text);
        PendingIntent pendingIntent = PendingIntent.getActivity(context,0,intent,0);

        views.setOnClickPendingIntent(R.id.appwidget_text, pendingIntent);

        // Instruct the widget manager to update the widget
        appWidgetManager.updateAppWidget(appWidgetId, views);
    }

    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        // There may be multiple widgets active, so update all of them
        ShowIngredientsService.startActionUpdateIngredientsWidget(context, context.getString(R.string.ingredients));
    }

    public static void updateIngredientsWidgets(Context context, AppWidgetManager appWidgetManager, String text, int[] appWidgetIds){
        for (int appWidgetId : appWidgetIds){
            updateAppWidget(context, appWidgetManager,text, appWidgetId);
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
}

