import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import javafx.application.Application;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import javafx.util.Duration;

public class MainRunner extends Application {

	private static final String FILENAME = "storeJSON";
	private static final int WIDTH = 1600;
	private static final int HEIGHT = 800;

	protected ArrayList<Department> deps = loadDepartments(FILENAME);
	protected ArrayList<Product> cart = new ArrayList<Product>();

	static Scene homeScene;
	static Scene cartScene;
	static Scene checkoutScene;
	static Stage mainStage;

	// COLORS:
	// Tan(Bisque): #FFE4C4
	// Dark Brown: #362204
	// Money Green: #85bb65

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		loadDepartments(FILENAME);
		
		MediaPlayer play = new MediaPlayer(new Media(new File("Tetris.mp3").toURI().toString()));
		
		mainStage = stage;
		
		HomePagePO homepage = new HomePagePO();
		cartPane cartpane = new cartPane(cart);
		Checkout checkout = new Checkout();
		
		homeScene = new Scene(homepage.getRoot(), WIDTH, HEIGHT);
		cartScene = new Scene(cartpane.getRoot(), WIDTH, HEIGHT);
		checkoutScene = new Scene(checkout.getRoot(), WIDTH, HEIGHT);
		
		mainStage.setTitle("https://LetsGetThisBread.com");
		mainStage.setMaximized(true);
		mainStage.setScene(homeScene);
		mainStage.show();
		play.setOnEndOfMedia(new Runnable() {
	        @Override
	        public void run() {
	            play.seek(Duration.ZERO);
	            play.play();
	        }
	    });
		play.play();
	}

	private ArrayList<Department> loadDepartments(String fileName) {
		ArrayList<Department> loading = new ArrayList<Department>();
		try {
			Scanner scan = new Scanner(new File(fileName));
			String jsonIn = "";
			while (scan.hasNextLine()) {
				jsonIn += scan.nextLine();
			}
			scan.close();

			JSONObject mainObject = new JSONObject(jsonIn);
			JSONArray departments = mainObject.getJSONArray("departments");

			for (int i = 0; i < departments.length(); i++) {
				Department dep = new Department(departments.getJSONObject(i).getString("name"));
				ArrayList<Product> depProd = new ArrayList<Product>();
				JSONArray products = departments.getJSONObject(i).getJSONArray("products");
				for (int j = 0; j < products.length(); j++) {
					String name = products.getJSONObject(j).getString("name");
					Double cost = products.getJSONObject(j).getDouble("cost");
					String desc = products.getJSONObject(j).getString("description");
					String url = products.getJSONObject(j).getString("imageURL");
					Product tempProd = new Product(url, name, cost, desc);
					depProd.add(tempProd);
				}
				dep.setProducts(depProd);
				loading.add(dep);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return loading;
	}

	public void toHome() {
		mainStage.setScene(homeScene);
	}

	public void toCart() {
		mainStage.setScene(cartScene);
	}

	public void toCheckout() {
		mainStage.setScene(checkoutScene);
	}

	public void toDepartment(String string) {
		for (Department dep : deps) {
			if (dep.getName().equals(string))
				mainStage.setScene(new Scene(new DepartmentPO(dep).getRoot()));
		}
	}

	public static void defaultCursor() {
		mainStage.getScene().setCursor(Cursor.DEFAULT);
	}

	public static void clickCursor() {
		mainStage.getScene().setCursor(Cursor.HAND);
	}

	public static void toProduct(Product product) {
		mainStage.setScene(new Scene(new ProductPageOrganizer(product).getRoot()));
	}
}
