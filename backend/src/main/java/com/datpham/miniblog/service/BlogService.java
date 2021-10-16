package com.datpham.miniblog.service;


import com.datpham.miniblog.entity.BlogEntity;
import com.datpham.miniblog.mapper.BlogMapper;
import com.datpham.miniblog.repository.AuthorRepository;
import com.datpham.miniblog.repository.BlogRepository;
import io.tej.SwaggerCodgen.model.Blog;
import io.tej.SwaggerCodgen.model.BlogList;
import io.tej.SwaggerCodgen.model.BlogRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.concurrent.BlockingQueue;

@Service
public class BlogService {

    private final BlogRepository blogRepository;
    private final BlogMapper mapper;

    @Autowired
    public BlogService(BlogRepository blogRepository, AuthorRepository authorRepository, BlogMapper mapper) {
        this.blogRepository = blogRepository;
        this.mapper = mapper;
    }

    public Blog createBlog(BlogRequest request) {
        BlogEntity entity = blogRepository.save(mapper.mapBlogEntityFromBlogRequest(request));

        return mapper.mapBlogFromBlogEntity(entity);
    }

    public BlogList getAllBlog() {
        return mapper.mapBlogListFromBlogEntities(blogRepository.findAll());
    }

    public Blog getBlogById(String blogId) {
        BlogEntity entity = blogRepository.getById(blogId);

        return mapper.mapBlogFromBlogEntity(entity);
    }

    public BlogList getAllBlogByAuthorId(String authorId) {
        BlogList blogList = new BlogList();
        List<BlogEntity> blogEntities = blogRepository.findAll();
        for (BlogEntity blogEntity : blogEntities) {
            if (Objects.equals(blogEntity.getAuthorId().getAuthorId(), authorId)) blogList.add(mapper.mapBlogFromBlogEntity(blogEntity));
        }

        return blogList;

    }


}
