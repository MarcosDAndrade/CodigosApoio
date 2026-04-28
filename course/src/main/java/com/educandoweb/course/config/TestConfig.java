package com.educandoweb.course.config;


import com.educandoweb.course.entities.Category;
import com.educandoweb.course.entities.Order;
import com.educandoweb.course.entities.Product;
import com.educandoweb.course.entities.User;
import com.educandoweb.course.entities.enums.OrderStatus;
import com.educandoweb.course.repositories.CategoryRepository;
import com.educandoweb.course.repositories.OrderRepository;
import com.educandoweb.course.repositories.ProductRepository;
import com.educandoweb.course.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.Instant;
import java.util.Arrays;

@Configuration
@Profile("test")

//CommandLineRunner serve pra rodar o código quando a  aplicação for iniciada
public class TestConfig implements CommandLineRunner {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private CategoryRepository categoryRepository;


    @Override
    public void run(String... args) throws Exception {

        Category cat1 = new Category(null, "Eletronics");
        Category cat2 = new Category(null, "Books");
        Category cat3 = new Category(null, "Computers");


        Product p1 = new Product(null, "The Lord of the Rings", "Lorem ipsum dolor sit amet,", 120.0, "ipsum");
        Product p2 = new Product(null, "SmartTv", "Lorem ipsum dolor sit amet,", 1200.00, "ipsum");
        Product p3 = new Product(null, "MacBookPro", "Lorem ipsum dolor sit amet,", 2000.0, "ipsum");
        Product p4 = new Product(null, "Pc Gamer", "Lorem ipsum dolor sit amet,", 5000.0, "ipsum");

        categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
        productRepository.saveAll(Arrays.asList(p1,p2,p3,p4));

        p1.getCategories().add(cat2);
        p2.getCategories().add(cat1);
        p3.getCategories().add(cat3);
        p4.getCategories().add(cat3);

        productRepository.saveAll(Arrays.asList(p1,p2,p3,p4));

        User u1 = new User(null, "Maria Brown", "Maria@gmail.com", "9999999", "123456");
        User u2 = new User(null, "Alex Green", "Alex@gmail.com", "99877777", "123456");


        Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), OrderStatus.PAID, u1);
        Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"),OrderStatus.WAITING_PAYMENT, u2);
        Order o3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"),OrderStatus.WAITING_PAYMENT, u1);

        userRepository.saveAll(Arrays.asList(u1, u2));
        orderRepository.saveAll(Arrays.asList(o1,o2,o3));
    }
}
