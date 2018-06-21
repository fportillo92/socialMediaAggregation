package com.socialmedia.aggregator.service;

import com.socialmedia.aggregator.dao.InterestDao;
import com.socialmedia.aggregator.exceptions.InterestException;
import com.socialmedia.aggregator.model.Hashtag;
import com.socialmedia.aggregator.model.Interest;
import com.socialmedia.aggregator.model.Usertag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("interestService")
public class InterestServiceImpl implements InterestService {

    @Autowired
    InterestDao interestDao;

    @Override
    public Hashtag addHashtag(String hashtag) throws InterestException {
        if (!hashtag.isEmpty()) {
            Hashtag hashtagNew = new Hashtag();
            hashtagNew.setTag(hashtag);

            return interestDao.addHashtag(hashtagNew);
        } else throw new InterestException("Error adding Hashtag");
    }

    @Override
    public void removeHashtag(String hashtag) throws InterestException {

        Hashtag hashtagRm = interestDao.findHashtag(hashtag);

        if(hashtagRm != null){
            interestDao.removeHashtag(hashtagRm);
        } else throw new InterestException("Error removing Hashtag");
    }

    @Override
    public Usertag addUsertagg(String usertag) throws InterestException {
        if (!usertag.isEmpty()) {
            Usertag usertagNew = new Usertag();
            usertagNew.setTag(usertag);

            return interestDao.addUsertag(usertagNew);
        } else throw new InterestException("Error adding Usertag");
    }

    @Override
    public void removeUsertag(String usertag) throws InterestException {
        Usertag usertagRm = interestDao.findUsertag(usertag);

        if(usertagRm != null){
            interestDao.removeUsertag(usertagRm);
        } else throw new InterestException("Error removing Usertag");
    }

    @Override
    public List<Interest> getAllInterest() throws InterestException {
        return interestDao.getAllInterest();
    }
}
