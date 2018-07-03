package com.kirsch.lennard.bakingapp;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        if (savedInstanceState == null) {

            RecipeDetailFragment detailFragment = new RecipeDetailFragment();
            detailFragment.setRecipe(new Recipe());

            FragmentManager fragmentManager = getSupportFragmentManager();

            fragmentManager.beginTransaction().add(R.id.recipe_detail_container, detailFragment).commit();
        }
    }
}
