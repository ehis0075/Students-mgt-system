package com.example.testttt.web.security;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;



@EnableWebSecurity
public class WebSecurity extends WebSecurityConfigurerAdapter {


    public WebSecurity() {

    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.headers().disable();
        http.httpBasic();

        http
                .authorizeRequests()
                .antMatchers("/student/**").permitAll()
                .and()
                .authorizeRequests().anyRequest().permitAll();

    }


}
