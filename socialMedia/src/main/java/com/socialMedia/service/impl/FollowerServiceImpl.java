package com.socialMedia.service.impl;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.socialMedia.entity.User;
import com.socialMedia.exception.BusinessException;
import com.socialMedia.repository.UserJpaRepository;
import com.socialMedia.service.FollowerService;

/**
 * Follower service implementation that allows the capability to follow or
 * unfollow a followee. A Follower/followee is expected to be a user.
 * 
 * @author mayankjalotra
 * @since v1.0
 */
@Service
public class FollowerServiceImpl implements FollowerService {

	private static final Logger logger = LoggerFactory.getLogger(FollowerServiceImpl.class);

	@Autowired
	private UserJpaRepository userJpaRepository;

	/**
	 * {@inheritDoc}
	 */
	@Transactional(rollbackFor = Exception.class)
	public boolean follow(Long followerId, Long followeeId) {
		logger.debug(String.format("User %d requested to follow %d", followerId, followerId));
		return followerAction(followerId, followeeId, "follow");
	}

	/**
	 * {@inheritDoc}
	 */
	@Transactional(rollbackFor = Exception.class)
	public boolean unfollow(Long followerId, Long followeeId) {
		logger.debug(String.format("User %d requested to un-follow %d", followerId, followerId));
		return followerAction(followerId, followeeId, "unfollow");
	}

	/**
	 * A common implementation that allows follow/unfollow a followee based upon the
	 * follower id provided and the action value
	 * 
	 * @param followerId current user Id
	 * @param followeeId followee id, user wants to follow/unfollow
	 * @param action     can be either of
	 *                   <li>follow</li>
	 *                   <li>unfollow</li>
	 * @return
	 */
	private boolean followerAction(Long followerId, Long followeeId, String action) {
		Optional<User> followerOpt = userJpaRepository.findById(followerId);
		Optional<User> followeeOpt = userJpaRepository.findById(followeeId);
		if (followeeOpt.isPresent() && followerOpt.isPresent()) {
			User follower = followerOpt.get();
			User followee = followeeOpt.get();
			switch (action) {
			case "follow":
				return followee.getFollowees().add(follower);

			case "unfollow":
				return followee.getFollowees().remove(follower);
			default:
				return false;
			}
		} else {
			logger.error(String.format(
					"Unable to follow/un-follow a user since either of follower: %d/followee: %d does not exist",
					followerId, followeeId));
			throw new BusinessException("Either of follower/followee does not exist");
		}
	}

}
