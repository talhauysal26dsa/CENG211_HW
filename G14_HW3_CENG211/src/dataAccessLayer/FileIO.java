package dataAccessLayer;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

import entitiesLayer.Book;
import entitiesLayer.CustomerType;
import entitiesLayer.Date;
import entitiesLayer.Item;
import entitiesLayer.ItemType;
import entitiesLayer.Magazine;



public class FileIO {
	private ArrayList<Item> itemArrayList = new  ArrayList<Item>();
	
public FileIO() {
	
		
	}
	public void readFile() {
	try (BufferedReader reader = new BufferedReader(new FileReader("items.csv"))) {
	    String line;

	    while ((line = reader.readLine()) != null) {
	    	StringTokenizer wordFinder = new StringTokenizer(line, ";");
	        // Process each line here
	    	while (wordFinder.hasMoreTokens()) {
	    		 String itemNumber = wordFinder.nextToken();
	    		 String title = wordFinder.nextToken();
	    		 int priority = getPriorityNumber(wordFinder.nextToken());
	    		 ItemType itemType = getItemType(wordFinder.nextToken());
	    		 String authorOrGenre = wordFinder.nextToken();
	    		 String publisherOrProducer = wordFinder.nextToken();
	    		 CustomerType customerType = getCustomerType(wordFinder.nextToken());
	    		 Date startBorrow = new Date(wordFinder.nextToken().trim());
	    		 Date endBorrow = new Date(wordFinder.nextToken().trim());
	    		 if (itemType.name() == "BOOK") {
	    			 Book book = new Book(itemNumber, title,priority, itemType, customerType, authorOrGenre, publisherOrProducer,startBorrow,endBorrow);
	    			 itemArrayList.add(book);

	    		 }
	    		 else if (itemType.name().equals("MAGAZINE")) {
	    			 Magazine magazine = new Magazine(itemNumber, title,priority, itemType, customerType, authorOrGenre, publisherOrProducer,startBorrow,endBorrow);
	    			 itemArrayList.add(magazine);
	    			 
	    		 }  		 
	    	}
	    	
	    }

	    } 
	 catch (IOException e) {
	    e.printStackTrace();}


	}
	public ArrayList<Item> getItemArrayList() {
		return itemArrayList;
		
	}
	
	 private ItemType getItemType(String itemString) {
	        if ("book".equalsIgnoreCase(itemString)) {
	            return ItemType.BOOK;
	        } else if ("magazine".equalsIgnoreCase(itemString)) {
	            return ItemType.MAGAZINE;
	        } else {
	            
	            return null;
	        }
	    }
	 private CustomerType getCustomerType(String customerString) {
	        if ("general".equalsIgnoreCase(customerString)) {
	            return CustomerType.GENERAL;
	        } else if ("studentwoscholar".equalsIgnoreCase(customerString)) {
	            return CustomerType.StudentWOScholar;
	        } else if ("studentwscholar".equalsIgnoreCase(customerString)) {
	            return CustomerType.StudentWScholar;
	        } else {
	            
	            return null;
	        }
	    }
	 private int getPriorityNumber(String priority) {
	        if ("invaluable".equalsIgnoreCase(priority)) {
	            return 3;
	        } else if ("highly significant".equalsIgnoreCase(priority)) {
	            return 2;
	            
	        }
	        else if ("noteworthy".equalsIgnoreCase(priority)) {
	            return 1;
	        }
	        else {
	           
	            return 0;
	        }
	    }

}
