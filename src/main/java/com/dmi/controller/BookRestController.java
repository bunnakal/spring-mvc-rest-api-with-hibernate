package com.dmi.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.dmi.model.Book;
import com.dmi.model.Item;
import com.dmi.service.BookService;


@RestController
@RequestMapping("/api/v1")
public class BookRestController {
	
	private static final Logger logger = Logger.getLogger(BookRestController.class);

	@Autowired
	BookService bookService; //Service which will do all data retrieval/manipulation work

	@RequestMapping(value = "/items", method = RequestMethod.GET)
	public ResponseEntity<List<Item>> list(@RequestParam("offset") int offset, @RequestParam("count") int count) {
		List<Item> books = bookService.list(offset, count);
		if(books.isEmpty()){
			return new ResponseEntity<List<Item>>(HttpStatus.NO_CONTENT);
		}
		logger.info("Book successfully loaded...in rest controller");
		return new ResponseEntity<List<Item>>(books, HttpStatus.OK);
	}

	@RequestMapping(value = "/items/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Book> getBook(@PathVariable("id") int id) {
		Book book = bookService.get(id);
		if (book == null) {
			System.out.println("Book with id " + id + " not found");
			return new ResponseEntity<Book>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Book>(book, HttpStatus.OK);
	}
		
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ResponseEntity<Void> createBook(@RequestBody Book book, 	UriComponentsBuilder ucBuilder) {
		bookService.save(book);
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/book/{id}").buildAndExpand(book.getId()).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}
	
	@RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Book> updateBook(@PathVariable("id") int id, @RequestBody Book book, 	UriComponentsBuilder ucBuilder) {
		Book currentBook = bookService.get(id);
        if (currentBook==null) {
            System.out.println("Book with id " + id + " not found");
            return new ResponseEntity<Book>(HttpStatus.NOT_FOUND);
        }
        currentBook.setTitle(book.getTitle());
        currentBook.setImage(book.getImage());
        currentBook.setAuthor(book.getAuthor());
        currentBook.setPrice(book.getPrice());
        bookService.update(currentBook);
        return new ResponseEntity<Book>(currentBook, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Book> deleteBook(@PathVariable("id") int id) {
		Book book = bookService.get(id);
		if (book == null) {
			System.out.println("Unable to delete. Book with id " + id + " not found");
			return new ResponseEntity<Book>(HttpStatus.NOT_FOUND);
		}
		bookService.delete(id);
		return new ResponseEntity<Book>(HttpStatus.NO_CONTENT);
	}
}
