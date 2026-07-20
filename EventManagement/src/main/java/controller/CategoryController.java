package controller;

import Dto.CategoryDto;
import service.CategoryService;
import service.impl.CategoryServiceImpl;

public class CategoryController {

 CategoryService categoryService = new CategoryServiceImpl();

    public boolean addCategory(CategoryDto category){
        return categoryService.addCategory(category);
    }
}
