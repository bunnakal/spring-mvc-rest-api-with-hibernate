package com.dmi.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class ListBooksTest {
	
	private final String REST_SERVICE_API="http://localhost:8085/Spring4MVCCRUDRestService/api/v1";
	
	@Test
	public void listBooksWorksOK() {
		RestTemplate template = new RestTemplate();
		@SuppressWarnings("rawtypes")
		ResponseEntity<List> result = template.getForEntity(REST_SERVICE_API + "/items?offset=0&count=2", List.class);
		assertNotNull(result);
		assertNotNull(result.getBody());
		assertEquals(result.getBody().size(), 2);
	}
}
