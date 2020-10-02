package GUI;

import java.util.ArrayList;

import javafx.geometry.Insets;
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
 *         Practice_Scene instance
 * 
 *         Description: The class for the Practice_Scene GUI.
 */

public class Practice_Scene extends Scene {

	private static Practice_Scene practice_scene_instance = null;

	// top components
	private static Label instruction_label_top;
	private static Label instruction_label_bottom;

	// bottom components
	private static Button back_button;
	private static Button go_button;

	// centre components
	private static ArrayList<RadioButton> radio_button_list = new ArrayList<>();
	private static ArrayList<AnchorPane> anchorPane_list = new ArrayList<>();
	private static ToggleGroup toggle_group = new ToggleGroup();
	private static int grid_row_num = 3;
	private static int grid_column_num = 3;

	private static String button_style = "-fx-background-color:#d8b063; -fx-font-family:monospace; -fx-font-size:24; -fx-font-weight:lighter; -fx-font-style:italic; -fx-text-fill:#583c30;";
	private static String label_style = "-fx-font-size:24; -fx-text-fill:#583c30";
	
	public Practice_Scene(Parent root, double width, double height) {
		super(root, width, height);
	}

	public Practice_Scene(Parent root) {
		super(root);
	}

	/**
	 * Method that returns an instance of Practice_Scene object
	 * 
	 * @return Practice_Scene
	 */
	public static Practice_Scene getInstance() {
		if (practice_scene_instance == null) {

			BorderPane overall_layout = new BorderPane();

			// The top part of the scene
			back_button = new Button("Back");
			back_button.setLayoutX(25);
			back_button.setLayoutY(15);
			back_button.setPrefSize(100, 50);
			back_button.setStyle(button_style);

			instruction_label_top = new Label(
					"Please select a category that you want to practice with");
			instruction_label_top.setLayoutX(160);
			instruction_label_top.setLayoutY(20);
			instruction_label_top.setStyle(label_style);

			AnchorPane top_anchor_pane = new AnchorPane(back_button,
					instruction_label_top);
			top_anchor_pane.setPrefHeight(80);
			top_anchor_pane.setPrefWidth(600);

			// The bottom part of the scene
			go_button = new Button("GO");
			go_button.setLayoutX(665);
			go_button.setPrefSize(120, 50);
			go_button.setStyle(button_style);

			AnchorPane bottom_anchor_pane = new AnchorPane(go_button);
			bottom_anchor_pane.setPrefHeight(80);
			bottom_anchor_pane.setPrefWidth(600);

			// initialize all the radio buttons in the grid pane
			GridPane middle_grid_pane = new GridPane();
			for (int i = 0; i < grid_row_num; i++) {
				for (int j = 0; j < grid_column_num; j++) {
					RadioButton radio_button = new RadioButton();
					radio_button.setToggleGroup(toggle_group);

					AnchorPane anchor_pane = new AnchorPane(radio_button);
					anchor_pane.setPrefSize(200, 200);
					radio_button.setLayoutX(90);
					radio_button.setLayoutY(65);
					radio_button.setStyle(label_style);

					middle_grid_pane.add(anchor_pane, j, i);
					radio_button_list.add(radio_button);
				}
			}
			
			// select the first radio button by default
			toggle_group.getToggles().get(0).setSelected(true);

			overall_layout.setTop(top_anchor_pane);
			overall_layout.setCenter(middle_grid_pane);
			overall_layout.setBottom(bottom_anchor_pane);
			overall_layout.setStyle("-fx-background-color:#f0ecc4");

			practice_scene_instance = new Practice_Scene(overall_layout,
					GUI_Manager.WINDOW_WIDTH, GUI_Manager.WINDOW_HEIGHT);
		}

		return practice_scene_instance;
	}

	public Button get_back_button() {
		return back_button;
	}

	public Button get_go_button() {
		return go_button;
	}

	/**
	 * Returns the list that contains all the radio buttons. Useful when assigns
	 * category names to every radio button.
	 * 
	 * @return radio_button_list
	 */
	public ArrayList<RadioButton> get_radio_button_list() {
		return radio_button_list;
	}

	/**
	 * Returns a radio button with the wanted category Useful assigning the
	 * radio button for a specific category functionalities. Returns null if
	 * there does not exist one
	 * 
	 * @return radioButton
	 */
	public RadioButton get_radio_button_by_category(String category_name) {
		for (RadioButton radioButton : radio_button_list) {
			if (radioButton.getText().equals(category_name)) {
				return radioButton;
			}
		}
		return null;
	}
	
	public ToggleGroup get_toggle_group() {
		return toggle_group;
	}

}
