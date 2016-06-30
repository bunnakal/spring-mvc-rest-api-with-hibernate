package com.dmi.test;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.dmi.model.Book;

public class AddBookTest {
	
	private final String REST_SERVICE_URI="http://localhost:8085/Spring4MVCCRUDRestService/api/v1";
	
	@Test
	public void addBookWorksOK() {
		RestTemplate template = new RestTemplate();
		Book book = new Book("Hibernate with MySQL","hibernatesql.png","Sorania",20);
		ResponseEntity<Book> resultSave = template.postForEntity(REST_SERVICE_URI + "/save", book, Book.class);
		assertNotNull(resultSave);
	}
}
