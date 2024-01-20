package com.inova.socialMedia.repositories;

import com.inova.socialMedia.models.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Post,Long> {

    Page<Post> findByUserId(Long userId, Pageable pageable);

    @Query("SELECT p, AVG(r.rating) as avgRating FROM Post p LEFT JOIN p.reviews r GROUP BY p ORDER BY avgRating DESC")
    Page<Object[]> findTopPosts(Pageable pageable);
}
