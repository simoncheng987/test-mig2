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
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
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

		window.setTitle("Jeopardy");
		window.setResizable(false);

		Start_Scene start_scene = Start_Scene.getInstance();
		Practice_Scene practice_Scene = Practice_Scene.getInstance();
		Practice_User_Input_Scene practice_User_Input_Scene = Practice_User_Input_Scene
				.getInstance();
		Correct_Scene correct_Scene = Correct_Scene.getInstance();
		Incorrect_Scene incorrect_Scene = Incorrect_Scene.getInstance();
		for (RadioButton rb : practice_Scene.get_radio_button_list()) {
			rb.setText("Category");
		}

		window.setScene(correct_Scene);
		window.show();

		// remind user to save their progres before exitting
//		window.setOnCloseRequest(evt -> {
//			// prevent window from closing
//			evt.consume();
//			// execute own shutdown procedure
//			shutdown(window);
//		});
	}

//	private void shutdown(Stage mainWindow) {
//		ButtonType okButton = new ButtonType("Yes", ButtonData.YES);
//		ButtonType noButton = new ButtonType("Cancel", ButtonData.NO);
//		Alert alert = new Alert(Alert.AlertType.NONE,
//				"Don't forget to save, are you sure to exit?",
//				ButtonType.YES, ButtonType.NO);
//		if (alert.showAndWait().orElse(ButtonType.NO) == ButtonType.YES) {
//			mainWindow.close();
//		}
//	}
}
