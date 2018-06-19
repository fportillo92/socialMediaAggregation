package com.socialmedia.aggregator.model;

import twitter4j.Status;

import java.util.List;

public interface Interest {

    public List<Status> getUpdates(String tag);
}
