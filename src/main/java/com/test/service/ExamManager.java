package com.test.service;

import java.util.List;

import org.appfuse.service.GenericManager;

import com.test.dao.model.ChoiceAnswer;
import com.test.dao.model.Question;

public interface ExamManager extends GenericManager<Question, Long> {
	public void saveChoiceAnswer(ChoiceAnswer choiceAnswer);
	public List getQuestions();
	public List getAnswer();
}
