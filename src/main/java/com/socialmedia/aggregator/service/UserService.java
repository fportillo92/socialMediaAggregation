package com.socialmedia.aggregator.service;

import com.socialmedia.aggregator.exceptions.UserException;
import com.socialmedia.aggregator.model.User;

public interface UserService {

    public User getUserByUserName(String username) throws  UserException;

    public User createUser(String username, String userpassword) throws UserException;

    public void removeUser(String username, String userpassword) throws UserException;

    public User updateUser(String username, String userpassword) throws UserException;

}
