package com.socialmedia.aggregator.service;

import com.socialmedia.aggregator.exceptions.InterestException;
import com.socialmedia.aggregator.model.Hashtag;
import com.socialmedia.aggregator.model.Interest;
import com.socialmedia.aggregator.model.Usertag;

import java.util.List;

public interface InterestService {

    Hashtag addHashtag(String hashtag) throws InterestException;
    void removeHashtag(String hashtag) throws InterestException;

    Usertag addUsertagg(String usertag) throws InterestException;
    void removeUsertag(String usertag) throws InterestException;

    List<Interest> getAllInterest() throws InterestException;
}
