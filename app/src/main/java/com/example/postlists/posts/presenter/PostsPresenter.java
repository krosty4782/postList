package com.example.postlists.posts.presenter;

import com.example.postlists.base.Presenter;
import com.example.postlists.base.PresenterView;
import com.example.postlists.posts.model.Post;

import java.util.List;

public interface PostsPresenter extends Presenter<PostsPresenter.View> {

    void onPostSelected(Post post);

    interface View extends PresenterView {
        void showPosts(List<Post> posts);

        void showPostDetail(Post post);
    }
}
