package GUI;

import java.util.ArrayList;
import java.util.HashMap;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;

/**
 * @author Simon
 * 
 *         Design Pattern: Singleton
 * 
 *         Purpose: Allows to get rid of bugs caused by repetitively creating
 *         Game_Scene instance
 * 
 *         Description: The class for the Game_Scene GUI.
 */

public class Game_Scene extends Scene {

	private static Game_Scene game_scene_instance = null;

	// top components
	private static Label instruction_label_top;
	private static Label current_score_label_bottom;

	// bottom components
	private static Button back_button;
	private static Button go_button;

	// centre components
	private static ArrayList<Label> label_list = new ArrayList<>();
	private static ArrayList<ArrayList<Button>> button_matrix = new ArrayList<>();
	private static int grid_row_num = 6;
	private static int grid_column_num = 5;

	private static String button_style = "-fx-background-color:#d8b063; -fx-font-family:monospace; -fx-font-size:24; -fx-font-weight:lighter; -fx-font-style:italic; -fx-text-fill:#583c30;";
	private static String label_style = "-fx-font-size:16; -fx-text-fill:#583c30; -fx-text-alignment:center; -fx-wrap-text:true; -fx-font-style:italic; -fx-font-weight:bold;";

	public Game_Scene(Parent root, double width, double height) {
		super(root, width, height);
	}

	public Game_Scene(Parent root) {
		super(root);
	}

	/**
	 * Method that returns an instance of Game_Scene object
	 * 
	 * @return Game_Scene
	 */
	public static Game_Scene getInstance() {
		if (game_scene_instance == null) {

			BorderPane overall_layout = new BorderPane();

			// The top part of the scene
			back_button = new Button("Back");
			back_button.setLayoutX(25);
			back_button.setLayoutY(15);
			back_button.setPrefSize(100, 50);
			back_button.setStyle(button_style);

			instruction_label_top = new Label(
					"Please pick a value under any category to play with");
			instruction_label_top.setLayoutX(160);
			instruction_label_top.setLayoutY(20);
			instruction_label_top.setStyle(
					"-fx-font-size:24; -fx-text-fill:#583c30; -fx-text-alignment:center; -fx-wrap-text:true;");

			AnchorPane top_anchor_pane = new AnchorPane(back_button,
					instruction_label_top);
			top_anchor_pane.setPrefHeight(80);
			top_anchor_pane.setPrefWidth(600);

			// The bottom part of the scene
			go_button = new Button("GO");
			go_button.setLayoutX(635);
			go_button.setLayoutY(15);
			go_button.setPrefSize(120, 50);
			go_button.setStyle(button_style);
			
			// if want to have it back just remove this line
			go_button.setVisible(false);

			current_score_label_bottom = new Label("Current Score: 0");
			current_score_label_bottom.setLayoutX(20);
			current_score_label_bottom.setLayoutY(15);
			current_score_label_bottom.setStyle(
					"-fx-font-size:30; -fx-text-fill:#583c30; -fx-text-alignment:center; -fx-wrap-text:true; -fx-font-style:italic; -fx-font-weight:bold;");

			AnchorPane bottom_anchor_pane1 = new AnchorPane(
					current_score_label_bottom);
			bottom_anchor_pane1.setPrefHeight(80);
			bottom_anchor_pane1.setPrefWidth(300);

			AnchorPane bottom_anchor_pane2 = new AnchorPane(go_button);
			bottom_anchor_pane2.setPrefHeight(80);
			bottom_anchor_pane2.setPrefWidth(300);

			AnchorPane bottom_anchor_pane_total = new AnchorPane(
					bottom_anchor_pane1, bottom_anchor_pane2);

			// initialize all the radio buttons in the grid pane
			// i starts from row 1 because row 0 is for text_label
			GridPane middle_grid_pane = new GridPane();

			// initialize all the label for the category text
			for (int j = 0; j < grid_column_num; j++) {
				Label category_label = new Label("Famous People");
				category_label.setStyle(label_style);
				middle_grid_pane.add(category_label, j, 0);
				GridPane.setHalignment(category_label, HPos.CENTER);
				label_list.add(category_label);
			}

			for (int j = 0; j < grid_column_num; j++) {

				// button list for each category
				ArrayList<Button> button_list = new ArrayList<>();

				// go through all the values in this category and add them to
				// the button_list list

				for (int i = 1; i < grid_row_num; i++) {
					Button button = new Button("500");

					button.setPrefSize(100, 50);
					button.setStyle(button_style);

					middle_grid_pane.add(button, j, i);
					button_list.add(button);
				}

				// add it to button_matrix
				button_matrix.add(button_list);

			}

			middle_grid_pane.setAlignment(Pos.CENTER);

			middle_grid_pane.setVgap(30);
			middle_grid_pane.setHgap(40);

			overall_layout.setTop(top_anchor_pane);
			overall_layout.setCenter(middle_grid_pane);
			overall_layout.setBottom(bottom_anchor_pane_total);
			overall_layout.setStyle("-fx-background-color:#f0ecc4");

			game_scene_instance = new Game_Scene(overall_layout,
					GUI_Manager.WINDOW_WIDTH, GUI_Manager.WINDOW_HEIGHT);
		}

		return game_scene_instance;
	}

	public Button get_back_button() {
		return back_button;
	}

	public Button get_go_button() {
		return go_button;
	}

	/**
	 * Returns the list(matrix) contains all the lists of buttons
	 * 
	 * @return button_matrix
	 */
	public ArrayList<ArrayList<Button>> get_button_matrix() {
		return button_matrix;
	}

	/**
	 * Returns the list contains all the labels of category text
	 * 
	 * @return label_list
	 */
	public ArrayList<Label> get_label_list() {
		return label_list;
	}

	/**
	 * Returns a button with the wanted category and value. Useful assigning the
	 * button for a specific category functionalities. Returns null if there
	 * does not exist one
	 * 
	 * @return Button
	 */
	public Button get_button_by_category_and_value(String category_name,
			int value) {

		int col_index = -1;
		Button output_button = null;

		// loop through the first row and finds the wanted category column
		// number
		for (Label temp_label : label_list) {
			if (temp_label.getText().equals(category_name)) {
				col_index = label_list.indexOf(temp_label);
				break;
			}
		}

		for (int i = 0; i < button_matrix.get(col_index).size(); i++) {
			// loop through the column with wanted category
			String temp_val_str = button_matrix.get(col_index).get(i).getText();

			if (Integer.parseInt(temp_val_str) == value) {
				output_button = button_matrix.get(col_index).get(i);
				break;
			}
		}

		return output_button;
	}

	/**
	 * Method that sets a button unclickable with its GUI changed to a lighter
	 * colour. Useful when printing out all the values but only the smallest
	 * value can be chosen
	 * 
	 * @param button
	 */
	public void set_button_unclickable(Button button) {
		button.setDisable(true);
	}

	/**
	 * Method that sets a button invisible. Useful when a value is attempted and
	 * it is removed from the database however for not changing the layout we
	 * instead set it invisible
	 * 
	 * @param button
	 */
	public void set_button_invisible(Button button) {
		button.setVisible(false);
	}

}
