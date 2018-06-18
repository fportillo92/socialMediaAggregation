package com.socialmedia.aggregator.service;

import com.socialmedia.aggregator.dao.UserDao;
import com.socialmedia.aggregator.exceptions.UserException;
import com.socialmedia.aggregator.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userDao;

    @Override
    public User getUserByUserName(String username) throws UserException {

        User user = userDao.findUserByUserName(username);

        if(user != null){
            return user;
        }else throw new UserException("The user doesn't exist");

    }

    @Override
    public User createUser(String username, String userpassword) throws UserException {

        if (username != null) {
            if (userpassword != null) {
                User user = new User(username, userpassword);
                return userDao.createUser(user);
            } else throw new UserException("Password cant be empty");

        } else throw new UserException("Username cant be empty");
    }

    @Override
    public void removeUser(String username, String userpassword) throws UserException {

        User user = userDao.findUserByUserName(username);

        if (user != null) {
            if(user.getUserpassword().equals(userpassword)){
                userDao.removeUser(user);
            }else throw new UserException("Invalid password");

        } else throw new UserException("The user you're trying to remove doesn't exist.");


    }

    @Override
    public User updateUser(String username, String userpassword) throws UserException{

        User user = userDao.findUserByUserName(username);

        return null;
    }
}
