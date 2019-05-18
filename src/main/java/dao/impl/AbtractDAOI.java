package dao.impl;

import dao.IGenericDao;
import mapper.RowMapper;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AbtractDAOI<T> implements IGenericDao<T> {
    String url = "jdbc:mysql://localhost:3306/news";
    String user = "root";
    String password = "1234";

    public Connection getConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            return DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException e) {
            return null;
        } catch (SQLException e) {
            return null;
        }
    }

    public List<T> query(String sql, RowMapper<T> rowMapper, Object... parameter) {
        Connection connection = null;
        ResultSet rs = null;
        PreparedStatement pr = null;
        List<T> results = new ArrayList<T>();
        try {
            connection = getConnection();
            pr = getConnection().prepareStatement(sql);
            setParameter(pr,parameter);
            rs = pr.executeQuery();
            while (rs.next()) {
                T t = rowMapper.mapRow(rs);
                results.add(t);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return results;
    }

    public void insert(String sql, Object... parameters) {
        Connection connection = null;
        PreparedStatement pr = null;
        try {
            connection = getConnection();
            connection.setAutoCommit(false);
            pr = getConnection().prepareStatement(sql);
            setParameter(pr, parameters);
            pr.executeUpdate();
            connection.commit();
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        }finally {
            if (pr != null){
                try {
                    pr.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null){
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void update(String sql, Object... parameter) {
        Connection connection = null;
        PreparedStatement pr = null;
        try {
            connection = getConnection();
            connection.setAutoCommit(false);
            pr = getConnection().prepareStatement(sql);
            setParameter(pr,parameter);
            pr.executeUpdate();
            connection.commit();
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        }finally {
            if (pr != null){
                try {
                    pr.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null){
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void setParameter(PreparedStatement ps, Object... parametera) {
        int length = parametera.length;
        try {
            for (int i = 0; i < length; i++) {
                int index = i + 1;
                Object parameter = parametera[i];
                if (parameter instanceof String) {
                    ps.setString(index, (String) parameter);
                } else if (parameter instanceof Long) {
                    ps.setLong(index, (Long) parameter);
                } else if (parameter instanceof Integer) {
                    ps.setInt(index, (Integer) parameter);
                } else if (parameter instanceof Boolean) {
                    ps.setBoolean(index, (Boolean) parameter);
                } else if (parameter instanceof Timestamp) {
                    ps.setTimestamp(index, (Timestamp) parameter);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
