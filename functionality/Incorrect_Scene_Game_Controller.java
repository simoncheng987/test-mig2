package functionality;

import GUI.GUI_Manager;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import util.Util;

/**
 * @author Simon
 * 
 *         This class manages all the functionalities of the buttons in the
 *         incorrect scene while in game mode.
 */
public class Incorrect_Scene_Game_Controller {
	GUI_Manager gui_manager;
	Stage window;

	/**
	 * When the constructor is called, it sets up all the the functionalities
	 * 
	 * @param gui_manager
	 * @param window
	 */
	public Incorrect_Scene_Game_Controller(GUI_Manager gui_manager,
			Stage window) {
		this.gui_manager = gui_manager;
		this.window = window;
		set_back_button();
	}

	/**
	 * sets up the functionality of the back button
	 */
	public void set_back_button() {
		Button back_button = gui_manager.get_incorrect_scene_game()
				.get_back_button();
		
		//checks if the game is finished, then it shows up the award scene.
		//otherwise goes back to he game scene
		back_button.setOnAction(e -> {
			if (Util.check_is_game_finished() == true) {
				window.setScene(gui_manager.get_award_scene());
			} else {
				window.setScene(gui_manager.get_game_scene());
			}
		});
	}
}