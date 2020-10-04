package functionality;

import GUI.GUI_Manager;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import util.Util;

/**
 * @author Simon
 * 
 *         This class manages all the functionalities of the buttons in the
 *         correct scene while in practice mode.
 */
public class Correct_Scene_Practice_Controller {
	GUI_Manager gui_manager;
	Stage window;

	/**
	 * When the constructor is called, it sets up all the the functionalities
	 * 
	 * @param gui_manager
	 * @param window
	 */
	public Correct_Scene_Practice_Controller(GUI_Manager gui_manager,
			Stage window) {
		this.gui_manager = gui_manager;
		this.window = window;
		set_back_button();
	}

	/**
	 * sets up the functionality of the back button
	 */
	public void set_back_button() {
		Button back_button = gui_manager.get_correct_scene_practice()
				.get_back_button();
		// cleans up the database, hence every time user will get different
		// question from the category
		back_button.setOnAction(e -> {
			Util.clear_practice_database();
			Util.set_up_practice_database();
			window.setScene(gui_manager.get_start_scene());
		});
	}
}