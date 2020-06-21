package com.socialMedia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.socialMedia.entity.User;
/**
 * User repository to fetch data related to user info, its followees and other relations.
 * 
 * @author mayankjalotra
 * @since v1.0
 */
@Repository
public interface UserJpaRepository  extends JpaRepository<User, Long>{
	
//	@Query(value = "select uf.followee_id FROM user_followee uf where uf.user_id = :userId", nativeQuery= true)
//	public Set<Long> findFolloweesByUserId(@Param("userId") Long userId);
	

}
