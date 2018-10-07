package executable;

import java.util.List;
import java.util.ArrayList;

import javax.swing.JFrame;

import model.Cart;
import model.Item;
import model.recipe;
import view.GroceryOrderView;
import view.MyCartEastView;
import view.ScrollablePanel;

public class RunnableFile {
	public static Cart myCart = new Cart();
	
	public static void main(String [] args) throws Exception {
//		GroceryOrderView orderView = new GroceryOrderView();
		ScrollablePanel orderView = new ScrollablePanel(new GroceryOrderView());
		
		
		JFrame main_frame = new JFrame();
		main_frame.setTitle("Grocery Order Example");
		main_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		main_frame.setContentPane(orderView);

		main_frame.pack();
		main_frame.setVisible(true);
	}
	
	public static void getRecipes(Item[] foods,recipe[] recipes) {
		System.out.println("We have entered getRecipes");
		 List<recipe> matches = new ArrayList<recipe>();
		 MyCartEastView.perfectMatchArray.clear();
		 MyCartEastView.oneAwayMatchArray.clear();
		 MyCartEastView.twoAwayMatchArray.clear();
		 
		for (int i=0; i < recipes.length; i++) {
			if (compareRecipe(foods, recipes[i]) >= recipes[i].foods.length - 2) {
//				matches.add(recipes[i]);
				System.out.println("We have at least some matches.");
				if(compareRecipe(foods, recipes[i]) - recipes[i].foods.length == 0) {
					System.out.println("We have a perfect match.");

					// we have a perfect match. 
					// add to perfect match array this recipe.
					MyCartEastView.perfectMatchArray.add(recipes[i]);
				} else if (recipes[i].foods.length - compareRecipe(foods, recipes[i]) == 1) {
					System.out.println("We are one away.");

					MyCartEastView.oneAwayMatchArray.add(recipes[i]);
				} else {
					System.out.println("We are two away.");

					MyCartEastView.twoAwayMatchArray.add(recipes[i]);
				}
			}
			
		}
		System.out.println("Size of Matches: " + matches.size());
//		return matches.toArray(new recipe [matches.size()]);
	 }
	 public static int compareRecipe(Item[] foods, recipe recipe) {
		 int count = 0;
		 for(int i =0; i< recipe.foods.length;i++) {
			 System.out.println("Cycling through recipe item " + i);
			 for(int j=0; j< foods.length; j++) {
				 System.out.println("Cycling through cart item " + i);
				 if (recipe.foods[i] == foods[j]) {
					 System.out.println("Returning false in compare recipe because one of our recipe items is not in our cart.");
					 count++;		 
				 }
			 }
		 }
//		 if (count == recipe.foods.length) {
//			 return true;
//		 } else if (count == recipe.foods.length - 1) {
//			 // we are within one Item to make this recipe. 
//			 return true;
//		 }
//		 return false;
		 return count;
	 }

}
