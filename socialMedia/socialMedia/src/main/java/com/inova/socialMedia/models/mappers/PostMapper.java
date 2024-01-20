package com.inova.socialMedia.models.mappers;

import com.inova.socialMedia.models.Post;
import com.inova.socialMedia.models.requestModels.PostRequestModel;
import com.inova.socialMedia.models.responseModels.PostResponseModel;
import org.mapstruct.Mapper;
import java.util.List;

@Mapper(componentModel = "spring")
public interface PostMapper {

    PostResponseModel mapPostToPostResModel(Post post);
    List<PostResponseModel> mapPostToPostResModelList(List<Post>posts);

    Post mapPostRequestModelToPost(PostRequestModel postRequestModel);
    List<Post>mapPostRequestModelToPostList(List<PostRequestModel> postRequestModels);

}
