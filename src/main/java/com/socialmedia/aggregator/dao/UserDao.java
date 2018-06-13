package com.socialmedia.aggregator.dao;

import com.socialmedia.aggregator.model.User;
import org.springframework.beans.factory.annotation.Autowired;

public class UserDao {

    @Autowired
    private UserRepository userRepository;

    public User createUser(String userName, String userPassword){
        return userRepository.save(new User(userName, userPassword));
    }
}
