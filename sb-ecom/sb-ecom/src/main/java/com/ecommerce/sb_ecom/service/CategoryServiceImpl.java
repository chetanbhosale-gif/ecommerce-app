package com.ecommerce.sb_ecom.service;

import com.ecommerce.sb_ecom.model.Category;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class CategoryServiceImpl implements  CategoryService{
    private List<Category> categories=new ArrayList<>();
    private long nextId=1;

    @Override
    public List<Category> getAlLCategories() {
        return categories;

    }

    @Override
    public void createCategory(Category category) {
        category.setCategoryID(nextId++);
        categories.add(category);

    }

    @Override
    public String deleteCategory(Long categoryId) {
        Category category=categories.stream().
                filter(n->n.getCategoryID()==(categoryId)).findFirst().orElse(null);
        if(category==null){
            return "Category not found";
        }
        categories.remove(category);
        return "Category with categoryId: "+categoryId+" deleted";
    }



}
