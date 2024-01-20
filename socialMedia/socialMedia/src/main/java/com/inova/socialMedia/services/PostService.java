package com.inova.socialMedia.services;
import com.inova.socialMedia.models.Post;
import com.inova.socialMedia.models.mappers.PostMapper;
import com.inova.socialMedia.models.requestModels.PostRequestModel;
import com.inova.socialMedia.models.responseModels.PostResponseModel;
import com.inova.socialMedia.repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class PostService {
    @Autowired
    PostRepository postRepository;
    @Autowired
    PostMapper postMapper;

    public PostResponseModel addPost(PostRequestModel postRequestModel){

        Post post = postMapper.mapPostRequestModelToPost(postRequestModel);
        postRepository.save(post);
        return postMapper.mapPostToPostResModel(post);
    }

    public Page<PostResponseModel> findPostsByUser(Long userId, Pageable pageable) {
        Page<Post> postPage = postRepository.findByUserId(userId, pageable);
        return postPage.map(postMapper::mapPostToPostResModel);
    }


}
