package com.moviesuggestion;
import com.moviesuggestion.model.user.User;
import com.moviesuggestion.model.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MovieSuggestionApplication implements CommandLineRunner {

    @Autowired
    private UserRepository repository;

    public static void main(String[] args) {
        SpringApplication.run(MovieSuggestionApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        repository.deleteAll();

        // save a couple of users
        repository.save(new User("Alice", "alice"));
        repository.save(new User("Bob", "bob"));

        // fetch all users
        System.out.println("Users found with findAll():");
        System.out.println("-------------------------------");
        for (User user : repository.findAll()) {
            System.out.println(user);
        }
        System.out.println();

        // fetch an individual user
        System.out.println("User found with findByFirstName('Alice'):");
        System.out.println("--------------------------------");
        System.out.println(repository.findByFirstName("Alice"));

        System.out.println("Users found with findByLogin('bob'):");
        System.out.println("--------------------------------");
        for (User user : repository.findByLogin("bob")) {
            System.out.println(user);
        }

    }

}
