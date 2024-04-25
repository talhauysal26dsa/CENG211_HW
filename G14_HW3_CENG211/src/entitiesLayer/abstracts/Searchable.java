package entitiesLayer.abstracts;


import entitiesLayer.ItemType;

public interface Searchable {
	public boolean searchByName(String title);
	public boolean searchByNameAndType(String title, ItemType type);

}
