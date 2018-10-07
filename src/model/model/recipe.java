package model;

public class recipe {
	int size = 0;
	public Item[] foods = new Item[100];
	public String name;
	String link;
	
	public recipe(String name, Item[] foods, String url ) {
		this.link = url;
		this.name = name;
		this.foods = foods;
		
	}
	
	public String getName() {
		return this.name;
	}
	public String getLink() {
		return this.link;
	}

}
