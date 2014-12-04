package com.liepin.dao;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public abstract class GenericDAO<T> {

    public static final String DRIVER            = "com.mysql.jdbc.Driver";
    public static final String URL               = "jdbc:mysql://10.10.10.240:3306/wireless?characterEncoding=UTF-8";
    public static final String DBNAME            = "root";
    public static final String DBPASS            = "123456";

    private Connection         connection        = null;
    private PreparedStatement  preparedStatement = null;
    private ResultSet          resultSet         = null;

    public void getConn() {
        try {
            Class.forName(DRIVER);
            this.connection = DriverManager.getConnection(URL, DBNAME, DBPASS);
        } catch (ClassNotFoundException e1) {
            e1.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void closeAll() {
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        if (preparedStatement != null) {
            try {
                preparedStatement.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        if (connection != null) {
            try {
                connection.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    public List<T> executeSQL(String sql, String[] params) {
        this.getConn();
        try {
            this.preparedStatement = this.connection.prepareStatement(sql);
            if (params != null) {
                for (int i = 1; i <= params.length; i++) {
                    this.preparedStatement.setString(i, params[i - 1]);
                }
            }
            this.resultSet = this.preparedStatement.executeQuery();
            int count = this.resultSet.getMetaData().getColumnCount();
            List<T> list = new ArrayList<T>();
            @SuppressWarnings("unchecked")
            Class<T> cls = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
            while (resultSet.next()) {
                T t = cls.newInstance();
                Field[] fields = cls.getDeclaredFields();
                for (Field field : fields) {
                    for (int i = 1; i <= count; i++) {
                        String columnName = resultSet.getMetaData().getColumnName(i);
                        String fieldName = field.getName().toLowerCase();
                        if (columnName.equals(fieldName)) {
                            field.setAccessible(true);
                            field.set(t, this.resultSet.getObject(fieldName));
                        }
                    }
                }
                list.add(t);
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } catch (InstantiationException e) {
            e.printStackTrace();
            return null;
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            return null;
        } finally {
            this.closeAll();
            resultSet = null;
            preparedStatement = null;
            connection = null;
        }
    }

    public int executeUpdate(String sql, String[] params) {
        int result = -1;
        try {
            this.getConn();
            this.preparedStatement = this.connection.prepareStatement(sql);
            if (params != null) {
                for (int i = 1; i <= params.length; i++)
                    this.preparedStatement.setString(i, params[i - 1]);
            }
            result = this.preparedStatement.executeUpdate();
            return result;
        } catch (Exception ex) {
            ex.printStackTrace();
            return -1;
        } finally {
            this.closeAll();
            resultSet = null;
            preparedStatement = null;
            connection = null;
        }

    }
}