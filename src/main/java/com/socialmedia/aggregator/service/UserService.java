package com.socialmedia.aggregator.service;

import com.socialmedia.aggregator.exceptions.UserException;
import com.socialmedia.aggregator.model.User;

public interface UserService {

    public User getUserByUserName(String userName) throws  UserException;

    public User createUser(String userName, String userPassword) throws UserException;

    public void removeUser(String userName, String userPassword) throws UserException;

    public User updateUser(String userName, String userPassword) throws UserException;

}
