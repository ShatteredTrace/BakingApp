package com.kirsch.lennard.bakingapp;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class RecipeDetailFragment extends Fragment {
    public static final String RECIPE_ID = "recipe";

    private Recipe recipe;

    //Mandatory constructor for instantiating the fragment
    public RecipeDetailFragment(){

    }


    /*
    Inflates the fragment layout and sets resources
     */
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if(savedInstanceState != null){
            //TODO
        }

        View rootView = inflater.inflate(R.layout.fragment_recipe_detail, container, false);
        return rootView;
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        //TODO
        super.onSaveInstanceState(outState);
    }

    public Recipe getRecipe() {
        return recipe;
    }

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }
}
