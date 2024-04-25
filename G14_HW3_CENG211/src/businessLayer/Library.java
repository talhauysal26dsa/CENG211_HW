package businessLayer;

import java.util.ArrayList;


import entitiesLayer.Item;
import entitiesLayer.ItemType;


public class Library {
	private ArrayList<Item> items;
	

	public Library(ArrayList<Item> items) {
		this.items = items;
		
		
	}
	

	 
	 public void searchAndPrint(String title) {
	        boolean found = false;
	        for (Item item : items) {
	            if (item.searchByName(title)) {
	            	
	            	System.out.println();
	                item.output();
	                found = true;
	            }
	        }
	        if (!found) {
	            System.out.println(" does not exist.");
	        }
	    }
	    
	    public void searchAndPrint(String title, ItemType itemType) {
	        boolean found = false;
	        for (Item item : items) {
	            if (item.searchByNameAndType(title, itemType)) {
	            	System.out.println("does exist.");
	                item.output();
	                found = true;
	            }
	        }
	        if (!found) {
	            System.out.println("does not exist.");
	        }
	    }
	    public void AllItems() {
	        if (items.isEmpty()) {
	            System.out.println("empty.");
	            return;
	        }

	        for (Item item : items) {
	            item.output();
	        }
	    }
	
}
