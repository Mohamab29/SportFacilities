package com.sports.sport.security.signUpController;

//PM2020T25-80 a Back end developer needs to build a Rest API rest password

import javax.validation.constraints.NotEmpty;

/**
 * @author adam
 * @created
 */
@SuppressWarnings("checkstyle:RegexpSingleline")
public class EmailRestPassword {

    @SuppressWarnings("checkstyle:JavadocVariable")
    @NotEmpty
    private String email;

    @SuppressWarnings("checkstyle:MissingJavadocMethod")
    public EmailRestPassword() {
    }

    @SuppressWarnings({"checkstyle:HiddenField", "checkstyle:FinalParameters", "checkstyle:MissingJavadocMethod"})
    public EmailRestPassword(@NotEmpty String email) {
        this.email = email;
    }

    @SuppressWarnings({"checkstyle:DesignForExtension", "checkstyle:MissingJavadocMethod"})
    public String getEmail() {
        return email;
    }

    @SuppressWarnings({"checkstyle:HiddenField", "checkstyle:FinalParameters", "checkstyle:DesignForExtension", "checkstyle:MissingJavadocMethod"})
    public void setEmail(String email) {
        this.email = email;
    }
}
