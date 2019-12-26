package com.barkie.barkie;

import com.barkie.barkie.config.security.JwtProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(JwtProperties.class)
public class BarkieApplication {

	public static void main(String[] args) {
		SpringApplication.run(BarkieApplication.class, args);
	}

}
