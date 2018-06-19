package com.socialmedia.aggregator.socialmedia;

import org.springframework.context.annotation.Scope;
import twitter4j.*;
import twitter4j.conf.ConfigurationBuilder;

import java.util.List;
import java.util.stream.Collectors;

@Scope("singleton")
public class TwitterConfig {

    	public static void main(String[] args) {
            ConfigurationBuilder cb = new ConfigurationBuilder();

            cb.setDebugEnabled(true);

            //TwitterFactory tf = new TwitterFactory(cb.build());
            //Twitter twitter = tf.getInstance();


// Using twitter4j-core
/*
            try {
                Query query = new Query("fitibirlo");
                QueryResult result = twitter.search(query);
                List<Status> lista = result.getTweets();
                System.out.println(lista.get(0));*/
                        /*.map(item -> item.getText())
                        .collect(Collectors.toList());*/

               /* ResponseList<Status> result = twitter.getUserTimeline("fitibirli");
                result.stream().forEach(x -> System.out.println(x.getText()));
                System.out.println(result.size());*/

/*
            } catch (TwitterException e) {
                e.printStackTrace();
            }
            */
            StatusListener listener = new StatusListener() {

                @Override
                public void onException(Exception e) {
                    e.printStackTrace();
                }
                @Override
                public void onDeletionNotice(StatusDeletionNotice arg) {
                }
                @Override
                public void onScrubGeo(long userId, long upToStatusId) {
                }
                @Override
                public void onStallWarning(StallWarning warning) {
                }
                @Override
                public void onStatus(Status status) {
                    System.out.println(status);
                }
                @Override
                public void onTrackLimitationNotice(int numberOfLimitedStatuses) {
                }
            };

            StatusListener listener2 = new StatusListener() {

                @Override
                public void onException(Exception e) {
                    e.printStackTrace();
                }
                @Override
                public void onDeletionNotice(StatusDeletionNotice arg) {
                }
                @Override
                public void onScrubGeo(long userId, long upToStatusId) {
                }
                @Override
                public void onStallWarning(StallWarning warning) {
                }
                @Override
                public void onStatus(Status status) {
                    System.out.println(status);
                }
                @Override
                public void onTrackLimitationNotice(int numberOfLimitedStatuses) {
                }
            };

            TwitterStream twitterStream = new TwitterStreamFactory(cb.build()).getInstance();

            twitterStream.addListener(listener);
            //twitterStream.addListener(listener2);

            FilterQuery fq = new FilterQuery();
            String keywords[] = {"fitibirlo"};

            fq.track(keywords);
            twitterStream.filter(fq);
            twitterStream.sample();



        }
    	private TwitterConfig(){

    }
}
