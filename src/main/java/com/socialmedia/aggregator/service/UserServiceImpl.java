package com.socialmedia.aggregator.service;

import com.socialmedia.aggregator.dao.UserDao;
import com.socialmedia.aggregator.exceptions.UserException;
import com.socialmedia.aggregator.model.Hashtag;
import com.socialmedia.aggregator.model.User;
import com.socialmedia.aggregator.model.Usertag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userDao;

    @Override
    public User getUserByUserName(String username) throws UserException {

        User user = userDao.findUserByUserName(username);

        if (user != null) {
            return user;
        } else throw new UserException("The user doesn't exist");

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
            if (user.getUserpassword().equals(userpassword)) {
                userDao.removeUser(user);
            } else throw new UserException("Invalid password");

        } else throw new UserException("The user you're trying to remove doesn't exist.");


    }

    @Override
    public User updateUser(String username, String userpassword) throws UserException {

        User user = userDao.findUserByUserName(username);

        return null;
    }

    @Override
    public User addBoard(String username, String board) throws UserException {

        User user = userDao.findUserByUserName(username);

        if (user != null) {
            user.addBoard(board);
            return userDao.updateUser(user);
        } else throw new UserException("Error adding board");
    }

    @Override
    public User addHashtag(String username, String board, String hashtag) throws UserException {

        User user = userDao.findUserByUserName(username);

        if (user != null) {
            Hashtag hashtagNew = new Hashtag();
            hashtagNew.setTag(hashtag);
            user.addInterestToBoard(board, hashtagNew);
            return userDao.updateUser(user);
        } else throw new UserException("Error adding hashtag");

    }

    @Override
    public User addUserTag(String username, String board, String usertag) throws UserException {

        User user = userDao.findUserByUserName(username);

        if (user != null) {
            Usertag usertagNew = new Usertag();
            usertagNew.setTag(usertag);
            user.addInterestToBoard(board, usertagNew);
            return userDao.updateUser(user);
        } else throw new UserException("Error adding usertag");
    }

    @Override
    public void removeHashtag(String username, String board, String hashtag) throws UserException {

        User user = userDao.findUserByUserName(username);

        if (user != null) {
            user.removeInterestOnHashtag(board, hashtag);
            userDao.updateUser(user);
        } else throw new UserException("Error removing hashtag");
    }

    @Override
    public void removeUserTag(String username, String board, String usertag) throws UserException {
        User user = userDao.findUserByUserName(username);

        if (user != null) {
            user.removeInterestOnUserTag(board, usertag);
            userDao.updateUser(user);
        } else throw new UserException("Error removing usertag");
    }

    @Override
    public void removeBoard(String username, String board) throws UserException {

        User user = userDao.findUserByUserName(username);

        if (user != null) {
            user.removeBoard(board);
            userDao.updateUser(user);
        } else throw new UserException("Error removing the board");
    }

    @Override
    public Set<String> getBoardsByUserName(String username) throws UserException {

        User user = userDao.findUserByUserName(username);

        if (user != null) {
            return user.getAllBoards();
        } else throw new UserException("Error getting boards");
    }

}
