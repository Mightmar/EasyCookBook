package com.example.mariusz.easycookbook.Adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.example.mariusz.easycookbook.Data.CookBook;
import com.example.mariusz.easycookbook.Data.Recipe;
import com.example.mariusz.easycookbook.itemView.RecipeItemView;
import com.example.mariusz.easycookbook.itemView.RecipeItemView_;

import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.RootContext;

import java.util.ArrayList;
import java.util.List;


@EBean
public class RecipesListAdapter extends BaseAdapter {

    @RootContext
    Context context;

    List<Recipe> recipes = new ArrayList<Recipe>();

    public RecipesListAdapter() {
    }
    @Override
    public int getCount() {
        return recipes.size();
    }

    @Override
    public Recipe getItem(int i) {
        return recipes.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        RecipeItemView recipeItemView;
        if (convertView == null) {
            recipeItemView = RecipeItemView_.build(context);
        } else {
            recipeItemView = (RecipeItemView_) convertView;
        }
        recipeItemView.bind(getItem(position));
        return recipeItemView;
    }

    public void update(CookBook cookBook) {
        recipes.clear();
        recipes.addAll(cookBook.records);
        notifyDataSetChanged();
    }

}