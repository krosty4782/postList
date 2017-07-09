package com.example.postlists.details.presenter;

import android.support.annotation.NonNull;
import android.util.Log;

import com.example.postlists.base.service.CommentsService;
import com.example.postlists.base.service.UsersService;
import com.example.postlists.posts.model.Post;

import rx.subscriptions.CompositeSubscription;

public class PostDetailsPresenterImpl implements PostDetailsPresenter {

    private View view;
    private UsersService service;
    private CommentsService commentsService;
    private Post post;
    private CompositeSubscription subscriptions = new CompositeSubscription();

    public PostDetailsPresenterImpl(@NonNull UsersService usersService,
                                    @NonNull CommentsService commentsService) {
        this.service = usersService;
        this.commentsService = commentsService;
    }

    @Override
    public void attachView(View presenterView) {
        this.view = presenterView;
        subscriptions.add(
                service.getUser(post.getUserId())
                        .subscribe(user -> view.showUsername(user.getUsername()), error -> Log.e("ERROR", error.getMessage())));
        subscriptions.add(
                commentsService.getComments(post.getId())
                        .subscribe(commentList -> view.showNumberOfComments(Integer.toString(commentList.size()))));
        initialiseViews();
    }

    private void initialiseViews() {
        view.showPostTitle(post.getTitle());
        view.showPostBody(post.getBody());
        view.showUserAvatar(post.getUserEmail());
    }

    @Override
    public void detachView() {

    }

    @Override
    public void destroy() {
        subscriptions.clear();
    }

    @Override
    public void onInitialise(Post post) {
        this.post = post;
    }
}
