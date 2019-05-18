package dao;

import model.NewsModel;
import model.RoleModel;

import java.util.List;

public interface IRoleDao extends IGenericDao<RoleModel>{
    void creatRole(RoleModel roleModel);
    void updateRole(Long id, RoleModel roleModel);
    void deleteRole(Long id);
    RoleModel findRoleById(Long id);
    List<RoleModel> findAll();
}
