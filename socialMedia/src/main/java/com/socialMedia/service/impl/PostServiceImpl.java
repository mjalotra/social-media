package com.socialMedia.service.impl;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.socialMedia.entity.Post;
import com.socialMedia.entity.User;
import com.socialMedia.exception.BusinessException;
import com.socialMedia.repository.PostJpaRepository;
import com.socialMedia.repository.UserJpaRepository;
import com.socialMedia.service.PostService;
/**
 * Post service implementation that allows the management of user Posts.
 *
 * @author mayankjalotra
 * @since v1.0
 */
@Service
public class PostServiceImpl implements PostService {
	
	@Autowired
	private PostJpaRepository postJpaRepository;
	
	@Autowired
	private UserJpaRepository userJpaRepository;
	
	/**
	 * {@inheritDoc}
	 */
	@Transactional
	public Post createPost(Long userId, Long postId, String content) {
		Optional<User> userOpt = userJpaRepository.findById(userId);
		Optional<Post> postOpt = postJpaRepository.findById(postId);
		if(!userOpt.isPresent() || postOpt.isPresent()) {
			throw new BusinessException("Either user does not exist or post with same id already exist");
		}
		return postJpaRepository.save(new Post(postId, content, userOpt.get(),new Date()));
	}

}
