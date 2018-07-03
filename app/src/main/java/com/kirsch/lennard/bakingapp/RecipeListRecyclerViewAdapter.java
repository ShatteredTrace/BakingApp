package com.kirsch.lennard.bakingapp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class RecipeListRecyclerViewAdapter extends RecyclerView.Adapter<RecipeListRecyclerViewAdapter.ViewHolder> {

    private Recipe recipe;
    private RecipeStep[] recipeSteps = new RecipeStep[0];
    private LayoutInflater mInflater;
    private ItemClickListener mClickListener;

    RecipeListRecyclerViewAdapter(Context context, Recipe[] recipes, Recipe recipe){
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
        //TODO NOW
    }


    @Override
    public int getItemCount() {
        return recipeSteps.length;
    }

    public class ViewHolder extends  RecyclerView.ViewHolder implements View.OnClickListener{
        TextView recipeStepsTextView;

        ViewHolder(View itemView){
            super(itemView);
            recipeStepsTextView = (TextView) itemView.findViewById(R.id.recipe_list_recycler_recipe_text);
        }

        @Override
        public void onClick(View view) {
            if(mClickListener != null){
                mClickListener.onItemClick(view, getAdapterPosition());
            }
        }
    }

    RecipeStep getItem(int id){
        return recipeSteps[id];
    }

    void setmClickListener(ItemClickListener itemClickListener){
        this.mClickListener = itemClickListener;
    }
}
