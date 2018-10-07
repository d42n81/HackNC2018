package view;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class BannerObject extends JPanel implements ActionListener{
	public static JButton cartButton;
	public BannerObject() {
		setLayout(new FlowLayout());
		// Initialize home button.
		JButton homeButton = new JButton("Home");
		homeButton.setPreferredSize(new Dimension(450, 150));
		homeButton.setFont(new Font("Arial", Font.PLAIN, 60));
		//Add Home button to the layout as the leftmost item.
		add(homeButton);
		// Initialize account Button:
		JButton accountButton = new JButton("Account");
		accountButton.setPreferredSize(new Dimension(450, 150));
		accountButton.setFont(new Font("Arial", Font.PLAIN, 60));
		// add account button to view.
		add(accountButton);
		//Initialize SuggestRecipe Button:
		JButton suggestRecipeButton = new JButton("Suggest Recipe");
		suggestRecipeButton.setPreferredSize(new Dimension(450, 150));
		suggestRecipeButton.setFont(new Font("Arial", Font.PLAIN, 50));
		// add button to the view.
		add(suggestRecipeButton);
		//Initialize Cart Button:
		cartButton = new JButton("Cart (Empty)");
		cartButton.setPreferredSize(new Dimension(450, 150));
		cartButton.setFont(new Font("Arial", Font.PLAIN, 60));
		// set Cart Button's on click to display new Cart Window.
		cartButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					CartView myCartView = new CartView();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			
		});
		//add button to cart
		add(cartButton);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
