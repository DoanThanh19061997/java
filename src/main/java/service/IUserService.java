package service;

import model.UserModel;
import model.request.Auth;

import java.util.List;

public interface IUserService {
    UserModel findUserNameAndPass(Auth auth);
    void createUser(UserModel userModel);
    void updateUser(Long id, UserModel userModel);
    UserModel findUserById(Long id);
    List<UserModel> findAll();
}
