package GUI;

/**
 * @author Simon
 * 
 *         This class manages all the scene classes
 */
public class GUI_Manager {

	public final static int WINDOW_WIDTH = 800;
	public final static int WINDOW_HEIGHT = 600;
	public final static String BUTTON_FONT_STYLE_STRING = "-fx-background-color:#d8b063; -fx-font-family:monospace; -fx-font-size:25; -fx-font-weight:lighter; -fx-font-style:italic; -fx-text-fill:#583c30;";

	private Start_Scene start_scene;
	private Practice_Scene practice_scene;
	private Practice_User_Input_Scene practice_user_input_scene;
	private Correct_Scene_Practice correct_scene_practice;
	private Incorrect_Scene_Practice incorrect_scene_practice;
	private Correct_Scene_Game correct_scene_game;
	private Incorrect_Scene_Game incorrect_scene_game;
	private Game_Scene game_scene;
	private Game_User_Input_Scene game_user_input_scene;
	private Award_Scene award_scene;

	/**
	 * When the constructor of GUI_Manager is called, it creates instances of
	 * all the scenes classes to set up all the layout in Quinzical
	 * 
	 * @param gui_manager
	 * @param window
	 */
	public GUI_Manager() {
		start_scene = Start_Scene.getInstance();
		practice_scene = Practice_Scene.getInstance();
		practice_user_input_scene = Practice_User_Input_Scene.getInstance();
		correct_scene_practice = Correct_Scene_Practice.getInstance();
		incorrect_scene_practice = Incorrect_Scene_Practice.getInstance();
		correct_scene_game = Correct_Scene_Game.getInstance();
		incorrect_scene_game = Incorrect_Scene_Game.getInstance();
		game_scene = Game_Scene.getInstance();
		game_user_input_scene = Game_User_Input_Scene.getInstance();
		award_scene = Award_Scene.getInstance();
	}

	/**
	 * @return the start scene
	 */
	public Start_Scene get_start_scene() {
		return start_scene;
	}

	/**
	 * @return the practice scene
	 */
	public Practice_Scene get_practice_scene() {
		return practice_scene;
	}

	/**
	 * @return the scene where user get to answer the question after picking a
	 *         category in practice mode
	 */
	public Practice_User_Input_Scene get_practice_user_input_scene() {
		return practice_user_input_scene;
	}

	/**
	 * @return the scene when user answers the question correctly in practice
	 *         mode
	 */
	public Correct_Scene_Practice get_correct_scene_practice() {
		return correct_scene_practice;
	}

	/**
	 * @return the scene when user answers the question incorrectly in practice
	 *         mode
	 */
	public Incorrect_Scene_Practice get_incorrect_scene_practice() {
		return incorrect_scene_practice;
	}

	/**
	 * @return the scene when user answers the question correctly in game mode
	 */
	public Correct_Scene_Game get_correct_scene_game() {
		return correct_scene_game;
	}

	/**
	 * @return the scene when user answers the question incorrectly in game mode
	 */
	public Incorrect_Scene_Game get_incorrect_scene_game() {
		return incorrect_scene_game;
	}

	/**
	 * @return the game scene
	 */
	public Game_Scene get_game_scene() {
		return game_scene;
	}

	/**
	 * @return the scene where user get to answer the question after picking a
	 *         value in game mode
	 */
	public Game_User_Input_Scene get_game_user_input_scene() {
		return game_user_input_scene;
	}

	/**
	 * @return the award scene
	 */
	public Award_Scene get_award_scene() {
		return award_scene;
	}

}
