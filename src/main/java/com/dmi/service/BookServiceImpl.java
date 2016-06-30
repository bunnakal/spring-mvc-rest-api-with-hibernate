package com.dmi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dmi.dao.BookDao;
import com.dmi.model.Book;
import com.dmi.model.Item;

@Service
public class BookServiceImpl implements BookService {
	
	@Autowired
	BookDao bookDao;
	
	@Override
	public Book get(int id) {
		return bookDao.get(id);
	}
	
	@Override
	public void save(Book book) {
		bookDao.save(book);
	}
	
	@Override
	public void delete(int id) {
		bookDao.delete(id);
	}

	@Override
	public List<Item> list(int offset, int count) {
		return bookDao.list(offset, count);
	}

	@Override
	public void update(Book book) {
		bookDao.update(book);
	}
	
}
