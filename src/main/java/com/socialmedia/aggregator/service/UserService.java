package com.socialmedia.aggregator.service;

import com.socialmedia.aggregator.exceptions.UserException;
import com.socialmedia.aggregator.model.User;

import java.util.Set;

public interface UserService {

    User getUserByUserName(String username) throws UserException;

    User createUser(String username, String userpassword) throws UserException;

    void removeUser(String username, String userpassword) throws UserException;

    User updateUser(String username, String userpassword) throws UserException;

    User addBoard(String username, String board) throws UserException;

    User addHashtag(String username, String board, String hashtag) throws UserException;

    void removeBoard(String username, String board) throws UserException;

    User addUserTag(String username, String board, String hashtag) throws UserException;

    void removeHashtag(String username, String board, String hashtag) throws UserException;

    void removeUserTag(String username, String board, String usertag) throws UserException;

    Set<String> getBoardsByUserName(String username) throws UserException;
}
