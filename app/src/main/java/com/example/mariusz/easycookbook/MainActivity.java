package com.example.mariusz.easycookbook;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;

import android.widget.ListView;
import android.widget.Toast;

import com.example.mariusz.easycookbook.Adapter.RecipesListAdapter;
import com.example.mariusz.easycookbook.Data.CookBook;
import com.example.mariusz.easycookbook.Data.Recipe;
import com.example.mariusz.easycookbook.Data.User;


import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.Extra;
import org.androidannotations.annotations.ItemClick;
import org.androidannotations.annotations.NonConfigurationInstance;
import org.androidannotations.annotations.ViewById;


@EActivity(R.layout.activity_main)
 public class MainActivity extends ActionBarActivity {

    @Extra
    User user;

    @Extra
    Recipe recipe;

    @ViewById
    ListView list;

    @Bean
    RecipesListAdapter adapter;

    @Bean
    @NonConfigurationInstance
    RestBackgroundTask restBackgroundTask;

    ProgressDialog ringProgressDialog;

    @AfterViews
    void init() {
        list.setAdapter(adapter);
        ringProgressDialog = new ProgressDialog(this);
        ringProgressDialog.setMessage("Ładowanie...");
        ringProgressDialog.setIndeterminate(true);
    }

    @ItemClick
    void listItemClicked(Recipe recipe) {
        ThingsActivity_.intent(this).recipe(recipe).start();
    }

    @Click
    void refreshClicked() {
        ringProgressDialog.show();
        restBackgroundTask.getCookBook();
    }

    public void updateCookbook(CookBook cookBook) {
        ringProgressDialog.dismiss();
        adapter.update(cookBook);
    }

    public void showError(Exception e) {
        ringProgressDialog.dismiss();
        Toast.makeText(this, e.getMessage(), Toast.LENGTH_LONG).show();
        e.printStackTrace();
    }


    @Click(R.id.add)
    void click() {
        startActivity(new Intent(this, LoginActivity_.class));
    }
}



