package com.socialmedia.aggregator.dao;

import com.socialmedia.aggregator.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User, Integer> {

    public User findUserById(Integer id);
    @Query(value = "{ 'username' : ?0}" )
    public User findUserByUserName(String username);
}
