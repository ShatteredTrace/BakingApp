package com.kirsch.lennard.bakingapp.Activities;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.kirsch.lennard.bakingapp.Adapters.RecipeListRecyclerViewAdapter;
import com.kirsch.lennard.bakingapp.Fragments.RecipeDetailFragment;
import com.kirsch.lennard.bakingapp.Objects.RecipeStep;
import com.kirsch.lennard.bakingapp.R;

public class RecipeStepDetailActivity extends AppCompatActivity {
    RecipeStep recipeStep;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_step_detail);

        if(savedInstanceState == null){
            Intent intent = getIntent();
            Bundle b = intent.getBundleExtra(MainActivity.BUNDLE_ID);
            recipeStep = b.getParcelable(RecipeListRecyclerViewAdapter.RECIPE_STEP_ID);

            RecipeDetailFragment fragment = new RecipeDetailFragment();
            fragment.setRecipeStep(recipeStep);

            FragmentManager fragmentManager = getSupportFragmentManager();

            fragmentManager.beginTransaction().add(R.id.recipe_detail_container, fragment).commit();
        }
    }
}
