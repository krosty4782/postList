package com.example.postlists.posts.dagger;

import android.support.annotation.NonNull;

import com.example.postlists.base.service.ApiPostsService;
import com.example.postlists.base.service.PostsApi;
import com.example.postlists.base.service.PostsService;
import com.example.postlists.base.service.UsersService;
import com.example.postlists.posts.presenter.PostsPresenter;
import com.example.postlists.posts.presenter.PostsPresenterImpl;

import dagger.Module;
import dagger.Provides;

@Module
public class PostsModule {

    @Provides
    @PostsScope
    public PostsService providePostsService(PostsApi postsApi) {

        return new ApiPostsService(postsApi);
    }

    @Provides
    @PostsScope
    public PostsPresenter providePostsPresenter(@NonNull PostsService postsService,
                                                @NonNull UsersService usersService) {

        return new PostsPresenterImpl(postsService, usersService);
    }

}
