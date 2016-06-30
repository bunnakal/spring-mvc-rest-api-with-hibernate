package com.dmi.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class DeleteBookTest {

	public static final String REST_SERVICE_URI = "http://localhost:8085/Spring4MVCCRUDRestService/api/v1";
	
	@SuppressWarnings("rawtypes")
	@Test
	public void deleteBookWorksOK() {
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<List> listPriorDelete = restTemplate.getForEntity(REST_SERVICE_URI + "/items?offset=0&count=100", List.class);
		restTemplate.delete(REST_SERVICE_URI + "/delete/" + 1); // 1 can be change to what ever id value need to be deleted 
		ResponseEntity<List> listAfterDeleted = restTemplate.getForEntity(REST_SERVICE_URI + "/items?offset=0&count=100", List.class);
		assertNotNull(listAfterDeleted);
		assertNotNull(listAfterDeleted.getBody());
		assertEquals(listPriorDelete.getBody().size()-1, listAfterDeleted.getBody().size() );
	}
}
