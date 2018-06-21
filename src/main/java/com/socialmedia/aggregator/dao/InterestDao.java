package com.socialmedia.aggregator.dao;

import com.socialmedia.aggregator.model.Hashtag;
import com.socialmedia.aggregator.model.Interest;
import com.socialmedia.aggregator.model.Usertag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InterestDao {

    @Autowired
    InterestRepository interestRepository;

    public List<Interest> getAllInterest() {
        return interestRepository.findAll();
    }

    public Hashtag addHashtag(Hashtag hashtag){
        return interestRepository.save(hashtag);
    }

    public Usertag addUsertag(Usertag usertag){
        return interestRepository.save(usertag);
    }

    public void removeHashtag(Hashtag hashtag){
        interestRepository.delete(hashtag);
    }

    public void removeUsertag(Usertag usertag){
        interestRepository.delete(usertag);
    }

    public Hashtag findHashtag(String hashtag){
        return interestRepository.findHashtag(hashtag);
    }

    public Usertag findUsertag(String usertag){
        return interestRepository.findUsertag(usertag);
    }
}
