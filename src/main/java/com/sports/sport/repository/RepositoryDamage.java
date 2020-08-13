package com.sports.sport.repository;

import com.sports.sport.damage.Damage;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * @author adam
 * @created 17:52
 */
@SuppressWarnings({"checkstyle:WhitespaceAfter", "checkstyle:JavadocType"})
@Repository
public interface RepositoryDamage extends MongoRepository<Damage, String> {
}
