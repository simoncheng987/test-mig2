package GUI;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import application.*;
import application.FileIO;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.stage.Stage;

/**
 * 
 * @author jeffp,simonc The main page of quinzical
 */
public class test_main extends Application {
	private Stage stage;
	private String filePath = System.getProperty("user.dir")
			+ "/src/application/Quinzical.txt";

	public static void main(String[] args) {
		launch(args);
	}

	/**
	 * Launches the programme
	 */
	@Override
	public void start(Stage window) throws Exception {

		window.setTitle("Quinzical");
		window.setResizable(false);

		Start_Scene start_scene = Start_Scene.getInstance();
		Practice_Scene practice_Scene = Practice_Scene.getInstance();
		Practice_User_Input_Scene practice_User_Input_Scene = Practice_User_Input_Scene
				.getInstance();
		Correct_Scene correct_Scene = Correct_Scene.getInstance();
		Incorrect_Scene incorrect_Scene = Incorrect_Scene.getInstance();
		Game_Scene game_Scene = Game_Scene.getInstance();
		Game_User_Input_Scene game_User_Input_Scene = Game_User_Input_Scene
				.getInstance();
		Award_Scene award_Scene = Award_Scene.getInstance();
		
		// for testing practice_scene
		for (RadioButton rb : practice_Scene.get_radio_button_list()) {
			rb.setText("Category");
		}
		
		// for testing practice_User_Input_Scene
		Label label_q = practice_User_Input_Scene.get_question_label();
		label_q.setText("This is the M¨¡ori word for stomach");
		//label_q.setText("This is the name of the long chain of mountains that make up the backbone of the South Island");

		// for testing game_scene
		ArrayList<Label> label_al = game_Scene.get_label_list();
		ArrayList<ArrayList<Button>> button_matrix = game_Scene
				.get_button_matrix();

		label_al.get(2).setText("animal");
		label_al.get(3).setText("country");

		Button button1 = button_matrix.get(2).get(2);
		Button button2 = button_matrix.get(3).get(0);

		button1.setText("150");
		button2.setText("0");
		
		game_Scene.set_button_invisible(
				game_Scene.get_button_by_category_and_value("animal", 150));
		game_Scene.set_button_unclickable(
				game_Scene.get_button_by_category_and_value("country", 0));
		
		// for loading the scene
		window.setScene(award_Scene);
		window.show();

		// remind user to save their progres before exitting
		window.setOnCloseRequest(evt -> {
			// prevent window from closing
			evt.consume();
			// execute own shutdown procedure
			shutdown(window);
		});
	}

	private void shutdown(Stage mainWindow) {
		ButtonType okButton = new ButtonType("Yes", ButtonData.YES);
		ButtonType noButton = new ButtonType("Cancel", ButtonData.NO);
		Alert alert = new Alert(Alert.AlertType.NONE,
				"Your progress will not be saved, are you sure to exit?",
				ButtonType.YES, ButtonType.NO);
		if (alert.showAndWait().orElse(ButtonType.NO) == ButtonType.YES) {
			mainWindow.close();
		}
	}
}
