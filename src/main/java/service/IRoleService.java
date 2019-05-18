package service;

import model.RoleModel;

import java.util.List;

public interface IRoleService {
    void creatRole(RoleModel roleModel);
    void updateRole(Long id, RoleModel roleModel);
    void deleteRole(Long id);
    List<RoleModel> findAll();
    RoleModel findOneById(Long id);

}
