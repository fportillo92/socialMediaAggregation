package com.socialmedia.aggregator.dao;

import com.socialmedia.aggregator.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User, Integer> {

    public User findUserById(Integer id);
    public User findUserByUserName(String username);
}
