package util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FileIO {
	// method to read the categories in the given directory.
	public static List<String> readCategory(String filepath)
			throws FileNotFoundException, IOException {
		List<String> output = new ArrayList<String>();
		try {

			File file = new File(filepath);
			@SuppressWarnings("resource")
			BufferedReader bf = new BufferedReader(new FileReader(file));
			if (file.isFile()) {
				String line;
				while ((line = bf.readLine()) != null) {
					if ((!line.contains("(")) && (line.length() != 1)) {
						if ((!line.contains("_")) && (line.length() > 3)) {
							// UTF-8-BOM format will automatically add the
							// encoding format to
							// the first character of the first line of the
							// text. So we delete
							// the first letter of the first line.
							if (output.size() == 0) {
								output.add(line.substring(1, line.length()));
							} else {
								output.add(line);
							}
						}
					}
				}
			}
		} catch (FileNotFoundException e) {
			System.out.println("readfile()   Exception:" + e.getMessage());
		}
		return output;

	}

	// method to pick a specified number of random categories
	public static List<String> pickRandomCategories(List<String> input,
			int number) {
		Set<String> hashSet = new HashSet<>();

		while (hashSet.size() < number) {
			// I need to critize Jeff's coding in here, serious bug.
			// int temp = (int) Math.random() * input.size();
			int temp = (int) (Math.random() * input.size());
			hashSet.add(input.get(temp));
			//System.err.println(temp);
		}
		List<String> output_random_categories = new ArrayList<>(hashSet);
		return output_random_categories;
	}

	// method to get corresponding list of Categories objects.
	public static List<Categories> FindCorrespondingCate(List<String> input1,
			List<Categories> input2) {
		List<Categories> output = new ArrayList<Categories>();
		for (int i = 0; i < input1.size(); i++) {
			for (int j = 0; j < input2.size(); j++) {
				if (input1.get(i).contentEquals(input2.get(j).name)) {
					output.add(input2.get(j));
				}
			}
		}
		return output;

	}

	// method to read
	public static List<Categories> readFileContent(String filepath)
			throws FileNotFoundException, IOException {
		List<String> CategoriesNames = readCategory(filepath);

		boolean read = false;
		List<Categories> output = new ArrayList<Categories>();

		for (int i = 0; i < CategoriesNames.size(); i++) {
			File file = new File(filepath);
			List<String> questions = new ArrayList<String>();
			List<String> answers = new ArrayList<String>();
			questions.clear();
			answers.clear();

			@SuppressWarnings("resource")
			BufferedReader bf = new BufferedReader(new FileReader(file));
			if (file.isFile()) {
				String line;
				while ((line = bf.readLine()) != null) {

					if (line.length() > 1) {
						if (i == 0) {
							if (line.substring(1)
									.contentEquals(CategoriesNames.get(i))) {
								read = true;
							}
						} else {
							if (line.contentEquals(CategoriesNames.get(i))) {
								read = true;

							}
						}
					}
					if ((read == true) && (line.length() > 18)) {
						if (line.contains(",")) {
							questions.add(line.substring(0, line.indexOf(",")));
						} else {
							questions.add(
									line.substring(0, line.indexOf("(") - 3));
						}
						if (line.contains(".")) {
							answers.add(line.substring(line.indexOf(")") + 2,
									line.length() - 1));
						} else {
							answers.add(line.substring(line.indexOf(")") + 2,
									line.length()));
						}

					}
					if ((line.length() < 3) && (read == true)) {
						output.add(new Categories(CategoriesNames.get(i),
								questions, answers));

						read = false;
						break;
					}
				}

			}
		}
		return output;
	}
}
