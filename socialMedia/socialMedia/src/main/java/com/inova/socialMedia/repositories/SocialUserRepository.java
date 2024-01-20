package com.inova.socialMedia.repositories;

import com.inova.socialMedia.models.SocialUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SocialUserRepository extends JpaRepository<SocialUser,Long> {

}
