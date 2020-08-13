package com.sports.sport.security.userDetails;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Collection;
import java.util.Date;

/**
 * @author adam
 * @created
 */

@SuppressWarnings("checkstyle:LineLength")
@Document(collection = "user")
public class ApplicationUser implements UserDetails {

    @SuppressWarnings("checkstyle:JavadocVariable")
    @Id
    private String id;
    //check the input validation
    @SuppressWarnings("checkstyle:JavadocVariable")
    @NotEmpty
    private String name;
    //check the input validation
    @SuppressWarnings({"checkstyle:MagicNumber", "checkstyle:NoWhitespaceBefore", "checkstyle:JavadocVariable"})
    @NotEmpty
    @Size(max = 30, min = 10)
    private String email;
    //check the input validation
    @SuppressWarnings({"checkstyle:MagicNumber", "checkstyle:NoWhitespaceBefore", "checkstyle:JavadocVariable"})
    @NotEmpty
    @Size(max = 30, min = 6)
    private String password;
    //check the input validation
    @SuppressWarnings("checkstyle:JavadocVariable")
    @NotEmpty
    private Date join;
    //check the input validation
    @SuppressWarnings({"checkstyle:MagicNumber", "checkstyle:WhitespaceAfter", "checkstyle:JavadocVariable"})
    @NotEmpty
    @Size(max = 10, min = 9)
    private String phone;
    //check the input validation
    @SuppressWarnings({"checkstyle:WhitespaceAfter", "checkstyle:JavadocVariable"})
    @NotEmpty
    @Size(max = 2, min = 2)
    private String age;
    //check the input validation
    @SuppressWarnings("checkstyle:JavadocVariable")
    @NotEmpty
    private String role;

    @SuppressWarnings("checkstyle:MissingJavadocMethod")
    public ApplicationUser() {
    }

    @SuppressWarnings({"checkstyle:HiddenField", "checkstyle:MagicNumber", "checkstyle:FinalParameters", "checkstyle:MissingJavadocMethod"})
    public ApplicationUser(@NotEmpty String name, @NotEmpty @Size(max = 30) String email, @NotEmpty String password, @NotEmpty @Size(max = 10, min = 9) String phone, @NotEmpty @Size(max = 80, min = 16) String age) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.phone = phone;
        this.age = age;
        //default role for Client is 3 , Admin 1 , Inspector 2
        this.role = "3";
        this.join = new Date();
    }

    @SuppressWarnings("checkstyle:DesignForExtension")
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @SuppressWarnings("checkstyle:DesignForExtension")
    @Override
    public String getPassword() {
        return password;
    }

    @SuppressWarnings("checkstyle:DesignForExtension")
    @Override
    public String getUsername() {
        return email;
    }

    @SuppressWarnings("checkstyle:DesignForExtension")
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @SuppressWarnings("checkstyle:DesignForExtension")
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @SuppressWarnings("checkstyle:DesignForExtension")
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @SuppressWarnings("checkstyle:DesignForExtension")
    @Override
    public boolean isEnabled() {
        return true;
    }

    @SuppressWarnings({"checkstyle:DesignForExtension", "checkstyle:MissingJavadocMethod"})
    public String getId() {
        return id;
    }

    @SuppressWarnings({"checkstyle:HiddenField", "checkstyle:FinalParameters", "checkstyle:DesignForExtension", "checkstyle:MissingJavadocMethod"})
    public void setId(String id) {
        this.id = id;
    }

    @SuppressWarnings({"checkstyle:HiddenField", "checkstyle:FinalParameters", "checkstyle:DesignForExtension", "checkstyle:MissingJavadocMethod"})
    public void setEmail(String email) {
        this.email = email;
    }

    @SuppressWarnings({"checkstyle:HiddenField", "checkstyle:FinalParameters", "checkstyle:DesignForExtension", "checkstyle:MissingJavadocMethod"})
    public void setPassword(String password) {
        this.password = password;
    }

    @SuppressWarnings({"checkstyle:DesignForExtension", "checkstyle:MissingJavadocMethod"})
    public Date getJoin() {
        return join;
    }

    @SuppressWarnings({"checkstyle:HiddenField", "checkstyle:FinalParameters", "checkstyle:DesignForExtension", "checkstyle:MissingJavadocMethod"})
    public void setJoin(Date join) {
        this.join = join;
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
    public String getPhone() {
        return phone;
    }

    @SuppressWarnings({"checkstyle:HiddenField", "checkstyle:FinalParameters", "checkstyle:DesignForExtension", "checkstyle:MissingJavadocMethod"})
    public void setPhone(String phone) {
        this.phone = phone;
    }

    @SuppressWarnings({"checkstyle:DesignForExtension", "checkstyle:MissingJavadocMethod"})
    public String getAge() {
        return age;
    }

    @SuppressWarnings({"checkstyle:HiddenField", "checkstyle:FinalParameters", "checkstyle:DesignForExtension", "checkstyle:MissingJavadocMethod"})
    public void setAge(String age) {
        this.age = age;
    }

    @SuppressWarnings({"checkstyle:HiddenField", "checkstyle:FinalParameters", "checkstyle:DesignForExtension", "checkstyle:MissingJavadocMethod"})
    public void setRole(String role) {
        this.role = role;
    }

    @SuppressWarnings({"checkstyle:DesignForExtension", "checkstyle:MissingJavadocMethod"})
    public String getRole() {
        return role;
    }

    @SuppressWarnings({"checkstyle:OperatorWrap", "checkstyle:DesignForExtension"})
    @Override
    public String toString() {
        return "ApplicationUser{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", join=" + join +
                ", phone='" + phone + '\'' +
                ", age='" + age + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}
