
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Editor extends Application {

	static Stage main;
	static Scene editor; // main scene for the editor
	static Scene addProduct, removeProduct, addDepartment, removeDepartment; // scene for adding/removing departments/products
	BorderPane root;
	static Button save, exit;
	static Button addProd, subProd, addDep, subDep;
	static Button addNewProduct, addNewDepartment, subNewD, subNewP;
	static JSONObject edits; // = new JSONObject(new File("storeJSON")); //Original JSON
	static JSONArray deps;
	static TextField addName, addCost, addDes, addImg;
	static TextField addNewDep;
	static ToggleGroup operator;
	static ArrayList<String> removeDepartments;
	static ArrayList<Product> removeProducts;

	public static void main(String[] args) {
		launch(args);
	}

	private void createEditor() {
		// Bottom of editor, save and exit buttons
		HBox bottom = new HBox();
		bottom.setAlignment(Pos.CENTER);
		bottom.setSpacing(10);
		save = new Button("Save"); // save button
		exit = new Button("Exit"); // exit button
		bottom.getChildren().addAll(save, exit);

		// middle of editor, add and remove products
		HBox center = new HBox();
		center.setAlignment(Pos.CENTER);
		center.setSpacing(10);
		Label product = new Label("Products");
		addProd = new Button("+"); // button 4 adding products
		subProd = new Button("-"); // button 4 removing products
		center.getChildren().addAll(product, addProd, subProd);

		// top of editor, add and remove departments
		HBox top = new HBox();
		top.setAlignment(Pos.CENTER);
		top.setSpacing(10);
		Label department = new Label("Departments");
		addDep = new Button("+"); // button 4 adding departments
		subDep = new Button("-"); // button 4 removing departments
		top.getChildren().addAll(department, addDep, subDep);

		root.setTop(top);
		root.setCenter(center);
		root.setBottom(bottom);

		// Commands for buttons
		save.setOnAction(event -> buttonPressed(event)); // Rewrites the old JSON File w/ the new stuff
		exit.setOnAction(event -> buttonPressed(event)); // exits the editor
		addProd.setOnAction(event -> buttonPressed(event)); // Adds products, must choose a department first
		subProd.setOnAction(event -> buttonPressed(event)); // Removes products, must select a department and what
															// product to remove from said department
		addDep.setOnAction(event -> buttonPressed(event)); // Adds departments
		subDep.setOnAction(event -> buttonPressed(event)); // Removes departments, along w/ the products
	}

	private static void buttonPressed(ActionEvent event) {
		if (event.getSource() == save) { // save
			// Add code later when JSON file is finished, adding the changes to the
			// JSONObject edits
			BufferedWriter bw;
			try {
				bw = new BufferedWriter(new FileWriter("storeJSON"));
				bw.write(edits.toString());
				bw.close();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		if (event.getSource() == exit) { // exit
			Platform.exit();
		}
		if (event.getSource() == addProd) {
			main.setScene(addProduct);
		}
		if (event.getSource() == subProd && !(deps.length() == 0)) {
			main.setScene(removeProduct);
		}
		if (event.getSource() == addDep) {
			main.setScene(addDepartment);
		}
		if (event.getSource() == subDep && !(deps.length() == 0)) {
			main.setScene(removeDepartment);
		}
	}

	private static void addPros() { // Creates a scene for adding products
		VBox newPro = new VBox();
		newPro.setAlignment(Pos.CENTER);
		newPro.setSpacing(10);

		// Department selection
		HBox depList = new HBox();
		depList.setAlignment(Pos.CENTER);
		operator = new ToggleGroup();
		for (int i = 0; i < deps.length(); i++) {
			RadioButton button;
			try {
				button = new RadioButton(deps.getJSONObject(i).getString("name"));
				button.setToggleGroup(operator);
				if (i == 0)
					button.setSelected(true);
				depList.getChildren().add(button);
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		// Product name
		HBox proName = new HBox();
		proName.setAlignment(Pos.CENTER);
		proName.setSpacing(5);
		Label name = new Label("Name: ");
		addName = new TextField("");
		proName.getChildren().addAll(name, addName);

		// Product Cost
		HBox proCost = new HBox();
		proCost.setAlignment(Pos.CENTER);
		proCost.setSpacing(5);
		Label cost = new Label("Cost: ");
		addCost = new TextField("");
		proCost.getChildren().addAll(cost, addCost);

		// Product Description
		HBox proDes = new HBox();
		proDes.setAlignment(Pos.CENTER);
		proDes.setSpacing(5);
		Label des1 = new Label("Description: ");
		addDes = new TextField("");
		proDes.getChildren().addAll(des1, addDes);

		// Image URL
		HBox proImg = new HBox();
		proImg.setAlignment(Pos.CENTER);
		proImg.setSpacing(5);
		Label img = new Label("Image URL: ");
		addImg = new TextField("");
		proImg.getChildren().addAll(img, addImg);

		Button preview = new Button("Preview");
		preview.setOnAction(event -> {
			ImageView test = new ImageView(new Image(addImg.getText()));
			test.setPreserveRatio(true);
			test.setFitWidth(200);
			Alert alert = new Alert(AlertType.CONFIRMATION, "Check if the image URL is valid.", ButtonType.OK);
			alert.initOwner(proImg.getScene().getWindow());
			alert.setGraphic(test);
			alert.showAndWait();

			if (alert.getResult() == ButtonType.OK) {
				alert.close();
			}
		});

		// This button adds to the JSON when pressed
		addNewProduct = new Button("Add");

		newPro.getChildren().addAll(depList, proName, proCost, proDes, proImg, addNewProduct, preview);
		addProduct = new Scene(newPro);

		addNewProduct.setOnAction(event -> addPros2());

	}

	/**
	 * 
	 */
	private static void addPros2() {
		String added = "{"; // String that will be added to JSON
		added += "\"name\":\"" + addName.getText() + "\",";
		added += "\"cost\":\"" + Double.parseDouble(addCost.getText()) + "\",";
		added += "\"description\":\"" + addDes.getText() + "\",";
		added += "\"imageURL\":\"" + addImg.getText() + "\"},";
		RadioButton button2 = (RadioButton) operator.getSelectedToggle();
		// System.out.println(button.getText()); //test
		String old = edits.toString();
		String newStuff = old.substring(0, old.indexOf(button2.getText()) + button2.getText().length() + 14);
		String oldStuff = old.substring(old.indexOf(button2.getText()) + button2.getText().length() + 14);
		old = newStuff + added + oldStuff;
		// System.out.println(newStuff);
		// System.out.println(old); //test
		try {
			edits = new JSONObject(old);
		} catch (JSONException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			deps = edits.getJSONArray("departments");

		} catch (JSONException e) {
			System.out.println("E");
			e.printStackTrace();
		}
		subPros();
		addName.setText("");
		addCost.setText("");
		addDes.setText("");
		addImg.setText("");
		main.setScene(editor);
		// System.out.println(edits); //test
	}

	private static void subPros() {
		removeProducts = new ArrayList<Product>();
		VBox idk = new VBox(0);
		idk.setAlignment(Pos.CENTER);
		idk.setSpacing(10);
		Label select = new Label("Select products from a departments to remove: ");
		HBox depList = new HBox();
		depList.setAlignment(Pos.CENTER);
		depList.setSpacing(10);
		for (int i = 0; i < deps.length(); i++) {
			Label button;
			try {
				VBox vbox = new VBox();
				vbox.setAlignment(Pos.CENTER);
				vbox.setSpacing(5);
				button = new Label(deps.getJSONObject(i).getString("name"));
				vbox.getChildren().add(button);
				for (int j = 0; j < deps.getJSONObject(i).getJSONArray("products").length(); j++) {
					int k = i;
					int x = j;
					CheckBox button2 = new CheckBox(
							deps.getJSONObject(i).getJSONArray("products").getJSONObject(j).getString("name"));
					vbox.getChildren().add(button2);
					button2.setOnAction(event -> subPros2(event, k, x));
				}
				depList.getChildren().add(vbox);
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		subNewP = new Button("Remove");

		idk.getChildren().addAll(select, depList, subNewP);
		removeProduct = new Scene(idk);

		subNewP.setOnAction(event -> subPros2(event, 0, 0));
	}

	@SuppressWarnings("unlikely-arg-type")
	private static void subPros2(ActionEvent event, int i, int j) {
		if (event.getSource() == subNewP) {
			String old = "";
			for (int k = 0; k < removeProducts.size(); k++) { // Work on remove string
				String removed = "{";
				removed += "\"cost\":\"" + removeProducts.get(k).getCost() + "\",";
				removed += "\"imageURL\":\"" + removeProducts.get(k).getImageURL() + "\",";
				removed += "\"name\":\"" + removeProducts.get(k).getName() + "\",";
				removed += "\"description\":\"" + removeProducts.get(k).getDescription() + "\"}";
				// System.out.println(removed);
				if (k == 0)
					old = edits.toString();
				System.out.println(old);
				String newStuff = old.substring(0, old.indexOf(removed));
				String stuff = old.substring(old.indexOf(removed) + removed.length());
				if (stuff.indexOf(",") == 0)
					stuff = old.substring(old.indexOf(removed) + removed.length() + 1);
				// System.out.println(stuff);
				try {
					if (!stuff.contains("},") && edits.getJSONArray("departments").getJSONObject(i)
							.getJSONArray("products").length() == 0) {
						newStuff = old.substring(0, old.indexOf(removed) - 1);
					}
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				// System.out.println(newStuff);
				old = newStuff + stuff;
				// System.out.println(old); //test
			}
			try {
				edits = new JSONObject(old);
			} catch (JSONException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			try {
				deps = edits.getJSONArray("departments");

			} catch (JSONException e) {
				System.out.println("E");
				e.printStackTrace();
			}
			addPros();
			subPros();
			subDeps();
			main.setScene(editor);
		} else {
			CheckBox rem = (CheckBox) event.getSource();
			if (!removeProducts.contains(rem.getText()))
				try {
					removeProducts.add(new Product(
							deps.getJSONObject(i).getJSONArray("products").getJSONObject(j).getString("imageURL"),
							deps.getJSONObject(i).getJSONArray("products").getJSONObject(j).getString("name"),
							deps.getJSONObject(i).getJSONArray("products").getJSONObject(j).getDouble("cost"),
							deps.getJSONObject(i).getJSONArray("products").getJSONObject(j).getString("description")));
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
	}

	private void addDeps() {
		// Adding departments
		VBox newDep = new VBox();
		newDep.setAlignment(Pos.CENTER);
		newDep.setSpacing(10);

		Label dept = new Label("Department Name: ");
		addNewDep = new TextField();
		addNewDepartment = new Button("Add");
		newDep.getChildren().addAll(dept, addNewDep, addNewDepartment);
		addDepartment = new Scene(newDep);

		addNewDepartment.setOnAction(event -> addDeps2());
	}

	private void addDeps2() {
		String added = "{\"name\":\"" + addNewDep.getText() + "\",\"products\":[]},";
		String old = edits.toString();
		String newStuff = old.substring(0, old.indexOf("[") + 1);
		String oldStuff = old.substring(old.indexOf("[") + 1);
		old = newStuff + added + oldStuff;
		// System.out.println(old); //test
		try {
			edits = new JSONObject(old);
		} catch (JSONException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			deps = edits.getJSONArray("departments");

		} catch (JSONException e) {
			System.out.println("E");
			e.printStackTrace();
		}
		addPros();
		subPros();
		subDeps();
		addNewDep.setText("");
		main.setScene(editor);
	}

	private static void subDeps() {
		removeDepartments = new ArrayList<String>();
		VBox idk = new VBox(0);
		idk.setAlignment(Pos.CENTER);
		idk.setSpacing(5);

		Label select = new Label("Select departments to remove: ");
		HBox depList = new HBox();
		depList.setAlignment(Pos.CENTER);
		for (int i = 0; i < deps.length(); i++) {
			CheckBox button;
			try {
				button = new CheckBox(deps.getJSONObject(i).getString("name"));
				depList.getChildren().add(button);
				button.setOnAction(event -> subDeps2(event));
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		subNewD = new Button("Remove");

		idk.getChildren().addAll(select, depList, subNewD);
		removeDepartment = new Scene(idk);

		subNewD.setOnAction(event -> subDeps2(event));
	}

	private static void subDeps2(ActionEvent event) {

		if (event.getSource() == subNewD) {
			String old = "";
			for (int i = 0; i < removeDepartments.size(); i++) {
				// System.out.println(remDep);
				String removed = "{\"name\":\"" + removeDepartments.get(i) + "\",";
				// System.out.println(removed);
				if (i == 0)
					old = edits.toString();
				String newStuff = old.substring(0, old.indexOf(removed));
				// System.out.println(newStuff);
				String stuff = old.substring(old.indexOf(removed) + removed.length());
				// System.out.println(stuff);
				try {
					if (!stuff.contains("]},") && edits.getJSONArray("departments").length() == 0)
						newStuff = old.substring(0, old.indexOf(removed) - 1);
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				// System.out.println(newStuff);
				String oldStuff;
				if (stuff.contains("]},"))
					oldStuff = stuff.substring(stuff.indexOf("]},") + "123".length());
				else
					oldStuff = stuff.substring(stuff.indexOf("]}") + "12".length());
				// System.out.println(oldStuff);
				old = newStuff + oldStuff;
				// System.out.println(old); //test
			}
			try {
				edits = new JSONObject(old);
			} catch (JSONException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			try {
				deps = edits.getJSONArray("departments");

			} catch (JSONException e) {
				System.out.println("E");
				e.printStackTrace();
			}
			addPros();
			subPros();
			subDeps();
			main.setScene(editor);
		} else {
			CheckBox rem = (CheckBox) event.getSource();
			if (!removeDepartments.contains(rem.getText()))
				removeDepartments.add(rem.getText());
		}

	}

	@Override
	public void start(Stage stage) throws Exception {
		// TODO Auto-generated method stub
		root = new BorderPane();
		root.setPrefSize(150, 100);
		String jsonIn = "";
		Scanner scan = new Scanner(new File("storeJSON")); // Change string to whatever you are you using as the JSON
		while (scan.hasNextLine()) {
			jsonIn += scan.nextLine();
		}
		scan.close();
		edits = new JSONObject(jsonIn);
		try {
			deps = edits.getJSONArray("departments");

		} catch (JSONException e) {
			System.out.println("E");
			e.printStackTrace();
		}
		// System.out.println(edits); //Test
		createEditor(); // Creates all the buttons and such w/in the editor
		addPros(); // Creates a scene for adding products
		subPros(); // Creates a scene for removing products
		addDeps(); // Creates a scene for adding departments
		subDeps(); // Creates a scene for removing departments
		main = stage;
		editor = new Scene(root);
		main.setScene(editor);
		main.show();
	}
}