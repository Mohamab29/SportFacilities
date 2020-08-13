package com.sports.sport.example;

import org.springframework.stereotype.Repository;

/**
 * @author adam
 * @created 2:50
 */
@SuppressWarnings("checkstyle:JavadocType")
@Repository
public class HelloRepositoryImpl implements HelloRepository {
    @SuppressWarnings("checkstyle:DesignForExtension")
    @Override
    public String get() {
        return "Hello JUnit 5";
    }
}
