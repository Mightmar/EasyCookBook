package com.example.mariusz.easycookbook;

import android.app.ProgressDialog;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

import com.example.mariusz.easycookbook.Data.Recipe;
import com.example.mariusz.easycookbook.Data.User;


import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.Extra;
import org.androidannotations.annotations.NonConfigurationInstance;
import org.androidannotations.annotations.ViewById;


@EActivity(R.layout.activity_dodaj_przepis)
public class DodajPrzepisActivity extends ActionBarActivity {

    @Bean
    @NonConfigurationInstance
    RestRecipeBackgroundTask restRecipeBackgroundTask;

    @Extra
    User user;

    @ViewById
    EditText title;

    @ViewById
    EditText introduction;

    @ViewById
    EditText ingredients;

    @ViewById
    EditText steps;

    @ViewById
    EditText preparationMinutes;

    @ViewById
    EditText cookingMinutes;

    @ViewById
    EditText servings;

    ProgressDialog ringProgressDialog;

    @AfterViews
    void init(){
        ringProgressDialog = new ProgressDialog(this);
        ringProgressDialog.setMessage("Dodawanie przepisu...");
        ringProgressDialog.setIndeterminate(true);
    }





    @Click(R.id.buttonConfirm)
    void buttonConfirmClicked() {
        ringProgressDialog.show();
        Recipe recipe = new Recipe();
        recipe.ownerId = user.id;
        recipe.title = title.getText().toString();
        recipe.introduction = introduction.getText().toString();
        recipe.ingredients = ingredients.getText().toString();
        recipe.steps = steps.getText().toString();
        recipe.preparationMinutes = preparationMinutes.getText().toString();
        recipe.cookingMinutes = cookingMinutes.getText().toString();
        recipe.servings = servings.getText().toString();
        restRecipeBackgroundTask.addCookBookEntry(user, recipe);

        if ((title.length() == 0) || (ingredients.length() == 0) || (steps.length() == 0) || (servings.length() == 0)) {
            ringProgressDialog.dismiss();
            Toast.makeText(this, "Wszystkie pola muszą być wypełnione!", Toast.LENGTH_LONG).show();
        } else {
            restRecipeBackgroundTask.addCookBookEntry(user, recipe);
        }
    }

    public void confirmSuccess(Recipe recipe) {
        ringProgressDialog.dismiss();
        Toast.makeText(this, "Przepis dodany z sukcesem!", Toast.LENGTH_LONG).show();
        MainActivity_.intent(this).recipe(recipe).start();
    }

    public void showError(Exception e) {
        ringProgressDialog.dismiss();
        Toast.makeText(this, e.getMessage(), Toast.LENGTH_LONG).show();
        e.printStackTrace();
    }
}

//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_dodaj_przepis);
//    }
//
//
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.menu_dodaj_przepis, menu);
//        return true;
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        // Handle action bar item clicks here. The action bar will
//        // automatically handle clicks on the Home/Up button, so long
//        // as you specify a parent activity in AndroidManifest.xml.
//        int id = item.getItemId();
//
//        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//            return true;
//        }
//
//        return super.onOptionsItemSelected(item);
//    }
//}
