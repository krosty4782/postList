package com.example.postlists.base.service;

import com.example.postlists.details.model.Comment;

import java.util.List;

import rx.Observable;

public interface CommentsService {

    Observable<List<Comment>> getComments(String postId);
}
