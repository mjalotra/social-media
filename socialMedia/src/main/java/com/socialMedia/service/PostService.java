package com.socialMedia.service;

import com.socialMedia.entity.Post;

/**
 * Post service that allows the management of user Posts.
 *
 * @author mayankjalotra
 * @since v1.0
 */
public interface PostService {

	/**
	 * Method that allows creation of a new post.
	 * 
	 * @param userId
	 * @param postId
	 * @param content
	 * @return Post
	 */
	public Post createPost(Long userId, Long postId, String content);
}
