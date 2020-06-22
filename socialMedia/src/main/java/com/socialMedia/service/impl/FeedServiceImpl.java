package com.socialMedia.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.socialMedia.repository.PostJpaRepository;
import com.socialMedia.service.FeedService;

/**
 * Feed service impl to generate the user feed based upon their interest of
 * followees.
 *
 * @author mayankjalotra
 * @since v1.0
 */
@Service
public class FeedServiceImpl implements FeedService {

	private static final Logger logger = LoggerFactory.getLogger(FeedServiceImpl.class);

	@Autowired
	private PostJpaRepository postJpaRepository;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getNewsFeed(Long userId) {
		logger.debug("Fetching top 20 News Feed");
		return postJpaRepository.findTop20PostForFeeds(userId).toString();
	}

}
