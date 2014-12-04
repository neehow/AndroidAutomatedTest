package com.liepin.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.liepin.entity.User;

public class Generator {

    public static User createUser() {
        SimpleDateFormat format = new SimpleDateFormat("MMddHHmmss");
        User user = new User();
        user.setPhone("1"+format.format(new Date()));
        user.setPassword("654321");
        return user;
    }
}
