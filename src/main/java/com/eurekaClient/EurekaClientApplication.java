package com.eurekaClient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableEurekaClient
@SpringBootApplication
public class EurekaClientApplication {

	@RequestMapping("/hello")
    public String home() {
        return "Hello world";
    }

	public static void main(String[] args) {
		SpringApplication.run(EurekaClientApplication.class, args);
	}
	@EnableWebSecurity
	class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	    @Override
	    protected void configure(HttpSecurity http) throws Exception {
	        http.csrf().ignoringAntMatchers("/eureka/**");
	        super.configure(http);

	    }
	}

}
