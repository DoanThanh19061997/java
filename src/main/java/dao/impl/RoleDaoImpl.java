package dao.impl;

import dao.IRoleDao;
import mapper.NewsMapper;
import mapper.RoleMapper;
import model.NewsModel;
import model.RoleModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class RoleDaoImpl extends AbtractDAOI<RoleModel> implements IRoleDao {
    @Override
    public void creatRole(RoleModel roleModel) {
        String sql ="INSERT INTO role(rolename) VALUES (?)";
        insert(sql,roleModel.getRoleName());
    }

    @Override
    public void updateRole(Long id, RoleModel roleModel) {
        String sql ="UPDATE role SET rolename =? WHERE roleid =?";
        update(sql,roleModel.getRoleName(),id);
    }

    @Override
    public void deleteRole(Long id) {
        String sql ="DELETE FROM role WHERE id =?";
        Connection connection = getConnection();
        try {
            PreparedStatement ps = getConnection().prepareStatement(sql);
            ps.setLong(1,id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public RoleModel findRoleById(Long id) {
        String sql = "SELECT * FROM role WHERE roleid=?";
        List<RoleModel> roleModels = query(sql, new RoleMapper(), id);
        return roleModels.isEmpty()?null : roleModels.get(0);
    }

    @Override
    public List<RoleModel> findAll() {
        String sql = "SELECT * FROM role";
        return query(sql, new RoleMapper());
    }

   /* public static void main(String[] args) {
        IRoleDao roleDao = new RoleDaoImpl();
       List<RoleModel> roleModelList = roleDao.findAll();
       for (RoleModel roleModel:roleModelList){
           System.out.println(roleModel);
       }
    }*/
}
