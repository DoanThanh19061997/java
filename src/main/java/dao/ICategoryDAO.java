package dao;

import model.CategoryModel;

import java.util.List;

public interface ICategoryDAO extends IGenericDao<CategoryModel> {
    void createCategory(CategoryModel categoryModel);
    List<CategoryModel> findAll();
   CategoryModel findByID(Long id);
    void updateCategory(Long id, CategoryModel categoryModel);
    void delete(Long id);
}
