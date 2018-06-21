package com.socialmedia.aggregator.dao;

import com.socialmedia.aggregator.model.Hashtag;
import com.socialmedia.aggregator.model.Interest;
import com.socialmedia.aggregator.model.Usertag;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface InterestRepository extends MongoRepository<Interest, String> {

    @Query(value = "{ 'tag' : ?0}")
    Hashtag findHashtag(String hashtag);

    @Query(value = "{ 'tag' : ?0}")
    Usertag findUsertag(String usertag);
}
