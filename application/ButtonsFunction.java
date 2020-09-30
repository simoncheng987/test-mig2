package application;

import javax.swing.JOptionPane;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class ButtonsFunction {
	public static Button goScene(Button button, final Stage stage,
			final Scene scene) {
		button.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				stage.setScene(scene);
			}
		});
		return button;
	}

	public static Button readInput(Button button) {
		return button;

	}
}
