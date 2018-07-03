package com.kirsch.lennard.bakingapp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class RecipeRecyclerViewAdapter extends RecyclerView.Adapter<RecipeRecyclerViewAdapter.ViewHolder>{

    private Recipe[] recipes = new Recipe[0];
    private LayoutInflater mInflater;
    private ItemClickListener mClickListener;

    RecipeRecyclerViewAdapter(Context context, Recipe[] recipes){
        this.mInflater = LayoutInflater.from(context);
        this.recipes = recipes;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view  = mInflater.inflate(R.layout.main_recyclerview_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.recipeTextView.setText(recipes[position].name);
        if(recipes[position].image.length() > 0 && recipes[position].image != null) {
            Picasso.get().load(recipes[position].image).placeholder(R.drawable.placeholder).error(R.drawable.placeholder).into(holder.recipeImageView);
        } else {
            Picasso.get().load(R.drawable.placeholder).into(holder.recipeImageView);
        }
    }

    @Override
    public int getItemCount() {
        return recipes.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        ImageView recipeImageView;
        TextView recipeTextView;

        ViewHolder(View itemView){
            super(itemView);
            recipeTextView = (TextView) itemView.findViewById(R.id.recycler_recipe_name);
            recipeImageView = (ImageView) itemView.findViewById(R.id.recycler_recipe_image);
        }

        @Override
        public void onClick(View view) {
            if (mClickListener != null){
                mClickListener.onItemClick(view, getAdapterPosition());
            }
        }
    }

    Recipe getItem(int id){
        return recipes[id];
    }

    void setmClickListener(ItemClickListener itemClickListener){
        this.mClickListener = itemClickListener;
    }
}
