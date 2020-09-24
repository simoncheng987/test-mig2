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

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
/**
 * 
 * @author jeffp,simonc
 * The main page of quinzical
 */
public class Main extends Application{
	private Stage stage;
	private String filePath =System.getProperty("user.dir")+"/src/application/Quinzical.txt";
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		List<String> Categories = FileIO.readCategory(filePath);
		for(int i=0;i<Categories.size();i++) {
			System.out.println(Categories.get(i));
		}
		List<Categories> contents = FileIO.readFileContent(filePath);
		System.out.println(contents.get(1).answers.get(5));
		stage = primaryStage;	
		primaryStage.setScene(mainScene());
		primaryStage.show();
	}

	
	
	
	public Scene mainScene() {
		return null;
		
	}
	
	
	public Scene GameScene() {
		return null;
		
	}
	
	
	public Scene PracticeScene() {
		return null;
		
	}
	
	
	//method to read the categories in the given directory.
	
	
	
	public static void main(String[] args) {
		launch(args);
	}
}

	
	
	
	
	
	
	
	
	
	
	
	
	

