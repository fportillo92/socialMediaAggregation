package com.socialmedia.aggregator.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class UserController {

    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET, produces = "application/json")
    public List getUser(@PathVariable("id") String userId){

        return null;
    }
}
