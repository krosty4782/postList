package com.example.postlists.base.service;

import retrofit.RestAdapter;

public class ApiClient {
    private static final String ENDPOINT = "http://jsonplaceholder.typicode.com/";
    private final RestAdapter restAdapter;

    public ApiClient() {
        this.restAdapter = new RestAdapter.Builder()
                .setEndpoint(ENDPOINT)
                .build();
    }

    public <T> T api(Class<T> service) {
        return restAdapter.create(service);
    }
}
