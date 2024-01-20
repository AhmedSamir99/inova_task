package com.inova.socialMedia.models.responseModels;

import com.inova.socialMedia.models.Post;
import com.inova.socialMedia.models.SocialUser;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.io.Serializable;

public class ReviewResponseModel implements Serializable {

    private Long id;
    private Post post;

    private SocialUserResponseModel user;
    private int rating;
    private String comment;
}
