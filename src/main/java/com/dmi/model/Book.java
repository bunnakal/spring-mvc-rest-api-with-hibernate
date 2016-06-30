package com.dmi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "BOOKS")
public class Book {
	
	@Id
	@GeneratedValue
	@Column(name = "ID")
	private int id;
	
	@Column(name = "TITLE")
	private String title;
	
	@Column(name = "IMAGE")
	private String image;
	
	@Column(name = "AUTHOR")
	private String author;
	
	@Column(name = "PRICE")
	private double price;

	public int getId() {
		return id;
	}
	public Book(){
		
	}
	
	public Book(String title, String image, String author, double price){
		this.title=title;
		this.image=image;
		this.author=author;
		this.price=price;
	}
	
	public Book(int id, String title, String image, String author, double price){
		this.id=id;
		this.title=title;
		this.image=image;
		this.author=author;
		this.price=price;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
	 @Override
	 public String toString() {
		 return "Book [id=" + id + ", title=" + title + ", image=" + image
	                + ", author=" + author + ", price=" + price + "]";
	 }
}
