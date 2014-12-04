package com.liepin.dao;

import java.util.List;

import com.liepin.entity.User;
import com.liepin.utils.RandomControl;

public class UserDao extends GenericDAO<User> {

    private final static String SELECT_ALL_SQL = "SELECT * FROM user";
    private final static String INSERT_SQL     = "INSERT INTO user (phone, password) VALUES (?,?)";

    public User getRandomUser(){
        return RandomControl.getOneRandom(getAllUsers());
    }
    
    public List<User> getAllUsers() {
        return super.executeSQL(SELECT_ALL_SQL, null);
    }
    
    public int addUser(User user){
        String[] params = {user.getPhone(), user.getPassword()};
        return super.executeUpdate(INSERT_SQL, params);
    }
}
