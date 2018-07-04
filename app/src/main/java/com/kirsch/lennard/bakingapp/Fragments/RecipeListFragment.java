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

import com.kirsch.lennard.bakingapp.Adapters.RecipeListRecyclerViewAdapter;
import com.kirsch.lennard.bakingapp.Objects.Recipe;
import com.kirsch.lennard.bakingapp.R;
import com.kirsch.lennard.bakingapp.Util.ItemClickListener;

public class RecipeListFragment extends Fragment{

    ItemClickListener mCallback;
    RecipeListRecyclerViewAdapter mAdapter;
    Recipe recipe;

    public RecipeListFragment(){}

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.fragment_recipe_list, container, false);
        int numberOfColumns = 1;
        RecyclerView recyclerView = rootView.findViewById(R.id.recipe_list_fragment_recycler);
        recyclerView.setLayoutManager(new GridLayoutManager(inflater.getContext(), numberOfColumns));
        mAdapter = new RecipeListRecyclerViewAdapter(getContext(), recipe.steps, recipe);
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
}
