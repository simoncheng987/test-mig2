package GUI;

import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
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
 *         start_scene instance
 * 
 *         Description: The class for the start scene GUI.
 */

public class Start_Scene extends Scene {

	private static Start_Scene start_scene_instance = null;
	private static Button game_button;
	private static Button practice_button;

	public Start_Scene(Parent root, double width, double height) {
		super(root, width, height);
	}

	public Start_Scene(Parent root) {
		super(root);
	}

	/**
	 * Method that returns an instance of Start_Scene object
	 * 
	 * @return Start_Scene
	 */
	public static Start_Scene getInstance() {
		if (start_scene_instance == null) {

			game_button = new Button("Game");
			practice_button = new Button("Practice");
			game_button.setMinSize(360, 100);
			practice_button.setMinSize(360, 100);
			game_button.setStyle(GUI_Manager.BUTTON_FONT_STYLE_STRING);
			practice_button.setStyle(GUI_Manager.BUTTON_FONT_STYLE_STRING);

			HBox hbox = new HBox(game_button, practice_button);
			hbox.setSpacing(30);

			BorderPane layout = new BorderPane();
			layout.setPadding(new Insets(20, 30, 20, 30));
			layout.setBottom(hbox);
			layout.setStyle("-fx-background-color:#f0ecc4");

			start_scene_instance = new Start_Scene(layout,
					GUI_Manager.WINDOW_WIDTH, GUI_Manager.WINDOW_HEIGHT);
		}

		return start_scene_instance;
	}

	public Button get_game_button() {
		return game_button;
	}

	public Button get_practice_button() {
		return practice_button;
	}

}
