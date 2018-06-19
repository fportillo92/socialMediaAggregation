package com.socialmedia.aggregator.model;

import twitter4j.Status;

import java.util.List;

public class Hashtag implements Interest {

    private String tag;

    @Override
    public List<Status> getUpdates(String tag) {
        return null;
    }

    @Override
    public boolean equals(Object obj) {
        Hashtag other = (Hashtag) obj;
        if (this.getTag().equals(other.getTag())) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return tag.hashCode();
    }


    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

}
