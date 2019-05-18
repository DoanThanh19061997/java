package dao;

import model.UserModel;

import java.util.List;

public interface IUserDAO {
    void insertUser(UserModel userModel);
    void updateUser(long id, UserModel userModel);
//    void delete (long userId);
    List<UserModel> findAll();
    UserModel findOne(String userName, String password);
    UserModel findUserById(Long id);

}
