package entitiesLayer;

import java.util.ArrayList;

import businessLayer.Library;
import entitiesLayer.abstracts.Borrowing;
import entitiesLayer.abstracts.Searchable;

public abstract class Item implements Searchable, Borrowing{

	private String itemNumber;
	private String title;
	protected int priority;
	private ItemType itemType;
		
	private CustomerType customerType;
	protected Date startBorrow;
	protected Date endBorrow;
	
	
	
	public Item(String itemNumber, String title, int priority, ItemType itemType, CustomerType customerType, Date startBorrow, Date endBorrow) {
		this.setItemNumber(itemNumber);
		this.setTitle(title);
		this.setPriority(priority);
		this.setItemType(itemType);
		this.setCustomerType(customerType);
		this.setStartBorrow(startBorrow);
		this.setEndBorrow(endBorrow);
		
		
		
		
		
	}

	

	public CustomerType getCustomerType() {
		return customerType;
	}

	public void setCustomerType(CustomerType customerType) {
		this.customerType = customerType;
	}

	public String getItemNumber() {
		return itemNumber;
	}

	public void setItemNumber(String itemNumber) {
		this.itemNumber = itemNumber;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public ItemType getItemType() {
		return itemType;
	}

	public void setItemType(ItemType itemType) {
		this.itemType = itemType;
	}

	public abstract Date getStartBorrow();
	public void setStartBorrow(Date startBorrow) {
		this.startBorrow = startBorrow;
	}

	public abstract Date getEndBorrow();

	public void setEndBorrow(Date endBorrow) {
		this.endBorrow = endBorrow;
	}

	public abstract int getPriority();

	public void setPriority(int priority) {
		this.priority = priority;
	}

	


	public abstract double getBorrowingChargePerDay();
	
	public boolean searchByName(String title)
	
	{
		return this.title.equalsIgnoreCase(title);
		
		}
	public boolean searchByNameAndType(String title, ItemType type) {
		return this.title.equalsIgnoreCase(title) && this.itemType.name().equalsIgnoreCase(type.name());
	}
	public  double calculateBorrowingCharge(Item item) {
		
		int daysBetween = daysBetween(item.getStartBorrow(), item.getEndBorrow());
		int priority = item.getPriority();
		double borrowingChargePerDay = item.getBorrowingChargePerDay();
		return daysBetween*priority*borrowingChargePerDay;
		
		
		
	}
	public double calculateLateCharge(Item item) {
		int borrowingDays = daysBetween(item.getStartBorrow(), item.getEndBorrow());
		if (borrowingDays>10) {
			return 5;
		}
		else if ((7<borrowingDays) && (borrowingDays<=10)) {
			return 2;
			
		}else {
			return 0;
		}
		
	}
	public double calcuteDiscount(Item item) {
		if (this.getCustomerType().name().equals("StudentWScholar")) {
			return 30;
			
		}
		else if(this.getCustomerType().name().equals("StudentWOScholar")) {
			return 20;
		}
		else 
		{	return 0;
		}
		
	}
	
	 public int daysBetween(Date startDate, Date endDate) {
	        int startDays = startDate.getDay() + startDate.getMonth() * 30 + startDate.getYear() * 365;
	        int endDays = endDate.getDay() + endDate.getMonth() * 30 + endDate.getYear() * 365;

	        return Math.abs(endDays - startDays);
	    }
	 
	 public double calculateTotalCharge(Item item) {
		 double discount = calcuteDiscount(item);
		 
		 return (calculateBorrowingCharge(item)+calculateLateCharge(item))*((100.0-discount)/100);
		 
		 
	 }
	
	
	
	private String getExceeds(Item item) {
		if(calculateLateCharge(this)!= 0) {
			return "Exceeds";
			
		}
		else {
			return "Not Exceeds";
		}
		
	}
	 public void output() {
	        System.out.println("Item Number: " + itemNumber +"/" +"Title: " + title+ "/"+"Item Type:"+ itemType+" /" +"Borrowing Days: " + daysBetween(this.startBorrow, this.endBorrow)+" /"+
	        		"Exceeds Date: " + getExceeds(this) +" /"+ "Total Price: " + calculateTotalCharge(this) );
	        
	    }
	
		
		
	
}
