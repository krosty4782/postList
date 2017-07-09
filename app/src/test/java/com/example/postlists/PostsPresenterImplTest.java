package com.example.postlists;

import com.example.postlists.base.service.PostsService;
import com.example.postlists.base.service.UsersService;
import com.example.postlists.details.model.User;
import com.example.postlists.posts.model.Post;
import com.example.postlists.posts.presenter.PostsPresenter;
import com.example.postlists.posts.presenter.PostsPresenterImpl;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import rx.Observable;

import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class PostsPresenterImplTest {

    @Mock
    PostsPresenter.View mockedView;

    @Mock
    PostsService mockPostService;

    @Mock
    UsersService mockUserService;

    List<Post> posts;
    Post post;
    User user;

    @Before
    public void beforeTests() {
        posts = new ArrayList<>();
        post = new Post();
        posts.add(post);
        user = new User();
    }

    @Test
    public void onAttachView_showPostCalled() {

        //given
        PostsPresenterImpl postsPresenter = new PostsPresenterImpl(mockPostService, mockUserService);
        when(mockPostService.getPosts()).thenReturn(Observable.just(posts));
        when(mockUserService.getUser(anyString())).thenReturn(Observable.just(user));

        //when
        postsPresenter.attachView(mockedView);

        //then
        verify(mockedView).showPosts(posts);

    }

    @Test
    public void onAttachViewNotCalled_showPostNeverCalled() {

        //given
        PostsPresenterImpl postsPresenter = new PostsPresenterImpl(mockPostService, mockUserService);
        when(mockPostService.getPosts()).thenReturn(Observable.just(posts));
        when(mockUserService.getUser(anyString())).thenReturn(Observable.just(user));

        //when

        //then
        verify(mockedView, never()).showPosts(posts);

    }

    @Test
    public void onPostRequested_returnsPostWithEmail() {

        //given
        PostsPresenterImpl postsPresenter = new PostsPresenterImpl(mockPostService, mockUserService);
        user.setEmail("exampleemail");
        when(mockPostService.getPosts()).thenReturn(Observable.just(posts));
        when(mockUserService.getUser(anyString())).thenReturn(Observable.just(user));

        //when
        postsPresenter.attachView(mockedView);

        //then
        Assert.assertEquals(posts.get(0).getUserEmail(), "exampleemail");

    }

    @Test
    public void onPostSelected_showPostDetailsCalled() {

        //given
        PostsPresenterImpl postsPresenter = new PostsPresenterImpl(mockPostService, mockUserService);
        when(mockPostService.getPosts()).thenReturn(Observable.just(posts));
        when(mockUserService.getUser(anyString())).thenReturn(Observable.just(user));
        postsPresenter.attachView(mockedView);

        //when
        postsPresenter.onPostSelected(post);

        //then
        verify(mockedView).showPostDetail(post);

    }

    @Test
    public void onPostSelectedNotCalled_showPostDetailsNeverCalled() {

        //given
        PostsPresenterImpl postsPresenter = new PostsPresenterImpl(mockPostService, mockUserService);
        when(mockPostService.getPosts()).thenReturn(Observable.just(posts));
        when(mockUserService.getUser(anyString())).thenReturn(Observable.just(user));
        postsPresenter.attachView(mockedView);

        //when

        //then
        verify(mockedView, never()).showPostDetail(post);

    }
}