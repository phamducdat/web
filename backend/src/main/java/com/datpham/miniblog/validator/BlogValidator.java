package com.datpham.miniblog.validator;


import com.datpham.miniblog.exception.BadRequestException;
import com.datpham.miniblog.exception.EntityNotFoundException;
import com.datpham.miniblog.repository.BlogRepository;
import io.tej.SwaggerCodgen.model.BlogRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BlogValidator {

    private static final String BLOG_DOES_NOT_EXIST = "Blog does not exist";

    private final BlogRepository repository;

    @Autowired
    public BlogValidator(BlogRepository repository) {
        this.repository = repository;
    }

    public void validateAddBlog(BlogRequest request) {
        checkRequiredField(request.getAuthorId(), "AuthorId");
        checkRequiredField(request.getBlogContent(), "blogContent");
        checkRequiredField(request.getBlogName(), "blogName");
        checkRequiredField(request.getBlogIntroduction(),"blogIntroduction");
        checkRequiredField(request.getBlogContent(), "blogContent");
        checkRequiredField(request.getBlogPicture(),"blogPicture");
    }


    public void validateBlogExist(String id) {
        if (repository.existsById(id)) return;

        throw new EntityNotFoundException(BLOG_DOES_NOT_EXIST);
    }

    private void checkRequiredField(String value, String errorMsg) {
        if (null == value || value.trim().isEmpty())
            throw new BadRequestException(errorMsg.toLowerCase() + " is required");
    }

}
