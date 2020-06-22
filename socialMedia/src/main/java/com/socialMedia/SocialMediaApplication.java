package com.socialMedia;

import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.socialMedia.exception.BusinessException;
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
		logger.info(
				"\nThere is already some data added in H2 db for testing purpose, please do refer H2 db for more details, http://localhost:8080/h2-console/");
		String start = "Y";
		Scanner sc = new Scanner(System.in);
		while ("Y".equalsIgnoreCase(start)) {
			logger.info("\n==================================================================");
			logger.info(
					"\nPress 1 to Follow somebody.\nPress 2 to un-follow someone.\nPress 3 to create a new Post.\nPress 4 to fetch top 20 news feed.\n");
			int optionSelected = sc.nextInt();
			try {
				performTests(optionSelected, sc);
			} catch (BusinessException be) {
				logger.info("\nInvalid input passed : " + be.getMessage());
			} catch (Exception e) {
				logger.info("\nInvalid input passed");
			}

			logger.info("\n==================================================================");
			logger.info(
					"\nPlease press 'Y' or 'y' to continue testing application, pressing anything else would exit the test\n");
			start = sc.next();
		}

	}

	public void performTests(int optionSelected, Scanner sc) {
		switch (optionSelected) {
		case 1:
			logger.info("\n==================================================================");
			logger.info("\nEnter existing follower id, on startup user id from 10001 to 10011 exist, ex 10011:\n");
			Long followerId = sc.nextLong();
			logger.info("\nEnter followee id, ex 10002:\n");
			Long followeeId = sc.nextLong();
			logger.info("\nFollow request was successful: " + followerService.follow(followerId, followeeId)
					+ "\nTo verify please refer User_followee table in DB");
			break;
		case 2:
			logger.info("\n==================================================================");
			logger.info("\nEnter existing follower id, on startup user id from 10001 to 10011 exist, ex 10004:\n");
			Long followerUid = sc.nextLong();
			logger.info("\nEnter followee id, ex 10002:\n");
			Long followeeuId = sc.nextLong();
			logger.info("\nUn-Follow request was successful: " + followerService.unfollow(followerUid, followeeuId)
					+ " refer DB to verify results");
			break;
		case 3:
			logger.info("\n==================================================================");
			logger.info("\nEnter post creator's user id, on startup user id from 10001 to 10011 exist:\n");
			Long userId = sc.nextLong();
			logger.info("\nEnter post id, as per requirement you need to provide post id you want to generate:\n");
			Long postId = sc.nextLong();
			logger.info("\nEnter post content :");
			Scanner contentSc = new Scanner(System.in);
			String content = contentSc.nextLine();
			logger.info("\nAfter Post save: " + postService.createPost(userId, postId, content));
			break;
		case 4:
			logger.info("\n==================================================================");
			logger.info(
					"\nEnter the user id for whom you want to fetch news feed, on startup user id from 10001 to 10011 exist, ex: 10011:\n");
			Long userIdForFeeds = sc.nextLong();
			logger.info("\n" + feedService.getNewsFeed(userIdForFeeds));
			break;
		default:
			logger.info("\n==================================================================");
			logger.info("\nInvalid option selected.");
			break;
		}
	}

}
