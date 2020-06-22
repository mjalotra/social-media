package com.socialMedia.service;

/**
 * Feed service to generate the user feed based upon their interest of
 * followees.
 *
 * @author mayankjalotra
 * @since v1.0
 */
public interface FeedService {

	/**
	 * Retrieve the 20 most recent post ids in the user's news feed. Each item in
	 * the news feed is posted either by one of the user’s followees or by the user
	 * herself. Posts are ordered by posting time starting from the most recent one
	 * 
	 * @param userId
	 * @return String converted post value
	 */
	public String getNewsFeed(Long userId);
}
