package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import executable.RunnableFile;
import model.Cart;
import model.Item;
import model.recipe;

public class MyCartEastView extends JPanel implements ActionListener {
	int countY = 0;
	recipe [] filteredArray = new recipe [2];
	public static List <recipe> perfectMatchArray = new ArrayList<recipe>();
//	recipe [] perfectMatchArray = new recipe [10];
	public static List <recipe> oneAwayMatchArray = new ArrayList<recipe>();
	public static List <recipe> twoAwayMatchArray = new ArrayList<recipe>();
//	recipe [] oneAwayMatchArray = new recipe [10];
//	recipe [] twoAwayMatchArray = new recipe [10];
	public MyCartEastView(recipe [] recipeArray, Item [] cartArray) {
		System.out.println("Creating East View.");
		setLayout(new GridBagLayout());
		setBorder(BorderFactory.createLineBorder(Color.black));
		// Filter recipe array by items in cart
		RunnableFile.getRecipes(RunnableFile.myCart.getFood(), GroceryOrderView.arrayOfRecipes);
		
//		filteredArray = RunnableFile.getRecipes(cartArray, recipeArray).clone();
//		System.out.println(filteredArray[0].getName());
		if(perfectMatchArray.size() > 0) {
			System.out.println("Printing from PerfectMatch Array.");
			for(int i = 0; i < perfectMatchArray.size(); i++) {
				// Handle Recipe Name:
				JLabel recipeName = new JLabel(perfectMatchArray.get(i).getName());
				recipeName.setFont(new Font("Arial", Font.BOLD, 30));
				
				JButton linkButton = new JButton("Click Here for the Recipe!");
				linkButton.setName("" + i);
				linkButton.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						if (((JButton) e.getSource()).getName() != null) {
							openWebPage(perfectMatchArray.get(Integer.parseInt(((JButton) e.getSource()).getName())).getLink());
						}
						
					}

				});
				
				//Make label with amount of items:
				JLabel amountOfItems = new JLabel("You have all the items needed to make this recipe!");
				amountOfItems.setFont(new Font("Arial", Font.BOLD, 20));
				// Make Empty Space;
				JLabel emptySpace = new JLabel();
				emptySpace.setPreferredSize(new Dimension(40,40));
				JLabel emptySpace1 = new JLabel();
				emptySpace1.setPreferredSize(new Dimension(40,40));
				JLabel emptySpace2 = new JLabel();
				emptySpace2.setPreferredSize(new Dimension(40,40));
				
//				JLabel test = new JLabel("Testing");
				// add constraints
				GridBagConstraints gbc = new GridBagConstraints();
				gbc.fill = GridBagConstraints.HORIZONTAL;
		        gbc.gridx = 0;
		        countY++;
		        gbc.gridy = countY;
		        gbc.gridwidth = 1;
		        add(emptySpace, gbc);
		        gbc.gridx++;
		        add(recipeName, gbc);
		        gbc.gridx++;
		        add(emptySpace1,gbc);
		        gbc.gridx++;
		        add(linkButton, gbc);
		        gbc.gridx++;
		        add(emptySpace2, gbc);
		        gbc.gridx++;
		        add(amountOfItems, gbc);
		       
				

			}
		}
		if (oneAwayMatchArray.size() > 0) {
			System.out.println("Printing from OneAway Array.");
			for(int i = 0; i < oneAwayMatchArray.size(); i++) {
				// Handle Recipe Name:
				JLabel recipeName = new JLabel(oneAwayMatchArray.get(i).getName());
				recipeName.setFont(new Font("Arial", Font.BOLD, 30));
				
				JButton linkButton = new JButton("Recipe Link!");
				linkButton.setName("" + i);
				linkButton.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						if (((JButton) e.getSource()).getName() != null) {
							openWebPage(oneAwayMatchArray.get(Integer.parseInt(((JButton) e.getSource()).getName())).getLink());
						}
						
					}

				});
				//Make JLabel for amount of items:
				JLabel amountOfItems = new JLabel("You Have All but One Item Needed to Make this Recipe."
						+ "Would You Like to Add this Item to Your Cart?");
				
				// Make a Button to add the items.
				JButton buttonToAddItems = new JButton("Add Item to Cart!");
				buttonToAddItems.setName(recipeArray[i].getName());
				buttonToAddItems.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						//call upsell and refresh cart.
						String buttonName = ((JButton) e.getSource()).getName();
						recipe tempRecipe = getRecipeFromName(recipeArray, buttonName);
						System.out.println(buttonName);
						upSell(cartArray, tempRecipe);
						// Make new Window:
//						MyCartView.westView.repaint();
//						MyCartView.westView.revalidate();
						try {
							CartView myCartView = new CartView();
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
						
					}
					
				});
				
				// Make Empty Space;
				JLabel emptySpace = new JLabel();
				emptySpace.setPreferredSize(new Dimension(40,40));
				JLabel emptySpace1 = new JLabel();
				emptySpace1.setPreferredSize(new Dimension(40,40));
				JLabel emptySpace2 = new JLabel();
				emptySpace2.setPreferredSize(new Dimension(40,40));
				
//				JLabel test = new JLabel("Testing");
				// add constraints
				GridBagConstraints gbc = new GridBagConstraints();
				gbc.fill = GridBagConstraints.HORIZONTAL;
		        gbc.gridx = 0;
		        countY++;
		        gbc.gridy = countY;
		        gbc.gridwidth = 1;
		        add(emptySpace, gbc);
		        gbc.gridx++;
		        add(recipeName, gbc);
		        gbc.gridx++;
		        add(emptySpace1,gbc);
		        gbc.gridx++;
		        add(linkButton, gbc);
		        gbc.gridx++;
		        add(emptySpace2, gbc);
		        gbc.gridx++;
		        add(amountOfItems, gbc);
		        gbc.gridx++;
		        add(buttonToAddItems, gbc);
		       
				

			}
		}
		
		if (twoAwayMatchArray.size() > 0) {
			System.out.println("Printing from TwoAway Array.");
			for(int i = 0; i < twoAwayMatchArray.size(); i++) {
				// Handle Recipe Name:
				JLabel recipeName = new JLabel(twoAwayMatchArray.get(i).getName());
				recipeName.setFont(new Font("Arial", Font.BOLD, 30));
				
				JButton linkButton = new JButton("Recipe Link!");
				linkButton.setName("" + i);
				linkButton.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						if (((JButton) e.getSource()).getName() != null) {
							openWebPage(twoAwayMatchArray.get(Integer.parseInt(((JButton) e.getSource()).getName())).getLink());
						}
						
					}

				});
				//Make JLabel for amount of items:
				JLabel amountOfItems = new JLabel("You Have All but Two Items Needed to Make this Recipe.");
				
				// Make a Button to add the items.
				JButton buttonToAddItems = new JButton("Add Item to Cart!");
				buttonToAddItems.setName(recipeArray[i].getName());
				buttonToAddItems.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						//call upsell and refresh cart.
						String buttonName = ((JButton) e.getSource()).getName();
						recipe tempRecipe = getRecipeFromName(recipeArray, buttonName);
						System.out.println(buttonName);
						upSell(cartArray, tempRecipe);
						// Make new Window:
//						MyCartView.westView.repaint();
//						MyCartView.westView.revalidate();
						try {
							CartView myCartView = new CartView();
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}

					}
					
				});
				
				// Make Empty Space;
				JLabel emptySpace = new JLabel();
				emptySpace.setPreferredSize(new Dimension(40,40));
				JLabel emptySpace1 = new JLabel();
				emptySpace1.setPreferredSize(new Dimension(40,40));
				JLabel emptySpace2 = new JLabel();
				emptySpace2.setPreferredSize(new Dimension(40,40));
				
//				JLabel test = new JLabel("Testing");
				// add constraints
				GridBagConstraints gbc = new GridBagConstraints();
				gbc.fill = GridBagConstraints.HORIZONTAL;
		        gbc.gridx = 0;
		        countY++;
		        gbc.gridy = countY;
		        gbc.gridwidth = 1;
		        add(emptySpace, gbc);
		        gbc.gridx++;
		        add(recipeName, gbc);
		        gbc.gridx++;
		        add(emptySpace1,gbc);
		        gbc.gridx++;
		        add(linkButton, gbc);
		        gbc.gridx++;
		        add(emptySpace2, gbc);
		        gbc.gridx++;
		        add(amountOfItems, gbc);
		        gbc.gridx++;
		        add(buttonToAddItems, gbc);
		       
				

			}
		}
		
		
		
	}
	
	public static recipe getRecipeFromName(recipe[] recipeData, String name) {
		 recipe result = null;
		 for (int i=0; i< recipeData.length; i++) {
			 if(name.equals(recipeData[i].name)) {
				 result = recipeData[i];
			 }
		 }
		 return result;
	 }


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	public static void upSell(Item[] items, recipe recipe) {
		 //List<Item> matches = new ArrayList<Item>();
		 for (int i =0; i< recipe.foods.length; i++) {
			 Item [] myTempCart = RunnableFile.myCart.getFood();
			 if(!Cart.Contains(myTempCart, recipe.foods[i])){
				 System.out.println(recipe.foods[i].getname());
				 RunnableFile.myCart.add(recipe.foods[i], 1);
			 }
		 }
	 }

	public void openWebPage(String url) {
		   try {         
		     java.awt.Desktop.getDesktop().browse(java.net.URI.create(url));
		   }
		   catch (java.io.IOException e) {
		       System.out.println(e.getMessage());
		   }
		}

}
