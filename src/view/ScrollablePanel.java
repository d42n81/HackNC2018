package view;

import java.awt.ScrollPane;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class ScrollablePanel extends ScrollPane {
	public ScrollablePanel(GroceryOrderView view) {
		add(new JScrollPane(view));
	}

	public ScrollablePanel(MyCartView myCartView) {
		// TODO Auto-generated constructor stub
		add(new JScrollPane(myCartView));
	}

}
