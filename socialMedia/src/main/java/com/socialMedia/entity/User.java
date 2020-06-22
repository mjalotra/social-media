package com.socialMedia.entity;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.UniqueConstraint;

/**
 * User entity
 * 
 * @author mayankjalotra
 * @since v1.0
 */
@Entity
public class User {

	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	private Long id;
	private String name;

	@ManyToMany(mappedBy = "followees", cascade = CascadeType.ALL)
	private Set<User> followingList = new HashSet<>();

	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "USER_FOLLOWEE", joinColumns = @JoinColumn(name = "FOLLOWEE_ID"), inverseJoinColumns = @JoinColumn(name = "USER_ID"), uniqueConstraints = @UniqueConstraint(columnNames = {
			"USER_ID", "FOLLOWEE_ID" }))
	private Set<User> followees = new HashSet<>();

	@OneToMany(mappedBy = "user")
	private List<Post> posts = new ArrayList<>();

	public Long getUserId() {
		return id;
	}

	public void setUserId(Long userId) {
		this.id = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<User> getFollowingList() {
		return followingList;
	}

	public void setFollowingList(Set<User> followingList) {
		this.followingList = followingList;
	}

	public List<Post> getPosts() {
		return posts;
	}

	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}

	public Set<User> getFollowees() {
		return followees;
	}

	public void setFollowees(Set<User> followees) {
		this.followees = followees;
	}

}
