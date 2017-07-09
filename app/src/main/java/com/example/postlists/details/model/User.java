package com.example.postlists.details.model;

/* TODO Using Api class for model as well, ideally we should use a converter to leave the Api Model as
        TODO immutable and use a converted copy  */

public class User {

    String id;
    String username;
    String email;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
