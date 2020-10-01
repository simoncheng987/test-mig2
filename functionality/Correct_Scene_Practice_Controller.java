package functionality;

import java.util.ArrayList;

import GUI.GUI_Manager;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import util.Util;

public class Correct_Scene_Practice_Controller {
	GUI_Manager gui_manager;
	Stage window;

	public Correct_Scene_Practice_Controller(GUI_Manager gui_manager, Stage window) {
		this.gui_manager = gui_manager;
		this.window = window;
		set_back_button();
	}

	public void set_back_button() {
		Button back_button = gui_manager.get_correct_scene_practice().get_back_button();
		back_button.setOnAction(e -> {
			Util.clear_practice_database();
			Util.set_up_practice_database();
			window.setScene(gui_manager.get_start_scene());
		});
	}
}