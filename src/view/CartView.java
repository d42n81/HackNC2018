package view;

import javax.swing.JFrame;

public class CartView {

	public CartView() throws Exception {
		ScrollablePanel orderView = new ScrollablePanel(new MyCartView());
		
		
		JFrame main_frame = new JFrame();
		main_frame.setTitle("My Cart Example");
		main_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		main_frame.setContentPane(orderView);

		main_frame.pack();
		main_frame.setVisible(true);
	}
}
