package com.datpham.miniblog.api;

import com.datpham.miniblog.controller.BlogController;
import com.datpham.miniblog.mock.BlogData;
import com.datpham.miniblog.service.BlogService;
import com.datpham.miniblog.validator.AuthorValidator;
import com.datpham.miniblog.validator.BlogValidator;
import io.tej.SwaggerCodgen.model.Blog;
import io.tej.SwaggerCodgen.model.BlogList;
import io.tej.SwaggerCodgen.model.BlogRequest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;
import static org.junit.Assert.assertEquals;
@RunWith(MockitoJUnitRunner.class)
public class BlogControllerTest {


    @InjectMocks
    BlogController controller;

    @Mock
    BlogService blogService;

    @Mock
    AuthorValidator authorValidator;

    @Mock
    BlogValidator blogValidator;


    private void assertBlog(Blog actual) {
        assertEquals(BlogData.BLOG_ID, actual.getBlogId());
        assertEquals(BlogData.BLOG_CONTENT, actual.getBlogContent());
        assertEquals(BlogData.BLOG_NAME, actual.getBlogName());
        assertEquals(BlogData.BLOG_CONTENT, actual.getBlogContent());
        assertEquals(BlogData.BLOG_TYPE, actual.getBlogType());
        assertEquals(BlogData.BLOG_PICTURE, actual.getBlogPicture());
        assertEquals(BlogData.BLOG_INTRODUCTION, actual.getBlogIntroduction());
    }

    private void assertStatus200(HttpStatus actualStatus) {
        assertEquals(HttpStatus.OK, actualStatus);
    }

    private void assertBlogList(BlogList blogList) {
        assertBlog(blogList.get(0));
    }

    @Test
    public void testEndpointCreateBlog() {
        BlogRequest blogRequest = BlogData.mockBlogRequest();
        Blog blog = BlogData.mockBlog();

        when(blogService.createBlog(blogRequest)).thenReturn(blog);

        ResponseEntity<Blog> blogResponseEntity =
                controller.createBlog(blogRequest);
        assertStatus200(blogResponseEntity.getStatusCode());
        assertBlog(blogResponseEntity.getBody());
    }

    @Test
    public void testEndpointGetAllBlog() {
        BlogList blogList = BlogData.mockBlogList();

        when(blogService.getAllBlog()).thenReturn(blogList);
        ResponseEntity<BlogList> blogListResponseEntity =
                controller.getAllBlog();

        assertBlogList(blogList);
        assertStatus200(blogListResponseEntity.getStatusCode());
    }

    @Test
    public void testEndpointGetById() {
        Blog blog = BlogData.mockBlog();

        when(blogService.getBlogById(BlogData.BLOG_ID)).thenReturn(blog);

        ResponseEntity<Blog> blogResponseEntity =
                controller.getBlogById(BlogData.BLOG_ID);

        assertStatus200(blogResponseEntity.getStatusCode());
        assertBlog(blogResponseEntity.getBody());
    }

}
