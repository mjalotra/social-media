package com.socialMedia.service;

/**
 * Follower service that allows the capability to follow or unfollow a followee.
 * A Follower/followee is expected to be a user.
 * 
 * @author mayankjalotra
 * @since v1.0
 */
public interface FollowerService {

	/**
	 * Follower follows a followee.
	 * 
	 * @param followerId
	 * @param followeeId
	 * @return
	 */
	public boolean follow(Long followerId, Long followeeId);

	/**
	 * Follower unfollows a followee.
	 * 
	 * @param followerId
	 * @param followeeId
	 * @return
	 */
	public boolean unfollow(Long followerId, Long followeeId);

}
