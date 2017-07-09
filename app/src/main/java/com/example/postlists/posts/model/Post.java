package com.example.postlists.posts.model;

import java.io.Serializable;


/*
TODO Using Api class for model as well, ideally we should use a converter to leave the Api Model as
TODO immutable and use a converted copy  */
public class Post implements Serializable {

    String id;
    String userId;
    String title;
    String body;
    String userEmail;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }
}
