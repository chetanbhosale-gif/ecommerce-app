package com.ecommerce.sb_ecom.service;

import com.ecommerce.sb_ecom.model.Category;
import com.ecommerce.sb_ecom.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.*;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements  CategoryService{
    //private List<Category> categories=new ArrayList<>();
    private long nextId=1;

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<Category> getAlLCategories() {
        return categoryRepository.findAll();

    }

    @Override
    public void createCategory(Category category) {
        category.setCategoryID(nextId++);
        //categories.add(category);
        categoryRepository.save(category);

    }

    @Override
    public String deleteCategory(Long categoryId) {
        List<Category> categories= categoryRepository.findAll();
        Category category=categories.stream().
                filter(n->n.getCategoryID()==(categoryId)).findFirst().orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,"Resource not found"));
//        if(category==null){
//            return "Category not found";
//        }
        //categories.remove(category);
        categoryRepository.delete(category);
        return "Category with categoryId: "+categoryId+" deleted";
    }

    @Override
    public Category updateCategory(Category category, long categoryId) {
        List<Category> categories= categoryRepository.findAll();
        Optional<Category> optionalCategory=categories.stream().
                filter(n->n.getCategoryID()==(categoryId)).findFirst();
        if(optionalCategory.isPresent()) {
            Category existingCategory=optionalCategory.get();
            existingCategory.setCategoryName(category.getCategoryName());
            Category savedCategory=categoryRepository.save(existingCategory);
            return existingCategory;
        }
        else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Resource not found");

        }
    }




}
