package com.e.dxy;

import com.ctrip.framework.apollo.spring.annotation.EnableApolloConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableApolloConfig(value = "application")
public class DxyApplication {

    public static void main(String[] args) {
        SpringApplication.run(DxyApplication.class, args);
    }
}
