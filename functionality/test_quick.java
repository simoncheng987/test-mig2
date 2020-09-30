package functionality;

public class test_quick {
	public static void main(String[] args) {
		String str = "/Qunizical/functionality/Controller_Manager.java\n" + 
				"/Qunizical/functionality/Correct_Scene_Game_Controller.java\n" + 
				"/Qunizical/functionality/Correct_Scene_Practice_Controller.java\n" + 
				"/Qunizical/functionality/Game_Scene_Controller.java\n" + 
				"/Qunizical/functionality/Game_User_Input_Scene_Controller.java\n" + 
				"/Qunizical/functionality/Incorrect_Scene_Game_Controller.java\n" + 
				"/Qunizical/functionality/Incorrect_Scene_Practice_Controller.java\n" + 
				"/Qunizical/functionality/Practice_Scene_Controller.java\n" + 
				"/Qunizical/functionality/Practice_User_Input_Scene_Controller.java\n" + 
				"/Qunizical/functionality/Start_Scene_Controller.java";
		
		str = str.replace("/Qunizical/functionality/", "");
		str = str.replace(".java", "");
		
		String str_arr[] = str.split("\n");
		
//		System.out.println(str);
		
		for (int i = 0; i < str_arr.length; i++) {
			String s = str_arr[i];
			String t = "private " + str_arr[i] + " " + s.toLowerCase() + ";";
			System.out.println(t);
		}
		
		for (int i = 0; i < str_arr.length; i++) {
			String s = str_arr[i];
			String s_low = str_arr[i].toLowerCase();
			System.out.println(s_low + " = " + "new " + s + "(gui_manager, window);");
		}
		
		for (int i = 0; i < str_arr.length; i++) {
			String s = str_arr[i];
			String s_low = str_arr[i].toLowerCase();
			String out = "public " + s + " get_" + s_low + "(){\n\treturn " + s_low + ";\n}";
			System.out.println(out);
		}
		
	}
}
