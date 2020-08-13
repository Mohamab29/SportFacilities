package com.sports.sport.security;

//PM2020T25-115 - Add security for Sign-In
//PM2020T25-78 a Back end developer needs to build a Rest Api
//Enable Security for Rest Api Sign-in

import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

/**
 * @author adam
 * @created
 */
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @SuppressWarnings({"checkstyle:WhitespaceAfter", "checkstyle:WhitespaceAround", "checkstyle:MemberName", "checkstyle:JavadocVariable"})
    private final String[] PUBLIC_ENDPOINTS = {
            "/api/v1/signIn", "/api/v1/restPassword",
            "/category/getCategoryAd", "/swagger-ui.html", "/category",
            "/damage", "/Reservation", "/updateRoleUsers",
            "/complaint/**", "/damage/getAllDamage",
            "/managementEmail/**", "/users/**"
    };

    @SuppressWarnings({"checkstyle:WhitespaceAround", "checkstyle:DesignForExtension"})
    @Bean
    @Override
    protected AuthenticationManager authenticationManager() throws Exception {
        return super.authenticationManager();
    }

    @SuppressWarnings({"checkstyle:FinalParameters", "checkstyle:DesignForExtension"})
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .cors().and().csrf().disable()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeRequests()
                .antMatchers(PUBLIC_ENDPOINTS).permitAll()
                .anyRequest().authenticated()
                .and()
                .httpBasic();
    }

    @SuppressWarnings({"checkstyle:FinalParameters", "checkstyle:DesignForExtension"})
    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/api/v1/signUp/**");


    }
}
