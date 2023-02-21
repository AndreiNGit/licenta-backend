package com.licenta.category;

import org.springframework.beans.factory.annotation.Autowired;

public class CategoryController {
    public CategoryRepository categoryRepository;

    public CategoryController(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }


}
