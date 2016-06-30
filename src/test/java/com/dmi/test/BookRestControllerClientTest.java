package com.dmi.test;

import java.net.URI;
import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.web.client.RestTemplate;

import com.dmi.model.Book;

public class BookRestControllerClientTest {

	public static final String REST_SERVICE_URI = "http://localhost:8085/Spring4MVCCRUDRestService/api/v1";
	
	/* GET */
	@SuppressWarnings("unchecked")
	private static void listAllBooks(){
		System.out.println("Testing listAllBooks API-----------");
		
		RestTemplate restTemplate = new RestTemplate();
		List<LinkedHashMap<String, Object>> booksMap = restTemplate.getForObject(REST_SERVICE_URI+"/items?offset=0&count=20", List.class);
		
		if(booksMap!=null){
			for(LinkedHashMap<String, Object> map : booksMap){
	            System.out.println("Book : id="+map.get("id")+", title="+map.get("title"));
	        }
		}else{
			System.out.println("No Book exist----------");
		}
	}
	
	/* GET */ 
	private static void getBookById(int id){
		System.out.println("Testing getBook API----------");
		RestTemplate restTemplate = new RestTemplate();
        Book book = restTemplate.getForObject(REST_SERVICE_URI+"/items/" + id, Book.class);
        System.out.println(book);
	}
	 
	/* POST */ 
    private static void createBook() {
		System.out.println("Testing create Book API----------");
    	RestTemplate restTemplate = new RestTemplate();
        Book book = new Book("JAVA APP Development with Java SE","webjava.pnh", "Wim Polet", 40);
        URI uri = restTemplate.postForLocation(REST_SERVICE_URI+"/save", book, Book.class);
        System.out.println("Location : "+uri.toASCIIString());
    }
    
    /* PUT */
    private static void updateBook(int id) {
        System.out.println("Testing update Book API----------");
        RestTemplate restTemplate = new RestTemplate();
        Book bb = restTemplate.getForObject(REST_SERVICE_URI+"/items/" + id, Book.class);
        System.out.println("Book id= " + id + "before update");
        System.out.println(bb);
        Book book  = new Book("Spring and Hibernate","springhibernate.png","KAL",33);
        restTemplate.put(REST_SERVICE_URI + "/update/" + id, book);
        Book ba = restTemplate.getForObject(REST_SERVICE_URI + "/items/" + id, Book.class);
        System.out.println("Book id= " + id + " after updated");
        System.out.println(ba);
    }

    /* DELETE */ 
    @SuppressWarnings("unused")
	private static void deleteBookById(int id) {
		System.out.println("Testing delete Book API----------");
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete(REST_SERVICE_URI + "/delete/" + id);
    }
    
    public static void main(String args[]){
		listAllBooks();
		getBookById(1);
		createBook();
		updateBook(8);
//		deleteBookById(28);
    }
}