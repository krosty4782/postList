package com.example.postlists.base.service;

import com.example.postlists.posts.model.Post;

import java.util.List;

import rx.Observable;

public interface PostsService {

    Observable<List<Post>> getPosts();
}
