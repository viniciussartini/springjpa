package br.com.example.springjpa.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import br.com.example.springjpa.entities.User;
import br.com.example.springjpa.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{

    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {
        User user1 = new User(null, "Maria", "maria@email.com", "1234", "988007766");
        User user2 = new User(null, "Alex", "alex@email.com", "1234", "988005544");

        userRepository.saveAll(Arrays.asList(user1, user2));
    }


}
