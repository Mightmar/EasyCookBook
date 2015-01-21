package com.example.mariusz.easycookbook;

import com.example.mariusz.easycookbook.Data.Recipe;
import com.example.mariusz.easycookbook.Data.User;

import org.androidannotations.annotations.Background;
import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.RootContext;
import org.androidannotations.annotations.UiThread;
import org.androidannotations.annotations.rest.RestService;

@EBean
public class RestRecipeBackgroundTask {

    @RootContext
    DodajPrzepisActivity activity;

    @RestService
    CookbookRestClient restClient;

    @Background
    void addCookBookEntry(Recipe recipe,String sessionId) {
        try {
            restClient.setHeader("X-Dreamfactory-Application-Name", "cookbook");
            restClient.setHeader("X-Dreamfactory-Session-Token",sessionId);
            restClient.addCookBookEntry(recipe);
            publishResult(recipe);
        } catch (Exception e) {
            publishError(e);
        }
    }

    @UiThread
    void publishResult(Recipe recipe) {
        activity.confirmSuccess(recipe);
    }

    @UiThread
    void publishError(Exception e) {
        activity.showError(e);
    }

}

