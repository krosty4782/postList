package com.example.postlists.posts;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.postlists.R;
import com.example.postlists.base.dagger.AppComponent;
import com.example.postlists.base.dagger.ComponentsManager;
import com.example.postlists.details.PostDetailsActivity;
import com.example.postlists.posts.dagger.PostsComponent;
import com.example.postlists.posts.dagger.PostsModule;
import com.example.postlists.posts.model.Post;
import com.example.postlists.posts.presenter.PostsPresenter;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.example.postlists.posts.dagger.DaggerPostsComponent.builder;

public class PostsActivity extends AppCompatActivity implements PostsPresenter.View {

    @BindView(R.id.posts_recycler_view)
    RecyclerView postsList;

    @Inject
    PostsPresenter presenter;

    private PostsAdapter postsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getPostsComponent().inject(this);
        setContentView(R.layout.activity_posts);
        ButterKnife.bind(this);
        presenter.attachView(this);
        configureView();
    }

    private PostsComponent getPostsComponent() {
        PostsComponent postsComponent = ComponentsManager.get().getBaseComponent(PostsComponent.KEY);
        if (postsComponent == null) {
            AppComponent appComponent = ComponentsManager.get().getAppComponent();
            PostsModule postsModule = new PostsModule();
            postsComponent = builder().appComponent(appComponent).postsModule(postsModule).build();
            ComponentsManager.get().putBaseComponent(PostsComponent.KEY, postsComponent);
        }
        return postsComponent;
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    private void configureView() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        postsList.setLayoutManager(linearLayoutManager);
        postsList.setAdapter(postsAdapter = new PostsAdapter(presenter));
    }

    @Override
    public void showPosts(List<Post> posts) {
        postsAdapter.addData(posts);
    }

    @Override
    public void showPostDetail(Post post) {
        startActivity(PostDetailsActivity.createIntent(this, post));
    }

    @Override
    public void onPause() {
        presenter.detachView();
        super.onPause();
    }

    @Override
    public void onDestroy() {
        if (isFinishing()) {
            ComponentsManager.get().removeBaseComponent(PostsComponent.KEY);
            presenter.destroy();
        }
        super.onDestroy();
    }
}
