package mapper;

import model.CategoryModel;
import utils.MapperUtilt;

import java.sql.ResultSet;

public class CategoryMapper implements RowMapper<CategoryModel> {
    @Override
    public CategoryModel mapRow(ResultSet rs) {
        CategoryModel categoryModel = new CategoryModel();
        MapperUtilt.map(categoryModel, rs);
        return categoryModel;
    }
}
