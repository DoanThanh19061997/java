package mapper;

import model.UserModel;
import utils.MapperUtilt;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserMapper implements RowMapper<UserModel> {
    public UserModel mapRow(ResultSet rs) {
        UserModel userModel = new UserModel();
        MapperUtilt.map(userModel,rs);
        /*try {
            userModel.setUserId(rs.getLong("userid"));
            if (rs.getString("username") != null){
                userModel.setUserName(rs.getString("username"));
            }
            if (rs.getString("email") != null){
                userModel.setEmail(rs.getString("email"));
            }
            if (rs.getTimestamp("createddate") != null){
                userModel.setCreatedDate(rs.getTimestamp("createddate"));
            }
            if (rs.getString("lastname") != null){
                userModel.setLastName(rs.getString("lastname"));
            }
            if (rs.getString("firstname") != null){
                userModel.setFirstName(rs.getString("firstname"));
            }
            if (rs.getString("password") != null){
                userModel.setPassword(rs.getString("password"));
            }
            userModel.setSex(rs.getInt("sex"));
            userModel.setRoleId(rs.getLong("roleid"));

        } catch (SQLException e) {
            e.printStackTrace();
        }*/
        return userModel;
    }
}
