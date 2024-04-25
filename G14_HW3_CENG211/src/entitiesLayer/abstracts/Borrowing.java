package entitiesLayer.abstracts;

import entitiesLayer.Date;
import entitiesLayer.Item;

public interface Borrowing {
	
	
	public double calculateBorrowingCharge(Item item);
	public double calculateLateCharge(Item item);
	public double calcuteDiscount(Item item);
	public int daysBetween(Date startDate, Date endDate);
	public double calculateTotalCharge(Item item);
	
	
	

}
