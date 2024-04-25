package entitiesLayer;

import java.util.ArrayList;

import businessLayer.Library;
import entitiesLayer.abstracts.Searchable;

public class Book extends Item {
	private String author;
	private String publisher;
	

	public Book(String itemNumber, String title, int priority, ItemType itemType, CustomerType customerType, String author, String publisher, 
			Date startBorrow, Date endBorrow) {
		super(itemNumber, title, priority, itemType, customerType, startBorrow, endBorrow);
		this.author = author;
		this.publisher = publisher;
		
		
	}


	public String getAuthor() {
		return author;
	}


	public void setAuthor(String author) {
		this.author = author;
	}


	public String getPublisher() {
		return publisher;
	}


	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}


	@Override
	public Date getStartBorrow() {
		
		return startBorrow;
	}


	@Override
	public Date getEndBorrow() {
		
		return endBorrow;
	}


	@Override
	public int getPriority() {
		
		return priority;
	}


	@Override
	public double getBorrowingChargePerDay() {
		
		return 5;
	}



	
}
