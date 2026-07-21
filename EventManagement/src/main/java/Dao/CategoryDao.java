package Dao;

import Dto.CategoryDto;

public interface CategoryDao {

    boolean addCategory(CategoryDto category);

    boolean existsById(int categoryId);

}
