package functionality;

import java.util.ArrayList;

import GUI.GUI_Manager;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.stage.Stage;

public class Practice_Scene_Controller {
	GUI_Manager gui_manager;
	Stage window;

	public Practice_Scene_Controller(GUI_Manager gui_manager, Stage window) {
		this.gui_manager = gui_manager;
		this.window = window;
		set_back_button();
		set_go_button();
	}

	public void set_back_button() {
		Button back_button = gui_manager.get_practice_scene().get_back_button();
		back_button.setOnAction(e -> {
			window.setScene(gui_manager.get_start_scene());
		});
	}

	public void set_go_button() {
		Button go_button = gui_manager.get_practice_scene().get_go_button();
		go_button.setOnAction(e -> {		
			window.setScene(gui_manager.get_practice_user_input_scene());
		});
	}

}
