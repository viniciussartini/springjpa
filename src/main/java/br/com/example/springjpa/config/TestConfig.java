package br.com.example.springjpa.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import br.com.example.springjpa.entities.Order;
import br.com.example.springjpa.entities.User;
import br.com.example.springjpa.entities.enums.OrderStatus;
import br.com.example.springjpa.repositories.OrderRepository;
import br.com.example.springjpa.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public void run(String... args) throws Exception {
        User user1 = new User(null, "Maria", "maria@email.com", "1234", "988007766");
        User user2 = new User(null, "Alex", "alex@email.com", "1234", "988005544");
        userRepository.saveAll(Arrays.asList(user1, user2));

        Order order1 = new Order(null, Instant.parse("2025-01-20T19:53:07Z"), OrderStatus.WAITING_PAYMENT,user1);
        Order order2 = new Order(null, Instant.parse("2025-01-21T15:23:17Z"), OrderStatus.PAID, user2);
        Order order3 = new Order(null, Instant.parse("2025-02-02T11:20:06Z"), OrderStatus.SHIPPED, user1);
        orderRepository.saveAll(Arrays.asList(order1, order2, order3));
    }


}
