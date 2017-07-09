package com.example.postlists.base.service;

import android.support.annotation.NonNull;

import com.example.postlists.details.model.Comment;
import com.example.postlists.details.model.User;

import java.util.List;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;

public class ApiCommentsService implements CommentsService {

    private CommentsApi api;

    public ApiCommentsService(@NonNull CommentsApi api) {
        this.api = api;
    }

    @Override
    public Observable<List<Comment>> getComments(String postId) {
        return api.getComments()
                .flatMapIterable(commentList -> commentList)
                .filter(comment -> comment.getPostId().equals(postId))
                .toList()
                .observeOn(AndroidSchedulers.mainThread());
    }
}
