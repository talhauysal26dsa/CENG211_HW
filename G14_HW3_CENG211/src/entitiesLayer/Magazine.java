package entitiesLayer;



public class Magazine extends Item{
	private String genre;
	
	private String publisher;
	

	public Magazine(String itemNumber, String title, int priority, ItemType itemType, CustomerType customerType,String genre, String publisher,
			Date startBorrow, Date endBorrow) {
		super(itemNumber, title, priority, itemType, customerType, startBorrow, endBorrow);
		this.genre = genre;
		this.publisher = publisher;
		
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
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
		
		return 10;
	}

	


	

}
