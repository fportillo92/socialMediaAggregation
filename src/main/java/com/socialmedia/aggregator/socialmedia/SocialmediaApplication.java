package com.socialmedia.aggregator.socialmedia;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication(scanBasePackages={"com.socialmedia.aggregator"})
@ComponentScan({"com.socialmedia.aggregator"})
@EnableMongoRepositories(basePackages = "com.socialmedia.aggregator.dao")
@EnableScheduling
public class SocialmediaApplication {

	public static void main(String[] args) {
		SpringApplication.run(SocialmediaApplication.class, args);
	}
}
