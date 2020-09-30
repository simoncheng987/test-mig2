package application;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public class test_file_reading {
	public static void main(String[] args)
			throws FileNotFoundException, IOException {
		String filePath = System.getProperty("user.dir")
				+ "\\application\\Quinzical.txt";
		String temp_str = System.getProperty("user.dir");
		
		System.out.println(temp_str);
		List<String> Categories = FileIO.readCategory(filePath);
		for (int i = 0; i < Categories.size(); i++) {
			System.out.println(Categories.get(i));
		}
		
		System.out.println("?-Places".length());
		
		List<Categories> contents = FileIO.readFileContent(filePath);
		for (int i = 0; i < contents.size(); i++) {
			System.out.println(contents.get(i).name);
			System.out.println(contents.get(i).question);
			System.out.println(contents.get(i).answer);
		}
		
		System.out.println((int) (1
		+ Math.random() * contents.get(0).question.size() - 1));
		
	}
}
