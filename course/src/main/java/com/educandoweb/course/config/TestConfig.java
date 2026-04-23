package com.educandoweb.course.config;


import com.educandoweb.course.entities.User;
import com.educandoweb.course.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;

@Configuration
@Profile("test")

//CommandLineRunner serve pra rodar o código quando a  aplicação for iniciada
public class TestConfig implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;


    @Override
    public void run(String... args) throws Exception {
        User u1 = new User(null, "Maria Brown", "Maria@gmail.com", "9999999", "123456");
        User u2 = new User(null, "Alex Green", "Alex@gmail.com", "99877777", "123456");

        userRepository.saveAll(Arrays.asList(u1, u2));
    }
}
