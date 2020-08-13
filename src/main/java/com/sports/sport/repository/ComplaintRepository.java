package com.sports.sport.repository;

import com.sports.sport.complaint.Complaint;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * @author adam
 * @created 19:24
 */
@SuppressWarnings({"checkstyle:WhitespaceAfter", "checkstyle:LineLength", "checkstyle:JavadocType"})
@Repository
public interface ComplaintRepository extends MongoRepository<Complaint, String> {
    @SuppressWarnings("checkstyle:MissingJavadocMethod")
    List<Complaint> findByIdUser(String idUser);
}
