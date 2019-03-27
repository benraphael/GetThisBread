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

	private static final String FILENAME = "";
	
	private ArrayList<Department> deps;
	
	public static void main(String[] args) {
		launch(args);
	}

	static Scene scene;
	@Override
	public void start(Stage stage) throws Exception {
		deps = new ArrayList<Department>();
//		loadDepartments(FILENAME);
		stage.setTitle("https://LetsGetThisBread.com");
		HomePagePO organizer = new HomePagePO();
		scene = new Scene(organizer.getRoot(), 1600, 800);
		stage.setMaximized(true);
		stage.setScene(scene);
		stage.show();
	}
	
	private void loadDepartments(String fileName) {
		try {
			Scanner scan = new Scanner(new File(fileName));
			String jsonIn = "";
			while (scan.hasNextLine()) {
				jsonIn += scan.nextLine();
			}
			scan.close();
			
			JSONObject mainObject = new JSONObject(jsonIn);
			JSONArray departments = mainObject.getJSONArray("departments");
			
			for (int i=0;i<departments.length();i++) {
				Department dep = new Department(departments.getJSONObject(i).getString("name"));
				ArrayList<Product> depProd = new ArrayList<Product>();
				JSONArray products  = departments.getJSONObject(i).getJSONArray("products");
				for (int j=0;j<products.length();j++) {
					String name = products.getJSONObject(j).getString("name");
					Double cost = products.getJSONObject(j).getDouble("cost");
					String desc = products.getJSONObject(j).getString("description");
					String url = products.getJSONObject(j).getString("imageURL");
					Product tempProd = new Product(url, name, cost, desc);
					depProd.add(tempProd);
				}
				dep.setProducts(depProd);
				deps.add(dep);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (JSONException e) {
			e.printStackTrace();
		}
	}

	public static void defaultCursor() {
		 scene.setCursor(Cursor.DEFAULT);
		
	}
	public static void clickCursor() {
		 scene.setCursor(Cursor.HAND);
		
	}
}
