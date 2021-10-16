package com.datpham.miniblog.controller;

import com.datpham.miniblog.service.BlogService;
import com.datpham.miniblog.validator.AuthorValidator;
import com.datpham.miniblog.validator.BlogValidator;
import io.tej.SwaggerCodgen.api.BlogsApi;
import io.tej.SwaggerCodgen.model.Blog;
import io.tej.SwaggerCodgen.model.BlogList;
import io.tej.SwaggerCodgen.model.BlogRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("/miniblogs/backend/v1")
public class BlogController implements BlogsApi {

    private final BlogService blogService;
    private final BlogValidator blogValidator;
    private final AuthorValidator authorValidator;


    @Autowired
    public BlogController(BlogService blogService, BlogValidator blogValidator, AuthorValidator authorValidator) {
        this.blogService = blogService;
        this.blogValidator = blogValidator;
        this.authorValidator = authorValidator;
    }

    @Override
    public ResponseEntity<Blog> createBlog(BlogRequest blogRequest) {
        authorValidator.validateAuthorExist(blogRequest.getAuthorId());
        blogValidator.validateAddBlog(blogRequest);
        Blog blog = blogService.createBlog(blogRequest);
        return new ResponseEntity<>(blog, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<BlogList> getAllBlog() {
        System.out.print("Get in Blogs");
        BlogList blogList = blogService.getAllBlog();
        return new ResponseEntity<>(blogList, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Blog> getBlogById(String blogId) {
        blogValidator.validateBlogExist(blogId);
        Blog blog = blogService.getBlogById(blogId);

        return new ResponseEntity<>(blog, HttpStatus.OK);
    }
}
