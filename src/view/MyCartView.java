package view;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import executable.RunnableFile;

public class MyCartView extends JPanel implements ActionListener{
	public static MyCartWestView westView;
	public MyCartView() throws Exception {
		setLayout(new BorderLayout());
		JLabel cartTitle = new JLabel("My Cart", SwingConstants.CENTER);
		cartTitle.setFont(new Font("Arial", Font.BOLD, 40));
		add(cartTitle, BorderLayout.NORTH);
		// add myCartWestView
		westView = new MyCartWestView(RunnableFile.myCart.getFood());
		add(westView, BorderLayout.WEST);
		//add east view:
		MyCartEastView eastView = new MyCartEastView(GroceryOrderView.arrayOfRecipes, RunnableFile.myCart.getFood());
		add(eastView, BorderLayout.EAST);

}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
