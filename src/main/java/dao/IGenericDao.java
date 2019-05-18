package dao;

import mapper.RowMapper;

import java.util.List;

public interface IGenericDao<T>  {
    List<T> query(String sql, RowMapper<T> rowMapper, Object... parameter);
    void insert(String sql, Object... parameter);
    void update(String sql, Object... parameter);
}
