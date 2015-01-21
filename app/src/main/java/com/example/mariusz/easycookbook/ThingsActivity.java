package com.example.mariusz.easycookbook;

import android.support.v7.app.ActionBarActivity;
import android.widget.TextView;

import com.example.mariusz.easycookbook.Data.Recipe;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.Extra;
import org.androidannotations.annotations.ViewById;

@EActivity(R.layout.activity_things)
public class ThingsActivity extends ActionBarActivity {

    @Extra
    Recipe recipe;
    @ViewById
    TextView title;
    @ViewById
    TextView introduction;
    @ViewById
    TextView ingredients;
    @ViewById
    TextView steps;
    @ViewById
    TextView created;
    @ViewById
    TextView preparationMinutes;
    @ViewById
    TextView cookingMinutes;
    @ViewById
    TextView servings;


    @AfterViews
    void init() {
        title.setText(recipe.title);
        introduction.setText(recipe.introduction);
        ingredients.setText(recipe.ingredients);
        steps.setText(recipe.steps);
        created.setText(recipe.created);
        preparationMinutes.setText(recipe.preparationMinutes);
        cookingMinutes.setText(recipe.cookingMinutes);
        servings.setText(recipe.servings);
    }
}
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_things);
//    }
//
//
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.menu_things, menu);
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
