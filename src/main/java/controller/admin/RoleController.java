package controller.admin;

import model.CategoryModel;
import model.RoleModel;
import service.ICategorySevice;
import service.IRoleService;
import service.impl.CategorySeviceImpl;
import service.impl.RoleService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/admin/role")
public class RoleController extends HttpServlet {
    private IRoleService roleService;
    private ICategorySevice categorySevice;

    public RoleController() {
        this.roleService = new RoleService();
        this.categorySevice = new CategorySeviceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String type = req.getParameter("type");
        String view ="";
        if (type !=null){
            if (type.equals("edit")){
                String i = req.getParameter("id");
                Long id = Long.parseLong(i);
                RoleModel roleModel = roleService.findOneById(id);
                req.setAttribute("role",roleModel);
            }
            /*List<CategoryModel> list = categorySevice.findAll();
            req.setAttribute("categories",list);*/
            view = "/views/admin/role/edit.jsp";
        }else {
            view = "/views/admin/role/list.jsp";
        }

        List<RoleModel> listRole =roleService.findAll();
        req.setAttribute("roles",listRole);

        RequestDispatcher requestDispatcher = req.getRequestDispatcher(view);
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
