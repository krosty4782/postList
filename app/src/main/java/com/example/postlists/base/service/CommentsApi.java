package com.example.postlists.base.service;

import com.example.postlists.details.model.Comment;

import java.util.List;

import retrofit.http.GET;
import rx.Observable;

public interface CommentsApi {

    @GET("/comments")
    Observable<List<Comment>> getComments();
}
