package util;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import GUI.GUI_Manager;
import application.*;
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

	public Util(GUI_Manager gui_manager) throws FileNotFoundException, IOException {
		this.gui_manager = gui_manager;
		set_up_main_database();
		set_up_practice_database();
		set_up_practice_scene();
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
