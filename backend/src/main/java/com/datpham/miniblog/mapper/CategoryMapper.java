package com.datpham.miniblog.mapper;


import com.datpham.miniblog.entity.CategoryEntity;
import com.datpham.miniblog.repository.CategoryRepository;
import io.tej.SwaggerCodgen.model.CategoryList;
import io.tej.SwaggerCodgen.model.CategoryRequest;
import io.tej.SwaggerCodgen.model.Category;
import io.tej.SwaggerCodgen.model.CategoryList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;


@Service
public class CategoryMapper {
    
    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryMapper(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }
    
    public Category mapCategoryFromCategoryEntity(CategoryEntity categoryEntity) {
        Category to = new Category();
        to.setId(categoryEntity.getCategoryId() );
        to.setName(categoryEntity.getCategoryName());
        to.setType(categoryEntity.getCategoryType());
        return to;
    }

    public CategoryList mapCategoryListFromCategoryEntities(List<CategoryEntity> from) {

        CategoryList list = new CategoryList();

        from.forEach(categoryEntity -> {
            list.add(mapCategoryFromCategoryEntity(categoryEntity));
        });

        return list;
    }


    public CategoryEntity mapCategoryEntityFromCategoryRequest(CategoryRequest request) {
        CategoryEntity entity = new CategoryEntity();

        entity.setCategoryId(UUID.randomUUID().toString());
        return getCategoryEntity(request, entity);
    }

    public CategoryEntity mapCategoryEntityFromCategoryRequest(String categoryId, CategoryRequest request) {
        CategoryEntity entity = new CategoryEntity();

        entity.setCategoryId(categoryId);
        return getCategoryEntity(request, entity);
    }

    private CategoryEntity getCategoryEntity(CategoryRequest request, CategoryEntity entity) {
        entity.setCategoryName(request.getName());
        entity.setCategoryType(request.getType());
        return entity;
    }

}
