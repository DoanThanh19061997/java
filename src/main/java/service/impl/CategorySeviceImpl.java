package service.impl;

import Contact.Status;
import dao.ICategoryDAO;
import dao.impl.CategoryDAOImpl;
import model.CategoryModel;
import service.ICategorySevice;

import java.util.List;

public class CategorySeviceImpl implements ICategorySevice {
    private ICategoryDAO iCategoryDAO ;

    public CategorySeviceImpl() {
        this.iCategoryDAO = new CategoryDAOImpl();
    }


    @Override
    public void createCategory(CategoryModel categoryModel) {
                iCategoryDAO.createCategory(categoryModel);
    }

    @Override
    public List<CategoryModel> findAll() {
       return iCategoryDAO.findAll();

    }

    @Override
    public void updateCategory(Long id, CategoryModel categoryModel) {

         iCategoryDAO.updateCategory(id,categoryModel);
    }

    @Override
    public void delete(Long id) {
        iCategoryDAO.delete(id);
    }

    @Override
    public CategoryModel findOneById(Long id) {
        return iCategoryDAO.findByID(id);
    }
}
