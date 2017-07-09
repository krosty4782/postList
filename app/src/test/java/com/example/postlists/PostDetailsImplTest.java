package com.example.postlists;

import com.example.postlists.base.service.CommentsService;
import com.example.postlists.base.service.UsersService;
import com.example.postlists.details.model.Comment;
import com.example.postlists.details.model.User;
import com.example.postlists.details.presenter.PostDetailsPresenter;
import com.example.postlists.details.presenter.PostDetailsPresenterImpl;
import com.example.postlists.posts.model.Post;
import com.example.postlists.posts.presenter.PostsPresenterImpl;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import rx.Observable;

import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class PostDetailsImplTest {

    @Mock
    PostDetailsPresenter.View mockedView;

    @Mock
    CommentsService mockCommentService;

    @Mock
    UsersService mockUserService;

    List<Comment> comments;
    User user;
    Post post;

    @Before
    public void beforeTests() {
        user = new User();
        user.setEmail("exampleemail");
        user.setId("123");
        user.setUsername("exampleusername");
        comments = new ArrayList<>();
        comments.add(new Comment());
        post = new Post();
        post.setTitle("exampletitle");
        post.setBody("examplebody");
        post.setId("123");
        post.setUserEmail("exampleemail");
    }

    @Test
    public void onAttachView_showUsernameCalled() {

        //given
        when(mockUserService.getUser(anyString())).thenReturn(Observable.just(user));
        when(mockCommentService.getComments("123")).thenReturn(Observable.just(comments));
        PostDetailsPresenterImpl postDetailPresenter = new PostDetailsPresenterImpl(mockUserService, mockCommentService);
        postDetailPresenter.onInitialise(post);

        //when
        postDetailPresenter.attachView(mockedView);

        //then
        verify(mockedView).showUsername("exampleusername");

    }

    @Test
    public void onAttachView_showNumberOfCommentsCalled() {

        //given
        when(mockUserService.getUser(anyString())).thenReturn(Observable.just(user));
        when(mockCommentService.getComments("123")).thenReturn(Observable.just(comments));
        PostDetailsPresenterImpl postDetailPresenter = new PostDetailsPresenterImpl(mockUserService, mockCommentService);
        postDetailPresenter.onInitialise(post);

        //when
        postDetailPresenter.attachView(mockedView);

        //then
        verify(mockedView).showNumberOfComments(Integer.toString(comments.size()));

    }

    @Test
    public void onAttachView_showPostTitleCalled() {

        //given
        when(mockUserService.getUser(anyString())).thenReturn(Observable.just(user));
        when(mockCommentService.getComments("123")).thenReturn(Observable.just(comments));
        PostDetailsPresenterImpl postDetailPresenter = new PostDetailsPresenterImpl(mockUserService, mockCommentService);
        postDetailPresenter.onInitialise(post);

        //when
        postDetailPresenter.attachView(mockedView);

        //then
        verify(mockedView).showPostTitle("exampletitle");

    }

    @Test
    public void onAttachView_showPostBodyCalled() {

        //given
        when(mockUserService.getUser(anyString())).thenReturn(Observable.just(user));
        when(mockCommentService.getComments("123")).thenReturn(Observable.just(comments));
        PostDetailsPresenterImpl postDetailPresenter = new PostDetailsPresenterImpl(mockUserService, mockCommentService);
        postDetailPresenter.onInitialise(post);

        //when
        postDetailPresenter.attachView(mockedView);

        //then
        verify(mockedView).showPostBody("examplebody");

    }

    @Test
    public void onAttachView_showUserAvatarCalled() {

        //given
        when(mockUserService.getUser(anyString())).thenReturn(Observable.just(user));
        when(mockCommentService.getComments("123")).thenReturn(Observable.just(comments));
        PostDetailsPresenterImpl postDetailPresenter = new PostDetailsPresenterImpl(mockUserService, mockCommentService);
        postDetailPresenter.onInitialise(post);

        //when
        postDetailPresenter.attachView(mockedView);

        //then
        verify(mockedView).showUserAvatar("exampleemail");

    }

}