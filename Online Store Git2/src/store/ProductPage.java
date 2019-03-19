
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ProductPage extends Application {

	@Override
	public void start(Stage stage) throws Exception {
		ProductPageOrganizer organizer = new ProductPageOrganizer();
		Scene scene = new Scene(organizer.getRoot(),700,600);
		stage.setScene(scene);
		stage.show();
		stage.setResizable(false);
	}
	
	public static void main(String[] args) { launch(args);}
}
