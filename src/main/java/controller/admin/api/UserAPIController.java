package controller.admin.api;

import model.RoleModel;
import model.UserModel;
import service.IRoleService;
import service.IUserService;
import service.impl.UserService;
import utils.MapJsonToModelUtils;
import utils.SessionUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/api/admin/user")
public class UserAPIController  extends HttpServlet {
    private IUserService userService;
    private IRoleService roleService;

    public UserAPIController() {
        this.userService = new UserService();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("application/json");
        UserModel user = MapJsonToModelUtils
                .of(req.getReader())
                .toModel(UserModel.class);

        userService.createUser(user);
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPut(req, resp);
    }
}
