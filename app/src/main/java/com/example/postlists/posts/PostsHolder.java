package com.example.postlists.posts;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.postlists.R;
import com.example.postlists.base.Utils;
import com.example.postlists.posts.model.Post;
import com.example.postlists.posts.presenter.PostsPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;

class PostsHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    @BindView(R.id.user_avatar)
    ImageView userAvatar;

    @BindView(R.id.post_title)
    TextView postTitle;

    private Context context;
    private final PostsPresenter postsPresenter;
    private Post post;

    PostsHolder(Context context, View itemView, PostsPresenter postsPresenter) {
        super(itemView);
        this.context = context;
        this.postsPresenter = postsPresenter;
        ButterKnife.bind(this, itemView);
        itemView.setOnClickListener(this);
    }

    void showTitle(String title) {
        postTitle.setText(title);
    }

    void setItem(Post post) {
        this.post = post;
    }

    void showAvatar(String userEmail) {
        Utils.showAvatar(userEmail, context, userAvatar);
    }

    @Override
    public void onClick(View view) {
        postsPresenter.onPostSelected(post);
    }
}
