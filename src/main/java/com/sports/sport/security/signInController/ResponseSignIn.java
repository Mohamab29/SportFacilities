package com.sports.sport.security.signInController;

/**
 * @author adam
 * @created 19:07
 */
@SuppressWarnings({"checkstyle:NoWhitespaceBefore", "checkstyle:JavadocType"})
public class ResponseSignIn {

    @SuppressWarnings("checkstyle:JavadocVariable")
    private String name;

    @SuppressWarnings("checkstyle:JavadocVariable")
    private String id;

    @SuppressWarnings({"checkstyle:MemberName", "checkstyle:JavadocVariable"})
    private String Role;

    @SuppressWarnings({"checkstyle:FinalParameters", "checkstyle:HiddenField", "checkstyle:MissingJavadocMethod"})
    public ResponseSignIn(String name, String id, String role) {
        this.name = name;
        this.id = id;
        Role = role;
    }

    @SuppressWarnings({"checkstyle:DesignForExtension", "checkstyle:MissingJavadocMethod"})
    public String getName() {
        return name;
    }

    @SuppressWarnings({"checkstyle:HiddenField", "checkstyle:FinalParameters", "checkstyle:DesignForExtension", "checkstyle:MissingJavadocMethod"})
    public void setName(String name) {
        this.name = name;
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
        return "ResponseSignIn{" +
                "name='" + name + '\'' +
                ", id='" + id + '\'' +
                ", Role='" + Role + '\'' +
                '}';
    }
}
