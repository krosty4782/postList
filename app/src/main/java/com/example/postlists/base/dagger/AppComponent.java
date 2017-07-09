package com.example.postlists.base.dagger;

import com.example.postlists.PostsListApplication;
import com.example.postlists.base.service.CommentsApi;
import com.example.postlists.base.service.PostsApi;
import com.example.postlists.base.service.UsersApi;
import com.example.postlists.base.service.UsersService;

import dagger.Component;

@AppScope
@Component(modules = AppModule.class)
public interface AppComponent extends BaseComponent {

    PostsApi postsApi();

    UsersApi usersApi();

    CommentsApi commentsApi();

    UsersService provideUsersService();

    void inject(PostsListApplication application);
}
