package com.home.work.JWT.work;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
@EnableJpaRepositories // This annotation will enable JPA repositories. This will scan for Spring Data repositories in the annotated configuration class by default.
public class JwtWorkApplication {

	public static void main(String[] args) {
		SpringApplication.run(JwtWorkApplication.class, args);
	}
	
	@Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
