package application;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import GUI.Practice_Scene;
import GUI.Start_Scene;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 * 
 * @author jeffp,simonc The main page of quinzical
 */
public class Main extends Application {
	public static Stage stage;
	private static String filePath = System.getProperty("user.dir")
			+ "/src/application/Quinzical.txt";
	private Button btnBack;
	private Button btnGo;
	public static List<String> Categories;
	public static List<Categories> contents;

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		Categories = FileIO.readCategory(filePath);

		for (int i = 0; i < Categories.size(); i++) {
			System.out.println(Categories.get(i));
		}
		contents = FileIO.readFileContent(filePath);
//		System.out.println((int) (1
//				+ Math.random() * Main.contents.get(0).question.size() - 1));

		stage = primaryStage;

		primaryStage.setTitle("Jeopardy");
		primaryStage.setResizable(false);

		Start_Scene start_Scene = Start_Scene.getInstance();
		Practice_Scene practice_Scene = Practice_Scene.getInstance();

		primaryStage.setScene(start_Scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
