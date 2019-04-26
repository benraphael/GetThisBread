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
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaPlayer.Status;
import javafx.stage.Stage;
import javafx.util.Duration;

public class MainRunner extends Application {

	private static final String[] SONGNAMES = { "TrophyGallery.mp3", "WiiShopJazz.mp3", "WiiShopJM.mp3",
			"PeaceAndTranquility.mp3" };
	private static final String FILENAME = "storeJSON";
	private static final int WIDTH = 1600;
	private static final int HEIGHT = 800;

	protected static MediaPlayer[] play = new MediaPlayer[SONGNAMES.length];
	protected static MediaPlayer currentSong;
	protected static ArrayList<Department> deps = loadDepartments(FILENAME);
	protected static ArrayList<Product> cart = new ArrayList<Product>();

	private static Scene homeScene;
	private static Scene cartScene;
	private static Scene checkoutScene;
	private static Stage mainStage;

	// COLORS:
	// Tan(Bisque): #FFE4C4
	// Dark Brown: #362204
	// Money Green: #85bb65

	public static void main(String[] args) {
		for (int i = 0; i < play.length; i++) {
			play[i] = new MediaPlayer(new Media(new File("Music\\" + SONGNAMES[i]).toURI().toString()));
			play[i].setVolume(.5);
			if (SONGNAMES[i].equals("Oblivion.mp3")) {
				play[i].setStopTime(Duration.minutes(1));
				play[i].setStartTime(Duration.seconds(20));
			}
		}
		for (MediaPlayer media : play) {
			media.setOnEndOfMedia(new Runnable() {
				@Override
				public void run() {
					for (MediaPlayer media : play) {
						media.seek(media.getStartTime());
						media.stop();
					}
					currentSong = play[(int) (Math.random() * play.length)];
					currentSong.play();
				}
			});
		}
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		currentSong = play[(int) (Math.random() * play.length)];
		currentSong.play();

		mainStage = stage;

		HomePagePO homepage = new HomePagePO();
		CartPane cartpane = new CartPane();
		Checkout checkout = new Checkout();

		homeScene = new Scene(homepage.getRoot(), WIDTH, HEIGHT);
		cartScene = new Scene(cartpane.getRoot(), WIDTH, HEIGHT);
		checkoutScene = new Scene(checkout.getRoot(), WIDTH, HEIGHT);

		cartScene.getStylesheets().add("tablecss.css");
		checkoutScene.getStylesheets().add("tablecss.css");

		mainStage.setTitle("https://LetsGetThisBread.com");
		mainStage.getIcons().add(new Image("https://i.imgur.com/OVWPlbB.png", 100, 100, true, true));
		mainStage.setMaximized(true);
		mainStage.setScene(homeScene);
		mainStage.show();

		Alert alert = new Alert(AlertType.NONE,
				"Press the N key to get a new random song and press the M key to mute/pause the current song",
				ButtonType.OK);
		alert.showAndWait();

		if (alert.getResult() == ButtonType.OK) {
			alert.close();
		}
	}

	private static ArrayList<Department> loadDepartments(String fileName) {
		System.out.println("Loading....");
		long startTime = System.currentTimeMillis();
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
		System.out.println("Loaded in " + (System.currentTimeMillis() - startTime) + " ms");
		return loading;
	}

	public void mute(boolean mute) {
		if (mute) {
			currentSong.pause();
		} else {
			currentSong.play();
		}
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
				mainStage.setScene(new Scene(new DepartmentPO(dep).getRoot(), WIDTH, HEIGHT));
		}
	}

	public static void toProduct(Product product) {
		mainStage.setScene(new Scene(new ProductPageOrganizer(product).getRoot(), WIDTH, HEIGHT));
	}

	public static void defaultCursor() {
		mainStage.getScene().setCursor(Cursor.DEFAULT);
	}

	public static void clickCursor() {
		mainStage.getScene().setCursor(Cursor.HAND);
	}
}
