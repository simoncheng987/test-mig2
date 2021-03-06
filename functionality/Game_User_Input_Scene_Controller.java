package functionality;

import java.io.IOException;
import GUI.GUI_Manager;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import util.Speaker;
import util.Util;

/**
 * @author Simon, Jeff
 * 
 *         This class manages all the functionalities of the buttons in the
 *         scene after user choose a value from the game scene
 */
public class Game_User_Input_Scene_Controller {
	GUI_Manager gui_manager;
	Stage window;

	/**
	 * When the constructor is called, it sets up all the the functionalities
	 * 
	 * @param gui_manager
	 * @param window
	 */
	public Game_User_Input_Scene_Controller(GUI_Manager gui_manager,
			Stage window) {
		this.gui_manager = gui_manager;
		this.window = window;
		set_dont_know_button();
		set_submit_button();
		set_speed_up_button();
		set_speed_down_button();
		set_repeat_button();
	}

	/**
	 * sets up the functionality of the dont know button
	 */
	public void set_dont_know_button() {
		Button dont_know_button = gui_manager.get_game_user_input_scene()
				.get_dont_know_button();
		dont_know_button.setOnAction(e -> {
			gui_manager.get_incorrect_scene_game().get_correct_answer_label()
					.setText(Util.current_correct_answer);
			window.setScene(gui_manager.get_incorrect_scene_game());
		});
	}

	/**
	 * sets up the functionality of the submit button
	 */
	public void set_submit_button() {
		Button submit_button = gui_manager.get_game_user_input_scene()
				.get_submit_button();
		submit_button.setOnAction(e -> {

			// if the user answer is correct gui_manager.get_correct_scene()
			// else gui_manager.get_incorrect_scene()

			String user_answer = gui_manager.get_game_user_input_scene()
					.get_user_input_text_field().getText();

			if (user_answer.equalsIgnoreCase(Util.current_correct_answer)) {
				window.setScene(gui_manager.get_correct_scene_game());

				// updates the score
				Util.game_score += Util.current_game_value;
				String score_text = "Current Score: " + Util.game_score;
				String final_text = "CONGRTULATIONS!!!!\n Your Final Score is "
						+ Util.game_score;
				gui_manager.get_game_scene().get_current_score_label()
						.setText(score_text);
				gui_manager.get_award_scene().get_label().setText(final_text);

			} else {
				gui_manager.get_incorrect_scene_game()
						.get_correct_answer_label()
						.setText(Util.current_correct_answer);
				window.setScene(gui_manager.get_incorrect_scene_game());
			}

		});
	}

	/**
	 * sets up the functionality of the speed up button
	 */
	public void set_speed_up_button() {
		Button speed_up_button = gui_manager.get_game_user_input_scene()
				.get_speed_up_button();
		speed_up_button.setOnAction(e -> {
			String question = Util.current_question;

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
			String label = gui_manager.get_game_user_input_scene()
					.get_bottom_laebl_speaker().getText();
			String value = label.replace("Speaker (Current speed: x", "");
			value = value.replace(")", "");

			double value_double = 1+Util.speaker_speed/100.0;

			String speed_val = Double.toString(value_double).substring(0, 3);

			String output = "Speaker (Current speed: x" + speed_val + ")";
			gui_manager.get_game_user_input_scene().get_bottom_laebl_speaker()
					.setText(output);

		});
	}

	/**
	 * sets up the functionality of the speed down button
	 */
	public void set_speed_down_button() {
		Button speed_down_button = gui_manager.get_game_user_input_scene()
				.get_speed_down_button();
		speed_down_button.setOnAction(e -> {

			String question = Util.current_question;
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
			String label = gui_manager.get_game_user_input_scene()
					.get_bottom_laebl_speaker().getText();
			String value = label.replace("Speaker (Current speed: x", "");
			value = value.replace(")", "");
			double value_double = 1 + Util.speaker_speed / 100.0;
			String speed_val = Double.toString(value_double).substring(0, 3);

			String output = "Speaker (Current speed: x" + speed_val + ")";
			gui_manager.get_game_user_input_scene().get_bottom_laebl_speaker()
					.setText(output);

		});
	}

	/**
	 * sets up the functionality of the repeat button
	 */
	public void set_repeat_button() {
		Button repeat_button = gui_manager.get_game_user_input_scene()
				.get_repeat_button();
		repeat_button.setOnAction(e -> {
			String question = Util.current_question;
			try {
				Speaker.speedySpeak(question, Util.speaker_speed);
			} catch (InterruptedException | IOException e1) {
				e1.printStackTrace();
			}

		});
	}
}
