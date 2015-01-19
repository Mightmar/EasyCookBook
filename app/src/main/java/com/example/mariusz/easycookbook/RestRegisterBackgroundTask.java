package com.example.mariusz.easycookbook;

import com.example.mariusz.easycookbook.Data.EmailAndPassword;
import com.example.mariusz.easycookbook.Data.User;

import org.androidannotations.annotations.Background;
import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.RootContext;
import org.androidannotations.annotations.UiThread;
import org.androidannotations.annotations.rest.RestService;

/**
 * Created by Mariusz on 2015-01-18.
 */
@EBean
public class RestRegisterBackgroundTask {

    @RootContext
    RegisterActivity activity;

    @RestService
    CookbookRestClient restClient;

    @Background
    void register(EmailAndPassword emailAndPassword) {
        try {
            restClient.setHeader("X-Dreamfactory-Application-Name", "cookbook");
            User user = restClient.register(emailAndPassword);
            publishResult(user);
        } catch (Exception e) {
            publishError(e);
        }
    }

    @UiThread
    void publishResult(User user) {
        activity.registerSuccess(user);
    }

    @UiThread
    void publishError(Exception e) {
        activity.showError(e);
    }

}
