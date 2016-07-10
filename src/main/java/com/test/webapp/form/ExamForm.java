package com.test.webapp.form;

import java.util.List;

import com.test.dao.model.Question;

public class ExamForm {

    private List<Question> questionList;
    private String ans;
    private int questionSize;
    
	public List<Question> getQuestionList() {
		return questionList;
	}
	public void setQuestionList(List<Question> questionList) {
		this.questionList = questionList;
	}
	public String getAns() {
		return ans;
	}
	public void setAns(String ans) {
		this.ans = ans;
	}
	public int getQuestionSize() {
		return questionSize;
	}
	public void setQuestionSize(int questionSize) {
		this.questionSize = questionSize;
	}
}
