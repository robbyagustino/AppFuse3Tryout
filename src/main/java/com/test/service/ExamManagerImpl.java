package com.test.service;

import java.util.List;

import org.appfuse.service.impl.GenericManagerImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.dao.core.ChoiceAnswerDao;
import com.test.dao.core.QuestionDao;
import com.test.dao.core.TestExamDao;
import com.test.dao.model.ChoiceAnswer;
import com.test.dao.model.Question;

@Service("examManager")
public class ExamManagerImpl extends GenericManagerImpl<Question, Long>
		implements ExamManager {
	
	QuestionDao questionDao;
	ChoiceAnswerDao choiceAnswerDao;
	TestExamDao testExamDao;

	@Autowired
	public ExamManagerImpl(QuestionDao questionDao, ChoiceAnswerDao choiceAnswerDao, TestExamDao testExamDao) {
		super(questionDao);
		this.questionDao = questionDao;
		this.choiceAnswerDao = choiceAnswerDao;
		this.testExamDao = testExamDao;
	}
	
	public void saveChoiceAnswer(ChoiceAnswer choiceAnswer)	{
		choiceAnswerDao.save(choiceAnswer);
	}
	
	public List getQuestions()	{
		return questionDao.getAll();
	}
	
	public List getAnswer()	{
		return choiceAnswerDao.getAll();
	}
	
	
}
