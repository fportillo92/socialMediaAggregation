package com.socialmedia.aggregator.model;

import twitter4j.Status;

import java.util.List;

public class Usertag implements Interest {

    private String tag;

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    @Override
    public boolean equals(Object obj) {
        Usertag other = (Usertag) obj;
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

    @Override
    public List<Status> getUpdates(String tag) {
        return null;
    }
}
