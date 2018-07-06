package com.kirsch.lennard.bakingapp.Fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kirsch.lennard.bakingapp.Activities.DetailActivity;
import com.kirsch.lennard.bakingapp.Adapters.RecipeListRecyclerViewAdapter;
import com.kirsch.lennard.bakingapp.Objects.Recipe;
import com.kirsch.lennard.bakingapp.Objects.RecipeStep;
import com.kirsch.lennard.bakingapp.R;
import com.kirsch.lennard.bakingapp.Util.ItemClickListener;

public class RecipeListFragment extends Fragment{
    public static final String RECIPE_ID = "recipeID";
    private final String TWOPANE_ID = "twoPaneID";

    RecipeListRecyclerViewAdapter mAdapter;
    Recipe recipe;
    boolean twoPane;

    public RecipeListFragment(){}

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if(savedInstanceState != null){
            recipe = savedInstanceState.getParcelable(RECIPE_ID);
            twoPane = savedInstanceState.getBoolean(TWOPANE_ID);
        }

        final View rootView = inflater.inflate(R.layout.fragment_recipe_list, container, false);
        int numberOfColumns = 1;
        RecyclerView recyclerView = rootView.findViewById(R.id.recipe_list_fragment_recycler);
        recyclerView.setLayoutManager(new GridLayoutManager(inflater.getContext(), numberOfColumns));
        mAdapter = new RecipeListRecyclerViewAdapter(getContext(), recipe.steps, recipe, twoPane, RecipeListFragment.this);
        recyclerView.setAdapter(mAdapter);

        return rootView;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

    }

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        outState.putParcelable(RECIPE_ID, recipe);
        outState.putBoolean(TWOPANE_ID, twoPane);
    }

    public void setTwoPane(boolean twoPane) {
        this.twoPane = twoPane;
    }

    public void updateFlow(RecipeStep recipeStep){

        ((DetailActivity)getActivity()).updateFlow(recipeStep);
    }
}
