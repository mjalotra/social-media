package com.socialMedia.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.socialMedia.entity.User;
import com.socialMedia.repository.UserJpaRepository;
import com.socialMedia.service.impl.FollowerServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FollowerServiceTests {

	@Mock
	UserJpaRepository userJpaRepository;

	@InjectMocks
	FollowerServiceImpl followerService;

	@Test
	public void follow_test() {
		User followerDummy = new User();
		when(userJpaRepository.findById(10001L)).thenReturn(Optional.of(followerDummy));
		User followeeDummy = new User();
		when(userJpaRepository.findById(10008L)).thenReturn(Optional.of(followeeDummy));

		boolean following = followerService.follow(10001L, 10008L);
		assertEquals("was able to follow a followee", true, following);
	}

	@Test
	public void unfollow_test() {
		User followerDummy = new User();
		followerDummy.setUserId(10001L);
		when(userJpaRepository.findById(10001L)).thenReturn(Optional.of(followerDummy));
		User followeeDummy = new User();
		Set<User> followees = new HashSet<>();
		followees.add(followerDummy);
		followeeDummy.setFollowees(followees);
		when(userJpaRepository.findById(10008L)).thenReturn(Optional.of(followeeDummy));

		boolean following = followerService.unfollow(10001L, 10008L);
		assertEquals("was able to unfollow a followee", following, true);
	}
}
