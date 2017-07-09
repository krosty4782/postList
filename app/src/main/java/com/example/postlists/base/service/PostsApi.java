package com.example.postlists.base.service;

import com.example.postlists.posts.model.Post;

import java.util.List;

import retrofit.http.GET;
import rx.Observable;

public interface PostsApi {

    @GET("/posts")
    Observable<List<Post>> getPosts();
}
