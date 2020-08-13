package com.sports.sport.repository;
//Create Repository interface for Ad (Connection to Database **/#PM2020T25-77

import com.sports.sport.ad.Advertisement;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author adam
 * @created
 */
@SuppressWarnings({"checkstyle:WhitespaceAfter", "checkstyle:LineLength"})
@Repository
public interface AdvertisementRepository extends MongoRepository<Advertisement, String> {
}
