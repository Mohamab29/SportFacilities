package com.sports.sport.repository;

import com.sports.sport.message.Message;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author adam
 * @created 18:56
 */
@SuppressWarnings({"checkstyle:WhitespaceAfter", "checkstyle:JavadocType"})
@Repository
public interface MessageRepository extends MongoRepository<Message, String> {

    @SuppressWarnings("checkstyle:MissingJavadocMethod")
    List<Message> findByIdUser(String id);

    @SuppressWarnings("checkstyle:MissingJavadocMethod")
    List<Message> findByUserNameSending(String userNameSending);

    @SuppressWarnings("checkstyle:MissingJavadocMethod")
    List<Message> findByRecipientEmail(String userNameSending);
}
