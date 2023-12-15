package com.library.springbootlibrary.config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.accept.ContentNegotiationStrategy;
import org.springframework.web.accept.HeaderContentNegotiationStrategy;

@Configuration
public class SecurityConfiguration {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        //disable cross site request forgery
        http.csrf().disable();

        //protect endpoints at /api/<type>/secure
        http.authorizeHttpRequests(requests ->
          requests
                 .requestMatchers("/api/books/secure/**","/api/admin/secure/**")
                 .authenticated()
                 .anyRequest().permitAll())    // added this line
          .oauth2ResourceServer()
          .jwt();

        //Add CORS filters
        http.cors();

        //Add content to negotiation strategy
        http.setSharedObject(ContentNegotiationStrategy.class, new HeaderContentNegotiationStrategy());

        //force a non-empty response body for 401's to make the response frinedly
        //Okta.configureResourceServer401ResponseBody(http);

        return http.build();
    }
    
}
