package com.inova.socialMedia.models.requestModels;

import com.inova.socialMedia.models.SocialUser;
import java.io.Serializable;

public class PostRequestModel implements Serializable {

    private Long id;
    private SocialUser user;

    private String title;
    private String body;

}
