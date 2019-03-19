package onlineStore;

import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.input.KeyCombination;

public class MainMenu {

	private MenuBar menuBar;

	/**
	 * The MenuBar used for each page. Menus can be added here based on what we need
	 * and can be programmed to change scenes or on the editor, etc. In each scene
	 * class, this should be added using the code:
	 * 
	 * @category borderPaneName.setTop(new MainMenu().getRoot());
	 */
	public MainMenu() {
		menuBar = new MenuBar();
		createMenu();
	}

	private void createMenu() {
		//TODO All of this is test code experimenting with how to use menus and is liable to change
		Menu options = new Menu("Options");
		Menu test = new Menu("Test");
		Menu checkoutMenu = new Menu();
		Label checkout = new Label("Checkout");

		checkoutMenu.setGraphic(checkout);

		MenuItem home = new MenuItem("Home");
		MenuItem save = new MenuItem("Save");

		home.setOnAction(event -> System.out.println(home.getText()));
		save.setOnAction(event -> System.out.println(save.getText()));
		checkout.setOnMouseClicked(event -> System.out.println(checkout.getText()));

		home.setAccelerator(KeyCombination.keyCombination("Ctrl+H"));
		save.setAccelerator(KeyCombination.keyCombination("Ctrl+S"));

		test.getItems().addAll(home, save);

		options.getItems().addAll(test);

		menuBar.getMenus().addAll(options, checkoutMenu);
	}

	public MenuBar getRoot() {
		return menuBar;
	}

}
