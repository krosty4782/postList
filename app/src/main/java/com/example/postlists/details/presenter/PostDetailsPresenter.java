package com.example.postlists.details.presenter;

import com.example.postlists.base.Presenter;
import com.example.postlists.base.PresenterView;
import com.example.postlists.posts.model.Post;

public interface PostDetailsPresenter extends Presenter<PostDetailsPresenter.View> {

    void onInitialise(Post post);

    interface View extends PresenterView {

        void showUserAvatar(String userEmail);

        void showPostTitle(String postTitle);

        void showPostBody(String postBody);

        void showUsername(String username);

        void showNumberOfComments(String numberOfComments);
    }
}
