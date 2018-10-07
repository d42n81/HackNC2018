package model;

import java.awt.Image;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;

public class Item {
	Image image = null; 
	int id;
	String name;
	String description;
	
	public Item (String name, String bio, int id, String url) throws IOException {
		this.name = name;
		this.id = id;
		this.description = bio;
		image = ImageIO.read(new URL(url));
	}
	
	
	
	public int getId() {
		return id;
	}
	public String getname() {
		return name;
	}
	



	public Image getImage() {
		return image;
	}

	public void setImage(Image image) {
		this.image = image;
	}

	public String getDescription() {
		// TODO Auto-generated method stub
		return this.description;
	}
}
