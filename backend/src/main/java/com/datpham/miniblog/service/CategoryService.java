package com.datpham.miniblog.service;

import com.datpham.miniblog.entity.CategoryEntity;
import com.datpham.miniblog.mapper.CategoryMapper;
import com.datpham.miniblog.repository.CategoryRepository;
import io.tej.SwaggerCodgen.model.Category;
import io.tej.SwaggerCodgen.model.CategoryList;
import io.tej.SwaggerCodgen.model.CategoryRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {
    private final CategoryRepository categoryRepository;
    private final CategoryMapper mapper;


    @Autowired
    public CategoryService(CategoryRepository categoryRepository, CategoryMapper mapper) {
        this.categoryRepository = categoryRepository;
        this.mapper = mapper;
    }

    public Category create(CategoryRequest categoryRequest) {
        CategoryEntity entity = categoryRepository.save(mapper.mapCategoryEntityFromCategoryRequest(categoryRequest));
        return mapper.mapCategoryFromCategoryEntity(entity);
    }

    public CategoryList getAllCategories() {

        return mapper.mapCategoryListFromCategoryEntities(categoryRepository.findAll());
    }

    public Category getCategoryId(String categoryId) {
        CategoryEntity entity = categoryRepository.getById(categoryId);

        return mapper.mapCategoryFromCategoryEntity(entity);
    }

    public Category updateCategory(String id, CategoryRequest categoryRequest) {
        CategoryEntity categoryEntity = mapper.mapCategoryEntityFromCategoryRequest(id, categoryRequest);
        categoryRepository.save(categoryEntity);
        return mapper.mapCategoryFromCategoryEntity(categoryEntity);
    }

    public void deleteCategory(String categoryId) {
        categoryRepository.deleteById(categoryId);
    }
}
