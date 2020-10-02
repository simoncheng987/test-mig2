package util;

import java.util.ArrayList;
import java.util.List;

public class Categories {
	public String name;
	public List<String> question;
	public List<String> answer;
	public List<Integer> value_list;
	public int current_index;
	
	public Categories(String Name, List<String> Q, List<String> A) {
		this.name = Name;
		this.question = Q;
		this.answer = A;
	}

	public void setName(String inName) {
		this.name = inName;
	}

	public void setQ(List<String> inQ) {
		this.question = inQ;
	}

	public void setA(List<String> inA) {
		this.answer = inA;
	}
}
