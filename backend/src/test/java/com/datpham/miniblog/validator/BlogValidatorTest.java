package com.datpham.miniblog.validator;

import com.datpham.miniblog.entity.AuthorEntity;
import com.datpham.miniblog.exception.BadRequestException;
import com.datpham.miniblog.exception.EntityNotFoundException;
import com.datpham.miniblog.mock.AuthorData;
import com.datpham.miniblog.mock.BlogData;
import com.datpham.miniblog.repository.BlogRepository;
import io.tej.SwaggerCodgen.model.BlogRequest;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import static org.mockito.Mockito.when;


@RunWith(MockitoJUnitRunner.class)
public class BlogValidatorTest {


    @InjectMocks
    BlogValidator validator;

    @Mock
    BlogRepository repository;

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void validatorAddBlog() {
        BlogRequest blogRequest = BlogData.mockBlogRequest();
        blogRequest.setAuthorId(AuthorData.AUTHOR_ID);
        validator.validateAddBlog(blogRequest);
    }

    @Test
    public void validateBlogExist() {
        when(repository.existsById(BlogData.BLOG_ID)).thenReturn(true);
        validator.validateBlogExist(BlogData.BLOG_ID);
    }

    @Test
    public void validateBlogShowExceptionWhenWrongBlogId() {
        exception.expect(EntityNotFoundException.class);
        exception.expectMessage("Blog does not exist");

        when(repository.existsById(BlogData.BLOG_ID)).thenReturn(false);

        validator.validateBlogExist(BlogData.BLOG_ID);
    }

    @Test
    public void validateAddBlogShowExceptionWhenWrongAuthorId() {
        exception.expect(BadRequestException.class);
        exception.expectMessage("authorid is required");

        validator.validateAddBlog(BlogData.mockBlogRequest());
    }

}
