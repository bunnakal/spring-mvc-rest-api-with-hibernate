package com.dmi.test;

import org.junit.Test;
import org.springframework.web.client.RestTemplate;

import com.dmi.model.Book;

public class UpdateBookTest {
	
	private final String REST_SERVICE_API="http://localhost:8085/Spring4MVCCRUDRestService/api/v1";
	
	@Test
	public void updateBookWorksOK() {
		RestTemplate template = new RestTemplate();
		Book book = new Book("Rest API with JAVA", "restjava.png", "Jonhan", 30);
		template.put(REST_SERVICE_API + "/update/1", book);
	}
}
