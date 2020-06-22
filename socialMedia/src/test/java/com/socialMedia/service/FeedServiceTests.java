package com.socialMedia.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.socialMedia.entity.Post;
import com.socialMedia.entity.User;
import com.socialMedia.repository.PostJpaRepository;
import com.socialMedia.service.impl.FeedServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FeedServiceTests {

	@Mock
	PostJpaRepository postJpaRepository;

	@InjectMocks
	FeedServiceImpl feedService;

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void getNewsFeed_test() {
		List<Post> posts = Arrays.asList(new Post(324L, "con", new User(), new Date()),
				new Post(323L, "nifeb", new User(), new Date()));
		when(postJpaRepository.findTop20PostForFeeds(10011L)).thenReturn(posts);

		String postString = feedService.getNewsFeed(10011L);

		assertEquals("return type string check", postString, posts.toString());

		boolean expectedSizeLessThan20 = true;
		// since number of comma's will be 19 doing a less than check
		boolean actualFeedSize = postString != null ? postString.split(",").length < 20 : false;
		assertSame("feed size less than equal to 20", expectedSizeLessThan20, actualFeedSize);

		verify(postJpaRepository).findTop20PostForFeeds(10011L);
	}

}
