package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.JPanel;
import javax.swing.JTextField;

import model.Item;
import model.recipe;

public class GroceryOrderView extends JPanel implements ActionListener{
	Item [] arrayOfItems = new Item[35];
	public static recipe [] arrayOfRecipes = new recipe[5];

	public GroceryOrderView() throws Exception {
		setLayout(new BorderLayout());
		// North Should be Search Bar and Banner.
		// So we should make a new container with Grid Bag Layout.
		
		BannerObject banner = new BannerObject();
		JTextField searchBar = new JTextField(20);
		searchBar.setPreferredSize(new Dimension(100, 150));
		searchBar.setFont(new Font("Arial", Font.BOLD, 60));
		searchBar.setText("Search Here:");
		// implement search here later.
		Container northContainer = new Container(banner, searchBar);
		add(northContainer, BorderLayout.NORTH);
		
		// Now we need to work on the middle, the main checkbox system for selecting items.
		// make an item for testing
//		URL newURL = new URL("https://upload.wikimedia.org/wikipedia/commons/3/36/Milk_jug_upright.jpg");
		
		// Let's make several items. 

		Item milk = new Item("Milk", "Happy Farms Whole Mik", 100, "https://upload.wikimedia.org/wikipedia/commons/3/36/Milk_jug_upright.jpg" );
		Item eggs = new Item ("Eggs", "Happy Farms Dozen Jumbo White Eggs", 101, "https://upload.wikimedia.org/wikipedia/commons/thumb/1/12/6-Pack-Chicken-Eggs.jpg/330px-6-Pack-Chicken-Eggs.jpg");
		Item bacon = new Item ("Bacon", "Happy Farms 16oz Salted Bacon", 102, "https://upload.wikimedia.org/wikipedia/commons/thumb/3/31/Made20bacon.png/330px-Made20bacon.png");
		Item butter = new Item ("Butter", "4 sticks of I Can't Believe it IS Butter", 103, "https://upload.wikimedia.org/wikipedia/commons/d/d3/%C5%A0v%C3%A9dsk%C3%BD_kol%C3%A1%C4%8D_naruby_904_%28cropped%29.JPG");
		Item salt = new Item("Salt", "it's just salt", 104,  "https://upload.wikimedia.org/wikipedia/commons/thumb/0/07/Comparison_of_Table_Salt_with_Kitchen_Salt.png/1024px-Comparison_of_Table_Salt_with_Kitchen_Salt.png");
		Item chives = new Item("Chives", "Onion things", 105, "https://i5.walmartimages.ca/images/Large/164/795/6000197164795.jpg");
		Item sugar = new Item("Sugar","One LB Bag of Sugar", 106,"https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcR_AmGa3p8CmE7usYLmVHhE75SXec-2P36fffNnkrHdCNBP6xRp9w" );
		Item flour = new Item("Flour", "flour", 107,"https://upload.wikimedia.org/wikipedia/commons/6/64/All-Purpose_Flour_%284107895947%29.jpg");
		Item oliveOil = new Item("Olive Oil", "10 oz Light Olive Oil", 108, "https://upload.wikimedia.org/wikipedia/commons/thumb/0/0e/Oliven_V1.jpg/375px-Oliven_V1.jpg");
		Item instantYeast = new Item("Instant Yeast", "3 Count Box of Yeast", 109, "https://target.scene7.com/is/image/Target/GUEST_f28bea70-b3b0-4289-8506-f3deec8221c2?wid=1400");
		Item pizzaSauce= new Item("Pizza Sauce", "32 oz TagU Classic Tomato Sauce", 110, "https://food.fnr.sndimg.com/content/dam/images/food/fullset/2013/9/17/2/WU0603H_Pizza-Sauce_s4x3.jpg.rend.hgtvcom.616.462.suffix/1388509453738.jpeg");
		Item americanCheese = new Item("American Cheese", "12 Pack Sliced Yellow American Cheese", 111, "https://upload.wikimedia.org/wikipedia/commons/thumb/1/1c/Single_wrapped_slice_of_processed_cheese.jpg/374px-Single_wrapped_slice_of_processed_cheese.jpg");
		Item mozzarellaCheese = new Item("Mozzarella", "2 oz sliced mozzarella", 112, "https://upload.wikimedia.org/wikipedia/commons/thumb/5/57/Mozzarella_di_bufala3.jpg/330px-Mozzarella_di_bufala3.jpg"); 
		Item cocoaPowder = new Item("Cocoa Powder", "6 oz canister of TollMouse Cocoa Powder", 113, "https://upload.wikimedia.org/wikipedia/commons/thumb/f/f6/Dutch_process_and_natural_cocoa.jpg/300px-Dutch_process_and_natural_cocoa.jpg");
		Item bakingSoda = new Item ("Baking Soda", "4 oz container of Foot and Shovel Baking Soda", 114, "https://target.scene7.com/is/image/Target/GUEST_b7dd8c51-bb4c-4504-ba61-c88618d5d2a5?wid=1400");
		Item brownSugar = new Item ("Brown Sugar", "1lb container of Brown Sugar", 115, "https://upload.wikimedia.org/wikipedia/commons/thumb/3/35/Vollrohrzucker_braun.JPG/330px-Vollrohrzucker_braun.JPG");
		Item vanillaExtract = new Item("Vanilla Extract", "1.5oz bottle of Vanilla Extract", 116, "https://upload.wikimedia.org/wikipedia/commons/thumb/0/03/VanillaExtract.png/330px-VanillaExtract.png");
		Item buttermilk = new Item("Buttermilk", "1 Pint USA Buttermilk", 117, "https://upload.wikimedia.org/wikipedia/commons/thumb/2/23/Buttermilk-%28right%29-and-Milk-%28left%29.jpg/359px-Buttermilk-%28right%29-and-Milk-%28left%29.jpg");
		Item sourCream = new Item("Sour Cream", "1 Pint USA Sour Cream", 118, "https://images.heb.com/is/image/HEBGrocery/000314026");
		Item coffee = new Item("Coffee", "1 Pint Ground Columbian Coffee Beans", 119, "https://upload.wikimedia.org/wikipedia/commons/thumb/1/11/MODOGlendora.jpg/330px-MODOGlendora.jpg");
		Item heavyCream = new Item("Heavy Cream", "1 Quart Heavy Cream", 120, "http://garelickfarms.com/sites/default/files/styles/recipe_and_product_hero_600px_tall/public/product/hero/Heavy_cream_quart.png?itok=1UYMRVKD");
		Item chocolateChips = new Item("Chocolate Chips", "16.9 oz Chocolate Chips", 121, "https://upload.wikimedia.org/wikipedia/commons/thumb/9/96/Semi-sweet_chocolate_chips.jpg/1200px-Semi-sweet_chocolate_chips.jpg"); 
		Item lemonJuice = new Item("Lemon Juice", "Half Gallon of Sunkissed Lemon Juice", 122, "https://i5.walmartimages.com/asr/2340f906-ac9a-4331-bd60-c3e90066735f_1.0c4b1dc48769fecf4b54100ea87a49c7.jpeg?odnWidth=undefined&odnHeight=undefined&odnBg=ffffff");
		Item apples = new Item ("Apples", "Half-pound of Honey Crisp Apples", 123, "https://upload.wikimedia.org/wikipedia/commons/thumb/f/f4/Honeycrisp.jpg/330px-Honeycrisp.jpg");
		Item cinnamon = new Item("Cinnamon", "3 oz of Cinamon", 124, "https://upload.wikimedia.org/wikipedia/commons/thumb/d/de/Cinnamomum_verum_spices.jpg/330px-Cinnamomum_verum_spices.jpg");
		Item groundNutmeg = new Item("Ground Nutmeg", "1.5 oz Freshly Ground Nutmeg", 125, "https://target.scene7.com/is/image/Target/GUEST_da2bd602-8d61-4df0-aa62-80559ee401da?wid=1400");
		Item mayonaise = new Item("Mayonaise", "18 oz BelMan's Mayo", 126, "https://upload.wikimedia.org/wikipedia/en/1/16/Hellmans-Mayo-6836e.jpg");
		Item parmesan = new Item("Parmesan", "0.25lbs Shredded Parmesan Cheese", 127, "https://upload.wikimedia.org/wikipedia/commons/thumb/4/48/Parmigiano_Reggiano_meules_MIN_Rungis.jpg/330px-Parmigiano_Reggiano_meules_MIN_Rungis.jpg");
		Item vinegar = new Item("Vinegar", "1 Pint Vinegar", 128, "https://upload.wikimedia.org/wikipedia/commons/thumb/f/fb/Sherryvinegar.jpg/255px-Sherryvinegar.jpg");
		Item worcestershire = new Item("Worcestershire", "6 oz Grade A British Worcestershire", 129, "https://upload.wikimedia.org/wikipedia/commons/thumb/d/d9/Lea_%26_Perrins_worcestershire_sauce_150ml.jpg/330px-Lea_%26_Perrins_worcestershire_sauce_150ml.jpg");
		Item anchovies = new Item("Anchovies", "4 oz can Salted Anchovies", 130, "https://5.imimg.com/data5/GB/YA/MY-48283593/fresh-frozen-fish-500x500.jpg");
		Item garlic = new Item("Garlic", "Bushel of Garlic", 131, "https://upload.wikimedia.org/wikipedia/commons/thumb/3/3f/Italian_garlic_PDO.JPG/330px-Italian_garlic_PDO.JPG");
		Item blackPepper = new Item("Black pepper", "8 oz Ground Black Pepper", 132, "https://d2ln0cvn4pv5w2.cloudfront.net/unsafe/fit-in/512x400/filters:quality(100):max_bytes(200000):fill(white)/http://dcmzfk78s4reh.cloudfront.net/1455322250420.jpg");
		Item croutons = new Item("Croutons", "1/2 lb bag of Croutons", 133, "https://upload.wikimedia.org/wikipedia/commons/thumb/e/e3/Croutons_on_a_salad.jpg/375px-Croutons_on_a_salad.jpg");
		Item lettuce = new Item("Lettuce", "1 Head Lettuce", 134, "https://upload.wikimedia.org/wikipedia/commons/thumb/4/41/Romaine.jpg/255px-Romaine.jpg");
		
		Item[] omeleteStuff = {salt, chives,eggs, butter};
		recipe omelete = new recipe("Omelete", omeleteStuff, "https://www.foodnetwork.com/recipes/alton-brown/omelet-recipe-1914282");
		Item[] pizzaStuff = {sugar, salt, oliveOil, flour, instantYeast, pizzaSauce, mozzarellaCheese};
		recipe pizza = new recipe("Pizza", pizzaStuff, "https://www.foodnetwork.com/recipes/alton-brown/pizza-pizzas-recipe4-1951401");
		Item[] cakeStuff = {flour, cocoaPowder, bakingSoda, salt, butter, brownSugar, sugar, eggs, vanillaExtract, buttermilk, sourCream, coffee, chocolateChips, heavyCream};
		recipe cake = new recipe("Cake", cakeStuff, "https://www.foodnetwork.com/recipes/ina-garten/haydens-chocolate-cake-2179527");
		Item [] applePieStuff = {flour, sugar, salt, butter, eggs, lemonJuice, apples, cinnamon, groundNutmeg};
		recipe applePie = new recipe("Apple Pie", applePieStuff, "https://www.foodnetwork.com/recipes/food-network-kitchen/apple-pie-recipe-2011423");
		Item [] caesarSaladStuff = {mayonaise, buttermilk, sourCream, parmesan, vinegar, worcestershire, anchovies, garlic, blackPepper, croutons, oliveOil, lettuce};
		recipe caesarSalad = new recipe("Caesar Salad", caesarSaladStuff, "https://www.foodnetwork.com/recipes/ree-drummond/julius-caesar-salad-2316518");
		
		//add recipes to array of recipes:
		arrayOfRecipes[0] = omelete;
		arrayOfRecipes[1] = pizza;
		arrayOfRecipes[2] = cake;
		arrayOfRecipes[3] = applePie;
		arrayOfRecipes[4] = caesarSalad;
		// Now make an array of items.
		
		arrayOfItems[0] = milk;
		arrayOfItems[1] = eggs;
		arrayOfItems[2] = bacon;
		arrayOfItems[3] = butter;
		arrayOfItems[4] = salt;
		arrayOfItems[5] = chives;
		arrayOfItems[6] = sugar;
		arrayOfItems[7] = flour;
		arrayOfItems[8] = oliveOil;
		arrayOfItems[9] = instantYeast;
		arrayOfItems[10] = pizzaSauce;
		arrayOfItems[11] = americanCheese;
		arrayOfItems[12] = mozzarellaCheese;
		arrayOfItems[13] = cocoaPowder;
		arrayOfItems[14] = bakingSoda;
		arrayOfItems[15] = brownSugar;
		arrayOfItems[16] = vanillaExtract;
		arrayOfItems[17] = buttermilk;
		arrayOfItems[18] = sourCream;
		arrayOfItems[19] = coffee;
		arrayOfItems[20] = heavyCream;
		arrayOfItems[21] = chocolateChips;
		arrayOfItems[22] = lemonJuice;
		arrayOfItems[23] = apples;
		arrayOfItems[24] = cinnamon;
		arrayOfItems[25] = groundNutmeg;
		arrayOfItems[26] = mayonaise;
		arrayOfItems[27] = parmesan;
		arrayOfItems[28] = vinegar;
		arrayOfItems[29] = worcestershire;
		arrayOfItems[30] = anchovies;
		arrayOfItems[31] = garlic;
		arrayOfItems[32] = blackPepper;
		arrayOfItems[33] = croutons;
		arrayOfItems[34] = lettuce;
		//Now send array to ItemOrderView
		ItemOrderView itemOrder = new ItemOrderView(arrayOfItems);
		add(itemOrder, BorderLayout.WEST);
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
