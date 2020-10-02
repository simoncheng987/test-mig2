package application;

import GUI.GUI_Manager;
import functionality.*;
import javafx.application.Application;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;
import util.Util;

/**
 * 
 * @author jeffp,simonc The main page of quinzical
 */
public class Main extends Application {


	public static void main(String[] args) {
		launch(args);
	}

	/**
	 * Launches the program
	 */
	@Override
	public void start(Stage window) throws Exception {

		window.setTitle("Quinzical");
		window.setResizable(false);

		GUI_Manager gui_manager = new GUI_Manager();
		Util util = new Util(gui_manager);
		Controller_Manager controller_manager = new Controller_Manager(
				gui_manager, window);

		window.setScene(gui_manager.get_start_scene());
		window.show();

		// remind user to save their progres before exitting
		window.setOnCloseRequest(evt -> {
			// prevent window from closing
			evt.consume();
			// execute own shutdown procedure
			Util.shutdown(window);
		});
	}

}
