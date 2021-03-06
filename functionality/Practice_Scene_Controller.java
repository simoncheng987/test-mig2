package functionality;

import GUI.GUI_Manager;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;
import util.Util;

/**
 * @author Simon
 * 
 *         This class manages all the functionalities of the buttons in the
 *         practice scene.
 */
public class Practice_Scene_Controller {
	GUI_Manager gui_manager;
	Stage window;

	/**
	 * When the constructor is called, it sets up all the the functionalities
	 * 
	 * @param gui_manager
	 * @param window
	 */
	public Practice_Scene_Controller(GUI_Manager gui_manager, Stage window) {
		this.gui_manager = gui_manager;
		this.window = window;
		set_back_button();
		set_go_button();
	}

	/**
	 * sets up the functionality of the back button
	 */
	public void set_back_button() {
		Button back_button = gui_manager.get_practice_scene().get_back_button();
		back_button.setOnAction(e -> {
			window.setScene(gui_manager.get_start_scene());
		});
	}
	/**
	 * sets up the functionality of the go button
	 */
	public void set_go_button() {
		Button go_button = gui_manager.get_practice_scene().get_go_button();
		go_button.setOnAction(e -> {

			// gets the selected radio button in the toggle group
			ToggleGroup toggle_group = gui_manager.get_practice_scene()
					.get_toggle_group();
			RadioButton selectedRadioButton = (RadioButton) toggle_group
					.getSelectedToggle();
			String toogleGroupValue = selectedRadioButton.getText();

			// finds the index of the category
			int index = -1;
			for (int i = 0; i < Util.category_list.size(); i++) {
				if (toogleGroupValue.equals(Util.category_list.get(i))) {
					index = i;
					break;
				}
			}

			Util.practice_list_index = index;

			// gets question for that category
			gui_manager.get_practice_user_input_scene().get_question_label()
					.setText(Util.practice_question_list.get(index));

			window.setScene(gui_manager.get_practice_user_input_scene());
		});
	}

}
