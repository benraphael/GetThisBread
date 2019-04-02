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
import javafx.stage.Stage;

public class MainRunner extends Application {

	private static final String FILENAME = "storeJSON";
	private static final int WIDTH = 1600;
	private static final int HEIGHT = 800;

	protected ArrayList<Department> deps = loadDepartments(FILENAME);

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
		mainStage = stage;
		System.out.println(deps.toString());
		mainStage.setTitle("https://LetsGetThisBread.com");
		HomePagePO homepage = new HomePagePO();
		cartPane cartpane = new cartPane();
		Checkout checkout = new Checkout();
		homeScene = new Scene(homepage.getRoot(), WIDTH, HEIGHT);
		cartScene = new Scene(cartpane.getRoot(), WIDTH, HEIGHT);
		checkoutScene = new Scene(checkout.getRoot(), WIDTH, HEIGHT);
		mainStage.setMaximized(true);
		mainStage.setScene(homeScene);
		mainStage.show();
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

	public static void defaultCursor() {
		mainStage.getScene().setCursor(Cursor.DEFAULT);
	}

	public static void clickCursor() {
		mainStage.getScene().setCursor(Cursor.HAND);
	}
}
