package dao.impl;

import dao.ICategoryDAO;
import mapper.CategoryMapper;
import model.CategoryModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class CategoryDAOImpl extends AbtractDAOI<CategoryModel> implements ICategoryDAO {
    @Override
    public void createCategory(CategoryModel categoryModel) {
        String sql = "INSERT INTO category(name) VALUES(?)";
        insert(sql, categoryModel.getName());

    }

    @Override
    public List<CategoryModel> findAll() {
        String sql = "SELECT * FROM category";
        return query(sql, new CategoryMapper());
    }

    @Override
    public CategoryModel findByID(Long id) {
        String sql = "SELECT * FROM category WHERE id = ?";
        List<CategoryModel> list = query(sql, new CategoryMapper(), id);
        return list.isEmpty() ? null : list.get(0);
    }

    @Override
    public void updateCategory(Long id, CategoryModel categoryModel) {
        String sql = "UPDATE category SET name =? WHERE id =?";
        update(sql, categoryModel.getName(), id);

    }

    @Override
    public void delete(Long id) {
        String sql = "DELETE FROM category WHERE id = ?";
        Connection connection = getConnection();
        try {
            PreparedStatement pr = getConnection().prepareStatement(sql);
            pr.setLong(1, id);
            pr.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
