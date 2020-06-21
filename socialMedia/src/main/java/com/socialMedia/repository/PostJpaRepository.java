package com.socialMedia.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.socialMedia.entity.Post;
/**
 * User's Post repository to manage their posts related operations.
 * @author mayankjalotra
 * @since v1.o
 */
@Repository
public interface PostJpaRepository extends JpaRepository<Post, Long> {
	
//	@Query(value="SELECT * FROM POST where posted_by in (:userFollowingSet) order by create_time desc limit 20", nativeQuery=true)
//	public List<Post> findTop20PostByUserIdIn(@Param("userFollowingSet") Set<Long> userFollowingSet);
	
	/**
	 * Method that feches a list of top 20 post or feeds to be
	 * visible on user's page based upon their interest of followees.
	 * @param userId
	 * @return List<Post>
	 */
	@Query(value="select p.*, u.name from post p "
			+ "inner join user_followee uf on (uf.followee_id=p.posted_by) or (uf.user_id=p.posted_by)"
			+ " inner join user u on p.posted_by = u.id "
			+ "where uf.user_id= :userId "
			+ "order by create_time desc limit 20", nativeQuery=true)
	public List<Post> findTop20PostForFeeds(@Param("userId") Long userId);
}
