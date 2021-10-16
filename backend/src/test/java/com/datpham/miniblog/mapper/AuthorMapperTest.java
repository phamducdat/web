package com.datpham.miniblog.mapper;

import com.datpham.miniblog.entity.AuthorEntity;
import com.datpham.miniblog.mock.AuthorData;
import com.datpham.miniblog.repository.AuthorRepository;
import io.tej.SwaggerCodgen.model.Author;
import io.tej.SwaggerCodgen.model.AuthorList;
import io.tej.SwaggerCodgen.model.AuthorRequest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;



@RunWith(MockitoJUnitRunner.class)
public class AuthorMapperTest {

    @InjectMocks
    AuthorMapper mapper;

    @Mock
    AuthorRepository repository;

    @Test
    public void ensureMapAuthorEntityFromAuthorRequestForAdd() {
        AuthorRequest request = AuthorData.mockAuthorRequest();

        AuthorEntity entity = mapper.mapAuthorEntityFromAuthorRequest(request);

        assertNotNull(entity.getAuthorId());
        assertEquals(request.getAuthorAvatar(), entity.getAuthorAvatar());
        assertEquals(request.getAuthorEmail(), entity.getAuthorEmail());
        assertEquals(request.getAuthorName(), entity.getAuthorName());
        assertEquals(request.getAuthorDescription(), entity.getAuthorDescription());
    }

    @Test
    public void ensureMapAuthorEntityToAuthorRequest() {
        System.out.println("Get in");
        AuthorEntity authorEntity = AuthorData.mockAuthorEntity();
        when(repository.getById(AuthorData.AUTHOR_ID)).thenReturn(authorEntity);
        AuthorRequest request = AuthorData.mockAuthorRequest();
        AuthorEntity entity = mapper.mapAuthorEntityFromAuthorRequest(AuthorData.AUTHOR_ID, request);
        assertNotNull(entity.getAuthorId());
        assertEquals(request.getAuthorDescription(), entity.getAuthorDescription());
        assertEquals(request.getAuthorAvatar(), entity.getAuthorAvatar());
        assertEquals(request.getAuthorEmail(), entity.getAuthorEmail());
        assertEquals(request.getAuthorName(), entity.getAuthorName());
    }

    private void assertAuthorList(List<AuthorEntity> authorEntities, AuthorList authorList) {
        assertAuthor(authorEntities.get(0), authorList.get(0));
    }

    @Test
    public void ensureMapAuthorListFromAuthorEntities() {
        List<AuthorEntity> authorEntities = AuthorData.mockAuthorEntityList();
        AuthorList authorList = mapper.mapAuthorListFroAuthorEntities(authorEntities);
        assertAuthorList(authorEntities, authorList);
    }

    private void assertAuthor(AuthorEntity entity, Author author) {
        assertEquals(entity.getAuthorAvatar(), author.getAuthorAvatar());
        assertEquals(entity.getAuthorId(), author.getAuthorId());
        assertEquals(entity.getAuthorEmail(), author.getAuthorEmail());
        assertEquals(entity.getAuthorDescription(), author.getAuthorDescription());
        assertEquals(entity.getAuthorName(), author.getAuthorName());

    }

    @Test
    public void ensureMapAuthorFromAuthorEntity() {
        AuthorEntity entity = AuthorData.mockAuthorEntity();

        Author author = mapper.mapAuthorFromAuthorEntity(entity);
        assertEquals(entity.getAuthorAvatar(), author.getAuthorAvatar());
        assertEquals(entity.getAuthorId(), author.getAuthorId());
        assertEquals(entity.getAuthorEmail(), author.getAuthorEmail());
        assertEquals(entity.getAuthorDescription(), author.getAuthorDescription());
        assertEquals(entity.getAuthorName(), author.getAuthorName());
    }

}
