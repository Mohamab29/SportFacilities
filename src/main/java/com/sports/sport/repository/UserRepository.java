package com.sports.sport.repository;
//Create Repository interface for Users **(Connection to Database /#PM2020T25-77

import com.sports.sport.security.userDetails.ApplicationUser;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * @author adam
 * @created
 */
@SuppressWarnings("checkstyle:LineLength")
@Repository
public interface UserRepository extends MongoRepository<ApplicationUser, String> {
    @SuppressWarnings("checkstyle:MissingJavadocMethod")
    ApplicationUser findByEmail(String email);

    @SuppressWarnings("checkstyle:MissingJavadocMethod")
    Boolean existsByEmail(String email);
}
