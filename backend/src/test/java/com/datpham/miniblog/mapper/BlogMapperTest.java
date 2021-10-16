package com.datpham.miniblog.mapper;


import com.datpham.miniblog.entity.AuthorEntity;
import com.datpham.miniblog.entity.BlogEntity;
import com.datpham.miniblog.mock.AuthorData;
import com.datpham.miniblog.mock.BlogData;
import com.datpham.miniblog.repository.AuthorRepository;
import com.datpham.miniblog.repository.BlogRepository;
import io.tej.SwaggerCodgen.model.Blog;
import io.tej.SwaggerCodgen.model.BlogList;
import io.tej.SwaggerCodgen.model.BlogRequest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static org.junit.Assert.*;


@RunWith(MockitoJUnitRunner.class)
public class BlogMapperTest {

    @InjectMocks
    BlogMapper mapper;

    @Mock
    BlogRepository repository;

    @Mock
    AuthorRepository authorRepository;

    @Test
    public void ensureMapBlogEntityFromBlogRequest() {
        BlogRequest request = BlogData.mockBlogRequest();
        AuthorEntity author = AuthorData.mockAuthorEntity();
        request.setAuthorId(author.getAuthorId());
        when(authorRepository.getById(request.getAuthorId())).thenReturn(author);

        BlogEntity entity = mapper.mapBlogEntityFromBlogRequest(request);
        assertNotNull(entity.getBlogId());
        assertEquals(request.getAuthorId(), entity.getAuthorId().getAuthorId());
        assertEquals(request.getBlogContent(), entity.getBlogContent());
        assertEquals(request.getBlogName(), entity.getBlogName());
        assertEquals(request.getBlogType(), entity.getBlogType());
        assertEquals(request.getBlogIntroduction(), entity.getBlogIntroduction());
        assertEquals(request.getBlogPicture(), entity.getBlogPicture());
    }

    @Test
    public void ensureMapBlogFromBlogEntity() {
        AuthorEntity authorEntity = AuthorData.mockAuthorEntity();
        BlogEntity entity = BlogData.mockBlogEntity();
        entity.setAuthorId(authorEntity);
//        System.out.println("Author hasn't? " + authorEntity.getBlogEntities().size() );
        Blog blog =  mapper.mapBlogFromBlogEntity(entity);
        assertEquals(entity.getBlogId(), blog.getBlogId());
        assertEquals(entity.getBlogContent(), blog.getBlogContent());
        assertEquals(entity.getBlogName(), blog.getBlogName());
        assertEquals(entity.getBlogType(), blog.getBlogType());
        assertEquals(entity.getAuthorId().getAuthorId(), blog.getAuthorId());
        assertEquals(entity.getBlogPicture(), blog.getBlogPicture());
        assertEquals(entity.getBlogIntroduction(), blog.getBlogIntroduction());
    }

    private void assertBlogList(List<BlogEntity> blogEntities, BlogList blogList) {
        assertBlog(blogEntities.get(0), blogList.get(0));
    }

    private void assertBlog(BlogEntity entity, Blog blog) {
        assertEquals(entity.getBlogId(), blog.getBlogId());
        assertEquals(entity.getAuthorId().getAuthorId(), blog.getAuthorId());
        assertEquals(entity.getBlogContent(), blog.getBlogContent());
        assertEquals(entity.getBlogName(), blog.getBlogName());
        assertEquals(entity.getBlogType(), blog.getBlogType());
        assertEquals(entity.getBlogPicture(), blog.getBlogPicture());
        assertEquals(entity.getBlogIntroduction(), blog.getBlogIntroduction());
    }

    @Test
    public void ensureMapBlogListFromBlogEntities() {
        AuthorEntity authorEntity = AuthorData.mockAuthorEntity();
        List<BlogEntity> blogEntities = BlogData.mockBlogEntityList();
        blogEntities.forEach(blogEntity -> {
            blogEntity.setAuthorId(authorEntity);
        });
        BlogList blogList = mapper.mapBlogListFromBlogEntities(blogEntities);
        assertBlogList(blogEntities, blogList);
    }


}
