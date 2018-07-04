package com.kirsch.lennard.bakingapp.Activities;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.kirsch.lennard.bakingapp.Objects.Recipe;
import com.kirsch.lennard.bakingapp.R;
import com.kirsch.lennard.bakingapp.Fragments.RecipeListFragment;

public class DetailActivity extends AppCompatActivity{
    Recipe recipe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        if (savedInstanceState == null) {
            Intent intent = getIntent();
            Bundle b = intent.getBundleExtra("bundle");
            recipe = b.getParcelable(MainActivity.RECIPE_ID);

            RecipeListFragment fragment = new RecipeListFragment();
            fragment.setRecipe(recipe);

            FragmentManager fragmentManager = getSupportFragmentManager();

            fragmentManager.beginTransaction().add(R.id.recipe_list_container, fragment).commit();
        }
    }
}
