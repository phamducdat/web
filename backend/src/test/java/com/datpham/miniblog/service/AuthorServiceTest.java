package com.datpham.miniblog.service;


import com.datpham.miniblog.mapper.AuthorMapper;
import com.datpham.miniblog.mock.AuthorData;
import com.datpham.miniblog.repository.AuthorRepository;
import com.datpham.miniblog.service.AuthorService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class AuthorServiceTest {

    @InjectMocks
    AuthorService authorService;

    @Mock
    AuthorRepository authorRepository;

    @Mock
    AuthorMapper authorMapper;

    @Test
    public void createAuthor() {
        authorService.createAuthor(AuthorData.mockAuthorRequest());
    }

    @Test
    public void getAllAuthor() {
        authorService.getAllAuthor();
    }

    @Test
    public void getAuthorById(){
        authorService.getAuthorById(AuthorData.AUTHOR_ID);
    }
}
