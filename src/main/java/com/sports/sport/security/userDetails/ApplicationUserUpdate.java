package com.sports.sport.security.userDetails;

/**
 * @author adam
 * @created 19:26
 */

//class for Update Role for All Users
@SuppressWarnings({"checkstyle:WhitespaceAround", "checkstyle:NoWhitespaceBefore", "checkstyle:JavadocType"})
public class ApplicationUserUpdate {

    @SuppressWarnings("checkstyle:JavadocVariable")
    private String id;
    @SuppressWarnings({"checkstyle:MemberName", "checkstyle:JavadocVariable"})
    private String Role;


    @SuppressWarnings({"checkstyle:WhitespaceAround", "checkstyle:MissingJavadocMethod"})
    public ApplicationUserUpdate() {
    }

    @SuppressWarnings({"checkstyle:FinalParameters", "checkstyle:HiddenField", "checkstyle:MissingJavadocMethod"})
    public ApplicationUserUpdate(String id, String role) {
        this.id = id;
        Role = role;
    }

    @SuppressWarnings({"checkstyle:DesignForExtension", "checkstyle:MissingJavadocMethod"})
    public String getId() {
        return id;
    }

    @SuppressWarnings({"checkstyle:HiddenField", "checkstyle:FinalParameters", "checkstyle:DesignForExtension", "checkstyle:MissingJavadocMethod"})
    public void setId(String id) {
        this.id = id;
    }

    @SuppressWarnings({"checkstyle:DesignForExtension", "checkstyle:MissingJavadocMethod"})
    public String getRole() {
        return Role;
    }

    @SuppressWarnings({"checkstyle:FinalParameters", "checkstyle:DesignForExtension", "checkstyle:MissingJavadocMethod"})
    public void setRole(String role) {
        Role = role;
    }

    @SuppressWarnings({"checkstyle:OperatorWrap", "checkstyle:DesignForExtension"})
    @Override
    public String toString() {
        return "ApplicationUserUpdate{" +
                "id='" + id + '\'' +
                ", Role='" + Role + '\'' +
                '}';
    }
}
