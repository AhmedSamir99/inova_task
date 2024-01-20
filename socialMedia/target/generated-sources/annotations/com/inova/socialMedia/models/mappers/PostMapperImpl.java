package com.inova.socialMedia.models.mappers;

import com.inova.socialMedia.models.Post;
import com.inova.socialMedia.models.requestModels.PostRequestModel;
import com.inova.socialMedia.models.responseModels.PostResponseModel;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-01-20T19:43:12+0200",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 20.0.1 (Oracle Corporation)"
)
@Component
public class PostMapperImpl implements PostMapper {

    @Override
    public PostResponseModel mapPostToPostResModel(Post post) {
        if ( post == null ) {
            return null;
        }

        PostResponseModel postResponseModel = new PostResponseModel();

        return postResponseModel;
    }

    @Override
    public List<PostResponseModel> mapPostToPostResModelList(List<Post> posts) {
        if ( posts == null ) {
            return null;
        }

        List<PostResponseModel> list = new ArrayList<PostResponseModel>( posts.size() );
        for ( Post post : posts ) {
            list.add( mapPostToPostResModel( post ) );
        }

        return list;
    }

    @Override
    public Post mapPostRequestModelToPost(PostRequestModel postRequestModel) {
        if ( postRequestModel == null ) {
            return null;
        }

        Post post = new Post();

        return post;
    }

    @Override
    public List<Post> mapPostRequestModelToPostList(List<PostRequestModel> postRequestModels) {
        if ( postRequestModels == null ) {
            return null;
        }

        List<Post> list = new ArrayList<Post>( postRequestModels.size() );
        for ( PostRequestModel postRequestModel : postRequestModels ) {
            list.add( mapPostRequestModelToPost( postRequestModel ) );
        }

        return list;
    }
}
