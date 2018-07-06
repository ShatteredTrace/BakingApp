package com.kirsch.lennard.bakingapp.Activities;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.kirsch.lennard.bakingapp.Fragments.RecipeDetailFragment;
import com.kirsch.lennard.bakingapp.Objects.Recipe;
import com.kirsch.lennard.bakingapp.Objects.RecipeStep;
import com.kirsch.lennard.bakingapp.R;
import com.kirsch.lennard.bakingapp.Fragments.RecipeListFragment;

public class DetailActivity extends AppCompatActivity{
    private boolean mTwoPane;
    Recipe recipe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        if(findViewById(R.id.master_flow_layout)!= null){
            mTwoPane = true;

            if (savedInstanceState == null) {
                Intent intent = getIntent();
                Bundle b = intent.getBundleExtra(MainActivity.BUNDLE_ID);
                recipe = b.getParcelable(MainActivity.RECIPE_ID);
                FragmentManager fragmentManager = getSupportFragmentManager();

                RecipeListFragment fragment = new RecipeListFragment();
                fragment.setRecipe(recipe);
                fragment.setTwoPane(true);

                fragmentManager.beginTransaction().add(R.id.master_recipe_list_container, fragment).commit();

                RecipeDetailFragment detailFragment = new RecipeDetailFragment();
                detailFragment.setRecipeStep(recipe.steps.get(0));
                detailFragment.setTwoPane(true);
                fragmentManager.beginTransaction().add(R.id.flow_recipe_detail_container, detailFragment).commit();
            }
        }
        else if (savedInstanceState == null) {
            Intent intent = getIntent();
            Bundle b = intent.getBundleExtra(MainActivity.BUNDLE_ID);
            recipe = b.getParcelable(MainActivity.RECIPE_ID);
            FragmentManager fragmentManager = getSupportFragmentManager();

            RecipeListFragment fragment = new RecipeListFragment();
            fragment.setRecipe(recipe);
            fragment.setTwoPane(false);

            fragmentManager.beginTransaction().add(R.id.recipe_list_container, fragment).commit();
        }
    }

    public void updateFlow(RecipeStep recipeStep){
        RecipeDetailFragment recipeDetailFragment = new RecipeDetailFragment();
        recipeDetailFragment.setRecipeStep(recipeStep);
        recipeDetailFragment.setTwoPane(false);

        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.flow_recipe_detail_container, recipeDetailFragment).commit();
    }
}