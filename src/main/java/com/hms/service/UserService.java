package com.hms.service;

import com.hms.model.User;

import java.util.List;


public interface UserService {
    User saveUser(User user);


    List<User> fetchUserList();

    User fetchUserById(int id);


    void deleteUserById(int id);



}
