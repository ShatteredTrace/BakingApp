package com.kirsch.lennard.bakingapp.Adapters;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.kirsch.lennard.bakingapp.Activities.DetailActivity;
import com.kirsch.lennard.bakingapp.Activities.MainActivity;
import com.kirsch.lennard.bakingapp.Objects.Recipe;
import com.kirsch.lennard.bakingapp.R;
import com.squareup.picasso.Picasso;

public class RecipeRecyclerViewAdapter extends RecyclerView.Adapter<RecipeRecyclerViewAdapter.ViewHolder>{

    private Context mContext;
    private Recipe[] recipes = new Recipe[0];
    private LayoutInflater mInflater;

    public RecipeRecyclerViewAdapter(Context context, Recipe[] recipes){
        this.mInflater = LayoutInflater.from(context);
        this.recipes = recipes;
        this.mContext = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view  = mInflater.from(parent.getContext()).inflate(R.layout.main_recyclerview_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        holder.recipeTextView.setText(recipes[position].name);
        if(recipes[position].image.length() > 0 && recipes[position].image != null) {
            Picasso.get().load(recipes[position].image).placeholder(R.drawable.placeholder).error(R.drawable.placeholder).into(holder.recipeImageView);
        } else {
            Picasso.get().load(R.drawable.placeholder).into(holder.recipeImageView);
        }

        holder.itemView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Bundle b = new Bundle();
                b.putParcelable(MainActivity.RECIPE_ID, recipes[position]);

                Intent intent = new Intent(mContext, DetailActivity.class);
                intent.putExtra(MainActivity.BUNDLE_ID, b);
                mContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return recipes.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView recipeImageView;
        TextView recipeTextView;

        public ViewHolder(View itemView){
            super(itemView);
            recipeTextView = (TextView) itemView.findViewById(R.id.recycler_recipe_name);
            recipeImageView = (ImageView) itemView.findViewById(R.id.recycler_recipe_image);
        }
    }

    public Recipe getItem(int id){
        return recipes[id];
    }

}
