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

        
        Category category1 = new Category("classics");
		 categoryRepository.save(category1);
        Category category2 =new Category("Satire");
         categoryRepository.save(category2);
        Category category3 = new Category("Fiction");
        categoryRepository.save(category3);
        Category category4 = new Category("Fantasy");
        categoryRepository.save(category4);

        bookRepository.save(new Book(null, "Jane Austen", "Pride and Prejudice", "978-1503290563", 1813, 9.90, category1));
        bookRepository.save(new Book(null, "George Orwell", "Animal Farm", "2212343-5", 1945, 19.90, category2));
		bookRepository.save(new Book(null, "Ernest Hemingway", "A Farewell to Arms", "1232323-21", 1929, 19.90, category3));
		bookRepository.save(new Book(null, "J. R. R. Tolkien", "The Hobbit", "978-0547928227", 1937, 12.99, category4));

        
        System.out.println("Categories:");
        categoryRepository.findAll().forEach(c -> System.out.println(c));

      
        System.out.println("Books:");
        bookRepository.findAll().forEach(b -> System.out.println(b));
    };
}


}
