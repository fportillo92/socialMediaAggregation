package com.socialmedia.aggregator.model;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import twitter4j.ResponseList;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;

import java.util.List;
import java.util.stream.Collectors;

@Document
public class Usertag implements Interest {

    @Id
    ObjectId _id;
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
    public List<Status> getUpdates(Twitter twitter) throws TwitterException {

        ResponseList<Status> result = twitter.getUserTimeline(tag);
        System.out.println(result.getRateLimitStatus());
        return result.stream().collect(Collectors.toList());
    }


    public ObjectId get_id() {
        return _id;
    }

    public void set_id(ObjectId _id) {
        this._id = _id;
    }
}
