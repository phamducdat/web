package com.datpham.miniblog.mock;

import com.datpham.miniblog.entity.BlogEntity;
import io.tej.SwaggerCodgen.model.Blog;
import io.tej.SwaggerCodgen.model.BlogList;
import io.tej.SwaggerCodgen.model.BlogRequest;

import java.time.LocalDate;
import java.util.*;

public class BlogData {

    public static final String BLOG_ID = "1234";
    public static final String BLOG_NAME = "blog";
    public static final String BLOG_INTRODUCTION = "introduction";
    public static final String BLOG_CONTENT = "content";
    public static final String BLOG_PICTURE = "picture";
    public static final String BLOG_TYPE = "type";
    public static final Date DATE = new GregorianCalendar(2000, 1, 1).getTime();
    public static final LocalDate LOCAL_DATE = LocalDate.now();

    public static Blog mockBlog() {
        Blog blog = new Blog();
        blog.setBlogId(BLOG_ID);
        blog.setBlogIntroduction(BLOG_INTRODUCTION);
        blog.setBlogContent(BLOG_CONTENT);
        blog.setBlogName(BLOG_NAME);
        blog.setBlogPicture(BLOG_PICTURE);
        blog.setBlogDate(LOCAL_DATE);
        blog.setBlogType(BLOG_TYPE);
        return blog;
    }

    public static BlogEntity mockBlogEntity() {
        BlogEntity entity = new BlogEntity();
        entity.setBlogId(BLOG_ID);
        entity.setBlogIntroduction(BLOG_INTRODUCTION);
        entity.setBlogContent(BLOG_CONTENT);
        entity.setBlogName(BLOG_NAME);
        entity.setBlogPicture(BLOG_PICTURE);
        entity.setBlogDate(DATE);
        entity.setBlogType(BLOG_TYPE);
        return entity;
    }

    public static BlogRequest mockBlogRequest() {
        BlogRequest request = new BlogRequest();
        request.setBlogIntroduction(BLOG_INTRODUCTION);
        request.setBlogContent(BLOG_CONTENT);
        request.setBlogName(BLOG_NAME);
        request.setBlogPicture(BLOG_PICTURE);
        request.setBlogDate(LOCAL_DATE);
        request.setBlogType(BLOG_TYPE);

        return  request;
    }

    public static BlogList mockBlogList() {
        BlogList list = new BlogList();
        list.add(mockBlog());
        return list;
    }

    public static List<BlogEntity> mockBlogEntityList() {
        return Collections.singletonList(mockBlogEntity());
    }


}
