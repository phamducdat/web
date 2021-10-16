package com.datpham.miniblog.service;

import com.datpham.miniblog.mapper.BlogMapper;
import com.datpham.miniblog.mock.BlogData;
import com.datpham.miniblog.repository.BlogRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class BlogServiceTest {

    @InjectMocks
    BlogService blogService;

    @Mock
    BlogRepository blogRepository;

    @Mock
    BlogMapper blogMapper;

    @Test
    public void creteBlog() {
        blogService.createBlog(BlogData.mockBlogRequest());
    }

    @Test
    public void getAllBlog() {
        blogService.getAllBlog();
    }

    @Test
    public void getBlogById() {
        blogService.getBlogById(BlogData.BLOG_ID);
    }
}
