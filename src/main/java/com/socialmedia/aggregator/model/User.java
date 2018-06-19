package com.socialmedia.aggregator.model;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.*;

@Document
public class User {

    @Id
    ObjectId _id;
    private String username;
    private String userpassword;

    private Map<String, Set<Interest>> boards = new HashMap<>();

    public User(String username, String userpassword) {
        this.username = username;
        this.userpassword = userpassword;
    }

    public User() {
    }

    public ObjectId getId() {
        return _id;
    }

    public void setId(ObjectId id) {
        this._id = id;
    }

    public String getUserpassword() {
        return userpassword;
    }

    public void setUserpassword(String userpassword) {
        this.userpassword = userpassword;
    }

    public String getUserName() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void addBoard(String nameBoard) {
        if (!this.boards.containsKey(nameBoard)) {
            this.boards.put(nameBoard, new HashSet<>());
        }
    }

    public void addInterestToBoard(String board, Interest interest) {
        if (this.boards.containsKey(board)) {
            this.boards.get(board).add(interest);
        } else {
            Set listInterest = new HashSet();
            listInterest.add(interest);
            this.boards.put(board, listInterest);
        }
    }

    public void removeBoard(String board) {
        this.boards.remove(board);
    }

    public void removeInterestOnHashtag(String board, String hashtag) {
        if (this.boards.containsKey(board)) {
            Optional<Hashtag> hashtagRm = this.boards.get(board).stream()
                    .filter(Hashtag.class::isInstance)
                    .map(Hashtag.class::cast)
                    .filter(tag -> tag.getTag().equals(hashtag))
                    .findFirst();
            this.boards.get(board).remove(hashtagRm);
        }
    }


    public void removeInterestOnUserTag(String board, String usertag) {
        if (this.boards.containsKey(board)) {
            Optional<Usertag> usertagRm = this.boards.get(board).stream()
                    .filter(Usertag.class::isInstance)
                    .map(Usertag.class::cast)
                    .filter(tag -> tag.getTag().equals(usertag))
                    .findFirst();
            this.boards.get(board).remove(usertagRm);
        }
    }

    public Set<String> getAllBoards() {
        return this.boards.keySet();
    }
}
