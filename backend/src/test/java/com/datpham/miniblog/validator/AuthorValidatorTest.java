package com.datpham.miniblog.validator;


import com.datpham.miniblog.exception.EntityNotFoundException;
import com.datpham.miniblog.mock.AuthorData;
import com.datpham.miniblog.repository.AuthorRepository;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class AuthorValidatorTest {

    @InjectMocks
    AuthorValidator authorValidator;

    @Mock
    AuthorRepository authorRepository;

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void validateAddAuthorExist() {
        when(authorRepository.existsById(AuthorData.AUTHOR_ID)).thenReturn(true);

        authorValidator.validateAuthorExist(AuthorData.AUTHOR_ID);
    }

    @Test
    public void validateAddAuthor() {
        authorValidator.validateAddAuthor(AuthorData.mockAuthorRequest());
    }

    @Test
    public void validateAuthorShowExceptionWhenWrongAuthorId() {
        exception.expect(EntityNotFoundException.class);
        exception.expectMessage("Author does not exist");

        when(authorRepository.existsById(AuthorData.AUTHOR_ID)).thenReturn(false);

        authorValidator.validateAuthorExist(AuthorData.AUTHOR_ID);

    }


}
