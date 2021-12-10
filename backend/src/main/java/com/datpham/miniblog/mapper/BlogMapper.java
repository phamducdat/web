package com.datpham.miniblog.mapper;


import com.datpham.miniblog.entity.AuthorEntity;
import com.datpham.miniblog.entity.BlogEntity;
import com.datpham.miniblog.entity.CategoryEntity;
import com.datpham.miniblog.repository.AuthorRepository;
import com.datpham.miniblog.repository.BlogRepository;
import com.datpham.miniblog.repository.CategoryRepository;
import io.tej.SwaggerCodgen.model.Blog;
import io.tej.SwaggerCodgen.model.BlogList;
import io.tej.SwaggerCodgen.model.BlogRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class BlogMapper {

    private final BlogRepository repository;
    private final AuthorRepository authorRepository;
    private final CategoryRepository categoryRepository;


    @Autowired
    public BlogMapper(BlogRepository repository, AuthorRepository authorRepository, CategoryRepository categoryRepository) {
        this.repository = repository;
        this.authorRepository = authorRepository;
        this.categoryRepository = categoryRepository;
    }

    public Blog mapBlogFromBlogEntity(BlogEntity from) {
        Blog blog = new Blog();
        blog.setBlogId(from.getBlogId());
        blog.setBlogIntroduction(from.getBlogIntroduction());
        blog.setBlogContent(from.getBlogContent());
        blog.setBlogDate(from.getBlogDate());
        blog.setBlogName(from.getBlogName());
        blog.setBlogPicture(from.getBlogPicture());
        blog.setAuthorId(from.getAuthorId().getAuthorId());
        blog.setCategoryName(from.getCategoryId().getCategoryName());
        blog.setCategoryId(from.getCategoryId().getCategoryId());
        return blog;

    }

    public BlogList mapBlogListFromBlogEntities(List<BlogEntity> from) {

        BlogList list = new BlogList();

        from.forEach(blogEntity -> {
            list.add(mapBlogFromBlogEntity(blogEntity));
        });

        return list;
    }


    public BlogEntity mapBlogEntityFromBlogRequest(BlogRequest request) {
        BlogEntity entity = new BlogEntity();
        AuthorEntity author = authorRepository.getById(request.getAuthorId());
        CategoryEntity category = categoryRepository.getById(request.getCategoryId());

        entity.setBlogId(UUID.randomUUID().toString());
        return getBlogEntity(request, entity, author, category);
    }

    public BlogEntity mapBlogEntityFromBlogRequest(String blogId, BlogRequest request) {
        BlogEntity entity = new BlogEntity();
        AuthorEntity author = authorRepository.getById(request.getAuthorId());
        CategoryEntity category = categoryRepository.getById(request.getCategoryId());

        entity.setBlogId(blogId);
        return getBlogEntity(request, entity, author, category);
    }

    private BlogEntity getBlogEntity(BlogRequest request, BlogEntity entity, AuthorEntity author, CategoryEntity category) {
        entity.setBlogIntroduction(request.getBlogIntroduction());
        entity.setBlogPicture(request.getBlogPicture());
        entity.setBlogName(request.getBlogName());
        entity.setBlogDate(request.getBlogDate());
        entity.setBlogContent(request.getBlogContent());
        entity.setAuthorId(author);
        entity.setBlogIntroduction(request.getBlogIntroduction());
        entity.setCategoryId(category);
        entity.setCategoryName(category.getCategoryName());
        return entity;
    }


}
