package view;

import java.awt.Color;
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

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import model.Item;

public class MyCartWestView extends JPanel implements ActionListener {
	public MyCartWestView(Item [] cartArray) {
		setLayout(new GridBagLayout());
		setBorder(BorderFactory.createLineBorder(Color.black));
		
		for (int i = 0; i < cartArray.length; i++) {
			// Handle Remove Button
			if (cartArray[i] != null) {
				int idOfButton = cartArray[i].getId();
				JButton itemRemoveButton = new JButton("Delete");
				itemRemoveButton.setName(String.valueOf(idOfButton));
				itemRemoveButton.setPreferredSize(new Dimension(200,100));
				itemRemoveButton.setFont(new Font("Arial", Font.BOLD, 30));
				
				// Handle Images
				JLabel imageLabel = new JLabel();
				Image imageTest = cartArray[i].getImage();
				int w = 100;
				int h = 100;
				BufferedImage resizedImg = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
			    Graphics2D g2 = resizedImg.createGraphics();

			    g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
			    g2.drawImage(imageTest, 0, 0, w, h, null);
			    g2.dispose();
				imageLabel.setIcon(new ImageIcon(resizedImg));
				
				
				// Handle Description
				JLabel itemDescription = new JLabel(cartArray[i].getDescription());
				itemDescription.setFont(new Font("Arial", Font.BOLD, 30));
				
				// Make Empty Space;
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
				
				// Put it all together into the layout.
				GridBagConstraints gbc = new GridBagConstraints();
				gbc.fill = GridBagConstraints.HORIZONTAL;
		        gbc.gridx = 0;
		        gbc.gridy = i + 1;
		        gbc.gridwidth = 1;
		        add(emptySpace, gbc);
		        gbc.gridx++;
		        add(itemRemoveButton, gbc);
		        gbc.gridx++;
		        add(emptySpace1,gbc);
		        gbc.gridx++;
		        add(imageLabel,gbc);
		        gbc.gridx++;
		        add(emptySpace2,gbc);
		        gbc.gridx++;
		        add(itemDescription, gbc);
		        gbc.gridx++;
			}
			
			

		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
