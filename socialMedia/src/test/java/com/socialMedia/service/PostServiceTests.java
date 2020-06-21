package com.socialMedia.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
import static org.mockito.Matchers.*;
import java.util.Date;
import java.util.Optional;

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
import com.socialMedia.exception.BusinessException;
import com.socialMedia.repository.PostJpaRepository;
import com.socialMedia.repository.UserJpaRepository;
import com.socialMedia.service.impl.PostServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PostServiceTests {
	
	@Mock
	PostJpaRepository postJpaRepository;
	
	@Mock
	UserJpaRepository userJpaRepository;
	
	@InjectMocks
	PostServiceImpl postService;
	
	@Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
    }
	
	@Test
	public void createPost_test() {
		User dummyUser = new User();
		when(userJpaRepository.findById(10001L)).thenReturn(Optional.of(dummyUser));
		when(postJpaRepository.findById(324L)).thenReturn(Optional.empty());
		Date dt = new Date();
		Post post= new Post(324L, "con", new User(), dt);
        when(postJpaRepository.save(anyObject())).thenReturn(post);
        
        Post expectedPost = postService.createPost(10001L, 324L, "cont");
        
        assertEquals("return type string check", expectedPost.toString(), post.toString());
	}
	
	@Test(expected = BusinessException.class)
	public void createPost_testBusinessException() {
		User dummyUser = new User();
		when(userJpaRepository.findById(10001L)).thenReturn(Optional.of(dummyUser));
		Date dt = new Date();
		when(postJpaRepository.findById(324L)).thenReturn(Optional.of(new Post(313L, "", new User(), dt)));
		
		Post post= new Post(324L, "con", new User(), dt);
        when(postJpaRepository.save(anyObject())).thenReturn(post);
        
        postService.createPost(10001L, 324L, "cont");
	}
	

}
