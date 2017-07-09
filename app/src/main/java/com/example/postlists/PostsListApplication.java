package com.example.postlists;

import android.app.Application;

import com.example.postlists.base.dagger.AppComponent;
import com.example.postlists.base.dagger.AppModule;
import com.example.postlists.base.dagger.ComponentsManager;

import static com.example.postlists.base.dagger.DaggerAppComponent.builder;

public class PostsListApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        initComponents();
    }

    protected void initComponents() {
        AppComponent appComponent = builder().appModule(new AppModule()).build();
        ComponentsManager.get().setAppComponent(appComponent);
        appComponent.inject(this);
    }
}
