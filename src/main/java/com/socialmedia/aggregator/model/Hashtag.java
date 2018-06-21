package com.socialmedia.aggregator.model;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import twitter4j.*;

import java.util.List;

@Document
public class Hashtag implements Interest {

    @Id
    ObjectId _id;
    private String tag;

    @Override
    public List<Status> getUpdates(Twitter twitter) throws TwitterException{
            Query query = new Query(tag);
            QueryResult result = twitter.search(query);
            System.out.println(result.getRateLimitStatus());

        return result.getTweets();
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


    public ObjectId get_id() {
        return _id;
    }

    public void set_id(ObjectId _id) {
        this._id = _id;
    }

}
