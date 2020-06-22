package com.socialMedia;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.socialMedia.service.FeedService;
import com.socialMedia.service.FollowerService;
import com.socialMedia.service.PostService;

/**
 * Social Media application entry point, application created to manage user
 * posts, their followees and top feeds based upon user choices or interest of
 * followees.
 * 
 * @author mayankjalotra
 * @since v1.0
 */
@SpringBootApplication
public class SocialMediaApplication implements CommandLineRunner {

	@Autowired
	private FollowerService followerService;

	@Autowired
	private PostService postService;

	@Autowired
	private FeedService feedService;

	private static final Logger logger = LoggerFactory.getLogger(SocialMediaApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(SocialMediaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		logger.info("\n\n============== Social Media Application sample calls =============\n");
		logger.info("Follow request was successful: " + followerService.follow(10011L, 10002L));
		logger.info("Un-Follow request was successful: " + followerService.unfollow(10004L, 10002L));
		logger.info("After Post save: "
				+ postService.createPost(10002L, 100L, "Post Created in Main class for testing purpose"));
		logger.info(feedService.getNewsFeed(10011L));
	}

}
