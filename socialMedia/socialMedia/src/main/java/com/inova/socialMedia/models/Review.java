package com.inova.socialMedia.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Entity
@Data
@NoArgsConstructor
@EqualsAndHashCode
public class Review implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "postId", referencedColumnName = "id")
    private Post post;

    @ManyToOne
    @JoinColumn(name = "userId", referencedColumnName = "id")
    private SocialUser user;

    private int rating;
    private String comment;


}