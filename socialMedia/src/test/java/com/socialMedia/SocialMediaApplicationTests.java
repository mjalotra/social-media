package com.socialMedia;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import com.socialMedia.service.FeedServiceTests;
import com.socialMedia.service.FollowerServiceTests;
import com.socialMedia.service.PostServiceTests;

@RunWith(Suite.class)
@Suite.SuiteClasses({PostServiceTests.class, FeedServiceTests.class, FollowerServiceTests.class})
class SocialMediaApplicationTests {
  
}
