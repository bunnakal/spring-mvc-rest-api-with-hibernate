package com.dmi.test;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.springframework.web.client.RestTemplate;

import com.dmi.model.Book;

public class GetBookByIdTest {

	private final String REST_SERVICE_URI = "http://localhost:8085/Spring4MVCCRUDRestService/api/v1";

	@Test
	public void getBookByIdWorksOK() {
		RestTemplate template = new RestTemplate();
		Book actualBook = template.getForObject(REST_SERVICE_URI+"/items/" + 1, Book.class);
		Book expectBook = new Book(1, "Rest API with JAVA", "restjava.png", "Jonhan", 30.0);
		assertEquals(expectBook.getId(), actualBook.getId());
		assertEquals(expectBook.getTitle(), actualBook.getTitle());
		assertEquals(expectBook.getImage(), actualBook.getImage());
		assertEquals(expectBook.getAuthor(), actualBook.getAuthor());
	}
}
