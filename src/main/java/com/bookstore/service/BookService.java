package com.bookstore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookstore.entity.Book;
import com.bookstore.repository.BookRepository;

@Service
public class BookService {
	
	@Autowired
	public BookRepository repo;
	
	public List<Book> getAllBooks(){
		return repo.findAll();
	}
	
	public Book createBook(Book book) {
		return repo.save(book);
	}

	public Book getBookById(Long id) {
		return repo.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Book not found"));
		
	}
	
	public Book updateBook(Long id,Book updateBook) {
		Book exsistingBook = repo.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Book not found"));
		
		exsistingBook.setAuthor(updateBook.getAuthor());
		exsistingBook.setTitle(updateBook.getTitle());
		
		return repo.save(exsistingBook);
	}
	
	public void deleteBook(Long id) {
		repo.deleteById(id);
	}
	
}
