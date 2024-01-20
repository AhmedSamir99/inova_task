package com.inova.socialMedia.services;

import com.github.javafaker.Faker;
import com.inova.socialMedia.models.Post;
import com.inova.socialMedia.models.SocialUser;
import com.inova.socialMedia.repositories.PostRepository;
import com.inova.socialMedia.repositories.ReviewRepository;
import com.inova.socialMedia.repositories.SocialUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class DataSeederService {

    @Autowired
    private PostRepository postRepository;
    @Autowired
    private ReviewRepository reviewRepository;
    @Autowired
    private SocialUserRepository userRepository;

    private final Faker faker = new Faker();

    @Transactional
    public void seedDatabase() {
        seedPosts(50000);
        seedReviews(20000);
    }

    private SocialUser getUser() {
        List<SocialUser> users = userRepository.findAll();
        if (users.isEmpty()) {
            return null;
        }
        return users.get(faker.number().numberBetween(0, users.size()));
    }

    private Post getPost() {

        List<Post> posts = postRepository.findAll();
        if (posts.isEmpty()) {
            return null;
        }
        return posts.get(faker.number().numberBetween(0, posts.size()));
    }

    private void seedPosts(int numberOfPosts) {
        List<Post> posts = new ArrayList<>();
        for (int i = 0; i < numberOfPosts; i++) {
            Post post = new Post();
            post.setUser(getUser());
            post.setTitle(faker.lorem().sentence());
            post.setBody(faker.lorem().paragraph());
            posts.add(post);

            if (i % 100 == 0) {
                postRepository.saveAll(posts);
                posts.clear();
            }
        }
        postRepository.saveAll(posts);
    }

    private void seedReviews(int numberOfReviews) {
        List<Review> reviews = new ArrayList<>();
        for (int i = 0; i < numberOfReviews; i++) {
            Review review = new Review();
            // Assume getPost() fetches a random or specific post
            review.setPost(getPost());
            review.setUser(getUser());
            review.setRating(faker.number().numberBetween(1, 5));
            review.setComment(faker.lorem().sentence());
            reviews.add(review);

            if (i % 100 == 0) {
                reviewRepository.saveAll(reviews);
                reviews.clear();
            }
        }
        reviewRepository.saveAll(reviews);
    }

    // Implement getUser() and getPost() methods
}
