package controller.admin.api;

import model.RoleModel;
import model.UserModel;
import service.IRoleService;
import service.impl.RoleService;
import utils.MapJsonToModelUtils;
import utils.SessionUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/api/admin/role")
public class RoleAPIController extends HttpServlet {
    private IRoleService roleService;

    public RoleAPIController() {
        this.roleService =  new RoleService();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("application/json");
        RoleModel role = MapJsonToModelUtils.of(req.getReader()).toModel(RoleModel.class);

        roleService.creatRole(role);

    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("application/json");
        RoleModel role = MapJsonToModelUtils.of(req.getReader()).toModel(RoleModel.class);
        roleService.updateRole(role.getRoleId(),role);

    }
}
