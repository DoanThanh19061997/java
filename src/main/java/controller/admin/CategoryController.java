package controller.admin;

import model.CategoryModel;
import model.NewsModel;
import service.ICategorySevice;
import service.impl.CategorySeviceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
@WebServlet("/admin/category")
public class CategoryController extends HttpServlet {
    private ICategorySevice categorySevice;

    public CategoryController() {
        this.categorySevice = new CategorySeviceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String type = req.getParameter("type");
        String view = "/views/admin/category/list.jsp";
        if (type != null) {
            if (type.equals("edit")) {
                String i = req.getParameter("id");
                Long id = Long.parseLong(i);
                CategoryModel categoryModel = categorySevice.findOneById(id);
                req.setAttribute("category", categoryModel);
            }
            view = "/views/admin/category/edit.jsp";
        } else {
            List<CategoryModel> list = categorySevice.findAll();
            req.setAttribute("categories", list);
        }

        RequestDispatcher requestDispatcher = req.getRequestDispatcher(view);
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
