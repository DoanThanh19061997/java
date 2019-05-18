package filter;

import model.RoleModel;
import model.UserModel;
import service.IRoleService;
import service.impl.RoleService;
import utils.SessionUtil;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AuthorticationFilter implements Filter {
    private ServletContext context;
    private IRoleService roleService;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        context = filterConfig.getServletContext();
        roleService = new RoleService();

    }

    // khởi tạo role service của init
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        UserModel userModel = (UserModel) SessionUtil.getValue(request, "MODEL");
        String url = request.getRequestURI();
        if (url.startsWith("/admin")) {
            /*UserModel userModel = (UserModel) SessionUtil.getValue(request, "MODEL");*/
            if (userModel != null) {
                RoleModel roleModel = roleService.findOneById(userModel.getRoleId());
                if (roleModel.getRoleName().equals("ADMIN")) {
                    filterChain.doFilter(request, response);
                } else if (roleModel.getRoleName().equals("USER")) {
                    response.sendRedirect(request.getContextPath() + "/login?message=notPermission");
                }
            } else {
                response.sendRedirect(request.getContextPath() + "/login?message=notLogin");
            }
        } else {
            filterChain.doFilter(request, response);
        }

    }

    @Override
    public void destroy() {

    }
}
