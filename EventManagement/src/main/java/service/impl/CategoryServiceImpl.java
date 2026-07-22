package service.impl;

import Dao.CategoryDao;
import Dao.impl.CategoryDaoImpl;
import Dto.CategoryDto;
import service.CategoryService;

public class CategoryServiceImpl implements CategoryService {

    CategoryDao categoryDao = new CategoryDaoImpl();

    @Override
    public boolean addCategory(CategoryDto category) {

        if (category == null) {
            System.out.println("Category object is null.");
            return false;
        }

        if (category.getCategoryName() == null || category.getCategoryName().trim().isEmpty()) {
            System.out.println("Category name is required.");
            return false;
        }

        if (category.getDescription() == null || category.getDescription().trim().isEmpty()) {
            System.out.println("Description is required.");
            return false;
        }

        return categoryDao.addCategory(category);
    }
}
