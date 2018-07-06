package com.kirsch.lennard.bakingapp.Activities;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.Volley;
import com.kirsch.lennard.bakingapp.Util.GsonRequest;
import com.kirsch.lennard.bakingapp.Util.ItemClickListener;
import com.kirsch.lennard.bakingapp.Objects.Recipe;
import com.kirsch.lennard.bakingapp.R;
import com.kirsch.lennard.bakingapp.Adapters.RecipeRecyclerViewAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements ItemClickListener {
    @BindView(R.id.recycler_recipe_main) RecyclerView recyclerView;

    public static final String RECIPE_SOURCE = "http://d17h27t6h515a5.cloudfront.net/topher/2017/May/59121517_baking/baking.json";
    public static final String RECIPE_ID = "recipeID";
    public static RequestQueue mRequestQueue;

    static RecipeRecyclerViewAdapter mAdapter;
    Recipe[] recipes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setUpUI();
    }

    private void setUpUI(){
        ButterKnife.bind(this);
        int numberOfColumns = 1;
        if(getResources().getBoolean(R.bool.isTablet)){
            numberOfColumns = 3;
        }
        recyclerView.setAdapter(null);
        recyclerView.setLayoutManager(new GridLayoutManager(this, numberOfColumns));
        getRecipes(this);

    }

    @Override
    public void onItemClick(View view, int position) {
        Toast.makeText(this, "test", Toast.LENGTH_LONG).show();
        Bundle b = new Bundle();
        b.putParcelable(RECIPE_ID, recipes[position]);

        Intent intent = new Intent(this, DetailActivity.class);
        intent.putExtras(b);
        startActivity(intent);
    }

    public void getRecipes(final Context context){
        mRequestQueue = Volley.newRequestQueue(context);
        GsonRequest<Recipe[]> recipesRequest = new GsonRequest<>(RECIPE_SOURCE, Recipe[].class,
                new Response.Listener<Recipe[]>() {
                    @Override
                    public void onResponse(Recipe[] response) {
                        recipes = response;
                        Log.i("LOG","Now setting up adapter");

                        mAdapter = new RecipeRecyclerViewAdapter(context, recipes);
                        //Adapter.setmClickListener(MainActivity.this);
                        recyclerView.setAdapter(mAdapter);
                        Log.i("LOG","Done");
                       // Toast.makeText(context, "Adapter should be full", Toast.LENGTH_SHORT).show();
                    }

                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                recipes = new Recipe[0];
                //Toast.makeText(context, error.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
        mRequestQueue.add(recipesRequest);
    }
}

/*
COMMON PROJECT REQUIREMENTS
TODO #1 App is written solely in the Java Programming Language

TODO #2 App utilizes stable release versions of all libraries, Gradle, and Android Studio.

GENERAL APP USAGE
COMPLETED #3 App should display recipes from provided network resource.

COMPLETED #4 App should allow navigation between individual recipes and recipe steps.

COMPLETED #5 App uses RecyclerView and can handle recipe steps that include videos or images.

TODO #6 App conforms to common standards found in the Android Nanodegree General Project Guidelines.

COMPONENTS AND LIBRARIES
COMPLETED #7 Application uses Master Detail Flow to display recipe steps and navigation between them.

COMPLETED #8 Application uses Exoplayer to display videos.

COMPLETED #9 Application properly initializes and releases video assets when appropriate.

COMPLETED #10 Application should properly retrieve media assets from the provided network links. It should properly handle network requests.

TODO #11 Application makes use of Espresso to test aspects of the UI.

COMPLETED #12 Application sensibly utilizes a third-party library to enhance the app's features. That could be helper library to interface with ContentProviders
if you choose to store the recipes, a UI binding library to avoid writing findViewById a bunch of times, or something similar.

HOMESCREEN WIDGET
TODO #13 Application has a companion homescreen widget.

TODO #14 Widget displays ingredient list for desired recipe.
 */

/*
I took inspitation / ideas to create the Exoplayer Fullscreen from:
    https://github.com/GeoffLedak/ExoplayerFullscreen
 */