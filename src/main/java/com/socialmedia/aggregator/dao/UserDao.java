package com.socialmedia.aggregator.dao;

import com.socialmedia.aggregator.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Query;

import java.util.Optional;

public class UserDao {

    @Autowired
    private UserRepository userRepository;

    public User findUserById(Integer id){
        return userRepository.findUserById(id);
    }

    public User createUser(User user){
        return userRepository.save(user);
    }

    public void removeUser(User user){
        userRepository.delete(user);
    }

    public User findUserByUserName(String userName){
        return userRepository.findUserByUserName(userName);
    }
}
