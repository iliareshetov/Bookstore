package com.bookstore.Bookstore.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bookstore.Bookstore.domain.Book;
import com.bookstore.Bookstore.domain.BookRepository;

@Controller
public class BookController {
	@Autowired
	private BookRepository repository;


	@RequestMapping(value ="/booklist", method = RequestMethod.GET)
	public String bookList(Model model){
		model.addAttribute("bookList",repository.findAll());
		return "booklist";
	}

	 @RequestMapping(value="/add")
	 public String addAttribute(Model model){
		 model.addAttribute("book", new Book());
		 return "addBook";
	 }

	 @RequestMapping(value="/save")
	 public String save(Book book){
		 repository.save(book);
		 return "redirect:booklist";
	 }

	 @RequestMapping(value="/delete/{id}", method = RequestMethod.GET)
	 public String deleteBook(@PathVariable("id") Long bookId, Model model){
		 repository.deleteById(bookId);
		 return "redirect:../booklist";
	 }

	 @RequestMapping(value="/edit/{id}", method = RequestMethod.GET)
	 public String editBook(@PathVariable("id") Long bookId, Model model){
		 model.addAttribute("editbook", repository.findById(bookId));
		 return "editBook";
	 }

}
