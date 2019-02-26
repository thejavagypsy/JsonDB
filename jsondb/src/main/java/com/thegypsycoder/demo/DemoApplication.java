package com.thegypsycoder.demo;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.thegypsycoder.demo.domain.User;
import com.thegypsycoder.demo.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@SpringBootApplication
@ComponentScan("com.thegypsycoder")
public class DemoApplication {

    public static void main(String[] args) {

        SpringApplication.run(DemoApplication.class, args);
    }

    @Bean
    CommandLineRunner runner(UserService userService){
        return args -> {
            ObjectMapper mapper = new ObjectMapper();
            TypeReference<List<User>> typeReference = new TypeReference<List<User>>() {};
            InputStream inputStream = TypeReference.class.getResourceAsStream("/json/users.json");
            try {
                List<User> users = mapper.readValue(inputStream,typeReference);
                userService.save(users);
                System.out.println("Users Saved");

            }catch (IOException e){
                System.out.println("Exception"+e);
            }

        };

    }

}
