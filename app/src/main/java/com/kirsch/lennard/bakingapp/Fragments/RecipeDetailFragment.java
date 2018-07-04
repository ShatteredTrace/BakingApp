package com.kirsch.lennard.bakingapp.Fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.kirsch.lennard.bakingapp.Objects.Recipe;
import com.kirsch.lennard.bakingapp.Objects.RecipeStep;
import com.kirsch.lennard.bakingapp.R;

public class RecipeDetailFragment extends Fragment {
    public static final String RECIPESTEP_ID = "recipeStepID";

    private RecipeStep recipeStep;

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
            recipeStep = savedInstanceState.getParcelable(RECIPESTEP_ID);
        }

        View rootView = inflater.inflate(R.layout.fragment_recipe_detail, container, false);

        TextView recipeStepInstruction = rootView.findViewById(R.id.recipe_detail_instruction_textview);
        recipeStepInstruction.setText(recipeStep.description);

        return rootView;
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        outState.putParcelable(RECIPESTEP_ID, recipeStep);
    }

    public RecipeStep getRecipeStep() {
        return recipeStep;
    }

    public void setRecipeStep(RecipeStep recipeStep) {
        this.recipeStep = recipeStep;
    }
}
