package com.example.postlists.base.service;

import com.example.postlists.details.model.User;

import java.util.List;

import retrofit.http.GET;
import rx.Observable;

public interface UsersApi {

    @GET("/users")
    Observable<List<User>> getUsers();
}
