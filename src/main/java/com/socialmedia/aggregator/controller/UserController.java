package com.socialmedia.aggregator.controller;

import com.socialmedia.aggregator.exceptions.UserException;
import com.socialmedia.aggregator.model.User;
import com.socialmedia.aggregator.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "/users/{userName}", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<User> getUser(@PathVariable("userName") String userName){

        try {
            return new ResponseEntity<>(userService.getUserByUserName(userName), HttpStatus.OK);
        } catch (UserException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/users/{userName}/{password}", method = RequestMethod.POST, produces = "application/json")
    public ResponseEntity<User> createUser(@PathVariable("userName") String userName, @PathVariable("password") String userPassword)   {
        try {
            return new ResponseEntity<>(userService.createUser(userName, userPassword), HttpStatus.CREATED);
        } catch (UserException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/users/{userName}/{password}", method = RequestMethod.DELETE, produces = "application/json")
    public ResponseEntity<User> removeUser(@PathVariable("userName") String userName, @PathVariable("password") String userPassword)   {
        try {
            userService.removeUser(userName, userPassword);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (UserException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
