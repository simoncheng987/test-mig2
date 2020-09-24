package application;

import java.util.List;

public class Categories {
public Categories(String name,List<String> questions,List<String> answers) {
	this.name=name;
	this.questions=questions;
	this.answers=answers;
}
public String name;
public List<String> questions;
public List<String> answers;
}
