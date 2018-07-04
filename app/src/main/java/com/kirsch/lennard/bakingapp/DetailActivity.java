package com.kirsch.lennard.bakingapp;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

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
           /* RecipeDetailFragment detailFragment = new RecipeDetailFragment();
            detailFragment.setRecipe(new Recipe());

            FragmentManager fragmentManager = getSupportFragmentManager();

            fragmentManager.beginTransaction().add(R.id.recipe_detail_container, detailFragment).commit();
                    */
        }
    }
}
