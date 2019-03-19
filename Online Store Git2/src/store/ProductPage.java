
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
/**
 * @author Ethan Jones
 * @date Mar 15, 2019
 * @file ProductPage.java
 * @timestamp 10:16:17 AM
 */
public class ProductPage extends Application {

	@Override
	public void start(Stage stage) throws Exception {
		
		String[] sizes = {"Small", "Medium", "Large"};
		String[] colors = {"Naruto Orange", "Deku Green", "Death the Kid Black"};
		
		
		Shirt testShirt = new Shirt("Anime Weeb Shit T-shirt", sizes, colors, 0.01, "If you buy this shit youre a fucking virgin");
		
		ProductPageOrganizer organizer = new ProductPageOrganizer(testShirt);
		Scene scene = new Scene(organizer.getRoot(),700,600);
		stage.setScene(scene);
		stage.show();
		stage.setResizable(false);
	}
	
	public static void main(String[] args) { launch(args);}
}
