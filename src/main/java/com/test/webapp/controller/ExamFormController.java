package com.test.webapp.controller;

import org.apache.commons.lang.StringUtils;
import org.appfuse.service.GenericManager;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
 


import org.springframework.web.servlet.ModelAndView;

import com.test.dao.model.ChoiceAnswer;
import com.test.dao.model.Question;
import com.test.service.ExamManager;
import com.test.webapp.form.ExamForm;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Controller
@RequestMapping("/examform*")
public class ExamFormController extends BaseFormController {
	private ExamManager examManager;
	private static List questionList = new ArrayList(); 
	
	@Autowired
    public void setExamManager(@Qualifier("examManager") ExamManager examManager) {
        this.examManager = examManager;
    }
	
	public ExamFormController() {
        setCancelView("redirect:examform");
        setSuccessView("redirect:exams");
    }
	
	@ModelAttribute
    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView showForm(HttpServletRequest request)
    throws Exception {
		
        ExamForm model = new ExamForm();
        model.setQuestionList(examManager.getQuestions());
        model.setQuestionSize(examManager.getQuestions().size());
                
        return new ModelAndView("examform","examform",model);
    }
	
	
	@RequestMapping(method = RequestMethod.POST)
    public String onSubmit(@ModelAttribute("examform") ExamForm examForm, BindingResult errors, HttpServletRequest request)
    throws Exception {
        if (request.getParameter("cancel") != null) {
            return getCancelView();
        }
 
        String success = getSuccessView();
        Locale locale = request.getLocale();
        
        questionList = examManager.getQuestions();
        ChoiceAnswer tempAnswer = new ChoiceAnswer();
        Question tempQuestion = new Question();
        
        if(null != questionList && questionList.size() > 0) {
        	 int totalAnswer = 0;
             if(null!= examForm.getAns()){
             		String[] temp = examForm.getAns().split("\\|");
             		totalAnswer = temp.length;
             
             		if(totalAnswer>0){
		            for (int i=0; questionList.size()>i; i++) {
		            	tempQuestion = (Question) questionList.get(i);
		            	String tempAnsText = "";
		            		tempAnsText = temp[i];
			            	tempAnswer.setAnswerText(tempAnsText);
			            	tempAnswer.setOrder(tempQuestion.getOrder());
			            	examManager.saveChoiceAnswer(tempAnswer);
		            }
		         }
             }
        }    
        
        String key = "exam.updated";
        saveMessage(request, getText(key, locale));
 
        return success;
    }
	
}
