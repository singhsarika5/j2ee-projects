package com.myprojects.beans;

public class Book {
	private String colNo, name, author, publisher;

	private int quantity;
	private int issued;

	public Book() {
		super();
	}

	public Book(String colNo, String name, String author, String publisher, int quantity) {
		this.colNo = colNo;
		this.name = name;
		this.author = author;
		this.publisher = publisher;
		this.quantity = quantity;
		issued = 0;
	}

	public String getColNo() {
		return this.colNo;
	}

	public String getName() {
		return this.name;
	}

	public String getAuthor() {
		return this.author;
	}

	public String getPublisher() {
		return this.publisher;
	}

	public int getQuantity() {
		return this.quantity;
	}

	public void setColNo(String colNo) {
		this.colNo = colNo;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getIssued() {
		return this.issued;
	}

	public void setIssued(int issued) {
		this.issued = issued;
	}
}
