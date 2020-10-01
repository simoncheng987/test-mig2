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
import functionality.*;
import functionality.Start_Scene_Controller;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.stage.Stage;
import util.Util;

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

//		Start_Scene start_scene = Start_Scene.getInstance();
//		Practice_Scene practice_Scene = Practice_Scene.getInstance();
//		Practice_User_Input_Scene practice_User_Input_Scene = Practice_User_Input_Scene
//				.getInstance();
//		Correct_Scene correct_Scene = Correct_Scene.getInstance();
//		Incorrect_Scene incorrect_Scene = Incorrect_Scene.getInstance();
//		Game_Scene game_Scene = Game_Scene.getInstance();
//		Game_User_Input_Scene game_User_Input_Scene = Game_User_Input_Scene
//				.getInstance();
//		Award_Scene award_Scene = Award_Scene.getInstance();

//		Start_Scene_Controller ssc = new Start_Scene_Controller(gui_manager,
//				window);
//		Practice_Scene_Controller psc = new Practice_Scene_Controller(
//				gui_manager, window);
//		Game_Scene_Controller gsc = new Game_Scene_Controller(gui_manager,
//				window);
//		Game_User_Input_Scene_Controller guisc = new Game_User_Input_Scene_Controller(
//				gui_manager, window);
//		Correct_Scene_Game_Controller csgc = new Correct_Scene_Game_Controller(
//				gui_manager, window);
//		Incorrect_Scene_Game_Controller isgc = new Incorrect_Scene_Game_Controller(
//				gui_manager, window);
//		Correct_Scene_Practice_Controller cspc = new Correct_Scene_Practice_Controller(
//				gui_manager, window);
//		Incorrect_Scene_Practice_Controller ispc = new Incorrect_Scene_Practice_Controller(
//				gui_manager, window);
//		Practice_User_Input_Scene_Controller puisc = new Practice_User_Input_Scene_Controller(
//				gui_manager, window);

		// // for testing practice_scene
//		for (RadioButton rb : practice_Scene.get_radio_button_list()) {
//			rb.setText("Category");
//		}
//		
//		// for testing practice_User_Input_Scene
//		Label label_q = practice_User_Input_Scene.get_question_label();
//		label_q.setText("This is the M¨¡ori word for stomach");
//		//label_q.setText("This is the name of the long chain of mountains that make up the backbone of the South Island");
//
		// for testing game_scene
//		ArrayList<Label> label_al = game_Scene.get_label_list();
//		ArrayList<ArrayList<Button>> button_matrix = game_Scene
//				.get_button_matrix();
//
//		label_al.get(2).setText("animal");
//		label_al.get(3).setText("country");
//
//		Button button1 = button_matrix.get(2).get(2);
//		Button button2 = button_matrix.get(3).get(0);
//
//		button1.setText("150");
//		button2.setText("0");
//
//		game_Scene.set_button_invisible(
//				game_Scene.get_button_by_category_and_value("animal", 150));
//		game_Scene.set_button_unclickable(
//				game_Scene.get_button_by_category_and_value("country", 0));

		// for loading the scene

//		ArrayList<String> al = new ArrayList<>();
//		al.add("1");
//		al.add("2");
//		al.add("3");
//		al.add("4");
//		al.add("5");
//		al.add("6");
//		al.add("7");
//		al.add("8");
//		al.add("9");
//
//		ArrayList<RadioButton> al_radb = gui_manager.get_practice_Scene()
//				.get_radio_button_list();
//		
//		for (int i = 0; i < al.size(); i++) {
//			al_radb.get(i).setText(al.get(i));
//		}
		GUI_Manager gui_manager = new GUI_Manager();
		Controller_Manager controller_manager = new Controller_Manager(
				gui_manager, window);
		//Util.gui_manager = gui_manager;
		Util util = new Util(gui_manager);
		window.setScene(gui_manager.get_start_scene());
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
//				"Your progress will not be saved, are you sure to exit?",
//				ButtonType.YES, ButtonType.NO);
//		if (alert.showAndWait().orElse(ButtonType.NO) == ButtonType.YES) {
//			mainWindow.close();
//		}
//	}
}
