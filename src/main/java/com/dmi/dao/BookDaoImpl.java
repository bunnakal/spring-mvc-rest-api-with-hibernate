package com.dmi.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.apache.log4j.Logger;

import com.dmi.model.Book;
import com.dmi.model.Item;

@Repository
@Transactional
public class BookDaoImpl implements BookDao {
	
	private static final Logger logger = Logger.getLogger(BookDaoImpl.class);
	
	@Autowired
	private SessionFactory sessionFactory;

	public BookDaoImpl() {
		
	}
	
	public BookDaoImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Item> list(int offset, int count){
		Session session = this.sessionFactory.getCurrentSession();
		Criteria cr = session.createCriteria(Book.class)
				.setFirstResult(offset)
				.setMaxResults(count)
				.setProjection(Projections.projectionList()
			      .add(Projections.property("id"), "id")
			      .add(Projections.property("title"), "title"));
		List<Item> items = convertToItemList(cr.list());
		for(Item it : items){
			logger.info("Book item List:" + it);
		}
		return items;
	}
	
	@Override
	public Book get(int id) {
		String hql = "from Book where id=" + id;
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		@SuppressWarnings("unchecked")
		List<Book> book = (List<Book>) query.list();
		if (book != null && !book.isEmpty()) {
			logger.info("Book load successfully, Book detail:" + book);
			return book.get(0);
		}
		return null;
	}
	
	@Override
	public void save(Book book) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(book);
		logger.info("Book save successfully, Book detail:" + book);
	}
	
	@Override
	public void delete(int id) {
		Book bookToDelete = new Book();
		bookToDelete.setId(id);
		sessionFactory.getCurrentSession().delete(bookToDelete);
		logger.info("Book delete successfully, Book detail:" + bookToDelete);
	}

	@Override
	public void update(Book book) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(book);
		logger.info("Book update successfully, Book detail:" + book);
	}
	
	private List<Item> convertToItemList(List<Object> rows){
		List<Item> items = new ArrayList<Item>();
		for(Object r: rows){
		  Object[] row = (Object[]) r;
		  Item it = new Item();
		  it.setId(Integer.parseInt(row[0].toString()));
		  it.setLink("/api/v1/items/" + row[0].toString());
		  it.setTitle(row[1].toString());
		  items.add(it);
		}
		return items;
	}
}