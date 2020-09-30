package util;

import java.io.FileNotFoundException;
import java.io.IOException;

import GUI.GUI_Manager;

public class test_util {
	public static void main(String[] args) throws FileNotFoundException, IOException {
		Util u = new Util(new GUI_Manager());
		u.set_up_main_database();
		u.set_up_practice_database();
		System.out.println(u.get_practice_index_list());
		System.out.println(u.get_practice_index_list().size());
		System.out.println(u.get_category_list());
		System.out.println(u.get_category_list().size());
		System.out.println(u.get_practice_answer_list());
		System.out.println(u.get_practice_answer_list().size());
		System.out.println(u.get_practice_question_list());
		System.out.println(u.get_practice_question_list().size());
		System.out.println(u.get_main_database());
		System.out.println(u.get_main_database().size());
		u.get_practice_answer_list();
		
		for (int i = 0; i < u.get_main_database().size(); i++) {
			System.out.println(u.get_main_database().get(i).name);
		}
	}
}
