package functionality;

import java.util.ArrayList;

import GUI.GUI_Manager;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import util.Util;

public class Practice_User_Input_Scene_Controller {
	GUI_Manager gui_manager;
	Stage window;
	String original_notification;

	public Practice_User_Input_Scene_Controller(GUI_Manager gui_manager, Stage window) {
		this.gui_manager = gui_manager;
		this.window = window;
		set_back_to_menu_button();
		set_submit_button();
		set_speed_up_button();
		set_speed_down_button();
		set_repeat_button();
	}

	public void set_back_to_menu_button() {
		Button back_to_menu_button = gui_manager.get_practice_user_input_scene().get_back_to_memu_button();
		back_to_menu_button.setOnAction(e -> {
			Util.clear_practice_database();
			Util.set_up_practice_database();
			window.setScene(gui_manager.get_start_scene());
		});
	}

	public void set_submit_button() {
		Button submit_button = gui_manager.get_practice_user_input_scene().get_submit_button();
		submit_button.setOnAction(e -> {

			// if the user answer is correct gui_manager.get_correct_scene()
			// else gui_manager.get_incorrect_scene()

			String user_input_string = gui_manager.get_practice_user_input_scene().get_user_input_text_field()
					.getText();
			String answer = Util.practice_answer_list.get(Util.practice_list_index);

			if (user_input_string.equals(answer)) {
				window.setScene(gui_manager.get_correct_scene_practice());
			} else {

				// check for attempts less than 3, then give another attempts
				if (Util.practice_number_of_attempt < 3) {
					Util.practice_number_of_attempt++;
				}

				// when 3rd attempt, give hint. 4th time, show answer
				if (Util.practice_number_of_attempt == 3) {
					// show the first letter as hint
					String notification = gui_manager.get_practice_user_input_scene().get_notification_label()
							.getText();
					original_notification = notification;
					notification = notification + "(hint: the first letter is: " + answer.charAt(0) + ")";
					gui_manager.get_practice_user_input_scene().get_notification_label().setText(notification);
					Util.practice_number_of_attempt++;
				} else if (Util.practice_number_of_attempt >= 4) {
					gui_manager.get_incorrect_scene_practice().get_correct_answer_label().setText(answer);

					// reset all the labels and attempts to default
					Util.practice_number_of_attempt = 0;
					gui_manager.get_practice_user_input_scene().get_notification_label().setText(original_notification);

					window.setScene(gui_manager.get_incorrect_scene_practice());
				}
			}

			// at this stage we set it to the correct scene for the ease of testing

		});
	}

	// for the ease of testing i use syso commands, delete those at the later stages
	public void set_speed_up_button() {
		Button speed_up_button = gui_manager.get_practice_user_input_scene().get_speed_up_button();
		speed_up_button.setOnAction(e -> {
			// speeds up the espeaker
			System.out.println("speed up");
		});
	}

	public void set_speed_down_button() {
		Button speed_down_button = gui_manager.get_practice_user_input_scene().get_speed_down_button();
		speed_down_button.setOnAction(e -> {
			// speeds down the espeaker
			System.out.println("speed down");
		});
	}

	public void set_repeat_button() {
		Button repeat_button = gui_manager.get_practice_user_input_scene().get_repeat_button();
		repeat_button.setOnAction(e -> {
			// repeat the clue
			System.out.println("repeat");

		});
	}
}
