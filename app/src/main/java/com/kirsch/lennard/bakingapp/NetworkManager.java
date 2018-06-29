package com.kirsch.lennard.bakingapp;

import android.content.Context;
import android.support.v7.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;


public class NetworkManager {
    public static final String RECIPE_SOURCE = "https://d17h27t6h515a5.cloudfront.net/topher/2017/May/59121517_baking/baking.json";
    public static final String RECIPE_QUEUE_TAG = "RecipeQueueTag";
    public static RequestQueue mRequestQueue;

    public static Recipe[] recipes;

    public static Recipe[] getRecipes(Context context, RecyclerView recyclerView){
        mRequestQueue = Volley.newRequestQueue(context);
        GsonRequest<Recipe[]> recipesRequest = new GsonRequest<Recipe[]>(RECIPE_SOURCE, Recipe[].class,
                new Response.Listener<Recipe[]>() {
                    @Override
                    public void onResponse(Recipe[] response) {
                        //TODO deal with Response
                        recipes = response;
                    }

                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                //TODO deal with Error
                recipes = new Recipe[0];
            }
        });
        return recipes;
    }
}
