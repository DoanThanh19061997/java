package utils;

import java.lang.reflect.Field;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MapperUtilt {
    public static <T> T map(T model, ResultSet rs){
        Field[] fields = model.getClass().getDeclaredFields();

            for (Field field:fields){
                field.setAccessible(true);
                try {
                    field.set(model,rs.getObject(field.getName(),field.getType()));
                } catch (IllegalAccessException e) {
                    continue;
                } catch (SQLException e) {
                    continue;
                }
            }

        return model;
    }
}
