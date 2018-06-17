package com.socialmedia.aggregator.controller;

import com.socialmedia.aggregator.exceptions.UserException;
import com.socialmedia.aggregator.model.User;
import com.socialmedia.aggregator.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.apache.log4j.Logger;

@RestController
public class UserController {

    private static final Logger logger = Logger.getLogger(UserController.class);

    @Autowired
    UserService userService;

    @RequestMapping(value = "/users/{userName}", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<User> getUser(@PathVariable("userName") String userName){

        try {
            return new ResponseEntity<>(userService.getUserByUserName(userName), HttpStatus.OK);
        } catch (UserException e) {
            logger.error("Error trying to get the user");
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @RequestMapping(value = "/users/", method = RequestMethod.POST, produces = "application/json")
    public ResponseEntity<User> createUser(@RequestBody final User user)   {
        try {
            return new ResponseEntity<>(userService.createUser(user.getUserName(), user.getUserPassword()), HttpStatus.CREATED);
        } catch (UserException e) {
            logger.error("Error creating the user");
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/users/", method = RequestMethod.DELETE, produces = "application/json")
    public ResponseEntity<User> removeUser(@RequestBody final User user)   {
        try {
            userService.removeUser(user.getUserName(), user.getUserPassword());
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (UserException e) {
            logger.error("Error deleting the user");
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
