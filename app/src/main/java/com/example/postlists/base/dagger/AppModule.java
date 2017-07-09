package com.example.postlists.base.dagger;

import com.example.postlists.base.service.ApiClient;
import com.example.postlists.base.service.ApiUsersService;
import com.example.postlists.base.service.CommentsApi;
import com.example.postlists.base.service.PostsApi;
import com.example.postlists.base.service.UsersApi;
import com.example.postlists.base.service.UsersService;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {

    @Provides
    @AppScope
    public ApiClient provideApiClient() {
        return new ApiClient();
    }

    @Provides
    @AppScope
    public PostsApi providePostsApi(ApiClient apiClient) {
        return apiClient.api(PostsApi.class);
    }

    @Provides
    @AppScope
    public UsersApi provideUsersApi(ApiClient apiClient) {
        return apiClient.api(UsersApi.class);
    }

    @Provides
    @AppScope
    public UsersService provideUsersService(UsersApi usersApi) {

        return new ApiUsersService(usersApi);
    }

    @Provides
    @AppScope
    public CommentsApi provideCommentsApi(ApiClient apiClient) {
        return apiClient.api(CommentsApi.class);
    }

}
