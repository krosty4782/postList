package com.example.postlists.base.service;

import android.support.annotation.NonNull;

import com.example.postlists.posts.model.Post;

import java.util.List;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;

public class ApiPostsService implements PostsService {

    private PostsApi api;

    public ApiPostsService(@NonNull PostsApi api) {
        this.api = api;
    }

    @Override
    public Observable<List<Post>> getPosts() {
        return api.getPosts().observeOn(AndroidSchedulers.mainThread());
    }
}
