package presentationLayer;


import java.util.ArrayList;

import businessLayer.Library;
import dataAccessLayer.FileIO;
import entitiesLayer.Item;


public class LibraryManagementApp {

	public static void main(String[] args) {
		FileIO fileIO = new FileIO();
		fileIO.readFile();
		Library library = new Library(fileIO.getItemArrayList());
		//library.searchAndPrint();
		library.AllItems();
		
		
		
		
		
		
			
			
		}
		
		
	}


