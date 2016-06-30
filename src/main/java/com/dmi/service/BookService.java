package com.dmi.service;

import java.util.List;

import com.dmi.model.Book;
import com.dmi.model.Item;

public interface BookService {
	
	public List<Item> list(int offset, int count);
	
	public Book get(int id);
	
	public void save(Book book);
	
	public void update(Book book);
	
	public void delete(int id);

}
