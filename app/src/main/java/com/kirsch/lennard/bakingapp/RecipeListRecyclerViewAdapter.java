package com.kirsch.lennard.bakingapp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class RecipeListRecyclerViewAdapter extends RecyclerView.Adapter<RecipeListRecyclerViewAdapter.ViewHolder> {

    private Recipe recipe;
    private ArrayList<RecipeStep> recipeSteps;
    private LayoutInflater mInflater;
    private ItemClickListener mClickListener;

    RecipeListRecyclerViewAdapter(Context context, ArrayList<RecipeStep> recipeSteps, Recipe recipe){
        this.mInflater = LayoutInflater.from(context);
        this.recipeSteps = this.recipeSteps;
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
            holder.recipeStepsTextView.setText(recipeSteps.get(position).shortDescription);

    }

    @Override
    public int getItemCount() {
        return recipeSteps.size();
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
