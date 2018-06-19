package com.socialmedia.aggregator.controller;

import com.socialmedia.aggregator.exceptions.UserException;
import com.socialmedia.aggregator.model.User;
import com.socialmedia.aggregator.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
public class UserController {

    private static final Logger logger = Logger.getLogger(UserController.class);

    @Autowired
    UserService userService;

    @RequestMapping(value = "/users/{username}", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<User> getUser(@PathVariable("username") String username) {

        try {
            return new ResponseEntity<>(userService.getUserByUserName(username), HttpStatus.OK);
        } catch (UserException e) {
            logger.error("Error trying to get the user");
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @RequestMapping(value = "/users/", method = RequestMethod.POST, produces = "application/json")
    public ResponseEntity<User> createUser(@RequestBody final User user) {
        try {
            return new ResponseEntity<>(userService.createUser(user.getUserName(), user.getUserpassword()), HttpStatus.CREATED);
        } catch (UserException e) {
            logger.error("Error creating the user");
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/users/", method = RequestMethod.DELETE, produces = "application/json")
    public ResponseEntity<User> removeUser(@RequestBody final User user) {
        try {
            userService.removeUser(user.getUserName(), user.getUserpassword());
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (UserException e) {
            logger.error("Error deleting the user");
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/users/{username}/boards/{board}/add", method = RequestMethod.PUT, produces = "application/json")
    public ResponseEntity<User> addBoard(@PathVariable("username") String username, @PathVariable("board") String board) {
        try {
            return new ResponseEntity<User>(userService.addBoard(username, board), HttpStatus.OK);
        } catch (UserException e) {
            logger.error("Error adding board");
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/users/{username}/boards/{board}/interests/{interest}/addHashtag", method = RequestMethod.PUT, produces = "application/json")
    public ResponseEntity<User> addHashtagInterestToBoard(@PathVariable("username") String username, @PathVariable("board") String board, @PathVariable("interest") String hashtag) {
        try {
            return new ResponseEntity<User>(userService.addHashtag(username, board, hashtag), HttpStatus.OK);
        } catch (UserException e) {
            logger.error("Error adding hashtag");
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/users/{username}/boards/{board}/interests/{interest}/addUserTag", method = RequestMethod.PUT, produces = "application/json")
    public ResponseEntity<User> addUserInterestToBoard(@PathVariable("username") String username, @PathVariable("board") String board, @PathVariable("interest") String usertag) {
        try {
            return new ResponseEntity<User>(userService.addUserTag(username, board, usertag), HttpStatus.OK);
        } catch (UserException e) {
            logger.error("Error adding usertag");
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/users/{username}/boards/{board}/remove", method = RequestMethod.DELETE, produces = "application/json")
    public ResponseEntity<User> removeBoard(@PathVariable("username") String username, @PathVariable("board") String board) {
        try {
            userService.removeBoard(username, board);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (UserException e) {
            logger.error("Error adding board");
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/users/{username}/boards/{board}/interests/{interest}/removeHashTag", method = RequestMethod.DELETE, produces = "application/json")
    public ResponseEntity<User> removeHashTag(@PathVariable("username") String username, @PathVariable("board") String board, @PathVariable("interest") String hashtag) {
        try {
            userService.removeHashtag(username, board, hashtag);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (UserException e) {
            logger.error("Error removing hashtag");
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/users/{username}/boards/{board}/interests/{interest}/removeUserTag", method = RequestMethod.DELETE, produces = "application/json")
    public ResponseEntity<User> removeUserTag(@PathVariable("username") String username, @PathVariable("board") String board, @PathVariable("interest") String usertag) {
        try {
            userService.removeUserTag(username, board, usertag);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (UserException e) {
            logger.error("Error removing usertag");
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/users/{username}/boards/", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<Set<String>> getBoards(@PathVariable("username") String username) {

        try {
            return new ResponseEntity<>(userService.getBoardsByUserName(username), HttpStatus.OK);
        } catch (UserException e) {
            logger.error("Error trying to get the user");
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
