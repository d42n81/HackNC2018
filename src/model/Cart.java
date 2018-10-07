package model;
import java.util.ArrayList;
import java.util.List;

public class Cart {
	Item[] foodItems;
	public Cart() {
		foodItems = new Item[100];
	}
	int size =0;
	
	int[][] cartItems = new int[2][100];	
	
	public void add(Item food, int quantity) {
		for (int i = 0; i< cartItems[0].length; i++) {
			if (cartItems[0][i] == 0) {
				cartItems[0][i] = food.getId();
				cartItems[1][i] = quantity;
				size += quantity;
				foodItems[i] = food;
				return;
			}
		}
	}
	void remove(Item food) {
		for (int i = 0; i< cartItems.length; i++) {
			if (cartItems[0][i] == food.getId()) {
				cartItems[0][i] = 0;
				cartItems[1][i] = 0;
				size--;
				return;
			}
		}
	}
	
	public static boolean Contains(Item[] food, Item elt) {
		 for (int i =0; i< food.length;i++) {
			 if(food[i] != null) {
				 if (food[i].getname().equals(elt.name)) {
					 return true;
				 }
			 }
			 
		 }
		 return false;
	 }

	
	public Item[] getFood() {
//		List<Item> food = new ArrayList<Item>();
//		for (int i=0; i< 100;i++) {
//			if (cartItems[0][i]!= 0) {
//				food.add(cartItems[0][i]);
//			}
//			
//		}
//		Item [] tempArray = food.toArray(new Item[food.size()]);
//		return tempArray;
		return foodItems;
		
	}
	public int getSize() {
		// TODO Auto-generated method stub
		return this.size;
	}
	
	
	
}
