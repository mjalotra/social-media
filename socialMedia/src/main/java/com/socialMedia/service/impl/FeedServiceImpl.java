package com.socialMedia.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.socialMedia.repository.PostJpaRepository;
import com.socialMedia.service.FeedService;
/**
 * Feed service impl to generate the user feed based upon their interest of followees.
 *
 * @author mayankjalotra
 * @since v1.0
 */
@Service
public class FeedServiceImpl implements FeedService {
	
	@Autowired
	private PostJpaRepository postJpaRepository;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getNewsFeed(Long userId) {
		return postJpaRepository.findTop20PostForFeeds(userId).toString();
	}


}
