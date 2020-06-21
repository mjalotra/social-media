package com.socialMedia.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
/**
 * Post Entity
 * @author mayankjalotra
 * @since v1.0
 */
@Entity
public class Post {
	
//	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	private Long postId;
	private String content;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "posted_by", nullable = false)
	private User user;
	
	private Date createTime;

	public Post() {
		
	}
	
	public Post(Long postId, String content, User postedBy, Date createTime) {
		this.postId = postId;
		this.content = content;
		this.user = postedBy;
		this.createTime = createTime;
	}

	public Long getPostId() {
		return postId;
	}

	public void setPostId(Long postId) {
		this.postId = postId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public User getPostedBy() {
		return user;
	}

	public void setPostedBy(User postedBy) {
		this.user = postedBy;
	}

	public Date getCreatTime() {
		return createTime;
	}

	public void setCreatTime(Date createTime) {
		this.createTime = createTime;
	}

	@Override
	public String toString() {
		return "\n" + content + " at \t createTime " + createTime+"\n";
	}
	
	
}
