package com.example.mariusz.easycookbook;

import com.example.mariusz.easycookbook.Data.CookBook;

import org.androidannotations.annotations.Background;
import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.RootContext;
import org.androidannotations.annotations.UiThread;
import org.androidannotations.annotations.rest.RestService;

import java.util.Collections;

@EBean
public class RestBackgroundTask {

    @RootContext
    MainActivity activity;

    @RestService
    CookbookRestClient restClient;

    @Background
    void getCookBook() {
        try {
            restClient.setHeader("X-Dreamfactory-Application-Name", "cookbook");
            CookBook cookBook = restClient.getCookBook();
            Collections.reverse(cookBook.records);//odwracanie kolejnosci listy
            publishResult(cookBook);
        } catch (Exception e) {
            publishError(e);
        }
    }


    @UiThread
    void publishResult(CookBook cookBook) {
        activity.updateCookbook(cookBook);
    }

    @UiThread
    void publishError(Exception e) {
        activity.showError(e);
    }

}
