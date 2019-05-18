package security;

import model.RoleModel;
import model.UserModel;
import model.request.Auth;
import service.IRoleService;
import service.IUserService;
import service.impl.RoleService;
import service.impl.UserService;
import utils.SessionUtil;

import javax.servlet.http.HttpServletRequest;

public class AuthenticationImpl implements Authentcation {
    private String userName;
    private String password;
    private IUserService userService = new UserService();
    private IRoleService roleService = new RoleService();

    public AuthenticationImpl() {
    }

    public AuthenticationImpl(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }


    @Override
    public String urlRedirect(HttpServletRequest request) {
        UserModel userModel =  userService.findUserNameAndPass(new Auth(userName, password));
        if (userModel!=null){
            SessionUtil.getSessionUtilIntance().putValue(request,"MODEL",userModel);
            /*RoleModel role= roleService.findAll(userModel.getRoleId());*/
            RoleModel role = roleService.findOneById(userModel.getRoleId());
            if (role.getRoleName().equals("ADMIN")){
                return "/admin";
            }else if(role.getRoleName().equals("USER")){
                return "/home";
            }
        }else{
            return "/login?message=userNameOrPasswordInvalist";
        }
        return null;
    }
}
