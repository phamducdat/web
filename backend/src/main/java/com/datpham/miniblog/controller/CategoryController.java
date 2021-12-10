package com.datpham.miniblog.controller;

import com.datpham.miniblog.service.CategoryService;
import io.tej.SwaggerCodgen.api.CategorysApi;
import io.tej.SwaggerCodgen.model.Category;
import io.tej.SwaggerCodgen.model.CategoryList;
import io.tej.SwaggerCodgen.model.CategoryRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("/miniblogs/backend/v1")
public class CategoryController implements CategorysApi {

    private final CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @Override
    public ResponseEntity<Category> getCategoryById(String categoryId) {
        Category category = categoryService.getCategoryId(categoryId);
        return new ResponseEntity<>(category, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Category> updateCategory(String categoryId, CategoryRequest categoryRequest) {
        Category category = categoryService.updateCategory(categoryId, categoryRequest);
        return new ResponseEntity<>(category, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Void> deleteCategory(String categoryId) {
        categoryService.deleteCategory(categoryId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @Override
    public ResponseEntity<CategoryList> getAllCategory() {
        CategoryList categoryList = categoryService.getAllCategories();
        return new ResponseEntity<>(categoryList, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Category> createCategory(CategoryRequest categoryRequest) {
        Category category = categoryService.create(categoryRequest);
        return new ResponseEntity<>(category, HttpStatus.OK);
    }
}
