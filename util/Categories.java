package util;

import java.util.List;
/**
 *  Class created for storing different category objects.
 *  Includes fields :name, question,answer,value_list and current index.
 */
public class Categories {
	public String name;
	public List<String> question;
	public List<String> answer;
	public List<Integer> value_list;
	public int current_index;
	/**
	*Constructor for Categories class, it takes three parameters as input:
	*String Name, List<String> Q(questions list) and List<String>A(answers list).
	*/
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
