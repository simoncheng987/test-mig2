package functionality;

import java.io.IOException;
import java.util.ArrayList;

import GUI.GUI_Manager;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import util.Categories;
import util.Speaker;
import util.Util;

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

		for (int i = 0; i < button_matrix.size(); i++) {
			ArrayList<Button> button_list = button_matrix.get(i);
			String current_category_name = Util.game_label_list.get(i)
					.getText();
			Categories current_category = Util.game_database.get(i);

			for (int j = 0; j < button_list.size(); j++) {
				Button temp_button = button_list.get(j);
				int last_row = button_list.size() - 1;
				int next_button_index = j + 1;

				String temp_question = current_category.question.get(j);
				String temp_answer = current_category.answer.get(j);
				int temp_score = Integer.parseInt(temp_button.getText());

				// checks if this is the last row, if yes, it does not enable
				// the next button since there is no such a button
				if (j == last_row) {
					temp_button.setOnAction(e -> {
						temp_button.setVisible(false);

						// records the temp question, answer and value
						Util.current_question = temp_question;
						Util.current_correct_answer = temp_answer;
						Util.current_game_value = temp_score;
						
						// speaks out the question
						try {
							Speaker.speedySpeak(Util.current_question,
									Util.speaker_speed);
						} catch (InterruptedException | IOException e1) {
							e1.printStackTrace();
						}

						window.setScene(
								gui_manager.get_game_user_input_scene());
					});
				} else {

					Button next_button = button_list.get(next_button_index);

					temp_button.setOnAction(e -> {
						temp_button.setVisible(false);
						next_button.setDisable(false);

						// records the temp question, answer and value
						Util.current_question = temp_question;
						Util.current_correct_answer = temp_answer;
						Util.current_game_value = temp_score;

						// speaks out the question
						try {
							Speaker.speedySpeak(Util.current_question,
									Util.speaker_speed);
						} catch (InterruptedException | IOException e1) {
							e1.printStackTrace();
						}

						window.setScene(
								gui_manager.get_game_user_input_scene());
					});
				}

			}
		}
	}

}
