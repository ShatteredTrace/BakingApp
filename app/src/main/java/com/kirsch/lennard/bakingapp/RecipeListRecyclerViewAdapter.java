package com.kirsch.lennard.bakingapp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class RecipeListRecyclerViewAdapter extends RecyclerView.Adapter<RecipeListRecyclerViewAdapter.ViewHolder> {

    private Recipe recipe;
    private ArrayList<RecipeStep> recipeSteps;
    private LayoutInflater mInflater;

    RecipeListRecyclerViewAdapter(Context context, ArrayList<RecipeStep> recipeSteps, Recipe recipe){
        this.mInflater = LayoutInflater.from(context);
        this.recipeSteps = recipeSteps;
        this.recipe = recipe;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.recipelist_recyclerview_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        if(position== 0){
            String ingredients = "You will need: \n";
            for (Ingredient i : recipe.ingredients){
                if(i.quantity == Math.ceil(i.quantity)){
                    ingredients += "- " + (int) i.quantity + " " +  i.measure + " of "+ i.ingredient + "\n";
                } else {
                    ingredients += i.quantity + " " + i.measure + " of " + i.ingredient + "\n";
                }
            }
            holder.recipeStepsTextView.setBackgroundResource(android.R.color.transparent);
            holder.recipeStepsTextView.setGravity(Gravity.START);

            holder.recipeStepsTextView.setText(ingredients);
        }
        else {
            holder.recipeStepsTextView.setText(recipeSteps.get(position - 1).shortDescription);
        }
    }

    @Override
    public int getItemCount() {
        return recipeSteps.size() + 1;
    }

    public class ViewHolder extends  RecyclerView.ViewHolder {
        TextView recipeStepsTextView;

        ViewHolder(View itemView){
            super(itemView);
            recipeStepsTextView = (TextView) itemView.findViewById(R.id.recipe_list_recycler_recipe_text);
        }
    }

    RecipeStep getItem(int id){
        return recipeSteps.get(id);
    }
}
