package service.impl;

import dao.IRoleDao;
import dao.impl.RoleDaoImpl;
import model.RoleModel;
import service.IRoleService;

import java.util.List;

public class RoleService implements IRoleService {
    private IRoleDao roleDao;

    public RoleService(){
        this.roleDao = new RoleDaoImpl();
    }

    @Override
    public void creatRole(RoleModel roleModel) {
        roleDao.creatRole(roleModel);
    }

    @Override
    public void updateRole(Long id, RoleModel roleModel) {
        roleDao.updateRole(id,roleModel);
    }

    @Override
    public void deleteRole(Long id) {
        roleDao.deleteRole(id);
    }

    @Override
    public List<RoleModel> findAll() {
        return roleDao.findAll();
    }

    @Override
    public RoleModel findOneById(Long id) {
        return roleDao.findRoleById(id);
    }


}
