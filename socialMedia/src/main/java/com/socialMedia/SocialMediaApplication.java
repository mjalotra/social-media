package com.socialMedia;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.socialMedia.service.FeedService;
import com.socialMedia.service.FollowerService;
import com.socialMedia.service.PostService;
/**
 * Social Media application entry point, application created to manage user posts, their followees and top feeds based upon user choices or interest of followees. 
 * 
 * @author mayankjalotra
 * @since v1.0
 */
@SpringBootApplication
public class SocialMediaApplication implements CommandLineRunner{
	
	@Autowired
	private FollowerService followerService;
	
	@Autowired
	private PostService postService;
	
	@Autowired
	private FeedService feedService;
	
	
	public static void main(String[] args) {
		SpringApplication.run(SocialMediaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("============== Social Media Application sample calls =============");
		followerService.follow(10011L, 10002L);
		followerService.unfollow(10004L, 10002L);
		postService.createPost(10002L, 100L, "Main class post by 10001 user");
		System.out.println("========= News Feed =======\n"+feedService.getNewsFeed(10011L));
	}

}
