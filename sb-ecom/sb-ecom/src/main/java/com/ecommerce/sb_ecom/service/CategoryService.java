package com.ecommerce.sb_ecom.service;

import com.ecommerce.sb_ecom.model.Category;

import java.util.List;

public interface CategoryService {
    List<Category> getAlLCategories();
    void createCategory(Category category);
    String deleteCategory(Long categoryId);
}
