package controller.web;

import model.UserModel;
import model.request.Auth;
import security.Authentcation;
import service.ICategorySevice;
import service.IRoleService;
import service.IUserService;
import service.impl.RoleService;
import service.impl.UserService;
import utils.FormUtil;
import utils.SessionUtil;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/login","/logout"})
public class AuthController extends HttpServlet {
    private IUserService userService;
    private IRoleService roleService;



    public AuthController() {
        this.userService = new UserService();
        this.roleService = new RoleService();

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String message = req.getParameter("message");
        String action = req.getParameter("action");
        if (message != null) {
            if (message.equals("userNameOrPasswordInvalues")) {
                req.setAttribute("message", "Đăng nhập sai rồi kìa! Nhìn Gì >.<");
            } else if (message.equals("notPermission")) {
                req.setAttribute("message", "bạn k có quyền truy cập đường dẫn này");
            } else if (message.equals("notLogin")) {
                req.setAttribute("message", "bạn chưa đăng nhập tài khoản");
            }
        }
        if (action !=null && action.equals("logout")){
            SessionUtil.xoaDL(req,"MODEL");
            resp.sendRedirect("/home");
        }
        else {
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/views/login.jsp");
            requestDispatcher.forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        String userName = req.getParameter("userName");
//        String password = req.getParameter("password");

        Auth auth = FormUtil.mapToModel(Auth.class, req);
        UserModel userModel = userService.findUserNameAndPass(auth);
        String url = Authentcation.newModel(auth.getUserName(), auth.getPassword()).urlRedirect(req);
        resp.sendRedirect(url);
    }
}
