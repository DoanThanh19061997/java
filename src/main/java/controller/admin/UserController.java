package controller.admin;

import model.CategoryModel;
import model.RoleModel;
import model.UserModel;
import service.IRoleService;
import service.IUserService;
import service.impl.RoleService;
import service.impl.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/admin/user")
public class UserController  extends HttpServlet {
    private IUserService userService;
    private IRoleService roleService;

    public UserController() {
        this.userService = new UserService();
        this.roleService = new RoleService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String type = req.getParameter("type");
        String view ="";
        if (type !=null){
            if (type.equals("edit")){
                String i = req.getParameter("id");
                long id = Long.parseLong(i);
                UserModel userModel = userService.findUserById(id);
                req.setAttribute("user",userModel);
            }
            List<RoleModel> roleModels = roleService.findAll();
            req.setAttribute("roles",roleModels);
            view = "/views/admin/user/edit.jsp";
        }else {
            List<UserModel> listUser =userService.findAll();
            req.setAttribute("users",listUser);
            view = "/views/admin/user/list.jsp";
        }
        RequestDispatcher requestDispatcher = req.getRequestDispatcher(view);
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
