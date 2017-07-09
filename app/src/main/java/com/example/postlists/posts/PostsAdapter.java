package com.example.postlists.posts;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.postlists.R;
import com.example.postlists.posts.model.Post;
import com.example.postlists.posts.presenter.PostsPresenter;

import java.util.ArrayList;
import java.util.List;

public class PostsAdapter extends RecyclerView.Adapter<PostsHolder> {

    private List<Post> posts = new ArrayList<>();

    private PostsPresenter presenter;

    PostsAdapter(PostsPresenter presenter) {
        this.presenter = presenter;
    }

    void addData(List<Post> data) {
        this.posts.addAll(data);
        notifyDataSetChanged();
    }

    @Override
    public PostsHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_post, viewGroup, false);
        return new PostsHolder(viewGroup.getContext(), view, presenter);
    }

    @Override
    public void onBindViewHolder(PostsHolder holder, int position) {
        holder.setItem(posts.get(position));
        holder.showTitle(posts.get(position).getTitle());
        holder.showAvatar(posts.get(position).getUserEmail());
    }

    @Override
    public int getItemCount() {
        return posts.size();
    }
}
