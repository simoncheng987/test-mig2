package functionality;

import GUI.GUI_Manager;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import util.Util;

public class Start_Scene_Controller {
	GUI_Manager gui_manager;
	Stage window;

	public Start_Scene_Controller(GUI_Manager gui_manager, Stage window) {
		this.gui_manager = gui_manager;
		this.window = window;
		set_game_button();
		set_practice_button();
		set_exit_button();
	}

	public void set_game_button() {
		Button game_button = gui_manager.get_start_scene().get_game_button();
		game_button.setOnAction(e -> {
			
			if (Util.check_is_game_finished() == true) {
				window.setScene(gui_manager.get_award_scene());
			}else {
				window.setScene(gui_manager.get_game_scene());
			}

		});
	}

	public void set_practice_button() {
		Button practice_button = gui_manager.get_start_scene()
				.get_practice_button();
		practice_button.setOnAction(e -> {
			window.setScene(gui_manager.get_practice_scene());
		});
	}
	

	public void set_exit_button() {
		Button exit_button = gui_manager.get_start_scene()
				.get_exit_button();
		exit_button.setOnAction(e -> {
				// execute own shutdown procedure
				Util.shutdown(window);
		});
	}

}
