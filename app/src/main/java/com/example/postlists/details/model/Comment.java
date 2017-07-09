package com.example.postlists.details.model;


/* TODO Using Api class for model as well, ideally we should use a converter to leave the Api Model as
TODO immutable and use a converted copy  */

public class Comment {
    String postId;

    public String getPostId() {
        return postId;
    }

    public void setPostId(String postId) {
        this.postId = postId;
    }
}
