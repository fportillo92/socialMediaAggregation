package com.socialmedia.aggregator.service;

import com.socialmedia.aggregator.dao.InterestDao;
import com.socialmedia.aggregator.model.Interest;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
public class TwitterService implements ApplicationRunner {

    private static final Logger logger = Logger.getLogger(TwitterService.class);

    @Autowired
    InterestDao interestDao;

    private Map<Interest, List<Status>> tweets = new HashMap<>();
    private List<Interest> interests;
    private Twitter twitter;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        ConfigurationBuilder cb = new ConfigurationBuilder();

        cb.setDebugEnabled(true);
        cb.setOAuthConsumerKey("");
        cb.setOAuthConsumerSecret("");
        cb.setOAuthAccessToken("");
        cb.setOAuthAccessTokenSecret("");
        TwitterFactory tf = new TwitterFactory(cb.build());
        twitter = tf.getInstance();

        logger.info("Starting twitter service");
        interests = interestDao.getAllInterest();

        logger.info("Number of interest: " + interests.size());

        getTwitterUpdates();
    }

    @Scheduled(fixedRate = 5000000)
    public void getUpdates(){
        logger.info("Updating interests...");
        interests = interestDao.getAllInterest();

        logger.info("Updating lastest tweets...");
        getTwitterUpdates();
    }

    public synchronized List<Status> getTweetsByInterest(Interest interest) throws TwitterException{
        if(tweets.containsKey(interest)){
            return tweets.get(interest);
        } else throw new TwitterException("The interest doesn't have tweets");
    }

    public synchronized List<Status> getTweetsByList(Set<Interest> interestSet){
        List<Status> listStatus = new ArrayList<>();
        interestSet.stream().forEach(interest -> {
            try {
                listStatus.addAll(this.getTweetsByInterest(interest));
            } catch (TwitterException e) {
                e.printStackTrace();
            }
        });

        return listStatus;
    }

    public void getTwitterUpdates(){
        interests.stream().forEach(interest -> {
            try {
                tweets.put(interest,interest.getUpdates(twitter));
            } catch (TwitterException e) {
                logger.error("Error trying to get updates from twitter");
                e.printStackTrace();
            }
        });
    }
}
