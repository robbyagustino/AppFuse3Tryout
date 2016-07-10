package com.test.webapp.controller;

import java.util.Iterator;
import java.util.List;

import org.appfuse.service.GenericManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.test.dao.model.ChoiceAnswer;
import com.test.dao.model.Question;
import com.test.service.ExamManager;


@Controller
@RequestMapping("/exams*")
public class ExamController {
	private ExamManager examManager;
	
	@Autowired
    public void setExamManager(@Qualifier("examManager") ExamManager examManager) {
        this.examManager = examManager;
    }
	
	@RequestMapping(method = RequestMethod.GET)
    public ModelAndView handleRequest()
    throws Exception {
		
		List answerList = examManager.getAnswer();
		ModelAndView mv = new ModelAndView();
		List questionList = examManager.getQuestions();
		ChoiceAnswer tempAnswer = new ChoiceAnswer();
		Question tempQuestion = new Question();
		
		if(null != answerList && null!=questionList){
			for(int i=0; answerList.size()>i; i++){
				tempAnswer = (ChoiceAnswer) answerList.get(i);
				for(int j=0; questionList.size()>j; j++){
					tempQuestion = (Question) questionList.get(j);
					
					if(tempAnswer.getOrder() == tempQuestion.getOrder()){
						tempQuestion.setAnswer(tempAnswer.getAnswerText());
					}
				}
			}
		}
		
		mv.addObject(questionList);
		
        return mv;
    }
}
