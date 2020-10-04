package functionality;

import GUI.GUI_Manager;
import javafx.stage.Stage;

/**
 * @author Simon
 * 
 *         This class manages all the controller classes
 */
public class Controller_Manager {
	GUI_Manager gui_manager;
	Stage window;

	private Correct_Scene_Game_Controller correct_scene_game_controller;
	private Correct_Scene_Practice_Controller correct_scene_practice_controller;
	private Game_Scene_Controller game_scene_controller;
	private Game_User_Input_Scene_Controller game_user_input_scene_controller;
	private Incorrect_Scene_Game_Controller incorrect_scene_game_controller;
	private Incorrect_Scene_Practice_Controller incorrect_scene_practice_controller;
	private Practice_Scene_Controller practice_scene_controller;
	private Practice_User_Input_Scene_Controller practice_user_input_scene_controller;
	private Start_Scene_Controller start_scene_controller;
	private Award_Scene_Controller award_scene_controller;

	/**
	 * When the constructor of Controller_Manager is called, it creates
	 * instances of all the controller classes to set up all the buttons
	 * functionalities in Quinzical
	 * 
	 * @param gui_manager
	 * @param window
	 */
	public Controller_Manager(GUI_Manager gui_manager, Stage window) {
		this.gui_manager = gui_manager;
		this.window = window;

		correct_scene_game_controller = new Correct_Scene_Game_Controller(
				gui_manager, window);
		correct_scene_practice_controller = new Correct_Scene_Practice_Controller(
				gui_manager, window);
		game_scene_controller = new Game_Scene_Controller(gui_manager, window);
		game_user_input_scene_controller = new Game_User_Input_Scene_Controller(
				gui_manager, window);
		incorrect_scene_game_controller = new Incorrect_Scene_Game_Controller(
				gui_manager, window);
		incorrect_scene_practice_controller = new Incorrect_Scene_Practice_Controller(
				gui_manager, window);
		practice_scene_controller = new Practice_Scene_Controller(gui_manager,
				window);
		practice_user_input_scene_controller = new Practice_User_Input_Scene_Controller(
				gui_manager, window);
		start_scene_controller = new Start_Scene_Controller(gui_manager,
				window);
		award_scene_controller = new Award_Scene_Controller(gui_manager,
				window);
	}

}
