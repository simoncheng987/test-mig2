package functionality;

import java.util.ArrayList;

import GUI.GUI_Manager;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class Game_Scene_Controller {
	GUI_Manager gui_manager;
	Stage window;

	public Game_Scene_Controller(GUI_Manager gui_manager, Stage window) {
		this.gui_manager = gui_manager;
		this.window = window;
		set_back_button();
		set_go_button();
	}

	public void set_back_button() {
		Button back_button = gui_manager.get_game_scene().get_back_button();
		back_button.setOnAction(e -> {
			window.setScene(gui_manager.get_start_scene());
		});
	}
	
	/**
	 * Sets up all the buttons in the button matrix 
	 */
	public void set_go_button() {
		ArrayList<ArrayList<Button>> button_matrix = gui_manager
				.get_game_scene().get_button_matrix();
		
		for (ArrayList<Button> arrayList : button_matrix) {
			for (Button temp_button : arrayList) {
				temp_button.setOnAction(e ->{
					window.setScene(gui_manager.get_game_user_input_scene());
				});
			}
		}
	}

}
