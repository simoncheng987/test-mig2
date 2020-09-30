package functionality;

import java.util.ArrayList;

import GUI.GUI_Manager;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class Game_User_Input_Scene_Controller {
	GUI_Manager gui_manager;
	Stage window;

	public Game_User_Input_Scene_Controller(GUI_Manager gui_manager, Stage window) {
		this.gui_manager = gui_manager;
		this.window = window;
		set_dont_know_button();
		set_submit_button();
		set_speed_up_button();
		set_speed_down_button();
		set_repeat_button();
	}

	public void set_dont_know_button() {
		Button dont_know_button = gui_manager.get_game_user_input_scene().get_dont_know_button();
		dont_know_button.setOnAction(e -> {
			window.setScene(gui_manager.get_incorrect_scene_game());
		});
	}
	
	public void set_submit_button() {
		Button submit_button = gui_manager.get_game_user_input_scene().get_submit_button();
		submit_button.setOnAction(e -> {
			
			// if the user answer is correct gui_manager.get_correct_scene()
			// else gui_manager.get_incorrect_scene()
			
			// at this stage we set it to the correct scene for the ease of testing
			window.setScene(gui_manager.get_correct_scene_game());
			
		});
	}
	
	// for the ease of testing i use syso commands, delete those at the later stages
	public void set_speed_up_button() {
		Button speed_up_button = gui_manager.get_game_user_input_scene().get_speed_up_button();
		speed_up_button.setOnAction(e -> {
			// speeds up the espeaker
			System.out.println("speed up");
		});
	}
	
	public void set_speed_down_button() {
		Button speed_down_button = gui_manager.get_game_user_input_scene().get_speed_down_button();
		speed_down_button.setOnAction(e -> {
			// speeds down the espeaker
			System.out.println("speed down");
		});
	}
	
	public void set_repeat_button() {
		Button repeat_button = gui_manager.get_game_user_input_scene().get_repeat_button();
		repeat_button.setOnAction(e -> {
			// repeat the clue
			System.out.println("repeat");
		});
	}
}
