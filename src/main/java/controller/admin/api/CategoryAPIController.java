package controller.admin.api;

import model.CategoryModel;
import model.UserModel;
import service.ICategorySevice;
import service.impl.CategorySeviceImpl;
import utils.MapJsonToModelUtils;
import utils.SessionUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/api/admin/category")
public class CategoryAPIController extends HttpServlet {
    private ICategorySevice categorySevice;

    public CategoryAPIController() {
        this.categorySevice = new CategorySeviceImpl();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("application/json");
        CategoryModel categoryModel = MapJsonToModelUtils
                .of(req.getReader())
                .toModel(CategoryModel.class);
       categorySevice.createCategory(categoryModel);
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("application/json");
        CategoryModel categoryModel = MapJsonToModelUtils
                .of(req.getReader())
                .toModel(CategoryModel.class);
        categorySevice.updateCategory(categoryModel.getId(),categoryModel);

    }
}
