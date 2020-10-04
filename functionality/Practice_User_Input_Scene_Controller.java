package functionality;

import java.io.IOException;
import java.util.ArrayList;

import GUI.GUI_Manager;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import util.Speaker;
import util.Util;

/**
 * @author Simon, Jeff
 * 
 *         This class manages all the functionalities of the buttons in the
 *         scene after user choose a value from the practice scene
 */
public class Practice_User_Input_Scene_Controller {
	GUI_Manager gui_manager;
	Stage window;
	String original_notification;

	/**
	 * When the constructor is called, it sets up all the the functionalities
	 * 
	 * @param gui_manager
	 * @param window
	 */
	public Practice_User_Input_Scene_Controller(GUI_Manager gui_manager,
			Stage window) {
		this.gui_manager = gui_manager;
		this.window = window;
		set_back_to_menu_button();
		set_submit_button();
		set_speed_up_button();
		set_speed_down_button();
		set_repeat_button();
	}

	/**
	 * sets up the functionality of the back to menu button
	 */
	public void set_back_to_menu_button() {
		Button back_to_menu_button = gui_manager.get_practice_user_input_scene()
				.get_back_to_memu_button();
		// cleans up the database, hence every time user will get different
		// question from the category
		back_to_menu_button.setOnAction(e -> {
			Util.clear_practice_database();
			Util.set_up_practice_database();
			window.setScene(gui_manager.get_start_scene());
		});
	}

	/**
	 * sets up the functionality of the back to submit button
	 */
	public void set_submit_button() {
		Button submit_button = gui_manager.get_practice_user_input_scene()
				.get_submit_button();
		submit_button.setOnAction(e -> {

			// obtains the current question and the answer to it
			String user_input_string = gui_manager
					.get_practice_user_input_scene().get_user_input_text_field()
					.getText();
			String answer = Util.practice_answer_list
					.get(Util.practice_list_index);

			// if the user answer is correct then goes to the correct scene
			// else goes to the incorrect scene

			if (user_input_string.equalsIgnoreCase(answer)) {
				window.setScene(gui_manager.get_correct_scene_practice());
			} else {

				// check for attempts less than 3, then give another attempts
				if (Util.practice_number_of_attempt < 3) {
					Util.practice_number_of_attempt++;
				}

				// when 3rd attempt, give hint. 4th time, goes to the incorrect
				// scene and show answer
				if (Util.practice_number_of_attempt == 3) {
					// show the first letter as hint
					String notification = gui_manager
							.get_practice_user_input_scene()
							.get_notification_label().getText();
					original_notification = notification;
					notification = notification + "(hint: the first letter is: "
							+ answer.charAt(0) + ")";
					gui_manager.get_practice_user_input_scene()
							.get_notification_label().setText(notification);
					Util.practice_number_of_attempt++;
				} else if (Util.practice_number_of_attempt >= 4) {
					gui_manager.get_incorrect_scene_practice()
							.get_correct_answer_label().setText(answer);

					// reset all the labels and attempts to default
					Util.practice_number_of_attempt = 0;
					gui_manager.get_practice_user_input_scene()
							.get_notification_label()
							.setText(original_notification);

					window.setScene(gui_manager.get_incorrect_scene_practice());
				}
			}
		});
	}

	/**
	 * sets up the functionality of the speed up button
	 */
	public void set_speed_up_button() {
		Button speed_up_button = gui_manager.get_practice_user_input_scene()
				.get_speed_up_button();
		speed_up_button.setOnAction(e -> {
			String question = Util.practice_question_list
					.get(Util.practice_list_index);

			try {
				if (Util.speaker_speed < 50) {
					Util.speaker_speed = Speaker.speedUp(question,
							Util.speaker_speed);
				} else {
					Speaker.speedySpeak(question, Util.speaker_speed);
				}
			} catch (InterruptedException | IOException e1) {
				e1.printStackTrace();
			}
			String label = gui_manager.get_practice_user_input_scene()
					.get_bottom_laebl_speaker().getText();
			String value = label.replace("Speaker (Current speed: x", "");
			value = value.replace(")", "");

			double value_double = 1 + Util.speaker_speed / 100.0;

			String speed_val = Double.toString(value_double).substring(0, 3);

			String output = "Speaker (Current speed: x" + speed_val + ")";
			gui_manager.get_practice_user_input_scene()
					.get_bottom_laebl_speaker().setText(output);

		});
	}

	/**
	 * sets up the functionality of the speed down button
	 */
	public void set_speed_down_button() {
		Button speed_down_button = gui_manager.get_practice_user_input_scene()
				.get_speed_down_button();
		speed_down_button.setOnAction(e -> {
			String question = Util.practice_question_list
					.get(Util.practice_list_index);
			try {
				if (Util.speaker_speed > -50) {
					Util.speaker_speed = Speaker.slowDown(question,
							Util.speaker_speed);
				} else {
					Speaker.speedySpeak(question, Util.speaker_speed);
				}
			} catch (InterruptedException | IOException e1) {
				e1.printStackTrace();
			}
			String label = gui_manager.get_practice_user_input_scene()
					.get_bottom_laebl_speaker().getText();
			String value = label.replace("Speaker (Current speed: x", "");
			value = value.replace(")", "");

			double value_double = 1 + Util.speaker_speed / 100.0;

			String speed_val = Double.toString(value_double).substring(0, 3);

			String output = "Speaker (Current speed: x" + speed_val + ")";
			gui_manager.get_practice_user_input_scene()
					.get_bottom_laebl_speaker().setText(output);
		});
	}

	/**
	 * sets up the functionality of the repeat button
	 */
	public void set_repeat_button() {
		Button repeat_button = gui_manager.get_practice_user_input_scene()
				.get_repeat_button();
		repeat_button.setOnAction(e -> {
			String question = Util.practice_question_list
					.get(Util.practice_list_index);
			try {
				Speaker.speedySpeak(question, Util.speaker_speed);
			} catch (InterruptedException | IOException e1) {
				e1.printStackTrace();
			}

		});
	}
}
