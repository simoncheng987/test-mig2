package GUI;

import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 * @author Simon
 * 
 *         Design Pattern: Singleton
 * 
 *         Purpose: Allows to get rid of bugs caused by repetitively creating
 *         Practice_User_Input_Scene instance
 * 
 *         Description: The scene after user picks a category category from the
 *         practice scene
 */

public class Practice_User_Input_Scene extends Scene {

	private static Practice_User_Input_Scene practice_user_input_scene_instance = null;

	private static Label top_laebl_practice_mode;
	private static Label top_laebl_clue_notification;
	private static Label top_laebl_question;
	private static Label center_laebl_notification;
	private static Label bottom_laebl_speaker;

	private static TextField center_text_field_user_input;

	private static Button bottom_button_speed_up;
	private static Button bottom_button_speed_down;
	private static Button bottom_button_repeat;
	private static Button bottom_button_submit;
	private static Button bottom_button_back_to_menu;

	private static String button_style = "-fx-background-color:#d8b063; -fx-font-family:monospace; -fx-font-size:18; -fx-font-weight:bold; -fx-font-style:italic; -fx-text-fill:#583c30;";

	public Practice_User_Input_Scene(Parent root, double width, double height) {
		super(root, width, height);
	}

	public Practice_User_Input_Scene(Parent root) {
		super(root);
	}

	/**
	 * Method that returns an instance of Practice_User_Input_Scene object
	 * 
	 * @return Practice_User_Input_Scene
	 */
	public static Practice_User_Input_Scene getInstance() {
		if (practice_user_input_scene_instance == null) {

			// the top layout
			top_laebl_practice_mode = new Label("Practice Mode");
			top_laebl_practice_mode.setStyle(
					"-fx-font-size:30; -fx-text-fill:#583c30; -fx-font-weight:bold;");
			top_laebl_practice_mode.setLayoutX(305);

			top_laebl_clue_notification = new Label(" Here is your clue");
			top_laebl_clue_notification.setStyle(
					"-fx-font-size:20; -fx-text-fill:#583c30; -fx-font-style:italic;");

			top_laebl_question = new Label(
					"This is the name of the long chain of mountains that make up the backbone of the South Island");
			top_laebl_question.setStyle(
					"-fx-font-size:44; -fx-text-fill:#000000; -fx-text-alignment:center; -fx-wrap-text:true;");

			AnchorPane top_anchor_pane = new AnchorPane(
					top_laebl_practice_mode);
			VBox top_vbox = new VBox(top_anchor_pane,
					top_laebl_clue_notification, top_laebl_question);
			top_laebl_question.setPadding(new Insets(0, 0, 0, 30));

			// the center layout

			center_laebl_notification = new Label(
					" Please enter your answer here");
			center_laebl_notification.setStyle(
					"-fx-font-size:20; -fx-text-fill:#583c30; -fx-font-style:italic;");
			AnchorPane center_anchor_pane1 = new AnchorPane(
					center_laebl_notification);

			center_text_field_user_input = new TextField("");
			center_text_field_user_input
					.setStyle("-fx-font-size:54; -fx-text-fill:#000000;");
			center_text_field_user_input.setPrefSize(720, 140);
			center_text_field_user_input.setLayoutX(40);
			center_text_field_user_input.setLayoutY(10);
			AnchorPane center_anchor_pane2 = new AnchorPane(
					center_text_field_user_input);
			VBox center_vbox = new VBox(center_anchor_pane1,
					center_anchor_pane2);

			// the bottom layout

			bottom_laebl_speaker = new Label(" Speaker (Current speed: x1.0)");
			bottom_laebl_speaker.setStyle(
					"-fx-font-size:20; -fx-text-fill:#583c30; -fx-font-style:italic;");
			bottom_laebl_speaker.setLayoutY(15);
			AnchorPane bottom_anchor_pane1 = new AnchorPane(
					bottom_laebl_speaker);
			bottom_anchor_pane1.setPrefHeight(65);

			bottom_button_speed_up = new Button("Speed Up");
			bottom_button_speed_up.setStyle(button_style);
			bottom_button_speed_up.setMinSize(125, 50);

			bottom_button_speed_down = new Button("Speed Down");
			bottom_button_speed_down.setStyle(button_style);
			bottom_button_speed_down.setMinSize(140, 50);

			bottom_button_repeat = new Button("Repeat");
			bottom_button_repeat.setStyle(button_style);
			bottom_button_repeat.setMinSize(100, 50);

			bottom_button_back_to_menu = new Button("Back to menu");
			bottom_button_back_to_menu.setStyle(button_style);
			bottom_button_back_to_menu.setLayoutX(50);
			bottom_button_back_to_menu.setMinSize(150, 75);

			bottom_button_submit = new Button("Submit");
			bottom_button_submit.setStyle(button_style);
			bottom_button_submit.setLayoutX(220);
			bottom_button_submit.setMinSize(150, 75);

			AnchorPane bottom_anchor_pane2 = new AnchorPane(
					bottom_button_back_to_menu, bottom_button_submit);

			HBox bottom_hbox = new HBox(bottom_button_speed_up,
					bottom_button_speed_down, bottom_button_repeat,
					bottom_anchor_pane2);
			bottom_hbox.setPadding(new Insets(0, 0, 20, 20));
			bottom_hbox.setSpacing(10);

			VBox bottom_vbox = new VBox(bottom_anchor_pane1, bottom_hbox);

			// put them together
			BorderPane layout = new BorderPane();
			layout.setTop(top_vbox);
			layout.setCenter(center_vbox);
			layout.setBottom(bottom_vbox);
			layout.setStyle("-fx-background-color:#f0ecc4");

			practice_user_input_scene_instance = new Practice_User_Input_Scene(
					layout, GUI_Manager.WINDOW_WIDTH,
					GUI_Manager.WINDOW_HEIGHT);
		}

		return practice_user_input_scene_instance;
	}

	/**
	 * @return the question label
	 */
	public Label get_question_label() {
		return top_laebl_question;
	}

	/**
	 * This method is useful when user click on button of speed up and down The
	 * change of value in the speed will be shown
	 * 
	 * @return the label for showing tts's speed
	 */
	public Label get_bottom_laebl_speaker() {
		return bottom_laebl_speaker;
	}

	/**
	 * @return the textfield where user input their answer
	 */
	public TextField get_user_input_text_field() {
		return center_text_field_user_input;
	}

	/**
	 * @return the speed up button
	 */
	public Button get_speed_up_button() {
		return bottom_button_speed_up;
	}

	/**
	 * @return the speed down button
	 */
	public Button get_speed_down_button() {
		return bottom_button_speed_down;
	}

	/**
	 * @return the repeat button
	 */
	public Button get_repeat_button() {
		return bottom_button_repeat;
	}

	/**
	 * 
	 * @return back to menu button
	 */
	public Button get_back_to_memu_button() {
		return bottom_button_back_to_menu;
	}

	/**
	 * @return the submit button.
	 */
	public Button get_submit_button() {
		return bottom_button_submit;
	}

	/**
	 * Useful to append some hint in this label Before: "Please enter your
	 * answer here" After: "Please enter your answer here (hint: the answer
	 * starts with 'a')
	 * 
	 * @return the notification label
	 */
	public Label get_notification_label() {
		return center_laebl_notification;
	}

}
