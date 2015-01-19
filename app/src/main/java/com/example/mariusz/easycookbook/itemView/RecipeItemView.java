package com.example.mariusz.easycookbook.itemView;

import android.content.Context;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.mariusz.easycookbook.Data.Recipe;
import com.example.mariusz.easycookbook.R;

import org.androidannotations.annotations.EViewGroup;
import org.androidannotations.annotations.ViewById;

/**
 * Created by Mariusz on 2015-01-18.
 */
@EViewGroup(R.layout.list_item)
public class RecipeItemView extends RelativeLayout {

    @ViewById
    TextView title;

    @ViewById
    TextView introduction;

    @ViewById
    TextView acronym;

    public RecipeItemView(Context context) {
        super(context);
    }

    public void bind(Recipe recipe) {
        title.setText(recipe.title);
        introduction.setText(recipe.introduction);
        acronym.setText(recipe.title.substring(0,1));
    }
}
