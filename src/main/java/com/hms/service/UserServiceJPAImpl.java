package com.hms.service;

import com.hms.model.User;

import com.hms.repository.UserJPARepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class UserServiceJPAImpl implements UserService {

    @Autowired
    private UserJPARepo userJPARepo;

    @Override
    public User saveUser(User user) {

        return userJPARepo.save(user);
    }

    @Override
    public List<User> fetchUserList() {

        return userJPARepo.findAll();
    }

    @Override
    public User fetchUserById(int id) {

        return userJPARepo.findById(id).orElse(null);
    }

    @Override
    public void deleteUserById(int userId) {
        userJPARepo.deleteById(userId);
    }


}
