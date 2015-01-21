package com.example.mariusz.easycookbook;

import android.app.ProgressDialog;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

import com.example.mariusz.easycookbook.Data.EmailAndPassword;
import com.example.mariusz.easycookbook.Data.User;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.NonConfigurationInstance;
import org.androidannotations.annotations.ViewById;

@EActivity(R.layout.activity_register)
public class RegisterActivity extends ActionBarActivity {

    @ViewById
    EditText name;
    @ViewById
    EditText last_name;
    @ViewById
    EditText email;
    @ViewById
    EditText password;
    @Bean
    @NonConfigurationInstance
    RestRegisterBackgroundTask restRegisterBackgroundTask;

    ProgressDialog ringProgressDialog;

    @Click(R.id.registerButton)
    void registerButtonClicked(){
        ringProgressDialog.show();
        EmailAndPassword emailAndPassword= new EmailAndPassword();
        emailAndPassword.email = email.getText().toString();
        emailAndPassword.name = name.getText().toString();
        emailAndPassword.last_name=last_name.getText().toString();
        emailAndPassword.password=password.getText().toString();
        restRegisterBackgroundTask.register(emailAndPassword);

    }
    @AfterViews
    void init () {
        ringProgressDialog = new ProgressDialog(this);
        ringProgressDialog.setMessage("trwa rejestracja");
        ringProgressDialog.setIndeterminate(true);

    }
    public void registerSuccess(User user){
        ringProgressDialog.dismiss();
        DodajPrzepisActivity_.intent(this).user(user).start();
        Toast.makeText(this, "Witaj "+ name.getText(), Toast.LENGTH_LONG).show();
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
//        setContentView(R.layout.activity_register);
//    }
//
//
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.menu_register, menu);
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
