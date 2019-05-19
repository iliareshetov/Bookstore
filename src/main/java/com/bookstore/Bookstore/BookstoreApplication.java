package com.bookstore.Bookstore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.bookstore.Bookstore.domain.Book;
import com.bookstore.Bookstore.domain.BookRepository;

@SpringBootApplication
public class BookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner Demo(BookRepository repository) {
		return (args) -> {
			Book book1 = new Book("A Farewell to Arms","Ernest Hemingway",1929,"1232323-21",20.00);
			 repository.save(book1);

			 Book book2 = new Book("Animal Farm", "George Orwell", 1945,"2212343-5", 20.00);
			 repository.save(book2);

		};
	}

}
