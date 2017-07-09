package com.example.postlists.base.service;

import android.support.annotation.NonNull;

import com.example.postlists.details.model.User;

import java.util.HashMap;
import java.util.Map;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;

public class ApiUsersService implements UsersService {

    private UsersApi api;
    private Map<String, User> cache = new HashMap<>();

    public ApiUsersService(@NonNull UsersApi api) {
        this.api = api;
    }

    @Override
    public Observable<User> getUser(String userId) {
        if (cache.containsKey(userId)) {
            return Observable.just(cache.get(userId));
        }
        return api.getUsers()
                .flatMapIterable(userList -> userList)
                .filter(user -> user.getId().equals(userId))
                .map(user -> {
                    cache.put(userId, user);
                    return user;
                })
                .observeOn(AndroidSchedulers.mainThread());
    }
}
