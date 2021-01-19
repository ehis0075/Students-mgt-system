package com.example.testttt.web.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;


@EnableWebSecurity
public class WebSecurity extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private JWTAuthorizationFilter jwtAuthorizationFilter;

    public WebSecurity(UserDetailsServiceImpl userDetailsService, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userDetailsService = userDetailsService;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

//    @Override
//    public void configure(org.springframework.security.config.annotation.web.builders.WebSecurity web) throws Exception {
//
//        web.ignoring().antMatchers().antMatchers("/css/**", "/webjars/**", "/html/**", "/js/**");
//
//    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors().and().csrf().disable() // enable crsf
                .authorizeRequests()
                .antMatchers("/css/**", "/html/**", "/js/**").permitAll()
                .antMatchers("/student/sign-up").permitAll()
                .antMatchers("/student/students").authenticated()
                .anyRequest().authenticated()
                .and()
//                .formLogin()
//                .loginProcessingUrl("/api/login")
//                .and()
//                .logout()
//                .logoutSuccessUrl("/")
//                .and()
                .addFilterBefore(jwtAuthorizationFilter, UsernamePasswordAuthenticationFilter.class)
                .addFilter(jwtAuthenticationFilter())
                .addFilter(new JWTAuthenticationFilter(authenticationManager()))

                 //this disables session creation on Spring Security
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
    }

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder);
    }



    public JWTAuthenticationFilter jwtAuthenticationFilter() throws Exception {
        JWTAuthenticationFilter jwtAuthenticationFilter = new JWTAuthenticationFilter(authenticationManager());
        jwtAuthenticationFilter.setFilterProcessesUrl("/auth/login");
        return jwtAuthenticationFilter;
    }

    @Bean
    CorsConfigurationSource corsConfigurationSource() {
        final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", new CorsConfiguration().applyPermitDefaultValues());
        return source;
    }
}
