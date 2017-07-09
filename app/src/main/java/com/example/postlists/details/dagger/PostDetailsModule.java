package com.example.postlists.details.dagger;

import android.support.annotation.NonNull;

import com.example.postlists.base.service.ApiCommentsService;
import com.example.postlists.base.service.CommentsApi;
import com.example.postlists.base.service.CommentsService;
import com.example.postlists.base.service.UsersService;
import com.example.postlists.details.presenter.PostDetailsPresenter;
import com.example.postlists.details.presenter.PostDetailsPresenterImpl;

import dagger.Module;
import dagger.Provides;

@Module
public class PostDetailsModule {

    @Provides
    @PostDetailsScope
    public CommentsService provideCommentsService(CommentsApi commentsApi) {

        return new ApiCommentsService(commentsApi);
    }

    @Provides
    @PostDetailsScope
    public PostDetailsPresenter providePostDetailsPresenter(@NonNull UsersService usersService,
                                                            @NonNull CommentsService commentsService) {

        return new PostDetailsPresenterImpl(usersService, commentsService);
    }

}
