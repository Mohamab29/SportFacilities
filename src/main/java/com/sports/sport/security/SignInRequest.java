package com.sports.sport.security;

//// Class for Sign In Account
////PM2020T25-78 a Back end

/**
 * @author adam
 * @created
 */
public class SignInRequest {

    @SuppressWarnings("checkstyle:JavadocVariable")
    private String username;
    @SuppressWarnings("checkstyle:JavadocVariable")
    private String password;

    @SuppressWarnings("checkstyle:MissingJavadocMethod")
    public SignInRequest() {
    }

    @SuppressWarnings({"checkstyle:HiddenField", "checkstyle:FinalParameters", "checkstyle:MissingJavadocMethod"})
    public SignInRequest(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @SuppressWarnings({"checkstyle:DesignForExtension", "checkstyle:MissingJavadocMethod"})
    public String getUsername() {
        return username;
    }

    @SuppressWarnings({"checkstyle:HiddenField", "checkstyle:FinalParameters", "checkstyle:DesignForExtension", "checkstyle:MissingJavadocMethod"})
    public void setUsername(String username) {
        this.username = username;
    }

    @SuppressWarnings({"checkstyle:DesignForExtension", "checkstyle:MissingJavadocMethod"})
    public String getPassword() {
        return password;
    }

    @SuppressWarnings({"checkstyle:HiddenField", "checkstyle:FinalParameters", "checkstyle:DesignForExtension", "checkstyle:MissingJavadocMethod"})
    public void setPassword(String password) {
        this.password = password;
    }
}
