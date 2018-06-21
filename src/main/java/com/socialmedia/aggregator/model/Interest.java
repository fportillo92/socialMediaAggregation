package com.socialmedia.aggregator.model;

import org.springframework.data.mongodb.core.mapping.Document;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;

import java.util.List;

@Document
public interface Interest {
    
    List<Status> getUpdates(Twitter twitter) throws TwitterException;
}
