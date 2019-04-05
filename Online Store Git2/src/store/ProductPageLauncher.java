
import java.util.ArrayList;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * @author Ethan Jones
 * @date Mar 15, 2019
 * @file ProductPage.java
 * @timestamp 10:16:17 AM
 */
public class ProductPageLauncher extends Application {
	private Product product;
	private String[] sizes, colors;
	private ArrayList<Product> suggestedProducts;
	
//	public ProductPageLauncher(Product product, String[] sizes, String[] colors, ArrayList<Product> suggestedProducts) {
//		this.product = product;
//		this.colors = colors;
//		this.sizes = sizes;
//		this.suggestedProducts = suggestedProducts;
//	}

	@Override
	public void start(Stage stage) throws Exception {

		String[] sizes1 = { "Small", "Medium", "Large" };
		String[] colors1 = { "Red", "Blue", "Yellow", "Purple", "Green", "Black", "White", "Grey" };
		String[] sizes2 = { "Petite", "Curvy", "Thicc" };
		String[] colors2 = { "a", "b", "c" };
		
		ArrayList<Product> tempSuggestions = new ArrayList<Product>();

		Shirt testShirt = new Shirt("https://goo.gl/LuWtcv", "Anime Weeb T-shirt", sizes1, colors1, 14.99, "If you buy this you're a loser");

		Product recShirt1 = new Shirt("https://pbs.twimg.com/media/DEj0_L_UwAAEo5n.jpg",
				"Kawaii T-Shirt", sizes1, colors2, 19.99,
				"———————————————————————— AYAYA This website is now in CUTE mode AYAYA ————————————————————————" );
		
		Product recShirt2 = new Shirt("https://images.lookhuman.com/render/standard/0496005000292260/3600-athletic_gray-md-t-obama-confirmed-weeaboo.png",
				"Obama-Chan Hoodie", sizes2, colors1, 34.99,
				"The most kawaii president of the United States of America. Biden-kun try hard to get Congress-sama to go along with them! Uwaah~" );
		
		Product recShirt3 = new Shirt("https://images.sunfrogshirts.com/2017/11/24/29942-1511508907152-Gildan-Hoo-Black-_w92_-front.jpg",
				"Thicc Loli Hoodie", sizes2, colors2, 24.99,
				"Konichiwa Kripp-kun AYAYA . This is your kawaii kouhai Aya-chan, calling in from Nihon. "
				+ "I have noticed a severe lack of cute emotes in chat tonight, and instead all I see are "
				+ "baka dansgame and baka nammers. This is not very sugoi, and I would appreciate it if "
				+ "your chat showed more respect for Japanese culture by typing kawaii emotes like AYAYA and "
				+ "AstolfoSmile . Arigato gozaimasu <3" );
		
		Product recShirt4 = new Shirt("https://i.pinimg.com/originals/84/20/3f/84203f29a4e7493c0caec66385e4bafd.jpg",
				"Thicc Loli Hoodie", sizes2, colors1, 24.99,
				"Wanna see my Blue Eyes White Dragon? uwu");
		
		tempSuggestions.add(recShirt1);
		tempSuggestions.add(recShirt2);
		tempSuggestions.add(recShirt3);
		tempSuggestions.add(recShirt4);
		tempSuggestions.add(testShirt);


//		ProductPageOrganizer organizer = new ProductPageOrganizer(testShirt, stage, tempSuggestions);
//		Scene scene = new Scene(organizer.getRoot(), 700, 600);
//		stage.setScene(scene);
		stage.show();
		stage.setResizable(false);
	}

	public static void main(String[] args) {
		launch(args);
	}
}
