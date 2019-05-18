package service;

import model.CategoryModel;

import java.util.List;

public interface ICategorySevice {
    void createCategory(CategoryModel categoryModel);
    List<CategoryModel> findAll();
    void updateCategory(Long id, CategoryModel categoryModel);
    void delete(Long id);
    CategoryModel findOneById(Long id);
}
