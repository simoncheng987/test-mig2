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

public class Main extends Application{
	private Stage stage;
	private String filePath =System.getProperty("user.dir")+"/src/application/Quinzical.txt";
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		List<String> Categories = readCategory(filePath);
		for(int i=0;i<Categories.size();i++) {
			System.out.println(Categories.get(i));
		}
		
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
	public List<String> readCategory(String filepath) throws FileNotFoundException, IOException{
		List<String> output= new ArrayList<String>();
		try {
			
            File file = new File(filepath);
            BufferedReader bf = new BufferedReader(new FileReader(file));
            if(file.isFile()) {
            	String line;
            	while((line=bf.readLine())!=null) {
            		if((!line.contains("("))&&(line.length()!=1)) {
            			if((!line.contains("_"))&&(line.length()>3)) {
            			output.add(line);
            			}
            		}
            	}
            }
		}catch (FileNotFoundException e) {
            System.out.println("readfile()   Exception:" + e.getMessage());
    }
		return output;
		
}    
	//method to Pick a specified number of random categories
	public List<String> pickRandomCategories(List<String>input,int number) {
		Set<String> hashSet = new HashSet<>();
		
		while(hashSet.size()<number) {
			hashSet.add(input.get((int)Math.random()*input.size()));
		}
		List<String> output_random_categories = new ArrayList<>(hashSet);
		return output_random_categories;
	}
	public List<Categories> readFileContent(String filepath) throws FileNotFoundException, IOException{
		List<String> CategoriesNames=readCategory(filepath);
		for(int i=0;i<CategoriesNames.size();i++) {
			 File file = new File(filepath);
	            BufferedReader bf = new BufferedReader(new FileReader(file));
	            if(file.isFile()) {
	            	String line;
	            	while((line=bf.readLine()).length()>3) {
	            		
		}
		
		
	}
		}
		return null;
	}
}
	
	
	
	
	
	
	
	
	
	
	
	
	

