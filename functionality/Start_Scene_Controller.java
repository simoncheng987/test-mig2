package functionality;

import GUI.GUI_Manager;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import util.Util;

/**
 * @author Simon
 * 
 *         This class manages all the functionalities of the buttons in the
 *         start scene.
 */
public class Start_Scene_Controller {
	GUI_Manager gui_manager;
	Stage window;

	/**
	 * When the constructor is called, it sets up all the the functionalities
	 * 
	 * @param gui_manager
	 * @param window
	 */
	public Start_Scene_Controller(GUI_Manager gui_manager, Stage window) {
		this.gui_manager = gui_manager;
		this.window = window;
		set_game_button();
		set_practice_button();
		set_exit_button();
	}

	/**
	 * sets up the functionality of the game button
	 */
	public void set_game_button() {
		Button game_button = gui_manager.get_start_scene().get_game_button();
		game_button.setOnAction(e -> {

			// checks if the game is finished, then it shows up the award scene.
			// otherwise goes back to he game scene
			if (Util.check_is_game_finished() == true) {
				window.setScene(gui_manager.get_award_scene());
			} else {
				window.setScene(gui_manager.get_game_scene());
			}

		});
	}

	/**
	 * sets up the functionality of the practice button
	 */
	public void set_practice_button() {
		Button practice_button = gui_manager.get_start_scene()
				.get_practice_button();
		practice_button.setOnAction(e -> {
			window.setScene(gui_manager.get_practice_scene());
		});
	}
	
	/**
	 * sets up the functionality of the exit button
	 */
	public void set_exit_button() {
		Button exit_button = gui_manager.get_start_scene().get_exit_button();
		exit_button.setOnAction(e -> {
			// execute the shutdown procedure with alert box showing the user
			// cannot save progress
			Util.shutdown(window);
		});
	}

}
