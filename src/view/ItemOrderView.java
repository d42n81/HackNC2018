package view;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import executable.RunnableFile;
import model.Cart;
import model.Item;

public class ItemOrderView extends JPanel implements ActionListener {
	
	Cart myCart;
	public ItemOrderView(Item [] itemArray) throws IOException {
		setLayout(new GridBagLayout());
		for(int i = 0; i < itemArray.length; i++) {
			
			//Handle Image CheckBox to Select:
			int idOfButton = itemArray[i].getId();
			JButton itemConfirmButton = new JButton("Add to Cart");
			itemConfirmButton.setName(String.valueOf(idOfButton));
			itemConfirmButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
//					System.out.println(((JButton) e.getSource()).getName());
					for(int i = 0; i < itemArray.length; i++) {
						String idAsString = (String) ((JButton) e.getSource()).getName();
						if (Integer.parseInt(idAsString) == itemArray[i].getId()) {
//							System.out.println(idAsString);
							RunnableFile.myCart.add(itemArray[i], 1);
							System.out.println(RunnableFile.myCart.getSize());
							BannerObject.cartButton.setText("Cart (" + RunnableFile.myCart.getSize() + ")");
						}
					}
					
				}

			});
			
			itemConfirmButton.setPreferredSize(new Dimension(200,100));
			itemConfirmButton.setFont(new Font("Arial", Font.BOLD, 30));
			// the way to determine if checkbox is selected is with checkBoxName.isSelected();
			
			// Handle Image Picture.
			JLabel imageLabel = new JLabel();
			Image imageTest = itemArray[i].getImage();
			int w = 100;
			int h = 100;
			BufferedImage resizedImg = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
		    Graphics2D g2 = resizedImg.createGraphics();

		    g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
		    g2.drawImage(imageTest, 0, 0, w, h, null);
		    g2.dispose();
			imageLabel.setIcon(new ImageIcon(resizedImg));
//			URL url = new URL("http://d28niecfu6trh0.cloudfront.net/34e44583d5e4f54c9f00d6529c70da83.jpg");
//			URL url = new URL("http://i.imgur.com/xiVXrCD.jpg");
//			URL url = new URL("https://upload.wikimedia.org/wikipedia/commons/thumb/f/f1/2ChocolateChipCookies.jpg/1200px-2ChocolateChipCookies.jpg");
//			Image imageTest = ImageIO.read(url);
//			imageLabel.setIcon(new ImageIcon(imageTest));
			
			// Add Image Description to label;
			JLabel itemDescription = new JLabel(itemArray[i].getDescription());
			itemDescription.setFont(new Font("Arial", Font.BOLD, 30));
			
			// Add Label to say Quantity:
			JLabel quantityLabel = new JLabel("<HTML><U>Quantity:</U></HTML>");
			quantityLabel.setPreferredSize(new Dimension(200,100));
			quantityLabel.setFont(new Font("Arial", Font.BOLD, 30));
			
			//Add Text Field to receive quantity.
			JLabel quantityTextField = new JLabel("1");
			quantityTextField.setName(String.valueOf(idOfButton));
			quantityTextField.setPreferredSize(new Dimension(200, 100));
			quantityTextField.setFont(new Font("Arial", Font.BOLD, 30));
			
			//Make empty JLabels for Space;
			JLabel emptySpace = new JLabel();
			emptySpace.setPreferredSize(new Dimension(40,40));
			JLabel emptySpace1 = new JLabel();
			emptySpace1.setPreferredSize(new Dimension(40,40));
			JLabel emptySpace2 = new JLabel();
			emptySpace2.setPreferredSize(new Dimension(40,40));
			JLabel emptySpace3 = new JLabel();
			emptySpace3.setPreferredSize(new Dimension(40,40));
			JLabel emptySpace4 = new JLabel();
			emptySpace4.setPreferredSize(new Dimension(40,40));
			JLabel emptySpace5 = new JLabel();
			emptySpace5.setPreferredSize(new Dimension(40,40));
			
			// Set JLabel Border Color and Size;
			
			GridBagConstraints gbc = new GridBagConstraints();
			gbc.fill = GridBagConstraints.HORIZONTAL;
	        gbc.gridx = 0;
	        gbc.gridy = i + 1;
	        gbc.gridwidth = 1;
	        add(emptySpace, gbc);
	        gbc.gridx++;
	        add(itemConfirmButton, gbc);
	        gbc.gridx++;
	        add(emptySpace1,gbc);
	        gbc.gridx++;
	        add(imageLabel,gbc);
	        gbc.gridx++;
	        add(emptySpace2,gbc);
	        gbc.gridx++;
	        add(itemDescription, gbc);
	        gbc.gridx++;
	        add(emptySpace3,gbc);
	        gbc.gridx++;
	        add(quantityLabel, gbc);
	        gbc.gridx++;
	        add(emptySpace4, gbc);
	        gbc.gridx++;
	        add(quantityTextField, gbc);
	        gbc.gridx++;
	        add(emptySpace5, gbc);
		}
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
