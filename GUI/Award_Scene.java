package GUI;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 * @author Simon
 * 
 *         Design Pattern: Singleton
 * 
 *         Purpose: Allows to get rid of bugs caused by repetitively creating
 *         award_scene instance
 * 
 *         Description: The GUI of when user finishes all the questions
 */

public class Award_Scene extends Scene {

	private static Award_Scene award_scene_instance = null;

	private static Label center_laebl;

	private static Button bottom_button_back;
	
	private static Button bottom_button_reset;

	private static String button_style = "-fx-background-color:#d8b063; -fx-font-family:monospace; -fx-font-size:18; -fx-font-weight:bold; -fx-font-style:italic; -fx-text-fill:#583c30;";

	public Award_Scene(Parent root, double width, double height) {
		super(root, width, height);
	}

	public Award_Scene(Parent root) {
		super(root);
	}

	/**
	 * Method that returns an instance of award_scene object
	 * 
	 * @return Start_Scene
	 */
	public static Award_Scene getInstance() {
		if (award_scene_instance == null) {
			
			// the top layout
			AnchorPane blank_anchor_pane = new AnchorPane();
			blank_anchor_pane.setPrefSize(800, 50);
			
			// the center layout
			
			center_laebl = new Label(
					"CONGRTULATIONS!!!!\n Your Final Score is ");
			center_laebl.setStyle(
					"-fx-font-size:60; -fx-text-fill:#98ce97; -fx-text-alignment:center; -fx-wrap-text:true;");
			VBox top_vbox = new VBox(center_laebl);
			top_vbox.setAlignment(Pos.CENTER);

			// the bottom layout

			bottom_button_back = new Button("Back to menu");
			bottom_button_back.setStyle(button_style);
			bottom_button_back.setMinSize(125, 50);

			bottom_button_reset = new Button("Reset the game");
			bottom_button_reset.setStyle(button_style);
			bottom_button_reset.setMinSize(125, 50);
			
			HBox bottom_hbox = new HBox(bottom_button_back, bottom_button_reset);
			bottom_hbox.setPadding(new Insets(0, 0, 20, 20));
			bottom_hbox.setSpacing(10);
			
			VBox bottom_vbox = new VBox(bottom_hbox);

			// put them together
			BorderPane layout = new BorderPane();
			layout.setTop(blank_anchor_pane);
			layout.setCenter(top_vbox);
			layout.setBottom(bottom_vbox);
			layout.setStyle("-fx-background-color:#f0ecc4");

			award_scene_instance = new Award_Scene(
					layout, GUI_Manager.WINDOW_WIDTH,
					GUI_Manager.WINDOW_HEIGHT);
		}

		return award_scene_instance;
	}

	public Label get_label() {
		return center_laebl;
	}

	public Button get_back_button() {
		return bottom_button_back;
	}
	
	public Button get_reset_button() {
		return bottom_button_reset;
	}
	

}
