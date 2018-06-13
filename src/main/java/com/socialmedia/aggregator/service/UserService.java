package com.socialmedia.aggregator.service;

import com.socialmedia.aggregator.model.User;

public interface UserService {

    public User getUserById(int id);

    public User createUser(String userName, String userPassword);

    public void removeUser(String userName, String userPassword);

    public User updateUser(String userName, String userPassword);

}
