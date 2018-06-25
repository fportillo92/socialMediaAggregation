package com.socialmedia.aggregator.controller;

import com.socialmedia.aggregator.exceptions.InterestException;
import com.socialmedia.aggregator.exceptions.UserException;
import com.socialmedia.aggregator.model.Interest;
import com.socialmedia.aggregator.model.User;
import com.socialmedia.aggregator.service.InterestService;
import com.socialmedia.aggregator.service.TwitterService;
import com.socialmedia.aggregator.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import twitter4j.Status;

import java.util.List;
import java.util.Set;

@CrossOrigin
@RestController
public class BoardController {

    private static final Logger logger = Logger.getLogger(BoardController.class);

    @Autowired
    UserService userService;

    @Autowired
    InterestService interestService;

    @Autowired
    TwitterService twitterService;

    @CrossOrigin
    @RequestMapping(value = "/users/{username}/boards/{board}", method = RequestMethod.PUT, produces = "application/json")
    public ResponseEntity<User> addBoard(@PathVariable("username") String username, @PathVariable("board") String board) {
        try {
            return new ResponseEntity<User>(userService.addBoard(username, board), HttpStatus.OK);
        } catch (UserException e) {
            logger.error("Error adding board");
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @CrossOrigin
    @RequestMapping(value = "/users/{username}/boards/{board}", method = RequestMethod.DELETE, produces = "application/json")
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

    @CrossOrigin
    @RequestMapping(value = "/users/{username}/boards/{board}/interests/{interest}/hashtag", method = RequestMethod.PUT, produces = "application/json")
    public ResponseEntity<User> addHashtagInterestToBoard(@PathVariable("username") String username, @PathVariable("board") String board, @PathVariable("interest") String hashtag) {
        try {
            interestService.addHashtag(hashtag);
            return new ResponseEntity<User>(userService.addHashtag(username, board, hashtag), HttpStatus.OK);
        } catch (UserException e) {
            logger.error("Error adding hashtag to User");
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (InterestException f){
            logger.error("Error adding hashtag to Database");
            f.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @CrossOrigin
    @RequestMapping(value = "/users/{username}/boards/{board}/interests/{interest}/usertag", method = RequestMethod.PUT, produces = "application/json")
    public ResponseEntity<User> addUserInterestToBoard(@PathVariable("username") String username, @PathVariable("board") String board, @PathVariable("interest") String usertag) {
        try {
            interestService.addUsertagg(usertag);
            return new ResponseEntity<User>(userService.addUserTag(username, board, usertag), HttpStatus.OK);
        } catch (UserException e) {
            logger.error("Error adding usertag");
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (InterestException f){
            logger.error("Error adding usertag to Database");
            f.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @CrossOrigin
    @RequestMapping(value = "/users/{username}/boards/{board}/interests/{interest}/hashtag", method = RequestMethod.DELETE, produces = "application/json")
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

    @CrossOrigin
    @RequestMapping(value = "/users/{username}/boards/{board}/interests/{interest}/usertag", method = RequestMethod.DELETE, produces = "application/json")
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

    @CrossOrigin
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

    @CrossOrigin
    @RequestMapping(value = "/users/{username}/boards/{board}/interests", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<List<Status>> getInterestByBoard(@PathVariable("username") String username, @PathVariable("board") String board) {

        try {
            Set<Interest> interests= userService.getUserByUserName(username).getInterestsByBoard(board);
            return new ResponseEntity<>(twitterService.getTweetsByList(interests), HttpStatus.OK);
        } catch (UserException e) {
            logger.error("Error trying to get the user");
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
