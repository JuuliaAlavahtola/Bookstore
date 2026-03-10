package hh.sof03.bookstore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import hh.sof03.bookstore.domain.BookRepository;
import hh.sof03.bookstore.domain.Category;
import hh.sof03.bookstore.domain.CategoryRepository;
import hh.sof03.bookstore.domain.Book;
import hh.sof03.bookstore.domain.AppUser;
import hh.sof03.bookstore.domain.AppUserRepository;

@SpringBootApplication
public class BookstoreApplication {

    public static void main(String[] args) {
        SpringApplication.run(BookstoreApplication.class, args);
    }

    @Bean
    public CommandLineRunner createDemo(BookRepository bookRepository,
                                        CategoryRepository categoryRepository,
                                        AppUserRepository userRepository,
                                        BCryptPasswordEncoder encoder) {
        return (args) -> {

            // Categories
            Category category1 = new Category("classics");
            categoryRepository.save(category1);
            Category category2 = new Category("Satire");
            categoryRepository.save(category2);
            Category category3 = new Category("Fiction");
            categoryRepository.save(category3);
            Category category4 = new Category("Fantasy");
            categoryRepository.save(category4);

            // Books
            bookRepository.save(new Book(null, "Jane Austen", "Pride and Prejudice", "978-1503290563", 1813, 9.90, category1));
            bookRepository.save(new Book(null, "George Orwell", "Animal Farm", "2212343-5", 1945, 19.90, category2));
            bookRepository.save(new Book(null, "Ernest Hemingway", "A Farewell to Arms", "1232323-21", 1929, 19.90, category3));
            bookRepository.save(new Book(null, "J. R. R. Tolkien", "The Hobbit", "978-0547928227", 1937, 12.99, category4));

            // USERS (ilman sähköpostia)
            if (userRepository.findByUsername("user") == null) {
                AppUser user = new AppUser(
                    "user",
                    encoder.encode("password"),
                    "USER"
                );
                userRepository.save(user);
            }

            if (userRepository.findByUsername("admin") == null) {
                AppUser admin = new AppUser(
                    "admin",
                    encoder.encode("admin"),
                    "ADMIN"
                );
                userRepository.save(admin);
            }

            System.out.println("Users created:");
            userRepository.findAll().forEach(u -> System.out.println(u.getUsername() + " / " + u.getRole()));
        };
    }
}
