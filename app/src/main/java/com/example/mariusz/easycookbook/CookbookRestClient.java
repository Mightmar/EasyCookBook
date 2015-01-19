package com.example.mariusz.easycookbook;

import com.example.mariusz.easycookbook.Data.CookBook;
import com.example.mariusz.easycookbook.Data.EmailAndPassword;
import com.example.mariusz.easycookbook.Data.Recipe;
import com.example.mariusz.easycookbook.Data.User;

import org.androidannotations.annotations.rest.Get;
import org.androidannotations.annotations.rest.Post;
import org.androidannotations.annotations.rest.RequiresHeader;
import org.androidannotations.annotations.rest.Rest;
import org.androidannotations.api.rest.RestClientHeaders;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;


@Rest(rootUrl = "http://pegaz.wzr.ug.edu.pl:8080/rest",
        converters = { MappingJackson2HttpMessageConverter.class })
@RequiresHeader({"X-Dreamfactory-Application-Name"})
public interface CookbookRestClient extends RestClientHeaders {

    @Get("/db/recipes")
    CookBook getCookBook();

    @Post("/user/session")
    User login(EmailAndPassword emailAndPassword);

    @Post("/user/register/?login=true")
    User register(EmailAndPassword emailAndPassword);

    @RequiresHeader({"X-Dreamfactory-Session-Token","X-Dreamfactory-Application-Name"})
    @Post("/db/recipes")
    Recipe addCookBookEntry(Recipe recipe);
}