package GUI;

import java.io.InputStream;

import application.Main;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
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
	private static Button exit_button;

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
			
			//reads the image
			InputStream input = Main.class.getResourceAsStream("/rsc/Start_Scene_Image.jpg");	
			Image image = new Image(input);
			ImageView imageView = new ImageView(image);

			game_button = new Button("Game");
			practice_button = new Button("Practice");
			exit_button = new Button("Exit");
			game_button.setMinSize(220, 100);
			practice_button.setMinSize(220, 100);
			exit_button.setMinSize(220, 100);
			game_button.setStyle(GUI_Manager.BUTTON_FONT_STYLE_STRING);
			practice_button.setStyle(GUI_Manager.BUTTON_FONT_STYLE_STRING);
			exit_button.setStyle(GUI_Manager.BUTTON_FONT_STYLE_STRING);

			HBox hbox = new HBox(game_button, practice_button, exit_button);
			hbox.setSpacing(35);
			hbox.setPadding(new Insets(30));
			hbox.setPrefSize(GUI_Manager.WINDOW_WIDTH, 100);

			BorderPane layout = new BorderPane();
			layout.setPadding(new Insets(0, 30, 30, 0));
			layout.setCenter(imageView);
			layout.setBottom(hbox);
			layout.setStyle("-fx-background-color:#f0ecc4");

			start_scene_instance = new Start_Scene(layout, GUI_Manager.WINDOW_WIDTH, GUI_Manager.WINDOW_HEIGHT);
		}

		return start_scene_instance;
	}

	public Button get_game_button() {
		return game_button;
	}

	public Button get_practice_button() {
		return practice_button;
	}
	
	public Button get_exit_button() {
		return exit_button;
	}

}
