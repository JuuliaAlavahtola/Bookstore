package hh.sof03.bookstore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import hh.sof03.bookstore.domain.BookRepository;
import hh.sof03.bookstore.domain.Category;
import hh.sof03.bookstore.domain.CategoryRepository;
import hh.sof03.bookstore.domain.Book;


@SpringBootApplication
public class BookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Bean
	public CommandLineRunner createDemo(BookRepository bookRepository, CategoryRepository categoryRepository) {
		return (args) -> {
			bookRepository.save(new Book(null, "Jane Austen", "Pride and Prejudice",  "978-1503290563",  1813, 9.90));
			bookRepository.save(new Book(null, "George Orwell", "Animal Farm", "2212343-5", 1945, 19.90));
			bookRepository.save(new Book(null, "Ernest Hemigway", "A Farewell to Arms",  "1232323-21", 1929, 19.90));
			bookRepository.save(new Book(null, "J. R. R. Tolkien", "The Hobbit", "978-0547928227", 1937, 12.99));

			bookRepository.findAll().forEach(book -> System.out.println(book));

			categoryRepository.save(new Category("Scifi"));
			categoryRepository.save(new Category("Comic")); 
			categoryRepository.save(new Category("Fantasy")); 
			
			System.out.println("Categories:"); categoryRepository.findAll().forEach(category -> System.out.println(category));
		};
	}

}
