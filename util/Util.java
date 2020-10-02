package util;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import GUI.GUI_Manager;
import application.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;

public class Util {

	public static List<Categories> main_database = new ArrayList<>();
	public static List<String> category_list = new ArrayList<>();

	public static List<Integer> practice_index_list = new ArrayList<>();
	public static List<String> practice_question_list = new ArrayList<>();
	public static List<String> practice_answer_list = new ArrayList<>();
	public static GUI_Manager gui_manager;

	public static int practice_list_index;
	public static int practice_number_of_attempt = 0;
	public static int speaker_speed = 100;

	public static int game_score = 0;
	public static List<String> category_list_game = new ArrayList<>();
	public static List<Categories> game_database = new ArrayList<>();
	public static List<Label> game_label_list = new ArrayList<>();
	public static ArrayList<ArrayList<Button>> game_button_matrix = new ArrayList<>();
	// public static int

	public Util(GUI_Manager gui_manager)
			throws FileNotFoundException, IOException {
		this.gui_manager = gui_manager;
		set_up_main_database();
		set_up_practice_database();
		set_up_practice_scene();
		set_up_game_database();
		set_up_game_scene();
	}

	public static void set_up_main_database()
			throws FileNotFoundException, IOException {
		String filePath = System.getProperty("user.dir")
				+ "\\application\\Quinzical.txt";
		System.out.println(filePath);
		category_list = FileIO.readCategory(filePath);
		main_database = FileIO.readFileContent(filePath);
	}

	public static void set_up_practice_database() {
		for (int i = 0; i < main_database.size(); i++) {
			int index = (int) (1
					+ Math.random() * main_database.get(i).question.size() - 1);
			practice_index_list.add(index);
			practice_question_list
					.add(main_database.get(i).question.get(index));
			practice_answer_list.add(main_database.get(i).answer.get(index));
		}
	}

	public static void set_up_practice_scene() {
		ArrayList<RadioButton> button_list = gui_manager.get_practice_scene()
				.get_radio_button_list();
		for (int i = 0; i < button_list.size(); i++) {
			button_list.get(i).setText(category_list.get(i));
		}
	}

	public static void clear_practice_database() {
		practice_index_list.clear();
		practice_question_list.clear();
		practice_answer_list.clear();
	}

	public static void set_up_game_database() {
		category_list_game = FileIO.pickRandomCategories(category_list, 5);
		game_database = FileIO.FindCorrespondingCate(category_list_game,
				main_database);

		// set up values
		int i = 0;
		int j = 0;

		for (i = 0; i < game_database.size(); i++) {
			int size_of_question = game_database.get(i).question.size();
			List<Integer> temp_value_list = new ArrayList<>();
			for (j = 0; j < size_of_question; j++) {
				int value = (j+1) * 100;
				temp_value_list.add(value);
			}
			game_database.get(i).value_list = temp_value_list;
			game_database.get(i).current_index = 0;
		}
	}

	public static void set_up_game_scene() {
		// set up the category names
		game_label_list = gui_manager.get_game_scene().get_label_list();
		for (int i = 0; i < game_label_list.size(); i++) {
			game_label_list.get(i).setText(category_list_game.get(i));
		}
		
		game_button_matrix = gui_manager.get_game_scene().get_button_matrix();
		for (int i = 0; i < game_button_matrix.size(); i++) {
			ArrayList<Button> temp_button_list = game_button_matrix.get(i);
			for (int j = 0; j < temp_button_list.size(); j++) {
				int temp_value = game_database.get(i).value_list.get(j);
				temp_button_list.get(j).setText(Integer.toString(temp_value));;
			}
		}
	}
	
	public static void enable_game_button(){
//		for (int i = 0; i < game_database.size(); i++) {
//			int index = game_database.get(i).current_index;
//			ArrayList<Button> temp_button_list = game_button_matrix.get(i);
//			for (int j = 0; j < temp_button_list.size(); j++) {
//				int temp_value = game_database.get(i).value_list.get(j);
//				temp_button_list.get(j).setText(Integer.toString(temp_value));;
//			}
//		}
	}
	
	//public static void check

	public List<Integer> get_practice_index_list() {
		return practice_index_list;
	}

	public List<String> get_practice_question_list() {
		return practice_question_list;
	}

	public List<String> get_practice_answer_list() {
		return practice_answer_list;
	}

	public List<String> get_category_list() {
		return category_list;
	}

	public List<Categories> get_main_database() {
		return main_database;
	}
}
