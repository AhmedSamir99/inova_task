package com.inova.socialMedia.controllers;

import com.inova.socialMedia.models.requestModels.PostRequestModel;
import com.inova.socialMedia.models.responseModels.PostResponseModel;
import com.inova.socialMedia.services.PostService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class Controller {

    @Autowired
    private PostService postService;


    @PostMapping("/posts")
    public ResponseEntity<PostResponseModel> addPost(@RequestBody PostRequestModel postRequestModel) {
        return ResponseEntity.ok(postService.addPost(postRequestModel));
    }

    @GetMapping("/users/{userId}/posts")
    public ResponseEntity<Page<PostResponseModel>> getUserPosts(
            @PathVariable Long userId,
            Pageable pageable) {
        return ResponseEntity.ok(postService.findPostsByUser(userId, pageable));
    }



}
