package com.socialMedia.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.socialMedia.service.FeedService;
import com.socialMedia.service.FollowerService;
import com.socialMedia.service.PostService;
/**
 * Controller under construction not part of current assignment requirement
 * @author mayankjalotra
 *  
 */
@RestController
public class UserController {
	
	@Autowired
	private FollowerService followerService;
	
	@Autowired
	private PostService postService;
	
	@Autowired
	private FeedService feedService;
	
	/**
	 * Under construction, not part of assignment.
	 */
	public void follow() {
		followerService.follow(10011L, 10001L);
	}
	
	/**
	 * Under construction, not part of assignment
	 */
	public void unfollow() {
		followerService.unfollow(10004L, 10007L);
	}
	
	/**
	 * Under construction, not part of assignment
	 */
	public void createPost() {
		postService.createPost(10001L, 100L, "Post by 10001 user");
	}
	
	/**
	 * Under construction, not part of assignment
	 */
	public String feeds() {
		return feedService.getNewsFeed(10011L);
	}
}
