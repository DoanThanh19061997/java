package dao.impl;

import dao.IUserDAO;
import mapper.UserMapper;
import model.UserModel;

import java.util.List;


public class UserDaoImpl extends AbtractDAOI<UserModel> implements IUserDAO {
    public void insertUser(UserModel userModel) {
        String sql ="INSERT INTO user(username, password, firstname, lastname, createddate, email, sex, roleid)\n" +
                "values (?,?,?,?,?,?,?,?)";
        insert(sql, userModel.getUserName(), userModel.getPassword(), userModel.getFirstName(), userModel.getLastName(),
                userModel.getCreatedDate(), userModel.getEmail(), userModel.getSex(), userModel.getRoleId());
    }

    public void updateUser(long id, UserModel userModel) {
        String sql = "UPDATE user SET username=?,password=?,firstname=?,lastname=?,createddate=?,email=?,sex=?,roleid=? WHERE id = ?";
        insert(sql, userModel.getUserName(), userModel.getPassword(), userModel.getFirstName(), userModel.getLastName(),
                userModel.getCreatedDate(), userModel.getEmail(), userModel.getSex(), userModel.getRoleId(),id);
    }

    public List<UserModel> findAll() {
        String sql = "SELECT * FROM user";
        return query(sql, new UserMapper());
    }

    public UserModel findOne(String userName, String password) {
        String sql = "SELECT * FROM user WHERE username=? AND  password=?";
        List<UserModel> list = query(sql, new UserMapper(), userName,password);
        return list.isEmpty() ? null : list.get(0);
    }

    @Override
    public UserModel findUserById(Long id) {
        String sql = "SELECT * FROM user WHERE userid=?";
        List<UserModel> userModels = query(sql, new UserMapper(), id);
        return userModels.isEmpty()?null :userModels.get(0);
    }


    public static void main(String[] args) {
        IUserDAO iUserDAO = new UserDaoImpl();
        UserModel userModelList = iUserDAO.findOne("binhdinh","123456");
        System.out.println(userModelList);
//        for (UserModel user : userModelList) {
//            System.out.println(user);
//        }
////        Date date = new Date();
////        Timestamp timestamp = new Timestamp(date.getTime());
////        UserModel user = new UserModel();
////        user.setUserId(1);
////        user.setUserName("binhdinh");
////        user.setPassword("123456");
////        user.setFirstName("dinh");
////        user.setLastName("binh");
////        user.setCreatedDate(timestamp);
////        user.setEmail("binhdinh@gmail.com");
////        user.setSex(1);
////        user.setRoleId(1);
////        iUserDAO.insert(user);
    }
}
