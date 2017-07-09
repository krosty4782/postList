package com.example.postlists.details;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.postlists.R;
import com.example.postlists.base.Utils;
import com.example.postlists.base.dagger.AppComponent;
import com.example.postlists.base.dagger.ComponentsManager;
import com.example.postlists.details.dagger.PostDetailsComponent;
import com.example.postlists.details.dagger.PostDetailsModule;
import com.example.postlists.details.presenter.PostDetailsPresenter;
import com.example.postlists.posts.model.Post;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.example.postlists.details.dagger.DaggerPostDetailsComponent.builder;

public class PostDetailsActivity extends AppCompatActivity implements PostDetailsPresenter.View {

    private static final String EXTRA_POST = "EXTRA_POST";

    @BindView(R.id.user_avatar)
    ImageView userAvatarView;

    @BindView(R.id.post_title)
    TextView postTitleView;

    @BindView(R.id.post_body)
    TextView postBodyView;

    @BindView(R.id.number_of_comments)
    TextView numberOfCommentsView;

    @BindView(R.id.user_name)
    TextView userNameView;

    @Inject
    PostDetailsPresenter presenter;

    public static Intent createIntent(Context context, Post post) {
        Intent intent = new Intent(context, PostDetailsActivity.class);
        intent.putExtra(EXTRA_POST, post);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getPostDetailsComponent().inject(this);
        setContentView(R.layout.activity_post_details);
        ButterKnife.bind(this);
        presenter.onInitialise((Post) getIntent().getSerializableExtra(EXTRA_POST));
    }

    private PostDetailsComponent getPostDetailsComponent() {
        PostDetailsComponent postDetailsComponent = ComponentsManager.get().getBaseComponent(PostDetailsComponent.KEY);
        if (postDetailsComponent == null) {
            AppComponent appComponent = ComponentsManager.get().getAppComponent();
            PostDetailsModule postDetailsModule = new PostDetailsModule();
            postDetailsComponent = builder().appComponent(appComponent).postDetailsModule(postDetailsModule).build();
            ComponentsManager.get().putBaseComponent(PostDetailsComponent.KEY, postDetailsComponent);
        }
        return postDetailsComponent;
    }

    @Override
    public void onResume() {
        super.onResume();
        presenter.attachView(this);
    }

    @Override
    public void onPause() {
        presenter.detachView();
        super.onPause();
    }

    @Override
    public void onDestroy() {
        if (isFinishing()) {
            ComponentsManager.get().removeBaseComponent(PostDetailsComponent.KEY);
            presenter.destroy();
        }
        super.onDestroy();
    }

    @Override
    public void showUserAvatar(String userEmail) {
        Utils.showAvatar(userEmail, this, userAvatarView);
    }

    @Override
    public void showPostTitle(String postTitle) {
        postTitleView.setText(postTitle);
    }

    @Override
    public void showPostBody(String postBody) {
        postBodyView.setText(postBody);
    }

    @Override
    public void showUsername(String username) {
        userNameView.setText(username);
    }

    @Override
    public void showNumberOfComments(String numberOfComments) {
        numberOfCommentsView.setText(numberOfComments);
    }
}
