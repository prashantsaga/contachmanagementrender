package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc
public class SpringConfiguration {
	
	public static final String[] PUBLIC_URLS= {
			"/v3/api-docs","/v2/api-docs","/api/v1/auth/**","/swagger-resources/**",
			"/swagger-ui/**","/webjars/**"
	};
	
	@Bean
  public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
      http
          .authorizeHttpRequests((authz) -> authz
          .anyRequest().authenticated().and().antMatcher("PUBLIC_URLS")
          )
          .httpBasic();
      return http.build();
  }
}
