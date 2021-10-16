package com.datpham.miniblog.mapper;


import com.datpham.miniblog.entity.AuthorEntity;
import com.datpham.miniblog.entity.BlogEntity;
import com.datpham.miniblog.repository.AuthorRepository;
import com.datpham.miniblog.repository.BlogRepository;
import io.tej.SwaggerCodgen.model.Blog;
import io.tej.SwaggerCodgen.model.BlogList;
import io.tej.SwaggerCodgen.model.BlogRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class BlogMapper {

    private final BlogRepository repository;
    private final AuthorRepository authorRepository;


    @Autowired
    public BlogMapper(BlogRepository repository, AuthorRepository authorRepository) {
        this.repository = repository;
        this.authorRepository = authorRepository;
    }

    public Blog mapBlogFromBlogEntity(BlogEntity from) {
        Blog blog = new Blog();
        blog.setBlogId(from.getBlogId());
        blog.setBlogIntroduction(from.getBlogIntroduction());
        blog.setBlogContent(from.getBlogContent());
        blog.setBlogDate(convertDateToLocalDate(from.getBlogDate()));
        blog.setBlogType(from.getBlogType());
        blog.setBlogName(from.getBlogName());
        blog.setBlogPicture(from.getBlogPicture());
        blog.setAuthorId(from.getAuthorId().getAuthorId());
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
        entity.setBlogType(request.getBlogType());
        entity.setBlogId(UUID.randomUUID().toString());
        entity.setBlogIntroduction(request.getBlogIntroduction());
        entity.setBlogPicture(request.getBlogPicture());
        entity.setBlogName(request.getBlogName());
        entity.setBlogDate(convertLocalDateToDate(request.getBlogDate()));
        entity.setBlogContent(request.getBlogContent());
        entity.setAuthorId(author);
        entity.setBlogIntroduction(request.getBlogIntroduction());

        return entity;
    }



    private Date convertLocalDateToDate(LocalDate localDate) {
        return java.sql.Date.valueOf(localDate);
    }

    private LocalDate convertDateToLocalDate(Date date) {
        return date.toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDate();
    }

}
