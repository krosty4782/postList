package com.example.postlists.posts.dagger;

import com.example.postlists.base.dagger.AppComponent;
import com.example.postlists.base.dagger.BaseComponent;
import com.example.postlists.posts.PostsActivity;

import dagger.Component;

@PostsScope
@Component(dependencies = AppComponent.class, modules = PostsModule.class)
public interface PostsComponent extends BaseComponent {

    String KEY = PostsComponent.class.getSimpleName();

    void inject(PostsActivity activity);

}
