package com.kirsch.lennard.bakingapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

public class MainActivity extends AppCompatActivity implements RecipeRecyclerViewAdapter.ItemClickListener {

    RecipeRecyclerViewAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setUpUI();


    }

    private void setUpUI(){
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_recipe_main);
        String[] data = new String[1];
        int numberOfColumns = 1;
        recyclerView.setLayoutManager(new GridLayoutManager(this, numberOfColumns));
        mAdapter = new RecipeRecyclerViewAdapter(this, data);
        mAdapter.setmClickListener(this);
        recyclerView.setAdapter(mAdapter);
    }

    @Override
    public void onItemClick(View view, int position) {
        //TODO
    }
}

/*
COMMON PROJECT REQUIREMENTS
TODO #1 App is written solely in the Java Programming Language

TODO #2 App utilizes stable release versions of all libraries, Gradle, and Android Studio.

GENERAL APP USAGE
TODO #3 App should display recipes from provided network resource.

TODO #4 App should allow navigation between individual recipes and recipe steps.

TODO #5 App uses RecyclerView and can handle recipe steps that include videos or images.

TODO #6 App conforms to common standards found in the Android Nanodegree General Project Guidelines.

COMPONENTS AND LIBRARIES
TODO #7 Application uses Master Detail Flow to display recipe steps and navigation between them.

TODO #8 Application uses Exoplayer to display videos.

TODO #9 Application properly initializes and releases video assets when appropriate.

TODO #10 Application should properly retrieve media assets from the provided network links. It should properly handle network requests.

TODO #11 Application makes use of Espresso to test aspects of the UI.

TODO #12 Application sensibly utilizes a third-party library to enhance the app's features. That could be helper library to interface with ContentProviders
if you choose to store the recipes, a UI binding library to avoid writing findViewById a bunch of times, or something similar.

HOMESCREEN WIDGET
TODO #13 Application has a companion homescreen widget.

TODO #14 Widget displays ingredient list for desired recipe.
 */