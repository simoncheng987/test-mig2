package GUI;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;

/**
 * @author Simon
 * 
 *         Design Pattern: Singleton
 * 
 *         Purpose: Allows to get rid of bugs caused by repetitively creating
 *         correct_scene instance
 * 
 *         Description: The GUI of the user's answer is incorrect
 */

public class Incorrect_Scene_Practice extends Scene {

	private static Incorrect_Scene_Practice incorrect_scene_instance = null;

	private static Label center_label_notification;
	private static Label center_laebl_correct_answer;

	private static Button bottom_button_back;

	private static String button_style = "-fx-background-color:#d8b063; -fx-font-family:monospace; -fx-font-size:18; -fx-font-weight:bold; -fx-font-style:italic; -fx-text-fill:#583c30;";

	public Incorrect_Scene_Practice(Parent root, double width, double height) {
		super(root, width, height);
	}

	public Incorrect_Scene_Practice(Parent root) {
		super(root);
	}

	/**
	 * Method that returns an instance of correct_scene object
	 * 
	 * @return Start_Scene
	 */
	public static Incorrect_Scene_Practice getInstance() {
		if (incorrect_scene_instance == null) {
			
			// the top layout
			AnchorPane blank_anchor_pane = new AnchorPane();
			blank_anchor_pane.setPrefSize(800, 50);
			
			// the center layout

			center_label_notification = new Label(" The correct answer is:");
			center_label_notification.setStyle(
					"-fx-font-size:20; -fx-text-fill:#583c30; -fx-font-style:italic;");

			center_laebl_correct_answer = new Label(
					"the Official National Wizard");
			center_laebl_correct_answer.setStyle(
					"-fx-font-size:44; -fx-text-fill:#82a6ae; -fx-text-alignment:center; -fx-wrap-text:true;");
			
			VBox top_vbox = new VBox( center_label_notification,
					center_laebl_correct_answer);
			top_vbox.setAlignment(Pos.CENTER);

			// the bottom layout

			bottom_button_back = new Button("Back to menu");
			bottom_button_back.setStyle(button_style);
			bottom_button_back.setMinSize(125, 50);


			HBox bottom_hbox = new HBox(bottom_button_back);
			bottom_hbox.setPadding(new Insets(0, 0, 20, 20));
			bottom_hbox.setSpacing(10);
			
			VBox bottom_vbox = new VBox(bottom_hbox);

			// put them together
			BorderPane layout = new BorderPane();
			layout.setTop(blank_anchor_pane);
			layout.setCenter(top_vbox);
			layout.setBottom(bottom_vbox);
			layout.setStyle("-fx-background-color:#f0ecc4");

			incorrect_scene_instance = new Incorrect_Scene_Practice(
					layout, GUI_Manager.WINDOW_WIDTH,
					GUI_Manager.WINDOW_HEIGHT);
		}

		return incorrect_scene_instance;
	}

	public Label get_correct_answer_label() {
		return center_laebl_correct_answer;
	}

	public Button get_back_button() {
		return bottom_button_back;
	}
	

}
