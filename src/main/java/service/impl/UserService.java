package service.impl;

import dao.IUserDAO;
import dao.impl.UserDaoImpl;
import model.UserModel;
import model.request.Auth;
import service.IUserService;

import java.sql.Timestamp;
import java.util.List;

public class UserService implements IUserService {
    private IUserDAO userDAO;

    public UserService(){
        this.userDAO = new UserDaoImpl();
    }

    public UserModel findUserNameAndPass(Auth auth) {
        return userDAO.findOne(auth.getUserName(), auth.getPassword());
    }

    public void createUser(UserModel userModel) {
        userModel.setCreatedDate(new Timestamp(System.currentTimeMillis()));
        userDAO.insertUser(userModel);
    }

    public void updateUser(Long id, UserModel userModel) {
        userDAO.updateUser(id, userModel);
    }

    @Override
    public UserModel findUserById(Long id) {
        return userDAO.findUserById(id);
    }

    @Override
    public List<UserModel> findAll() {
        return userDAO.findAll();
    }
}
