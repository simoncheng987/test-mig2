package functionality;

import java.io.FileNotFoundException;
import java.io.IOException;
import GUI.GUI_Manager;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import util.Util;

/**
 * @author Simon
 *
 *         This class manages all the functionalities of the buttons in the
 *         Award_Scene
 */
public class Award_Scene_Controller {
	GUI_Manager gui_manager;
	Stage window;

	/**
	 * When the constructor is called, it sets up all the the functionalities of
	 * all the buttons in Award_Scene
	 * 
	 * @param gui_manager
	 * @param window
	 */
	public Award_Scene_Controller(GUI_Manager gui_manager, Stage window) {
		this.gui_manager = gui_manager;
		this.window = window;
		set_back_button();
		set_reset_button();
	}

	/**
	 * sets up the functionality of the back button
	 */
	public void set_back_button() {
		Button game_button = gui_manager.get_award_scene().get_back_button();
		game_button.setOnAction(e -> {
			window.setScene(gui_manager.get_start_scene());
		});
	}
	
	/**
	 * sets up the functionality of the reset button
	 */
	public void set_reset_button() {
		Button practice_button = gui_manager.get_award_scene()
				.get_reset_button();
		practice_button.setOnAction(e -> {
			try {
				Util.reset();
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			window.setScene(gui_manager.get_start_scene());
		});
	}

}
