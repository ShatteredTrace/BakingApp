package com.kirsch.lennard.bakingapp;

import android.app.IntentService;
import android.appwidget.AppWidgetManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.util.Log;

public class ShowIngredientsService extends IntentService {
    public static final String ACTION_UPDATE_INGREDIENTS_WIDGET = "com.lennard.kirsch.bakingapp.action.update_ingredients";

    public ShowIngredientsService(){
        super("ShowIngredientsService");
    }

    public static void startActionUpdateIngredientsWidget(Context context, String text){
        Intent intent = new Intent(context, ShowIngredientsService.class);
        intent.setAction(ACTION_UPDATE_INGREDIENTS_WIDGET);
        intent.putExtra("test", text);
        context.startService(intent);
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        if(intent != null){
            final String action = intent.getAction();
            if(ACTION_UPDATE_INGREDIENTS_WIDGET.equals(action)){
                String text = intent.getStringExtra("test");
                handleActionUpdateIngredientsWidget(text);
            }
        }
    }

    private void handleActionUpdateIngredientsWidget(String text){
        Log.e("TAG", text);
        AppWidgetManager appWidgetManager = AppWidgetManager.getInstance(this);
        int[] appWidgetIds = appWidgetManager.getAppWidgetIds(new ComponentName(this, IngredientsWidgetProvider.class));

        IngredientsWidgetProvider.updateIngredientsWidgets(this, appWidgetManager, text, appWidgetIds);
    }
}
