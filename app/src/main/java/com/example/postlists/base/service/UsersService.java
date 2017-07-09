package com.example.postlists.base.service;

import com.example.postlists.details.model.User;

import rx.Observable;

public interface UsersService {

    Observable<User> getUser(String userId);
}
