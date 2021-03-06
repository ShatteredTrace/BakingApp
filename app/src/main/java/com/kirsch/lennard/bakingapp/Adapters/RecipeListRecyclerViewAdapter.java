package com.kirsch.lennard.bakingapp.Adapters;

import android.app.Activity;
import android.app.FragmentManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.kirsch.lennard.bakingapp.Activities.DetailActivity;
import com.kirsch.lennard.bakingapp.Activities.MainActivity;
import com.kirsch.lennard.bakingapp.Activities.RecipeStepDetailActivity;
import com.kirsch.lennard.bakingapp.Fragments.RecipeDetailFragment;
import com.kirsch.lennard.bakingapp.Fragments.RecipeListFragment;
import com.kirsch.lennard.bakingapp.Objects.Ingredient;
import com.kirsch.lennard.bakingapp.Objects.Recipe;
import com.kirsch.lennard.bakingapp.Objects.RecipeStep;
import com.kirsch.lennard.bakingapp.R;
import com.kirsch.lennard.bakingapp.ShowIngredientsService;

import java.util.ArrayList;

public class RecipeListRecyclerViewAdapter extends RecyclerView.Adapter<RecipeListRecyclerViewAdapter.ViewHolder> {

    public static final String RECIPE_STEP_ID = "recipeStepID";
    private Recipe recipe;
    private ArrayList<RecipeStep> recipeSteps;
    private LayoutInflater mInflater;
    private Context mContext;
    private boolean twoPane;
    RecipeListFragment mRecipeListFragment;

    public RecipeListRecyclerViewAdapter(Context context, ArrayList<RecipeStep> recipeSteps, Recipe recipe, boolean twoPane, RecipeListFragment homeFragment){
        this.mInflater = LayoutInflater.from(context);
        this.recipeSteps = recipeSteps;
        this.recipe = recipe;
        this.mContext = context;
        this.twoPane = twoPane;
        this.mRecipeListFragment = homeFragment;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.recipelist_recyclerview_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {
        if(position== 0){
            String ingredients = mContext.getResources().getString(R.string.ingredients_start) + " \n";
            for (Ingredient i : recipe.ingredients){
                if(i.quantity == Math.ceil(i.quantity)){
                    ingredients += "- " + (int) i.quantity + " " +  i.measure + " " + mContext.getResources().getString(R.string.of) +" " + i.ingredient + "\n";
                } else {
                    ingredients += i.quantity + " " + i.measure + " " + mContext.getResources().getString(R.string.of) + " " + i.ingredient + "\n";
                }
            }
            holder.recipeStepsTextView.setBackgroundResource(android.R.color.transparent);
            holder.recipeStepsTextView.setGravity(Gravity.START);

            holder.recipeStepsTextView.setText(ingredients);
            ShowIngredientsService.startActionUpdateIngredientsWidget(mContext, ingredients);
        }
        else {
            holder.recipeStepsTextView.setText(recipeSteps.get(position - 1).shortDescription);

            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(twoPane){
                        mRecipeListFragment.updateFlow(recipeSteps.get(position - 1));

                    }else {
                        Bundle b = new Bundle();
                        b.putParcelable(RECIPE_STEP_ID, recipeSteps.get(position - 1));

                        Intent intent = new Intent(mContext, RecipeStepDetailActivity.class);
                        intent.putExtra(MainActivity.BUNDLE_ID, b);
                        mContext.startActivity(intent);
                    }
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return recipeSteps.size() + 1;
    }

    public class ViewHolder extends  RecyclerView.ViewHolder {
        TextView recipeStepsTextView;

        public ViewHolder(View itemView){
            super(itemView);
            recipeStepsTextView = (TextView) itemView.findViewById(R.id.recipe_list_recycler_recipe_text);
        }
    }

    public RecipeStep getItem(int id){
        return recipeSteps.get(id);
    }

    public void setTwoPane(boolean twoPane) {
        this.twoPane = twoPane;
    }
}
