package com.example.postlists.posts.presenter;

import android.support.annotation.NonNull;
import android.support.v4.util.Pair;
import android.util.Log;

import com.example.postlists.base.service.PostsService;
import com.example.postlists.base.service.UsersService;
import com.example.postlists.details.model.User;
import com.example.postlists.posts.model.Post;

import rx.functions.Func2;
import rx.subscriptions.CompositeSubscription;

public class PostsPresenterImpl implements PostsPresenter {

    private View view;
    private PostsService postsService;
    private UsersService usersService;
    private CompositeSubscription subscriptions = new CompositeSubscription();

    public PostsPresenterImpl(@NonNull PostsService postsService,
                              @NonNull UsersService usersService) {
        this.postsService = postsService;
        this.usersService = usersService;
    }

    @Override
    public void attachView(View presenterView) {
        this.view = presenterView;
        subscriptions.add(
                postsService.getPosts()
                        .flatMapIterable(posts -> posts)
                        .flatMap(post -> usersService.getUser(post.getUserId()), (Func2<Post, User, Pair>) Pair::new)
                        .map(pair -> {
                            Post post = (Post) pair.first;
                            post.setUserEmail(((User) pair.second).getEmail());
                            return post;
                        })
                        .toList()
                        .subscribe(posts -> view.showPosts(posts), error -> Log.e("ERROR", error.getMessage())));
    }

    @Override
    public void detachView() {

    }

    @Override
    public void destroy() {
        subscriptions.clear();
    }

    @Override
    public void onPostSelected(Post post) {
        view.showPostDetail(post);
    }
}
