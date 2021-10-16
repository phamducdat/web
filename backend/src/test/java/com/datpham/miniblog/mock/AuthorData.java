package com.datpham.miniblog.mock;

import com.datpham.miniblog.entity.AuthorEntity;
import com.datpham.miniblog.entity.BlogEntity;
import com.datpham.miniblog.entity.ContactEntity;
import io.tej.SwaggerCodgen.model.Author;
import io.tej.SwaggerCodgen.model.AuthorList;
import io.tej.SwaggerCodgen.model.AuthorRequest;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class AuthorData {

    private final BlogData blogData;
    private final ContactData contactData;
    public static final String AUTHOR_ID = "224";
    public static final String AUTHOR_NAME = "dat";
    public static final String AUTHOR_EMAIL = "phamducdat2402@gmail.com";
    public static final String AUTHOR_DESCRIPTION = "test";
    public static final String AUTHOR_AVATAR = "picture";
//    public static final ArrayList<BlogEntity> BLOG_ENTITY_ARRAY_LIST = new ArrayList<>(Collections.singletonList(new BlogEntity()));

    @Autowired
    public AuthorData(BlogData blogData, ContactData contactData) {
        this.blogData = blogData;
        this.contactData = contactData;
    }


    public static Author mockAuthor() {
        Author author = new Author();
        author.setAuthorId(AUTHOR_ID);
        author.setAuthorName(AUTHOR_NAME);
        author.setAuthorEmail(AUTHOR_EMAIL);
        author.setAuthorDescription(AUTHOR_DESCRIPTION);
        author.setAuthorAvatar(AUTHOR_AVATAR);
        return author;
    }

    public static AuthorList mockAuthorList() {
        AuthorList authorList = new AuthorList();
        authorList.add(mockAuthor());
        return authorList;
    }

    public static AuthorEntity mockAuthorEntity() {
        AuthorEntity entity = new AuthorEntity();
        entity.setAuthorId(AUTHOR_ID);
        entity.setAuthorName(AUTHOR_NAME);
        entity.setAuthorEmail(AUTHOR_EMAIL);
        entity.setAuthorDescription(AUTHOR_DESCRIPTION);
        entity.setAuthorAvatar(AUTHOR_AVATAR);
        return entity;
    }

    public static AuthorRequest mockAuthorRequest() {
        AuthorRequest request = new AuthorRequest();
        request.setAuthorName(AUTHOR_NAME);
        request.setAuthorEmail(AUTHOR_EMAIL);
        request.setAuthorDescription(AUTHOR_DESCRIPTION);
        request.setAuthorAvatar(AUTHOR_AVATAR);
        return request;

    }

    public static List<AuthorEntity> mockAuthorEntityList() {

        return Collections.singletonList(mockAuthorEntity());
    }


}
