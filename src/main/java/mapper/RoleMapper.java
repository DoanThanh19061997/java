package mapper;

import model.RoleModel;
import utils.MapperUtilt;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RoleMapper implements RowMapper<RoleModel> {
    public RoleModel mapRow(ResultSet rs) {
        RoleModel roleModel = new RoleModel();
        MapperUtilt.map(roleModel,rs);

        return roleModel;
    }
}
