package com.inova.socialMedia.models.responseModels;

import com.inova.socialMedia.models.SocialUser;

import java.io.Serializable;

public class PostResponseModel implements Serializable {
    private Long id;
    private SocialUserResponseModel user;
    private String title;
    private String body;
}
