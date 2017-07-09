package com.example.postlists.details.dagger;

import com.example.postlists.base.dagger.AppComponent;
import com.example.postlists.base.dagger.BaseComponent;
import com.example.postlists.details.PostDetailsActivity;

import dagger.Component;

@PostDetailsScope
@Component(dependencies = AppComponent.class, modules = PostDetailsModule.class)
public interface PostDetailsComponent extends BaseComponent {

    String KEY = PostDetailsComponent.class.getSimpleName();

    void inject(PostDetailsActivity activity);

}
