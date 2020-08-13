package com.sports.sport.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author adam
 * @created 2:50
 */
@SuppressWarnings({"checkstyle:WhitespaceAround", "checkstyle:JavadocType"})
@Service
public class HelloServiceImpl implements HelloService {


    @SuppressWarnings({"checkstyle:VisibilityModifier", "checkstyle:JavadocVariable"})
    @Autowired
    HelloRepository helloRepository;


    @SuppressWarnings("checkstyle:DesignForExtension")
    @Override
    public String get() {
        return helloRepository.get();
    }
}
