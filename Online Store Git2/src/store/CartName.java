

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class CartName extends Application{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}

	@Override
	public void start(Stage Run) throws Exception {
		// TODO Auto-generated method stub
		Run.setTitle("Cart: ");
		
		cartPane organizer = new cartPane();
		Scene scene = new Scene(organizer.getRoot());
		
		Run.setScene(scene);
		Run.show();
	}

}
