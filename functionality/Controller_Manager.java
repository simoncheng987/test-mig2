package functionality;

import GUI.GUI_Manager;
import javafx.stage.Stage;

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
		award_scene_controller = new Award_Scene_Controller(gui_manager, window);
	}

	public Correct_Scene_Game_Controller get_correct_scene_game_controller() {
		return correct_scene_game_controller;
	}

	public Correct_Scene_Practice_Controller get_correct_scene_practice_controller() {
		return correct_scene_practice_controller;
	}

	public Game_Scene_Controller get_game_scene_controller() {
		return game_scene_controller;
	}

	public Game_User_Input_Scene_Controller get_game_user_input_scene_controller() {
		return game_user_input_scene_controller;
	}

	public Incorrect_Scene_Game_Controller get_incorrect_scene_game_controller() {
		return incorrect_scene_game_controller;
	}

	public Incorrect_Scene_Practice_Controller get_incorrect_scene_practice_controller() {
		return incorrect_scene_practice_controller;
	}

	public Practice_Scene_Controller get_practice_scene_controller() {
		return practice_scene_controller;
	}

	public Practice_User_Input_Scene_Controller get_practice_user_input_scene_controller() {
		return practice_user_input_scene_controller;
	}

	public Start_Scene_Controller get_start_scene_controller() {
		return start_scene_controller;
	}
	

}
