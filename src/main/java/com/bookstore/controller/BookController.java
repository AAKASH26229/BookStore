package com.bookstore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bookstore.entity.Book;
import com.bookstore.service.BookService;


@RestController
@RequestMapping("/books")
public class BookController {

	@Autowired 
	public BookService service;
	
	//Get list of all books 
	@CrossOrigin(origins = "http://127.0.0.1:5500")
	@GetMapping
	public List<Book> getAllBooks(){
		return service.getAllBooks();
	}
	
	//Add books 
	@CrossOrigin(origins = "http://127.0.0.1:5500")
	@PostMapping
	public Book createBook(@RequestBody Book book) {
		return service.createBook(book);
	}
	
	
	//Get book details by id
	@CrossOrigin(origins = "http://127.0.0.1:5500")
	@GetMapping("/{id}")
	public Book getBookById(@PathVariable Long id) {
		return service.getBookById(id);
	}
	
	
	//Update book details
	@CrossOrigin(origins = "http://127.0.0.1:5500")
	@PutMapping("/{id}")
	public Book updateBook(@PathVariable Long id, @RequestBody Book updateBook) {
		return service.updateBook(id, updateBook);
	}
	
	//Delete book by id
	@CrossOrigin(origins = "http://127.0.0.1:5500")
	@DeleteMapping("/{id}")
	public void deleteBook(@PathVariable Long id) {
		service.deleteBook(id);
	}
}
